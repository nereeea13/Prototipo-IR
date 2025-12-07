package SupermercadoDia.web.pedidos.mercancia;

import java.lang.foreign.Linker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import SupermercadoDia.web.enumerados.EstadoPedido;

public interface PedidosMercanciaRepository extends CrudRepository<PedidoMercancia, Integer> {

    PedidoMercancia save(PedidoMercancia pedidoMercancia);

    Optional<PedidoMercancia> findById(Integer id);

    List<PedidoMercancia> findAll();

    List<PedidoMercancia> findByEstado(EstadoPedido estado);


    
}
