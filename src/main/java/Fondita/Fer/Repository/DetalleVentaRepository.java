package Fondita.Fer.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Fondita.Fer.Entidades.DetalleVenta;

public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Integer>{
	List<DetalleVenta> findByIdVenta_IdVenta(Integer idVenta);

}
