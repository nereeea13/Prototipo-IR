package SupermercadoDia.web.empleados;

import SupermercadoDia.web.enumerados.PreferenciaTurno;
import SupermercadoDia.web.enumerados.RolEmpleado;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrearEmpleadoDTO {

    private String nombre;
    private String apellidos;
    private String dni;
    private String telefono;
    private String email;
    private String foto;
    private Integer contratoHorasSemanales;

    @Enumerated(EnumType.STRING)
    private PreferenciaTurno preferenciaTurno;

    @Enumerated(EnumType.STRING)
    private RolEmpleado rol;

    public CrearEmpleadoDTO() {
    }

}
