package SupermercadoDia.web.empleados;

import java.time.LocalDate;
import java.time.LocalTime;

import SupermercadoDia.web.enumerados.EstadoSolicitud;
import SupermercadoDia.web.model.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "solicitudes")
public class Solicitud extends BaseEntity {

    private LocalDate fecha; 
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private String motivo;

    @ManyToOne
    @JoinColumn(name = "solicitante_id", nullable = false)
    private Empleado empleadoSolicitante; 

    @ManyToOne
    @JoinColumn(name = "suplente_id")
    private Empleado empleadoAplicado;

    @Enumerated(EnumType.STRING)
    private EstadoSolicitud estado;

    public Solicitud() {
    }

    public Solicitud(LocalDate fecha, String horario, String motivo,Empleado empleadoSolicitante) {
        this.fecha = fecha;

        String[] partes = horario.split("-");
        LocalTime horaInicio = LocalTime.parse(partes[0]);
        LocalTime horaFin = LocalTime.parse(partes[1]);

        this.horaInicio = horaInicio;
        this.horaFin = horaFin;

        this.motivo = motivo;
        this.estado = EstadoSolicitud.PENDIENTE_DE_ANUNCIO;
        this.empleadoSolicitante = empleadoSolicitante;

        this.empleadoAplicado = null;
    }
    
}
