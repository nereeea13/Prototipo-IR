package SupermercadoDia.web.pedidos;

import org.springframework.stereotype.Repository;

import SupermercadoDia.web.enumerados.EstadoPedido;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface pedidosRepositorio  extends CrudRepository<PedidoMercancia, Integer> {

    Optional<PedidoMercancia> findById(Integer id);

    List<PedidoMercancia> findByEstado(EstadoPedido estado);

    // Devuelve pedidos cuyo estado es distinto al pasado (NOT equals)
    List<PedidoMercancia> findByEstadoNot(EstadoPedido estado);


    
}
