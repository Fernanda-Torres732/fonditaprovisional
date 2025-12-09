package Fondita.Fer.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Fondita.Fer.Entidades.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{
	 List<Producto> findByEstatus(int estatus);
}
