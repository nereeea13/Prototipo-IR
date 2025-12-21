package SupermercadoDia.web.empleados;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HorarioService {

    private final HorarioRepositorio horarioRepositorio;

    public HorarioService(HorarioRepositorio horarioRepositorio) {
        this.horarioRepositorio = horarioRepositorio;
    }

    public Horario generarHorarioAleatorio() {
        List<Horario> horarios = new ArrayList<>();
        horarioRepositorio.findAll().forEach(horarios::add);
        if (horarios.isEmpty()) return null;
        Random rand = new Random();
        Horario elegido = horarios.get(rand.nextInt(horarios.size()));
        for (Horario h : horarios) {
            h.setVigente(h == elegido);
        }
        horarioRepositorio.saveAll(horarios);
        return elegido;
    }

    public Horario cambiarHorario() {
        List<Horario> horarios = new ArrayList<>();
        horarioRepositorio.findAll().forEach(horarios::add);
        if (horarios.isEmpty()) return null;

        // find currently vigente
        Horario actual = horarioRepositorio.findByVigenteTrue().orElse(null);

        if (actual == null) {
            // no current active -> activate the first one
            Horario first = horarios.get(0);
            first.setVigente(true);
            horarioRepositorio.save(first);
            return first;
        }

        // find another horario different from actual
        Horario otro = null;
        for (Horario h : horarios) {
            if (!h.getId().equals(actual.getId())) {
                otro = h;
                break;
            }
        }

        if (otro == null) {
            // only one exists, keep it
            return actual;
        }

        // switch
        actual.setVigente(false);
        otro.setVigente(true);
        horarioRepositorio.save(actual);
        horarioRepositorio.save(otro);
        return otro;
    }
}
