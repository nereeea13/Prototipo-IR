package SupermercadoDia.web.tienda;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import SupermercadoDia.web.producto.Producto;

public interface StockProductoRepositorio extends CrudRepository<StockProducto, Integer> {

    StockProducto save(StockProducto s);

    Optional<StockProducto> findById(Integer id);

    Optional<StockProducto> findByProducto(Producto producto);

}
