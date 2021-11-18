package arq.soft.arqSoft1.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import arq.soft.arqSoft1.entitys.Vendedor;
import arq.soft.arqSoft1.entitys.VentaProducto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VentaProductoTest {
	@Autowired
	private VentaProductoDAO ventaProductoDAO;
	
	@Test
    public void obtener_venta_todos_productos() {
    	
		crearVentaProducto();
    	
    	List<VentaProducto> productosVen1 = ventaProductoDAO.findAll();
    	
    	assertTrue(productosVen1.size() == 1);
    }
	
	@Test
	public void crear_venta_producto() {
		
    	VentaProducto vp = new VentaProducto();
    	vp.setCantidadComprada(5);
    	vp.setIdComprador(1);
    	vp.setIdProducto(1);
    	
    	VentaProducto vp1 = ventaProductoDAO.save(vp);
    	Optional<VentaProducto> vop = ventaProductoDAO.findById(vp1.getId());
    	
    	assertTrue(vop.isPresent());

    	VentaProducto vdb = vop.get();

        assertEquals(vdb.getId(), vp.getId());
        assertEquals(vdb.getCantidadComprada(), vp.getCantidadComprada());
        assertEquals(vdb.getIdComprador(), vp.getIdComprador());
        assertEquals(vdb.getIdProducto(), vp.getIdProducto());
	}

	
	private VentaProducto crearVentaProducto() {
	  	VentaProducto p = new VentaProducto();
    	p.setCantidadComprada(25);
    	p.setIdComprador(5L);
    	p.setIdProducto(1L);
    	p.setId(1L);
    	
    	VentaProducto pbd = ventaProductoDAO.save(p);
    	
    	return pbd;
	}
	
}
