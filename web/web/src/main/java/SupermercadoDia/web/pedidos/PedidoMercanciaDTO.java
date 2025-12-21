package SupermercadoDia.web.pedidos;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;
import SupermercadoDia.web.enumerados.EstadoPedido;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;


@Getter
@Setter
public class PedidoMercanciaDTO {

    private Integer id;
    private LocalDate fechaCreacion;
    private LocalDate fechaLlegada;

    @Enumerated(EnumType.STRING)
    private EstadoPedido estado;

    private List<LineaPedidoDTO> lineas;
}
