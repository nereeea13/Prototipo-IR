package SupermercadoDia.web.pedidos.mercancia;

import SupermercadoDia.web.enumerados.EstadoPedido;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoMercanciaDTO {

    private Integer id; 

    private String fechaCreacion;
    private String fechaLlegada;

    @Enumerated(EnumType.STRING)
    private EstadoPedido estado;
    

    public PedidoMercanciaDTO() {
    }   

    public PedidoMercanciaDTO(Integer id, String fechaCreacion, String fechaLlegada, EstadoPedido estado) {
        this.id = id;
        this.fechaCreacion = fechaCreacion;
        this.fechaLlegada = fechaLlegada;
        this.estado = estado;
    }

    public PedidoMercanciaDTO(PedidoMercancia pedidoMercancia) {
        this.id = pedidoMercancia.getId();
        this.fechaCreacion = pedidoMercancia.getFechaCreacion().toString();
        this.fechaLlegada = pedidoMercancia.getFechaLlegada() != null ? pedidoMercancia.getFechaLlegada().toString() : null;
        this.estado = pedidoMercancia.getEstado();
    }
}
