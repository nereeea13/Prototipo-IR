package SupermercadoDia.web.empleados;

import java.time.LocalDate;

import SupermercadoDia.web.enumerados.EstadoSolicitud;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SolicitudDTO {

    private Integer id;

    private LocalDate fecha;
    private String motivo; 
    private String horario;

    private Integer empleadoSolicitanteId;
    private Integer empleadoAplicadoId;

    private EstadoSolicitud estado;
    
    public SolicitudDTO() {}

    public SolicitudDTO(Solicitud s) {
        this.estado = s.getEstado();
        this.id = s.getId();
        if (s.getFecha() != null) this.fecha = s.getFecha();
        this.motivo = s.getMotivo();
        if (s.getHoraInicio() != null && s.getHoraFin() != null) {
            this.horario = s.getHoraInicio().toString() + "-" + s.getHoraFin().toString();
        }
        if (s.getEmpleadoSolicitante() != null) {
            this.empleadoSolicitanteId = s.getEmpleadoSolicitante().getId();
        }
        if (s.getEmpleadoAplicado() != null) {
            this.empleadoAplicadoId = s.getEmpleadoAplicado().getId();
        }
    }


    
}
