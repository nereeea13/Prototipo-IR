package SupermercadoDia.web.pedidos;

import java.time.LocalDate;

import SupermercadoDia.web.enumerados.EstadoPedido;
import SupermercadoDia.web.model.BaseEntity;

public class PedidoMercancia extends BaseEntity {

    private LocalDate fechaCreacion; 
    private LocalDate fechaLlegada; 
    private EstadoPedido estado;
    
}
