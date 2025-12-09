package Fondita.Fer.DTO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class ProductoDto {
	private int idProducto;
	private String nombre;
	private String descripcion;
	private float precio;
	private int idTipo;
	private int estatus;
	private String imagen;
}
