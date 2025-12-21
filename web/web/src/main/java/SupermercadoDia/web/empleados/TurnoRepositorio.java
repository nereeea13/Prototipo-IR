package SupermercadoDia.web.empleados;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TurnoRepositorio extends CrudRepository<Turno, Integer> {
    List<Turno> findByFechaAndEmpleadoId(java.time.LocalDate fecha, Integer empleadoId);
    List<Turno> findByEmpleadoId(Integer empleadoId);
    List<Turno> findByHorarioId(Integer horarioId);
    List<Turno> findByHorarioIdAndEmpleadoId(Integer horarioId, Integer empleadoId);
}
