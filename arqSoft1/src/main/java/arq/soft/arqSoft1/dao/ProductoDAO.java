package arq.soft.arqSoft1.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import arq.soft.arqSoft1.entitys.Producto;

public interface ProductoDAO extends JpaRepository<Producto,Long> {
	
	@Query("SELECT p FROM Producto p WHERE p.idVendedor = ?1")
	List<Producto> obtenerProductosByVendedor(long idVendedor);
	
	@Query("SELECT p FROM Producto p WHERE p.nombre LIKE %:nombreDescripcion% OR p.descripcion LIKE %:nombreDescripcion% ")
	List<Producto> obtenerProductosByNombreYDescripcion(String nombreDescripcion);
	
}
