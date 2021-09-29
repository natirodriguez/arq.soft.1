package arq.soft.arqSoft1.dao;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import arq.soft.arqSoft1.entitys.Usuario;



@RunWith(SpringRunner.class)
@SpringBootTest
public class UsuarioTest {

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Test
	public void crear_un_usuario() {
		
		Usuario v = new Usuario();
    	v.setEmail("a@a.com");
    	v.setId(1L);
    	v.setApellido("Genne");
    	v.setNombre("Simmons");
    	
    	usuarioDAO.save(v);
    	Optional<Usuario> vop = usuarioDAO.findById(1L);
    	
    	assertTrue(vop.isPresent());

    	Usuario vdb = vop.get();

        assertEquals(vdb.getId(), v.getId());
        assertEquals(vdb.getEmail(), v.getEmail());
        assertEquals(vdb.getNombre(), v.getNombre());
        assertEquals(vdb.getApellido(), v.getApellido());
	}

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
}
