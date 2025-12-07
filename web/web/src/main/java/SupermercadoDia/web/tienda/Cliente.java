package SupermercadoDia.web.tienda;


import SupermercadoDia.web.model.Person;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cliente extends Person {

    private Integer telefono;
    private String correo; 
    
}
