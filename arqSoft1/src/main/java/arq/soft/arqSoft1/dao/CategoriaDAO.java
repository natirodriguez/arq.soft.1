package arq.soft.arqSoft1.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import arq.soft.arqSoft1.entitys.Categoria;



public interface CategoriaDAO extends JpaRepository<Categoria,Long> {

	
	@Query("SELECT p FROM Categoria p WHERE p.nombre = ?1")
	Categoria obtenerCategoriaByNombre(String nombre);
}
