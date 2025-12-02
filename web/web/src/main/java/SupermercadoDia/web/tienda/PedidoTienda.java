package SupermercadoDia.web.tienda;

import java.time.LocalDate;

import SupermercadoDia.web.enumerados.EstadoPedido;
import SupermercadoDia.web.model.BaseEntity;

public class PedidoTienda extends BaseEntity {

    private LocalDate fechaCreacion; 
    private LocalDate fechaEntrega;
    private EstadoPedido estado;
    private String empresaReparto; 
    private String direccionEnvio; 
    private Double precioTotal; 
    
}
