package Fondita.Fer.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Fondita.Fer.DTO.DetalleVentaDto;
import Fondita.Fer.DTO.VentaDto;
import Fondita.Fer.Service.DetalleVentaService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/detalleventa")
public class DetalleVentaController {
	private final DetalleVentaService detalleVentaService;

	@GetMapping("{id}")
	public ResponseEntity<DetalleVentaDto> getDetalleById(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(detalleVentaService.getDetalleById(id));
	}

	@GetMapping
	public ResponseEntity<List<DetalleVentaDto>> getAllDetalles() {
		return ResponseEntity.ok(detalleVentaService.getAllDetallesVenta());
	}

	@GetMapping("/venta/{ventaId}")
	public ResponseEntity<List<DetalleVentaDto>> getDetallesByVenta(@PathVariable("ventaId") Integer ventaId) {
		return ResponseEntity.ok(detalleVentaService.getDetallesByVenta(ventaId));
	}
	/*
	@PutMapping("{id}")
	public ResponseEntity<VentaDto> updateDetalleVenta(@PathVariable("id") Integer ventaId,
			@RequestBody VentaDto updateVenta) {
		VentaDto venta = detalleVentaService.updateDetalleVenta(ventaId, updateVenta);
		return ResponseEntity.ok(venta);
	}
	*/
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteVenta(@PathVariable("id") Integer ventaId) {
		detalleVentaService.deleteDetalleVenta(ventaId);
		return ResponseEntity.ok("Venta eliminada");
	}
}