 package Fondita.Fer.Mapper;

import Fondita.Fer.DTO.DetalleVentaDto;
import Fondita.Fer.Entidades.DetalleVenta;
import Fondita.Fer.Entidades.Producto;

public class DetalleVentaMapper {
	 public static DetalleVentaDto mapToDetalleVentaDto(DetalleVenta dv) {
	        if (dv == null) return null;

	        Long idVenta = null;
	        if (dv.getIdVenta() != null) {
	            idVenta = dv.getIdVenta().getIdVenta();
	        }

	        Integer idProducto = null;
	        if (dv.getIdProducto() != null) {
	            idProducto = dv.getIdProducto().getIdProducto();
	        } else {
	        }

	        DetalleVentaDto dto = new DetalleVentaDto();
	        dto.setIdDetalle(dv.getIdDetalle());
	        dto.setIdVenta(idVenta);
	        dto.setIdProducto(idProducto);
	        dto.setCantidad(dv.getCantidad());
	        dto.setPrecioUnitario(dv.getPrecioUnitario());
	        return dto;
	    }


    public static DetalleVenta mapToDetalleVenta(DetalleVentaDto dto) {
        if (dto == null) return null;

        Producto p = null;
        if (dto.getIdProducto() != null) {
            p = new Producto();
            p.setIdProducto(dto.getIdProducto());
        }

        DetalleVenta detalle = new DetalleVenta();
        detalle.setIdDetalle(dto.getIdDetalle());
        detalle.setIdProducto(p);
        detalle.setCantidad(dto.getCantidad());
        detalle.setPrecioUnitario(dto.getPrecioUnitario());

        // idVenta se asigna después en VentaMapper
        return detalle;
    }
}
