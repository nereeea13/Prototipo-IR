package SupermercadoDia.web.empleados;

import SupermercadoDia.web.enumerados.EstadoEmpleado;
import SupermercadoDia.web.enumerados.PreferenciaTurno;
import SupermercadoDia.web.enumerados.RolEmpleado;
import SupermercadoDia.web.enumerados.TipoContrato;
import SupermercadoDia.web.model.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
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



    private Integer diasLibresRestantes;

    @Enumerated(EnumType.STRING)
    private RolEmpleado rol;

 
    private Integer contratoHorasSemanales;


    @Enumerated(EnumType.STRING)
    private TipoContrato tipoContrato;

    // Preferencia de turno (enum)
    @Enumerated(EnumType.STRING)
    private PreferenciaTurno preferenciaTurno;


    @Enumerated(EnumType.STRING)
    private EstadoEmpleado estado;




    
    
}
