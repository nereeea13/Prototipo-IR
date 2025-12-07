package SupermercadoDia.web.empleados;

import java.time.LocalDate;
import java.time.LocalTime;

import SupermercadoDia.web.enumerados.EstadoSolicitud;
import SupermercadoDia.web.model.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

    @Enumerated(EnumType.STRING)
    private EstadoSolicitud estado;
    
}
