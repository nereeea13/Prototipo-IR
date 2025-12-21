package SupermercadoDia.web.empleados;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface EmpleadoRepository extends CrudRepository<Empleado, Integer>  {

    Empleado save(Empleado empleado);

    Optional<Empleado> findById(Integer id);

    List<Empleado> findAll();

    java.util.Optional<Empleado> findByNombre(String nombre);


    
}
    