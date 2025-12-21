package SupermercadoDia.web.empleados;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HorarioDTO {
    private Integer id;
    private LocalDate fechaInicio;
    private boolean vigente;

    public HorarioDTO() {}

    public HorarioDTO(Horario h) {
        if (h == null) return;
        this.id = h.getId();
        this.fechaInicio = h.getFechaInicio();
        this.vigente = h.isVigente();
    }
}
