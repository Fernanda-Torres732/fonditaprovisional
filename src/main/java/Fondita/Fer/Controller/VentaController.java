package Fondita.Fer.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import Fondita.Fer.DTO.VentaDto;
import Fondita.Fer.Service.VentaService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/venta")
public class VentaController {
	private final VentaService ventaService;

	@PostMapping
	public ResponseEntity<VentaDto> crearVenta(@RequestBody VentaDto ventaDto) {
		VentaDto guardada = ventaService.createVenta(ventaDto);
		return new ResponseEntity<>(guardada, HttpStatus.CREATED);
	}

	@GetMapping("{id}")
	public ResponseEntity<VentaDto> getVentaById(@PathVariable("id") Long ventaId) {
	    VentaDto venta = ventaService.getVentaById(ventaId);
	    return ResponseEntity.ok(venta);
	}

	@GetMapping
	public ResponseEntity<List<VentaDto>> getAllVentas() {
		List<VentaDto> ventas = ventaService.getAllVentas();
		return ResponseEntity.ok(ventas);
	}

	@PutMapping("{id}")
	public ResponseEntity<VentaDto> updateVenta(@PathVariable("id") Long ventaId,
	        @RequestBody VentaDto updateVenta) {
	    VentaDto venta = ventaService.updateVenta(ventaId, updateVenta);
	    return ResponseEntity.ok(venta);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteVenta(@PathVariable("id") Long ventaId) {
	    ventaService.deleteVenta(ventaId);
	    return ResponseEntity.ok("Venta eliminada");
	}


}