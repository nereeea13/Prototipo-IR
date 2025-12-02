package SupermercadoDia.web.tienda;

import java.time.LocalDate;

import SupermercadoDia.web.enumerados.CategoriaProducto;
import SupermercadoDia.web.model.BaseEntity;

public class Producto extends BaseEntity {

    private String nombre;
    private String descripcion;
    private Double precio;
    private String ubicacion; // TODO: ????
    private LocalDate  fechaCaducidad;
    private CategoriaProducto categoria;
    
}
