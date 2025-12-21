package SupermercadoDia.web.producto;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import SupermercadoDia.web.enumerados.CategoriaProducto;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;
    private final SupermercadoDia.web.tienda.StockProductoService stockProductoService;

    public ProductoController(ProductoService productoService, SupermercadoDia.web.tienda.StockProductoService stockProductoService) {
        this.productoService = productoService;
        this.stockProductoService = stockProductoService;
    }

    @GetMapping
    public ListaProductosDTO getAllProductos() {
        List<Producto> l = productoService.findAllProductos();
        ListaProductosDTO listaDTO = new ListaProductosDTO(l);
        return listaDTO;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable Integer id) {
        Optional<Producto> producto = productoService.findProductoById(id);
        return producto.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<ListaProductosDTO> getProductosByCategoria(@PathVariable String categoria) {
        try {
            CategoriaProducto cat = CategoriaProducto.valueOf(categoria.toUpperCase());
            List<Producto> productos = productoService.findProductosByCategoria(cat);
            ListaProductosDTO listaDTO = new ListaProductosDTO(productos);
            return ResponseEntity.ok(listaDTO);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<Producto> createProducto(@RequestBody Producto producto) {
        Producto saved = productoService.saveProducto(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> updateProducto(@PathVariable Integer id, @RequestBody Producto producto) {
        Optional<Producto> existing = productoService.findProductoById(id);
        if (existing.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        producto.setId(id);
        Producto saved = productoService.saveProducto(producto);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}/stock")
    public ResponseEntity<?> updateProductoStock(@PathVariable Integer id, @RequestBody SupermercadoDia.web.tienda.StockUpdateDTO dto) {
        if (dto == null || dto.getStockTotal() == null) {
            return ResponseEntity.badRequest().body("stockTotal is required");
        }
        Integer nueva = dto.getStockTotal();
        var updated = stockProductoService.updateStock(id, nueva);
        return updated.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    
}
