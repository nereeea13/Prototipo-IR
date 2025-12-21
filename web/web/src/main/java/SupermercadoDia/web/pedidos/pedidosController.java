package SupermercadoDia.web.pedidos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pedidos")
public class pedidosController {

    private final pedidosServicio pedidosServicio;

    @Autowired
    public pedidosController(pedidosServicio pedidosServicio) {
        this.pedidosServicio = pedidosServicio;
    }

    /**
     * Devuelve los pedidos en estado EN_PROCESO.
     */
    @GetMapping("/en-proceso")
    public ResponseEntity<List<PedidoDTO>> getPedidosEnProceso() {
        List<PedidoMercancia> pedidos = pedidosServicio.getPedidosEnProceso();
        return ResponseEntity.ok(PedidoMapper.toDTOList(pedidos));
    }

        @GetMapping("/en-entrega")
    public ResponseEntity<List<PedidoDTO>> getPedidosEnEntrega() {
        List<PedidoMercancia> pedidos = pedidosServicio.getPedidosEnReparto();
        return ResponseEntity.ok(PedidoMapper.toDTOList(pedidos));
    }

    @GetMapping("/todos-pedidos")
    public ResponseEntity<List<PedidoDTO>> getPedidos() {
        List<PedidoMercancia> pedidos = pedidosServicio.getPedidosNoEnProceso();
        return ResponseEntity.ok(PedidoMapper.toDTOList(pedidos));
    }

    @GetMapping(value = "/detalle", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PedidoDTO> getDetallePedido(@RequestParam Integer id) {

        PedidoMercancia pedido = pedidosServicio.getPedidoPorId(id);

        if (pedido == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(PedidoMapper.toDTO(pedido));
    }

    /**
     * Cambia el estado del pedido indicado a EN_PREPARACION.
     * Recibe el id como parámetro de consulta `?id=...`.
     */
    @PutMapping(value = "/en-preparacion", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PedidoDTO> setPedidoEnPreparacion(@RequestParam Integer id) {
        try {
            PedidoMercancia actualizado = pedidosServicio.cambiarEstadoAEnPreparacion(id);
            return ResponseEntity.ok(PedidoMapper.toDTO(actualizado));
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.notFound().build();
        }
    }



}