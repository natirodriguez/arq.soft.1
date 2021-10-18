package arq.soft.arqSoft1.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import arq.soft.arqSoft1.entitys.Usuario;

public interface UsuarioDAO extends JpaRepository<Usuario,Long>{
	@Query("SELECT u FROM Usuario u WHERE u.email = ?1")
	Optional<Usuario> findByEmail(String email);
}
