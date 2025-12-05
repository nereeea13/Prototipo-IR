package SupermercadoDia.web.producto;

import java.time.LocalDate;

import SupermercadoDia.web.enumerados.CategoriaProducto;
import SupermercadoDia.web.model.BaseEntity;
import SupermercadoDia.web.tienda.StockProducto;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
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

    private String foto; // URL o path a la foto del producto

    @Enumerated(EnumType.STRING)
    private CategoriaProducto categoria;

    @OneToOne(mappedBy = "producto")
    private StockProducto stock;
    
}
