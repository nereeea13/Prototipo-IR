package SupermercadoDia.web.tienda;

import java.time.LocalDateTime;

import SupermercadoDia.web.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Compra extends BaseEntity {

    private LocalDateTime fechaHora; 
    private Double precioTotal; 

    
}
