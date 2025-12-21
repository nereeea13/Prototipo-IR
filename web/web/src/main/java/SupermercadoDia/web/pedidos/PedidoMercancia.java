package SupermercadoDia.web.pedidos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import SupermercadoDia.web.enumerados.EstadoPedido;
import SupermercadoDia.web.model.BaseEntity;
import SupermercadoDia.web.producto.Producto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pedido_mercancia")
@Getter
@Setter

public class PedidoMercancia extends BaseEntity {

    private LocalDate fechaCreacion; 
    private LocalDate fechaLlegada; 

    @Enumerated(EnumType.STRING)
    private EstadoPedido estado;

    @JsonManagedReference
    @OneToMany(
        mappedBy = "pedido",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<LineaPedido> lineas = new ArrayList<>();

    public void addLinea(Producto producto, Integer cantidad) {
        LineaPedido linea = new LineaPedido(this, producto, cantidad);
        lineas.add(linea);
    }

    public void removeLinea(LineaPedido linea) {
        lineas.remove(linea);
        linea.setPedido(null);
    }
    
}
