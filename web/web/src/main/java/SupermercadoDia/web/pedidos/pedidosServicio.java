package SupermercadoDia.web.pedidos;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import SupermercadoDia.web.enumerados.EstadoPedido;

@Service
public class pedidosServicio {

    private final pedidosRepositorio pedidosRepo;

    @Autowired
    public pedidosServicio(pedidosRepositorio pedidosRepo) {
        this.pedidosRepo = pedidosRepo;
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