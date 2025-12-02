package SupermercadoDia.web.empleados;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

import SupermercadoDia.web.enumerados.EstadoTurno;
import SupermercadoDia.web.enumerados.TipoTurno;

public class Turno {

    private TipoTurno tipo; 

    private LocalTime horaInicio; 

    private LocalTime horaFin;

    private LocalDate fecha;

    private Duration duracion; 

    private EstadoTurno estado; 
    
}
