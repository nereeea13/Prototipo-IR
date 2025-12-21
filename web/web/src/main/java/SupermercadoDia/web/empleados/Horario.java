package SupermercadoDia.web.empleados;

import java.time.LocalDate;
import java.util.List;

import SupermercadoDia.web.model.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.CascadeType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "horarios")
public class Horario extends BaseEntity {

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "vigente")
    private boolean vigente;

    @OneToMany(mappedBy = "horario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Turno> turnos;

}
