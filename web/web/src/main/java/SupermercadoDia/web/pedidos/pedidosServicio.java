package SupermercadoDia.web.pedidos;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import SupermercadoDia.web.enumerados.EstadoPedido;
import SupermercadoDia.web.producto.ProductoRepositorio;
import SupermercadoDia.web.producto.Producto;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class pedidosServicio {

    private final pedidosRepositorio pedidosRepo;
    private final ProductoRepositorio productoRepo;

    @Autowired
    public pedidosServicio(pedidosRepositorio pedidosRepo, ProductoRepositorio productoRepo) {
        this.pedidosRepo = pedidosRepo;
        this.productoRepo = productoRepo;
    }

    /**
     * Devuelve todos los pedidos cuyo estado sea EN_PROCESO.
     */
    public List<PedidoMercancia> getPedidosEnProceso() {
        return pedidosRepo.findByEstado(EstadoPedido.EN_PROCESO);
    }

    /**
     * Método genérico por si quieres consultar por otro estado.
     */
    public List<PedidoMercancia> getPedidosPorEstado(EstadoPedido estado) {
        return pedidosRepo.findByEstado(estado);
    }

    /**
     * Devuelve todos los pedidos cuyo estado sea distinto a EN_PROCESO.
     */
    public List<PedidoMercancia> getPedidosNoEnProceso() {
        return pedidosRepo.findByEstadoNot(EstadoPedido.EN_PROCESO);
    }

        public List<PedidoMercancia> getPedidosEnReparto() {
        return pedidosRepo.findByEstado(EstadoPedido.EN_ENTREGA);
    }

    public PedidoMercancia getPedidoPorId(Integer id) {
        return pedidosRepo.findById(id).orElse(null);
    }

    /**
     * Edita un pedido: actualiza cantidades existentes y añade nuevas lineas si procede.
     * No elimina lineas existentes que no estén en la petición.
     */
    @Transactional
    public PedidoMercancia editarPedido(Integer id, EditPedidoDTO dto) {
        PedidoMercancia pedido = pedidosRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Pedido no encontrado: " + id));

        if (dto == null || dto.getLineas() == null) {
            return pedido; // nothing to change
        }

        for (EditLineaPedidoDTO lineaDto : dto.getLineas()) {
            if (lineaDto == null || lineaDto.getProductoId() == null || lineaDto.getCantidadSolicitada() == null) {
                continue;
            }

            Integer prodId = lineaDto.getProductoId();
            Integer nuevaCantidad = lineaDto.getCantidadSolicitada();

            // buscar linea existente para ese producto
            LineaPedido existente = pedido.getLineas().stream()
                    .filter(l -> l.getProducto() != null && prodId.equals(l.getProducto().getId()))
                    .findFirst().orElse(null);

            if (existente != null) {
                existente.setCantidadSolicitada(nuevaCantidad);
            } else {
                // añadir nueva linea si existe el producto
                Producto p = productoRepo.findById(prodId).orElse(null);
                if (p != null) {
                    pedido.addLinea(p, nuevaCantidad);
                }
            }
        }

        return pedidosRepo.save(pedido);
    }

    /**
     * Registra la llegada de un pedido: actualiza cantidades recibidas, marca fecha de llegada
     * y genera un nuevo pedido en EN_PROCESO con las cantidades faltantes si procede.
     */
    @Transactional
    public ArrivalResultDTO registrarLlegada(Integer id, RegistrarLlegadaDTO dto) {
        PedidoMercancia pedido = pedidosRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Pedido no encontrado: " + id));

        // Mapear cantidad recibida por producto id desde DTO
        Map<Integer, Integer> recibidos = (dto == null || dto.getLineas() == null) ? Map.of() :
            dto.getLineas().stream().filter(l -> l.getProductoId() != null && l.getCantidadRecibida() != null)
                .collect(Collectors.toMap(l -> l.getProductoId(), l -> l.getCantidadRecibida()));

        // Actualizar cantidadRecibida en las lineas del pedido
        for (LineaPedido linea : pedido.getLineas()) {
            Integer pid = linea.getProducto() != null ? linea.getProducto().getId() : null;
            if (pid != null && recibidos.containsKey(pid)) {
                linea.setCantidadRecibida(recibidos.get(pid));
            } else {
                // si no viene en DTO presumimos 0 recibidos
                linea.setCantidadRecibida(0);
            }
        }

        // marcar fecha y estado
        pedido.setFechaLlegada(LocalDate.now());
        pedido.setEstado(EstadoPedido.ENTREGADO);
        pedidosRepo.save(pedido);

        // calcular faltantes
        List<LineaPedido> faltantes = new ArrayList<>();
        for (LineaPedido linea : pedido.getLineas()) {
            int falt = (linea.getCantidadSolicitada() == null ? 0 : linea.getCantidadSolicitada()) - (linea.getCantidadRecibida() == null ? 0 : linea.getCantidadRecibida());
            if (falt > 0) {
                LineaPedido lp = new LineaPedido();
                lp.setProducto(linea.getProducto());
                lp.setCantidadSolicitada(falt);
                lp.setCantidadRecibida(0);
                faltantes.add(lp);
            }
        }

        ArrivalResultDTO result = new ArrivalResultDTO();
        result.setPedidoActualizado(PedidoMapper.toDTO(pedido));

        if (!faltantes.isEmpty()) {
            PedidoMercancia nuevo = new PedidoMercancia();
            nuevo.setFechaCreacion(LocalDate.now());
            nuevo.setEstado(EstadoPedido.EN_PROCESO);
            // attach lines
            for (LineaPedido falta : faltantes) {
                // use addLinea to create proper LineaPedido with relationship
                nuevo.addLinea(falta.getProducto(), falta.getCantidadSolicitada());
            }
            PedidoMercancia savedNuevo = pedidosRepo.save(nuevo);
            result.setNuevoPedidoFaltantes(PedidoMapper.toDTO(savedNuevo));
        } else {
            result.setNuevoPedidoFaltantes(null);
        }

        return result;
    }

    /**
     * Cambia el estado del pedido identificado por `id` a EN_PREPARACION.
     * Devuelve el pedido actualizado o lanza IllegalArgumentException si no existe.
     */
    public PedidoMercancia cambiarEstadoAEnPreparacion(Integer id) {
        PedidoMercancia pedido = pedidosRepo.findById(id).orElseThrow(
            () -> new IllegalArgumentException("Pedido no encontrado: " + id)
        );
        pedido.setEstado(EstadoPedido.EN_PREPARACION);
        return pedidosRepo.save(pedido);
    }
}