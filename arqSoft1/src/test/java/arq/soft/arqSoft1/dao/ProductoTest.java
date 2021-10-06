package arq.soft.arqSoft1.dao;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import arq.soft.arqSoft1.dao.ProductoDAO;
import arq.soft.arqSoft1.entitys.Categoria;
import arq.soft.arqSoft1.entitys.Producto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductoTest {
	
	@Autowired
	private ProductoDAO productoDAO;
	
	@Autowired
	private CategoriaDAO categoriaDAO;
	
    @Test
    public void al_obtener_un_producto_guardado_debera_tener_los_mismos_datos() {
       
    	Producto p = crearProducto();

    	Optional<Producto> pbdop = productoDAO.findById(p.getId());
    	
    	assertTrue(pbdop.isPresent());

    	Producto pbSearched = pbdop.get();

        assertEquals(pbSearched.getId(), p.getId());
        assertEquals(pbSearched.getIdVendedor(), p.getIdVendedor());
        assertEquals(pbSearched.getCantidad(), p.getCantidad());
        assertEquals(pbSearched.getCategoria().getNombre(), p.getCategoria().getNombre());
        assertEquals(pbSearched.getDescripcion(), p.getDescripcion());
        assertEquals(pbSearched.getNombre(), p.getNombre());
        assertEquals(pbSearched.getPrecio(), p.getPrecio());
        
    }
    
    @Test
    public void modificar_un_producto_guardado_en_base() {
    	
    	Producto pbSearched = crearProducto();
    	
    	pbSearched.setPrecio("100.00");
    	pbSearched.setNombre("RoyalCanin");
    	
    	Producto prod = productoDAO.save(pbSearched);
    	
        assertEquals(pbSearched.getId(), prod.getId());
        assertEquals(prod.getPrecio(), "100.00");
        assertNotEquals(prod.getNombre(), "Kongo");
        
    }
    
    @Test
    public void borrar_un_producto_guardado() {
    	
    	Producto pbSearched = crearProducto();
    	
    	assertTrue(pbSearched != null);
    	
    	long id = pbSearched.getId();
    	
    	productoDAO.delete(pbSearched);
    	
    	Optional<Producto> pbdop = productoDAO.findById(id);
    	
    	assertTrue(! pbdop.isPresent());
        
    }
    
    @Test
    public void obtener_prodcutos_de_un_vendedor() {
    	
    	crearSetProductos();
    	
    	List<Producto> productosVen1 = productoDAO.obtenerProductosByVendedor(1L);
    	List<Producto> productosVen2 = productoDAO.obtenerProductosByVendedor(2L);
    	
    	assertTrue(productosVen1.size() == 1);
    	assertTrue(productosVen2.size() == 2);
    }
    
    
	private Producto crearProducto() {
		
		Categoria c = new Categoria();
		c.setNombre("Mascotas");
		c = categoriaDAO.save(c);
		
	  	Producto p = new Producto();
	  	p.setCategoria(c);
    	p.setCantidad(25);
    	p.setDescripcion("Comida de perros");
    	p.setIdVendedor(5L);
    	p.setNombre("Kongo");
    	p.setPrecio("23.00");
    	p.setId(1L);
    	
    	Producto pbd = productoDAO.save(p);
    	
    	return pbd;
	}
	
	private List<Producto> crearSetProductos(){
		
		List<Producto> productos = new ArrayList<Producto>();
		
		Categoria c = new Categoria();
		c.setNombre("Mascotas");
		c = categoriaDAO.save(c);
		
	 	Producto p2 = new Producto();
	 	p2.setCantidad(25);
	 	p2.setCategoria(c);
	 	p2.setDescripcion("Comida de perros");
	 	p2.setIdVendedor(2L);
	 	p2.setNombre("Kongo");
	 	p2.setPrecio("23.00");
	 	p2.setId(1L);
    	productoDAO.save(p2);
    	productos.add(p2);
    	
    	Producto p = new Producto();
    	p.setCantidad(25);
    	p.setCategoria(c);
    	p.setDescripcion("Comida de perros");
    	p.setIdVendedor(2L);
    	p.setNombre("Kongo");
    	p.setPrecio("23.00");
    	p.setId(1L);
    	productoDAO.save(p);
    	productos.add(p);
    	
    	Producto p3 = new Producto();
	 	p3.setCantidad(25);
	 	p3.setCategoria(c);
	 	p3.setDescripcion("Comida de perros");
	 	p3.setIdVendedor(1L);
	 	p3.setNombre("Kongo");
	 	p3.setPrecio("23.00");
	 	p3.setId(1L);
    	productoDAO.save(p3);
    	productos.add(p3);
    	
    	return productos;
		
	}

	public ProductoDAO getProductoDAO() {
		return productoDAO;
	}

	public void setProductoDAO(ProductoDAO productoDAO) {
		this.productoDAO = productoDAO;
	}

	public CategoriaDAO getCategoriaDAO() {
		return categoriaDAO;
	}

	public void setCategoriaDAO(CategoriaDAO categoriaDAO) {
		this.categoriaDAO = categoriaDAO;
	}

}
