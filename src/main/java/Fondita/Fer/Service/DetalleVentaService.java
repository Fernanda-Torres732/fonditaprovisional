package Fondita.Fer.Service;

import java.util.List;

import Fondita.Fer.DTO.DetalleVentaDto;
import Fondita.Fer.DTO.VentaDto;

public interface DetalleVentaService {
	DetalleVentaDto getDetalleById(Integer detalleId);
	List<DetalleVentaDto> getAllDetallesVenta();
	List<DetalleVentaDto> getDetallesByVenta(Integer id_venta);
	void deleteDetalleVenta(Integer ventaId);
	
}
