package SupermercadoDia.web.pedidos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArrivalResultDTO {
    private PedidoDTO pedidoActualizado;
    private PedidoDTO nuevoPedidoFaltantes;
}
