package SupermercadoDia.web.pedidos;

import java.time.LocalDate;

import java.util.List;

import SupermercadoDia.web.enumerados.EstadoPedido;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoDTO {

    private Integer id;
    private LocalDate fechaCreacion;
    private LocalDate fechaLlegada;
    @Enumerated(EnumType.STRING)
    private EstadoPedido estado;

    private List<LineaPedidoDTO> lineas;
}
