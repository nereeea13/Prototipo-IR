package SupermercadoDia.web.empleados;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Collections;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TurnoService {

    private final TurnoRepositorio turnoRepositorio;
    private final HorarioRepositorio horarioRepositorio;
    private final EmpleadoRepository empleadoRepository;

    public TurnoService(TurnoRepositorio turnoRepositorio, HorarioRepositorio horarioRepositorio, EmpleadoRepository empleadoRepository) {
        this.turnoRepositorio = turnoRepositorio;
        this.horarioRepositorio = horarioRepositorio;
        this.empleadoRepository = empleadoRepository;
    }

    public List<TurnoDTO> getTurnosByEmpleado(Integer empleadoId) {
        List<Turno> turnos = turnoRepositorio.findByEmpleadoId(empleadoId);
        return turnos.stream().map(TurnoDTO::new).collect(Collectors.toList());
    }

    public List<TurnoDTO> getTurnosByHorario(Integer horarioId) {
        List<Turno> turnos = turnoRepositorio.findByHorarioId(horarioId);
        return turnos.stream().map(TurnoDTO::new).collect(Collectors.toList());
    }

    public List<TurnoDTO> getTurnosHorarioVigente() {
        return horarioRepositorio.findByVigenteTrue()
                .map(h -> turnoRepositorio.findByHorarioId(h.getId()).stream()
                        .map(TurnoDTO::new).collect(Collectors.toList()))
                .orElseGet(java.util.Collections::emptyList);
    }

    public List<TurnoDTO> getTurnosVigenteByEmpleadoNombre(String nombre) {
        java.util.Optional<Empleado> optEmpleado = empleadoRepository.findByNombre(nombre);
        if (optEmpleado.isEmpty()) return java.util.Collections.emptyList();
        Empleado empleado = optEmpleado.get();

        return horarioRepositorio.findByVigenteTrue()
                .map(h -> turnoRepositorio.findByHorarioIdAndEmpleadoId(h.getId(), empleado.getId()).stream()
                        .map(TurnoDTO::new).collect(Collectors.toList()))
                .orElseGet(java.util.Collections::emptyList);
    }

    public List<TurnoDTO> getRandomTurnosHorarioVigente(int count) {
        return horarioRepositorio.findByVigenteTrue()
                .map(h -> {
                    List<Turno> turnos = turnoRepositorio.findByHorarioId(h.getId());
                    if (turnos == null || turnos.isEmpty()) return Collections.<TurnoDTO>emptyList();
                    Collections.shuffle(turnos);
                    return turnos.stream().limit(count).map(TurnoDTO::new).collect(Collectors.toList());
                }).orElseGet(Collections::emptyList);
    }
}
