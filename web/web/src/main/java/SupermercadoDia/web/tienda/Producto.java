package SupermercadoDia.web.tienda;

import java.time.LocalDate;

import SupermercadoDia.web.enumerados.CategoriaProducto;
import SupermercadoDia.web.model.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "productos")
public class Producto extends BaseEntity {

    private String nombre;
    private String descripcion;
    private Double precio;
    private String ubicacion; // TODO: ????
    private LocalDate  fechaCaducidad;

    @Enumerated(EnumType.STRING)
    private CategoriaProducto categoria;
    
}
