package SupermercadoDia.web.pedidos;

import java.util.List;
import java.util.stream.Collectors;

import SupermercadoDia.web.pedidos.PedidoMercancia;
import SupermercadoDia.web.pedidos.LineaPedido;
import SupermercadoDia.web.producto.Producto;
import SupermercadoDia.web.producto.ProductoDTO;

public class PedidoMapper {

    public static PedidoDTO toDTO(PedidoMercancia pedido) {
        PedidoDTO dto = new PedidoDTO();
        dto.setId(pedido.getId());
        dto.setFechaCreacion(pedido.getFechaCreacion());
        dto.setFechaLlegada(pedido.getFechaLlegada());
        dto.setEstado(pedido.getEstado());

        if (pedido.getLineas() != null) {
            dto.setLineas(
                pedido.getLineas().stream()
                    .map(PedidoMapper::toLineaDTO)
                    .collect(Collectors.toList())
            );
        }

        return dto;
    }

    public static List<PedidoDTO> toDTOList(List<PedidoMercancia> pedidos) {
        return pedidos.stream()
                .map(PedidoMapper::toDTO)
                .collect(Collectors.toList());
    }

    private static LineaPedidoDTO toLineaDTO(LineaPedido linea) {
        LineaPedidoDTO dto = new LineaPedidoDTO();
        dto.setId(linea.getId());
        dto.setCantidadSolicitada(linea.getCantidadSolicitada());
        dto.setCantidadRecibida(linea.getCantidadRecibida());
        dto.setProducto(new ProductoDTO(linea.getProducto()));
        return dto;
    }

}

