package Fondita.Fer.Entidades;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "detalleventa")
public class DetalleVenta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idDetalle")
	private Integer idDetalle;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "idVenta", nullable = false, foreignKey = @ForeignKey(name = "fk_detalleventa_venta"))
	private Venta idVenta;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "idProducto", nullable = false, foreignKey = @ForeignKey(name = "fk_detalleventa_producto"))
	private Producto idProducto;

	@Column(name = "cantidad", nullable = false)
	private Integer cantidad;

	@Column(name = "preciounitario", nullable = false)
	private Float precioUnitario;

}