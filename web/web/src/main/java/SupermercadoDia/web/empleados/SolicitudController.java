package SupermercadoDia.web.empleados;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SupermercadoDia.web.enumerados.EstadoSolicitud;

@RestController
@RequestMapping("/api/solicitudes")
public class SolicitudController {

    private SolicitudService solicitudService;
    private  EmpleadoService empleadoService;

    public SolicitudController(SolicitudService solicitudService, EmpleadoService empleadoService) {
        this.solicitudService = solicitudService;
        this.empleadoService = empleadoService;
    }

    @PostMapping
    public ResponseEntity<SolicitudDTO> crearSolicitud(@RequestBody SolicitudDTO solicitud) {
        Empleado empleadoSolicitante = empleadoService.getEmpleadoPorId(solicitud.getEmpleadoSolicitanteId());
        Solicitud s = new Solicitud(solicitud.getFecha(), solicitud.getHorario(), solicitud.getMotivo(), empleadoSolicitante);
        Solicitud nuevaSolicitud = solicitudService.guardarSolicitud(s);
        Solicitud n = solicitudService.obtenerSolicitudPorId(nuevaSolicitud.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(new SolicitudDTO(n));
    }
    
    @GetMapping("/pendientes")
    public ResponseEntity<List<SolicitudDTO>> obtenerSolicitudesPendientes() {
        List<Solicitud> solicitudes = solicitudService.obtenerSolicitudesPendientes();
        List<SolicitudDTO> solicitudesDTO = solicitudes.stream()
            .map(SolicitudDTO::new)
            .collect(Collectors.toList());
        return ResponseEntity.ok(solicitudesDTO);
    }

    @PostMapping("/{id}/anunciar")
    public ResponseEntity<SolicitudDTO> anunciarSolicitud(@PathVariable Integer id) {
        Solicitud solicitud = solicitudService.obtenerSolicitudPorId(id);
        solicitud.setEstado(EstadoSolicitud.ANUNCIADA);
        Solicitud solicitudActualizada = solicitudService.guardarSolicitud(solicitud);
        return ResponseEntity.ok(new SolicitudDTO(solicitudActualizada));
    }

    @GetMapping("/anunciadas")
    public ResponseEntity<List<SolicitudDTO>> obtenerSolicitudesAnunciadas() {
        List<Solicitud> solicitudes = solicitudService.obtenerSolicitudesPorEstado(EstadoSolicitud.ANUNCIADA);
        List<SolicitudDTO> solicitudesDTO = solicitudes.stream()
            .map(SolicitudDTO::new)
            .collect(Collectors.toList());
        return ResponseEntity.ok(solicitudesDTO);
    }

    @PostMapping("/aplicar")
    public ResponseEntity<SolicitudDTO> aplicarSolicitud(@RequestBody SolicitudDTO solicitud) {
        Empleado empleadoAplicado = empleadoService.getEmpleadoPorId(solicitud.getEmpleadoAplicadoId());
        Solicitud s = solicitudService.obtenerSolicitudPorId(solicitud.getId());
        s.setEmpleadoAplicado(empleadoAplicado);
        Solicitud solicitudActualizada = solicitudService.guardarSolicitud(s);
        return ResponseEntity.ok(new SolicitudDTO(solicitudActualizada));
    }

    @PostMapping("/{id}/aceptarEmpleado")
    public ResponseEntity<SolicitudDTO> cambiarEmpleadoAplicadoYEstado(@PathVariable Integer id, @RequestBody SolicitudDTO solicitud) {
        Empleado empleadoAplicado = empleadoService.getEmpleadoPorId(solicitud.getEmpleadoAplicadoId());
        Solicitud s = solicitudService.obtenerSolicitudPorId(id);
        s.setEmpleadoAplicado(empleadoAplicado);
        s.setEstado(EstadoSolicitud.PENDIENTE_DE_CIERRE);
        Solicitud solicitudActualizada = solicitudService.guardarSolicitud(s);
        return ResponseEntity.ok(new SolicitudDTO(solicitudActualizada));
    }
    
}
