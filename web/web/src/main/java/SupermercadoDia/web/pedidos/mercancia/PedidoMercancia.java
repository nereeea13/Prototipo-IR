package SupermercadoDia.web.pedidos.mercancia;

import java.time.LocalDate;

import SupermercadoDia.web.enumerados.EstadoPedido;
import SupermercadoDia.web.model.BaseEntity;
import SupermercadoDia.web.pedidos.Camion;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pedidos_mercancia")
public class PedidoMercancia extends BaseEntity {

    private LocalDate fechaCreacion; 
    private LocalDate fechaLlegada; 

    @Enumerated(EnumType.STRING)
    private EstadoPedido estado;

    @ManyToOne
    private Camion camion;
    
}
