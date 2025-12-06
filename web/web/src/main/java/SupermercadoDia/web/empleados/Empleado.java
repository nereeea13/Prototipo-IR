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


    private Integer telefono;


    private String email;


    private Double salario;



    private Integer diasVacacionesVeranoRestantes;

    private Integer diasVacacionesInviernoRestantes;

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


    private String foto; 

    public Empleado() {
    }

    public Empleado(String nombre, String apellidos, String dni, Integer telefono, String email, Double salario,
            Integer diasVacacionesVeranoRestantes, Integer diasVacacionesInviernoRestantes, RolEmpleado rol,
            Integer contratoHorasSemanales, TipoContrato tipoContrato, PreferenciaTurno preferenciaTurno,
            EstadoEmpleado estado, String foto) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
        this.salario = salario;
        this.diasVacacionesVeranoRestantes = diasVacacionesVeranoRestantes;
        this.diasVacacionesInviernoRestantes = diasVacacionesInviernoRestantes;
        this.rol = rol;
        this.contratoHorasSemanales = contratoHorasSemanales;
        this.tipoContrato = tipoContrato;
        this.preferenciaTurno = preferenciaTurno;
        this.estado = estado;
        this.foto = foto;
    }




    
    
}
