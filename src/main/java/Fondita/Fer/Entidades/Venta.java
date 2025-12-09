package Fondita.Fer.Entidades;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "venta")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVenta")
    private Long idVenta; 

    @Column(name = "fechaventa", nullable = false)
    private LocalDateTime fechaVenta;

    @Column(name = "idCliente", nullable = false)
    private Integer idCliente;

    @Column(name = "idReserva")
    private Long idReserva; 

    @Column(name = "total", nullable = false)
    private Float total;

    @Column(name = "empleado")
    private String empleado;

    
    @OneToMany(mappedBy = "idVenta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleVenta> detalles = new ArrayList<>();

    @PrePersist
    protected void onCreate() {
        this.fechaVenta = LocalDateTime.now().withSecond(0).withNano(0);
    }

    @PreUpdate
    protected void onUpdate() {
        this.fechaVenta = LocalDateTime.now().withSecond(0).withNano(0);
    }

	public Long getIdVenta() {
		return idVenta;
	}

	public LocalDateTime getFechaVenta() {
		return fechaVenta;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public Long getIdReserva() {
		return idReserva;
	}

	public Float getTotal() {
		return total;
	}

	public List<DetalleVenta> getDetalles() {
		return detalles;
	}

	public String getEmpleado() {
		return empleado;
	}


}
