package SupermercadoDia.web.empleados;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/horarios")
public class HorarioController {

    private final TurnoService turnoService;
    private final HorarioService horarioService;

    public HorarioController(TurnoService turnoService, HorarioService horarioService) {
        this.turnoService = turnoService;
        this.horarioService = horarioService;
    }

    @GetMapping("/{id}/turnos")
    public ResponseEntity<List<TurnoDTO>> getTurnosPorHorario(@PathVariable Integer id) {
        List<TurnoDTO> turnos = turnoService.getTurnosByHorario(id);
        return ResponseEntity.ok(turnos);
    }

    @GetMapping("/vigente/turnos")
    public ResponseEntity<List<TurnoDTO>> getTurnosHorarioVigente() {
        List<TurnoDTO> turnos = turnoService.getTurnosHorarioVigente();
        return ResponseEntity.ok(turnos);
    }

    @GetMapping("/vigente/turnos/aleatorios")
    public ResponseEntity<List<TurnoDTO>> getTurnosAleatoriosVigente() {
        List<TurnoDTO> turnos = turnoService.getRandomTurnosHorarioVigente(3);
        return ResponseEntity.ok(turnos);
    }

    @PostMapping("/generar")
    public ResponseEntity<HorarioDTO> generarHorarioAleatorio() {
        Horario h = horarioService.generarHorarioAleatorio();
        if (h == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(new HorarioDTO(h));
    }

    @PostMapping("/cambiar")
    public ResponseEntity<HorarioDTO> cambiarHorario() {
        Horario h = horarioService.cambiarHorario();
        if (h == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(new HorarioDTO(h));
    }
}
