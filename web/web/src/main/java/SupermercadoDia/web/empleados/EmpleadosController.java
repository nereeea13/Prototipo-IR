package SupermercadoDia.web.empleados;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/empleados")
public class EmpleadosController {


    private EmpleadoService empleadoService;

    @Autowired
    public EmpleadosController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping
    public ListEmpleadoDTO getAllEmpleados() {
        return new ListEmpleadoDTO(empleadoService.getAll());
    }
    

    @PostMapping
    public EmpleadoDTO crearEmpleado(EmpleadoDTO empleado) {
        Empleado nuevoEmpleado = new Empleado(empleado.getNombre(), empleado.getApellidos(), empleado.getDni(),
                empleado.getTelefono(), empleado.getEmail(), empleado.getSalario(),
                empleado.getDiasVacacionesVeranoRestantes(), empleado.getDiasVacacionesInviernoRestantes(), empleado.getRol(), 
                empleado.getContratoHorasSemanales(),
                empleado.getTipoContrato(), empleado.getPreferenciaTurno(), empleado.getEstado(),
                empleado.getFoto());
        Empleado empleadoCreado = empleadoService.createEmpleado(nuevoEmpleado);
        return new EmpleadoDTO(empleadoCreado);
    }

    @DeleteMapping("/{id}")
    public void deleteEmpleado(Integer id) {
        empleadoService.deleteEmpleado(id);
    }   

    @PutMapping("/{id}")
    public EmpleadoDTO actualizarEmpleado(@PathVariable Integer id, @RequestBody EmpleadoDTO empleadoActualizado) {
        return new EmpleadoDTO(empleadoService.updateEmpleado(id, empleadoActualizado)); 
    }


}
