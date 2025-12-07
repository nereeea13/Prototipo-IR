package SupermercadoDia.web.pedidos;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.ManyToMany;

public class Camion {

    private String matricula;
    private double capacidadCarga; // en kg
    private String modelo;
    // TODO: private String ruta; COMO COJONES LA PONGO???????????

    private LocalDate fechaSalida; 
    private LocalDate fechaLlegada; 
    private String ubicacion; 

    @ManyToMany
    private List<TransportistaCamion> transportistas;
    
}
