package SupermercadoDia.web.empleados;

import java.time.LocalDate;
import java.time.LocalTime;

import SupermercadoDia.web.enumerados.EstadoTurno;
import SupermercadoDia.web.enumerados.TipoTurno;
import SupermercadoDia.web.model.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "turnos")
public class Turno extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private TipoTurno tipo;

    private LocalTime horaInicio;

    private LocalTime horaFin;

    private LocalDate fecha;

    @Enumerated(EnumType.STRING)
    private EstadoTurno estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empleado_id")
    private Empleado empleado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "horario_id")
    private Horario horario;

}
