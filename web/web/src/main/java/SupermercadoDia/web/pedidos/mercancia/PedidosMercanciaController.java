package SupermercadoDia.web.pedidos.mercancia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/pedidos-mercancia")
public class PedidosMercanciaController {

    private PedidosMercanciaService pedidosMercanciaService;

    @Autowired
    public PedidosMercanciaController(PedidosMercanciaService pedidosMercanciaService) {
        this.pedidosMercanciaService = pedidosMercanciaService;
    }

    @GetMapping
    public ListaPedidosMercanciaDTO getAllPedidosMercancia() {
        return new ListaPedidosMercanciaDTO(pedidosMercanciaService.getAll());
    } 

    @GetMapping("/en-revision")
    public ListaPedidosMercanciaDTO getPedidosMercanciaEnRevision() {
        return new ListaPedidosMercanciaDTO(pedidosMercanciaService.findByEstado(SupermercadoDia.web.enumerados.EstadoPedido.EN_REVISION));
    }

    @GetMapping("/realizados")
    public ListaPedidosMercanciaDTO getPedidosRealizados() {
        return new ListaPedidosMercanciaDTO(pedidosMercanciaService.getPedidosRealizados());
    }

    @GetMapping("{id}")
    public PedidoMercanciaDTO getPedidoMercanciaById(Integer id) {
        PedidoMercancia pedidoMercancia = pedidosMercanciaService.findById(id);
        return new PedidoMercanciaDTO(pedidoMercancia);
    }

    
    
}
