package SupermercadoDia.web.user;

import SupermercadoDia.web.empleados.Empleado;
import SupermercadoDia.web.model.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    private String username;
    private String password;
    private String role;
    
    @OneToOne
    private Empleado empleado;
}