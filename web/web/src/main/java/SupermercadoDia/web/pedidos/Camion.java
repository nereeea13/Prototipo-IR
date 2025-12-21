package SupermercadoDia.web.pedidos;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.ManyToMany;

public class Camion {

    // TODO: private String ruta; COMO COJONES LA PONGO???????????

    private LocalDate fechaSalida; 
    private LocalDate fechaLlegada; 
    private String ubicacion; 

    @ManyToMany
    private List<TransportistaCamion> transportistas;
    
}
