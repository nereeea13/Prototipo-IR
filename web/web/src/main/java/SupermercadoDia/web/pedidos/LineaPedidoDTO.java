package SupermercadoDia.web.pedidos;

import SupermercadoDia.web.producto.ProductoDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LineaPedidoDTO {

    private Integer id;
    private Integer cantidadSolicitada;
    private Integer cantidadRecibida;

    private ProductoDTO producto;
}