package SupermercadoDia.web.empleados;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TurnoUpdateDTO {
    // ISO date yyyy-MM-dd
    private String fecha;
    // HH:mm
    private String horaInicio;
    private String horaFin;
    // enums as names
    private String tipo;
    private String estado;
    // optional empleado id to reassign
    private Integer empleadoId;

    public TurnoUpdateDTO() {}
}
