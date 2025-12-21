package SupermercadoDia.web.empleados;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import SupermercadoDia.web.enumerados.EstadoEmpleado;
import SupermercadoDia.web.enumerados.TipoContrato;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadosController {

    private final EmpleadoService empleadoService;

    @Autowired
    public EmpleadosController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ListEmpleadoDTO> getAllEmpleados() {
        return ResponseEntity.ok(new ListEmpleadoDTO(empleadoService.getAll()));
    }

    // Nuevo endpoint: obtener empleado por id
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmpleadoDTO> getEmpleadoById(@PathVariable Integer id) {
        Empleado empleado = empleadoService.getEmpleadoPorId(id);
        if (empleado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new EmpleadoDTO(empleado));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmpleadoDTO> crearEmpleado(@RequestBody CrearEmpleadoDTO empleado) {
        Empleado nuevoEmpleado = new Empleado();
        nuevoEmpleado.setNombre(empleado.getNombre());
        nuevoEmpleado.setApellidos(empleado.getApellidos());
        nuevoEmpleado.setDni(empleado.getDni());
        nuevoEmpleado.setTelefono(Integer.parseInt(empleado.getTelefono()));
        nuevoEmpleado.setEmail(empleado.getEmail());
        nuevoEmpleado.setSalario(1200.0);
        nuevoEmpleado.setDiasVacacionesVeranoRestantes(15);
        nuevoEmpleado.setDiasVacacionesInviernoRestantes(15);
        nuevoEmpleado.setRol(empleado.getRol());
        nuevoEmpleado.setContratoHorasSemanales(empleado.getContratoHorasSemanales());
        nuevoEmpleado.setTipoContrato(TipoContrato.JORNADA_COMPLETA);
        nuevoEmpleado.setPreferenciaTurno(empleado.getPreferenciaTurno());
        nuevoEmpleado.setEstado(EstadoEmpleado.ACTIVO);
        nuevoEmpleado.setFoto(empleado.getFoto());
        Empleado empleadoCreado = empleadoService.createEmpleado(nuevoEmpleado);
        return ResponseEntity.ok(new EmpleadoDTO(empleadoCreado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmpleado(@PathVariable Integer id) {
        empleadoService.deleteEmpleado(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmpleadoDTO> actualizarEmpleado(@PathVariable Integer id, @RequestBody EmpleadoDTO empleadoActualizado) {
        Empleado actualizado = empleadoService.updateEmpleado(id, empleadoActualizado);
        return ResponseEntity.ok(new EmpleadoDTO(actualizado));
    }


}