package SupermercadoDia.web.empleados;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoService {

    private  EmpleadoRepository empleadoRepository;

    @Autowired
    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }
    


    public Empleado crearEmpleado(Empleado empleado) {
        if (empleado == null) {
            throw new IllegalArgumentException("El empleado no puede ser nulo");
        }
        return empleadoRepository.save(empleado);
    }

    public Empleado getEmpleadoPorId(Integer id) {
        return empleadoRepository.findById(id).orElse(null);
    }

    public List<Empleado> getAll() {
        return empleadoRepository.findAll();
    }

    public Empleado createEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    public void deleteEmpleado(Integer id) {
        Empleado e = getEmpleadoPorId(id);
            if (e == null) {
                throw new IllegalArgumentException("El empleado con id " + id + " no existe");
            }
        empleadoRepository.deleteById(id);
    }

    public Empleado updateEmpleado(Integer id, EmpleadoDTO empleadoActualizado) {
        Empleado empleadoExistente = getEmpleadoPorId(id);
        if (empleadoExistente == null) {
            throw new IllegalArgumentException("El empleado con id " + id + " no existe");
        }
        // Actualizar los campos del empleado existente con los valores del empleado actualizado
        empleadoExistente.setNombre(empleadoActualizado.getNombre());
        empleadoExistente.setApellidos(empleadoActualizado.getApellidos());
        empleadoExistente.setDni(empleadoActualizado.getDni());
        empleadoExistente.setTelefono(empleadoActualizado.getTelefono());
        empleadoExistente.setEmail(empleadoActualizado.getEmail());
        empleadoExistente.setRol(empleadoActualizado.getRol());
        empleadoExistente.setContratoHorasSemanales(empleadoActualizado.getContratoHorasSemanales());
        empleadoExistente.setPreferenciaTurno(empleadoActualizado.getPreferenciaTurno());
        empleadoExistente.setEstado(empleadoActualizado.getEstado());
        empleadoExistente.setFoto(empleadoActualizado.getFoto());

        return empleadoRepository.save(empleadoExistente);
    }


}
