
package SupermercadoDia.web.tienda;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import SupermercadoDia.web.enumerados.CategoriaProducto;

@Service
@Transactional
public class ProductoService {

    private final ProductoRepositorio productoRepositorio;

    public ProductoService(ProductoRepositorio productoRepositorio) {
        this.productoRepositorio = productoRepositorio;
    }

    public Producto saveProducto(Producto producto) {
        return productoRepositorio.save(producto);
    }

    public List<Producto> findAllProductos() {
        return productoRepositorio.findAll();
    }

    public Optional<Producto> findProductoById(Integer id) {
        return productoRepositorio.findById(id);
    }

    public List<Producto> findProductosByCategoria(CategoriaProducto categoria) {
        return productoRepositorio.findByCategoria(categoria);
    }

}