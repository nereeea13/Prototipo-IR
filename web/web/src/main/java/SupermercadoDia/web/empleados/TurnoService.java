package SupermercadoDia.web.empleados;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Collections;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import SupermercadoDia.web.enumerados.TipoTurno;
import SupermercadoDia.web.enumerados.EstadoTurno;

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

    public List<TurnoDTO> getTurnosVigenteByEmpleadoId(Integer id) {
        java.util.Optional<Empleado> optEmpleado = empleadoRepository.findById(id);
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

    public TurnoDTO updateTurno(Integer turnoId, TurnoUpdateDTO dto) {
        Optional<Turno> opt = turnoRepositorio.findById(turnoId);
        if (opt.isEmpty()) throw new IllegalArgumentException("Turno not found");
        Turno turno = opt.get();

        if (dto.getFecha() != null && !dto.getFecha().isBlank()) {
            turno.setFecha(LocalDate.parse(dto.getFecha()));
        }
        if (dto.getHoraInicio() != null && !dto.getHoraInicio().isBlank()) {
            turno.setHoraInicio(LocalTime.parse(dto.getHoraInicio()));
        }
        if (dto.getHoraFin() != null && !dto.getHoraFin().isBlank()) {
            turno.setHoraFin(LocalTime.parse(dto.getHoraFin()));
        }
        if (dto.getTipo() != null && !dto.getTipo().isBlank()) {
            turno.setTipo(TipoTurno.valueOf(dto.getTipo()));
        }
        if (dto.getEstado() != null && !dto.getEstado().isBlank()) {
            turno.setEstado(EstadoTurno.valueOf(dto.getEstado()));
        }
        if (dto.getEmpleadoId() != null) {
            var empOpt = empleadoRepository.findById(dto.getEmpleadoId());
            if (empOpt.isEmpty()) throw new IllegalArgumentException("Empleado not found");
            turno.setEmpleado(empOpt.get());
        }

        turnoRepositorio.save(turno);
        return new TurnoDTO(turno);
    }
}
