package Fondita.Fer.Mapper;

import Fondita.Fer.DTO.ProductoDto;
import Fondita.Fer.Entidades.Producto;
import Fondita.Fer.Entidades.TipoProducto;

public class ProductoMapper {
    public static ProductoDto mapToProductoDto(Producto producto) {
        if (producto == null) return null;

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

    public static Producto mapToProducto(ProductoDto dto) {
        if (dto == null) return null;

        Producto producto = new Producto();
        producto.setIdProducto(dto.getIdProducto());
        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());
        producto.setPrecio(dto.getPrecio());
        producto.setIdTipo(dto.getIdTipo()); 
        producto.setEstatus(dto.getEstatus());
        producto.setImagen(dto.getImagen());
        return producto;
    }
}
