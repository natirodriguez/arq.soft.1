package arq.soft.arqSoft1.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import arq.soft.arqSoft1.entitys.Vendedor;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VendedorTest {
	
	@Autowired
	private VendedorDAO vendedorDAO;
	
	@Test
	public void crear_vendedor() {
		
    	Vendedor v = new Vendedor();
    	v.setEmail("a@a.com");
    	v.setId(1L);
    	v.setRazonSocial("Geene Simmons");
    	
    	vendedorDAO.save(v);
    	Optional<Vendedor> vop = vendedorDAO.findById(1L);
    	
    	assertTrue(vop.isPresent());

    	Vendedor vdb = vop.get();

        assertEquals(vdb.getId(), v.getId());
        assertEquals(vdb.getEmail(), v.getEmail());
        assertEquals(vdb.getRazonSocial(), v.getRazonSocial());
	}

	public VendedorDAO getVendedorDAO() {
		return vendedorDAO;
	}

	public void setVendedorDAO(VendedorDAO vendedorDAO) {
		this.vendedorDAO = vendedorDAO;
	}
	

}
