package SupermercadoDia.web.tienda;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import SupermercadoDia.web.enumerados.CategoriaProducto;

public interface ProductoRepositorio extends CrudRepository<Producto,Integer> {

    Producto save(Producto p);

    List<Producto> findAll();

    Optional<Producto> findById(Integer id);

    List<Producto> findByCategoria(CategoriaProducto categoria);

    
    
}
