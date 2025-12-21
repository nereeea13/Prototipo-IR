package SupermercadoDia.web.empleados;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TurnoDTO {
    // día en formato ISO (yyyy-MM-dd)
    private String dia;
    // horario en formato "HH:mm-HH:mm"
    private String horario;
    // empleado info
    private Integer empleadoId;
    private String empleadoNombre;

    public TurnoDTO() {}

    public TurnoDTO(Turno t) {
        if (t.getFecha() != null) this.dia = t.getFecha().toString();
        if (t.getHoraInicio() != null && t.getHoraFin() != null) {
            this.horario = t.getHoraInicio().toString() + "-" + t.getHoraFin().toString();
        }
        if (t.getEmpleado() != null) {
            this.empleadoId = t.getEmpleado().getId();
            this.empleadoNombre = t.getEmpleado().getNombre();
        }
    }
}
