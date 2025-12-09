package Fondita.Fer.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Fondita.Fer.DTO.ProductoDto;
import Fondita.Fer.Service.ProductoService;
import lombok.AllArgsConstructor;
@CrossOrigin(origins = "http://localhost:4000")
@AllArgsConstructor
@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    private final ProductoService productoService;

    @PostMapping
    public ResponseEntity<ProductoDto> crearProducto(@RequestBody ProductoDto productoDto) {
        ProductoDto guardarProducto = productoService.createProducto(productoDto);
        return new ResponseEntity<>(guardarProducto, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductoDto> getProductoById(@PathVariable("id") Integer id) {
        ProductoDto productoDto = productoService.getProductoById(id);
        return ResponseEntity.ok(productoDto);
    }

    @GetMapping
    public ResponseEntity<List<ProductoDto>> getAllProductosActivos() {
        List<ProductoDto> productos = productoService.getAllProductosActivos();
        return ResponseEntity.ok(productos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoDto> updateProducto(@PathVariable("id") Integer id,
                                                      @RequestBody ProductoDto updateProducto) {
        ProductoDto productoDto = productoService.updateProducto(id, updateProducto);
        return ResponseEntity.ok(productoDto);
    }


    @PutMapping("/{id}/desactivar")
    public ResponseEntity<Void> desactivarProducto(@PathVariable int id) {
        productoService.desactivarProducto(id);
        return ResponseEntity.noContent().build();
    }

}
