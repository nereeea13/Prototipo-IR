package SupermercadoDia.web.pedidos.mercancia;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SupermercadoDia.web.enumerados.EstadoPedido;

@Service
public class PedidosMercanciaService {

    private  PedidosMercanciaRepository pedidosMercanciaRepository;

    @Autowired
    public PedidosMercanciaService(PedidosMercanciaRepository pedidosMercanciaRepository) {
        this.pedidosMercanciaRepository = pedidosMercanciaRepository;
    }


    public List<PedidoMercancia> getAll(){
        return pedidosMercanciaRepository.findAll();
    }


    public PedidoMercancia findById (Integer id) {
        return pedidosMercanciaRepository.findById(id).orElse(null);
    } 
    
    
    public List<PedidoMercancia> findByEstado (EstadoPedido estado) {
        return pedidosMercanciaRepository.findByEstado(estado);
    }

    public PedidoMercancia crearPedidoMercancia(PedidoMercancia pedidoMercancia) {
        if (pedidoMercancia == null) {
            throw new IllegalArgumentException("El pedido de mercancía no puede ser nulo");
        }
        return pedidosMercanciaRepository.save(pedidoMercancia);
    }

    public List<PedidoMercancia> getPedidosRealizados() {
       List<PedidoMercancia> pedidosRealizados = new ArrayList<>();

       List<PedidoMercancia> pedidosEntregados = pedidosMercanciaRepository.findByEstado(EstadoPedido.ENTREGADO);
       List<PedidoMercancia> pedidosEnEntrega = pedidosMercanciaRepository.findByEstado(EstadoPedido.EN_ENTREGA);
       List<PedidoMercancia> pedidosEnPreparacion = pedidosMercanciaRepository.findByEstado(EstadoPedido.EN_PREPARACION);

        pedidosRealizados.addAll(pedidosEntregados);
        pedidosRealizados.addAll(pedidosEnEntrega);
        pedidosRealizados.addAll(pedidosEnPreparacion);

       return pedidosRealizados;
    }


    
}
