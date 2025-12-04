package SupermercadoDia.web.tienda;

import java.time.LocalDate;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class InventarioTienda {

    private LocalDate fechaUltimaActualizacion;

    @ManyToOne
    @JoinColumn(name = "stock_id")
    private StockProducto stock;
    
}
