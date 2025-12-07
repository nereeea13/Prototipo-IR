package SupermercadoDia.web.tienda;

import java.time.LocalDate;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InventarioTienda {

    private LocalDate fechaUltimaActualizacion;

    @ManyToOne
    @JoinColumn(name = "stock_id")
    @Enumerated(EnumType.STRING)
    private StockProducto stock;
    
}
