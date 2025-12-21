package SupermercadoDia.web.empleados;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import SupermercadoDia.web.enumerados.EstadoSolicitud;

public interface SolicitudRepository extends CrudRepository<Solicitud, Integer> {

    Solicitud save(Solicitud solicitud);

   List<Solicitud> findByEstado(EstadoSolicitud estado);

   Optional<Solicitud> findById(Integer id);
    
}
