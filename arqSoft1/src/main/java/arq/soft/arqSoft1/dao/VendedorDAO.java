package arq.soft.arqSoft1.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import arq.soft.arqSoft1.entitys.Vendedor;

public interface VendedorDAO extends JpaRepository<Vendedor,Long>{
	@Query("SELECT v FROM Vendedor v WHERE v.email = ?1")
	Optional<Vendedor> findByEmail(String email);
}
