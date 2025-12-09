package Fondita.Fer.Service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import Fondita.Fer.DTO.ProductoDto;
import Fondita.Fer.Entidades.Producto;
import Fondita.Fer.Repository.ProductoRepository;
import Fondita.Fer.Service.ProductoService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;
    @Override
    public ProductoDto createProducto(ProductoDto productoDto) {
        Producto producto = mapToEntity(productoDto);

        producto.setEstatus(1);

        Producto saved = productoRepository.save(producto);
        return mapToDto(saved);
    }

    public ProductoDto getProductoById(int id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id " + id));
        return mapToDto(producto);
    }

    @Override
    public ProductoDto updateProducto(int id, ProductoDto updateDto) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id " + id));

        producto.setNombre(updateDto.getNombre());
        producto.setDescripcion(updateDto.getDescripcion());
        producto.setPrecio(updateDto.getPrecio());
        producto.setIdTipo(updateDto.getIdTipo());
        producto.setImagen(updateDto.getImagen());
        Producto updated = productoRepository.save(producto);
        return mapToDto(updated);
    }

    private ProductoDto mapToDto(Producto producto) {
        return new ProductoDto(
                producto.getIdProducto(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getPrecio(),
                producto.getIdTipo(),
                producto.getEstatus(),
                producto.getImagen()
        );
    }

    private Producto mapToEntity(ProductoDto dto) {
        return new Producto(
                dto.getIdProducto(),
                dto.getNombre(),
                dto.getDescripcion(),
                dto.getPrecio(),
                dto.getIdTipo(),
                dto.getEstatus(),
                dto.getImagen()
        );
    }

    @Override
    public List<ProductoDto> getAllProductosActivos() {
        return productoRepository.findByEstatus(1)
                .stream()
                .map(this::mapToDto) 
                .collect(Collectors.toList());
    }
    public void desactivarProducto(int idProducto) {
        Producto producto = productoRepository.findById(idProducto)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        producto.setEstatus(0);
        productoRepository.save(producto);
    }
}
