package SupermercadoDia.web.empleados;

import SupermercadoDia.web.enumerados.RolEmpleado;
import SupermercadoDia.web.model.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "empleados")
public class Empleado extends BaseEntity {


    private String nombre;


    private String apellidos;


    private String dni;


    private String telefono;


    private String email;


    private String salario;


    private String preferencias; //Capaz hay que cambiarlo a un enum


    private Integer diasLibresRestantes;


    private RolEmpleado rol;

    
    
}
