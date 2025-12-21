package SupermercadoDia.web.empleados;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface HorarioRepositorio extends CrudRepository<Horario, Integer> {
    Optional<Horario> findByVigenteTrue();
}
