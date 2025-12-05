package SupermercadoDia.web.producto;

import SupermercadoDia.web.enumerados.CategoriaProducto;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProductoDTO {

        private Integer id;

        private String nombre;

        @Enumerated(EnumType.STRING)
        private CategoriaProducto categoria;

        private Integer cantidadTotal;

        private String estadoStock;

        private String foto;


        
    public ProductoDTO() {
    }

    public ProductoDTO(Producto p){
        this.id=p.getId();
        this.nombre= p.getNombre();
        this.categoria= p.getCategoria();
        this.cantidadTotal = p.getStock().getStockTotal();
        this.foto = p.getFoto();
        if(p.getStock().getStockTotal()< p.getStock().getStockMinimo()){
            this.estadoStock= "BAJO";
        } else if (p.getStock().getStockMinimo() < p.getStock().getStockTotal() && p.getStock().getStockTotal() < 1000){
            this.estadoStock= "NORMAL";
        } else {
            this.estadoStock = "SOBRESTOCK";
        }
    }
    
}
