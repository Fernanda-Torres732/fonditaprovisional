package Fondita.Fer.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import Fondita.Fer.DTO.ProductoDto;
import Fondita.Fer.Entidades.Producto;
import Fondita.Fer.Repository.ProductoRepository;
import lombok.AllArgsConstructor;
@Service
public interface ProductoService {
    ProductoDto createProducto(ProductoDto productoDto);
    ProductoDto getProductoById(int id);
    ProductoDto updateProducto(int id, ProductoDto updateDto);
	List<ProductoDto> getAllProductosActivos();
	void desactivarProducto(int id);
}
