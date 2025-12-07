package SupermercadoDia.web.pedidos;

import SupermercadoDia.web.model.Person;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "transportistas_camion")
public class TransportistaCamion extends Person {

    private String nombre; 
    private String apellidos;
    private Integer telefono; 
    private String empresa; 

    
}
