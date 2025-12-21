package SupermercadoDia.web.empleados;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/turnos")
public class TurnoAdminController {

    private final TurnoService turnoService;

    public TurnoAdminController(TurnoService turnoService) {
        this.turnoService = turnoService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<TurnoDTO> updateTurno(@PathVariable Integer id, @RequestBody TurnoUpdateDTO dto) {
        try {
            TurnoDTO updated = turnoService.updateTurno(id, dto);
            return ResponseEntity.ok(updated);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}
