package Fondita.Fer.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetalleVentaDto {
	private Integer idDetalle;
	private Long idVenta;
	private Integer idProducto;
	private Integer cantidad;
	private Float precioUnitario;
}
