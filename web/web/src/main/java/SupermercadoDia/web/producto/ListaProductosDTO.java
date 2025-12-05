package SupermercadoDia.web.producto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListaProductosDTO {

    private List<ProductoDTO> productos;

    public ListaProductosDTO() {
    }

    public ListaProductosDTO(List<Producto> productos) {
        this.productos = productos.stream().map(ProductoDTO::new).toList();
    }
    
}
