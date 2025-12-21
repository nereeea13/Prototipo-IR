package SupermercadoDia.web.empleados;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/empleados")
public class TurnoController {

    private final TurnoService turnoService;

    public TurnoController(TurnoService turnoService) {
        this.turnoService = turnoService;
    }

    @GetMapping("/{id}/turnos")
    public ResponseEntity<List<TurnoDTO>> getTurnosEmpleado(@PathVariable Integer id) {
        List<TurnoDTO> turnos = turnoService.getTurnosByEmpleado(id);
        return ResponseEntity.ok(turnos);
    }

    @GetMapping("/nombre/{nombre}/turnos/vigente")
    public ResponseEntity<List<TurnoDTO>> getTurnosVigenteByNombre(@PathVariable String nombre) {
        List<TurnoDTO> turnos = turnoService.getTurnosVigenteByEmpleadoNombre(nombre);
        return ResponseEntity.ok(turnos);
    }

    @GetMapping("/id/{id}/turnos/vigente")
    public ResponseEntity<List<TurnoDTO>> getTurnosVigenteByid(@PathVariable Integer id) {
        List<TurnoDTO> turnos = turnoService.getTurnosVigenteByEmpleadoId(id);
        return ResponseEntity.ok(turnos);
    }
}
