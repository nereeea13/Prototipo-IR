package SupermercadoDia.web.empleados;

import java.util.List;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ListEmpleadoDTO {
    
    private List<EmpleadoDTO> empleados;

    public ListEmpleadoDTO () {
    }

    public ListEmpleadoDTO (List<Empleado> empleados) {
        this.empleados = empleados.stream().map(e-> new EmpleadoDTO(e)).toList();
    }

}
