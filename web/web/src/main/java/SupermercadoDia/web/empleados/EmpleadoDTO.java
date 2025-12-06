package SupermercadoDia.web.empleados;

import SupermercadoDia.web.enumerados.EstadoEmpleado;
import SupermercadoDia.web.enumerados.PreferenciaTurno;
import SupermercadoDia.web.enumerados.RolEmpleado;
import SupermercadoDia.web.enumerados.TipoContrato;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpleadoDTO {

    private Integer id;
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

    public EmpleadoDTO() {
    }

    public EmpleadoDTO(Empleado empleado) {
        this.id = empleado.getId();
        this.nombre = empleado.getNombre();
        this.apellidos = empleado.getApellidos();
        this.dni = empleado.getDni();
        this.telefono = empleado.getTelefono();
        this.email = empleado.getEmail();
        this.salario = empleado.getSalario();
        this.diasVacacionesVeranoRestantes = empleado.getDiasVacacionesVeranoRestantes();
        this.diasVacacionesInviernoRestantes = empleado.getDiasVacacionesInviernoRestantes();
        this.rol = empleado.getRol();
        this.contratoHorasSemanales = empleado.getContratoHorasSemanales();
        this.tipoContrato = empleado.getTipoContrato();
        this.preferenciaTurno = empleado.getPreferenciaTurno();
        this.estado = empleado.getEstado();
        this.foto = empleado.getFoto();
    }
}
