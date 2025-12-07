package SupermercadoDia.web.pedidos.mercancia;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListaPedidosMercanciaDTO {

    List<PedidoMercanciaDTO> pedidosMercancia;

    public ListaPedidosMercanciaDTO() {
    }

    public ListaPedidosMercanciaDTO(List<PedidoMercancia> pedidosMercancia) {
        this.pedidosMercancia = pedidosMercancia.stream().map(p -> new PedidoMercanciaDTO(p)).toList();
    }
    
}
