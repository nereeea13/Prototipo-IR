package SupermercadoDia.web.tienda;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import SupermercadoDia.web.producto.Producto;
import SupermercadoDia.web.producto.ProductoRepositorio;

@Service
@Transactional
public class StockProductoService {

    private final StockProductoRepositorio stockRepo;
    private final ProductoRepositorio productoRepositorio;

    public StockProductoService(StockProductoRepositorio stockRepo, ProductoRepositorio productoRepositorio) {
        this.stockRepo = stockRepo;
        this.productoRepositorio = productoRepositorio;
    }

    public Optional<StockProducto> findByProductoId(Integer productoId) {
        Optional<Producto> p = productoRepositorio.findById(productoId);
        if (p.isEmpty()) return Optional.empty();
        return stockRepo.findByProducto(p.get());
    }

    public Optional<StockProducto> updateStock(Integer productoId, Integer nuevaCantidad) {
        Optional<StockProducto> sOpt = findByProductoId(productoId);
        if (sOpt.isEmpty()) return Optional.empty();
        StockProducto s = sOpt.get();
        s.setStockTotal(nuevaCantidad);
        StockProducto saved = stockRepo.save(s);
        return Optional.of(saved);
    }

}
