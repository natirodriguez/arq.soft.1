package arq.soft.arqSoft1.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import arq.soft.arqSoft1.entitys.Producto;

public interface ProductoDAO extends JpaRepository<Producto,Long> {

	
   // List<Producto> findByCategoria(String categoria);
	
}
