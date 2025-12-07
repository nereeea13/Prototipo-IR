package SupermercadoDia.web.tienda;

import java.time.LocalTime;

import SupermercadoDia.web.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tienda extends BaseEntity {

    private String ubicacion; 
    private LocalTime horaApertura;
    private LocalTime horaCierre;
    private Integer numeroEmpleados;    
}
