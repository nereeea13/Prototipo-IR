package SupermercadoDia.web.pedidos;

import java.time.LocalDate;

import SupermercadoDia.web.model.BaseEntity;
import SupermercadoDia.web.model.Person;

public class Proveedor extends Person {

    private Integer telefono;
    private String email; 
    private String direccion;
    private Integer tiempoEntregaEstimado; 
    private LocalDate inicioHorarioEntrega; 
    private LocalDate finHorarioEntrega;
    private Double costeEnvio; 

    
    
}
