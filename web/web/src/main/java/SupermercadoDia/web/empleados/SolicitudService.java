package SupermercadoDia.web.empleados;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import SupermercadoDia.web.enumerados.EstadoSolicitud;

@Service
public class SolicitudService {

    private  SolicitudRepository solicitudRepository;

    public SolicitudService(SolicitudRepository solicitudRepository) {
        this.solicitudRepository = solicitudRepository;
    }


    public Solicitud guardarSolicitud(Solicitud solicitud) {
        return solicitudRepository.save(solicitud);
    }

    public List<Solicitud> obtenerSolicitudesPendientes() {
        List<Solicitud> solicitudes = new ArrayList<>();

        List<Solicitud> solicitudesPendientesAnuncio = solicitudRepository.findByEstado(EstadoSolicitud.PENDIENTE_DE_ANUNCIO);
        List<Solicitud> solicitudesAnunciadas = solicitudRepository.findByEstado(EstadoSolicitud.ANUNCIADA);
        List<Solicitud> solicitudesPendientesCierre = solicitudRepository.findByEstado(EstadoSolicitud.PENDIENTE_DE_CIERRE);

        solicitudes.addAll(solicitudesPendientesAnuncio);
        solicitudes.addAll(solicitudesAnunciadas);  
        solicitudes.addAll(solicitudesPendientesCierre);
        
        return solicitudes;
    
    }


    public Solicitud obtenerSolicitudPorId(Integer id) {
        return solicitudRepository.findById(id).orElse(null);
    }




    
}
