package SupermercadoDia.web.empleados;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmpleadoDTO> crearEmpleado(@RequestBody EmpleadoDTO empleado) {
        Empleado nuevoEmpleado = new Empleado(
            empleado.getNombre(),
            empleado.getApellidos(),
            empleado.getDni(),
            empleado.getTelefono(),
            empleado.getEmail(),
            empleado.getSalario(),
            empleado.getDiasVacacionesVeranoRestantes(),
            empleado.getDiasVacacionesInviernoRestantes(),
            empleado.getRol(),
            empleado.getContratoHorasSemanales(),
            empleado.getTipoContrato(),
            empleado.getPreferenciaTurno(),
            empleado.getEstado(),
            empleado.getFoto()
        );
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
