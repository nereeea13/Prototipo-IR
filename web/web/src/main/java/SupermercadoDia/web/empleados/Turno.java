package SupermercadoDia.web.empleados;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

import SupermercadoDia.web.enumerados.EstadoTurno;
import SupermercadoDia.web.enumerados.TipoTurno;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "turnos")
public class Turno  {

    private TipoTurno tipo; 

    private LocalTime horaInicio; 

    private LocalTime horaFin;

    private LocalDate fecha;

    // private Duration duracion; TODO: funcion getDuracion()

    private EstadoTurno estado; 
    
}
