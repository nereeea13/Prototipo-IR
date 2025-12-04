package SupermercadoDia.web.tienda;

import SupermercadoDia.web.model.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "stock_producto")
public class StockProducto extends BaseEntity {

    private Integer stockTotal; 
    private Integer stockMinimo;
    private Integer stockAlmacen; 
    private Integer stockExpuesto; 

    @OneToOne
    @JoinColumn(name = "producto_id", unique = true)
    private Producto producto;



    
}
