package arq.soft.arqSoft1.rest.services;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import arq.soft.arqSoft1.dao.CategoriaDAO;
import arq.soft.arqSoft1.dao.ProductoDAO;
import arq.soft.arqSoft1.entitys.Categoria;
import arq.soft.arqSoft1.rest.request.FiltrosBusqueda;
import arq.soft.arqSoft1.rest.response.Producto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductosControllerTest {
	
	@Autowired
	private ProductoController productoController;
	
	@Autowired
	private ProductoDAO productoDAO;
	
	@Autowired
	private CategoriaDAO categoriaDAO;
	

	@Test
	 public void buscar_productos_descripcion_malo() {
		 
		 crearSetProductos(); 
		
		 FiltrosBusqueda request = new FiltrosBusqueda();
		 request.setDescripcion("malo");
		 List<Producto> p =  productoController.buscarProducto(request); //.obtenerAllProductos();
		 
		 assertTrue(!p.isEmpty());
		 assertTrue(p.size() == 1);
		 
	 }
	
	
	
	@Test
	 public void buscar_productos_precio_maximo_60() {
		 
		 //crearSetProductos(); 
		
		 FiltrosBusqueda request = new FiltrosBusqueda();
		 request.setPrecioMaximo(60.00);
		 List<Producto> p =  productoController.buscarProducto(request); //.obtenerAllProductos();
		 
		 assertTrue(!p.isEmpty());
		 assertTrue(p.size() == 2);
		 
	 }
	
	
	@Test
	 public void buscar_productos_precio_minimo_40() {
		 
		 //crearSetProductos(); 
		
		 FiltrosBusqueda request = new FiltrosBusqueda();
		 request.setPrecioMinimo(40.00);
		 List<Producto> p =  productoController.buscarProducto(request); //.obtenerAllProductos();
		 
		 assertTrue(!p.isEmpty());
		 assertTrue(p.size() == 2);
		 
	 }
	 
		private List<arq.soft.arqSoft1.entitys.Producto> crearSetProductos(){
			
			List<arq.soft.arqSoft1.entitys.Producto> productos = new ArrayList<arq.soft.arqSoft1.entitys.Producto>();
			
			Categoria c = new Categoria();
			c.setNombre("Mascotas");
			c = categoriaDAO.save(c);
			
			arq.soft.arqSoft1.entitys.Producto p2 = new arq.soft.arqSoft1.entitys.Producto();
		 	p2.setCantidad(25);
		 	p2.setCategoria(c);
		 	p2.setDescripcion("Balanceado barato de perros");
		 	p2.setIdVendedor(2L);
		 	p2.setNombre("Kongo");
		 	p2.setPrecio(52.00D);
		 	p2.setId(1L);
	    	productoDAO.save(p2);
	    	productos.add(p2);
	    	
	    	arq.soft.arqSoft1.entitys.Producto p = new arq.soft.arqSoft1.entitys.Producto();
	    	p.setCantidad(25);
	    	p.setCategoria(c);
	    	p.setDescripcion("Balanceado bueno y caro de perros");
	    	p.setIdVendedor(2L);
	    	p.setNombre("Royal canin");
	    	p.setPrecio(1400.00D);
	    	p.setId(1L);
	    	productoDAO.save(p);
	    	productos.add(p);
	    	
	    	arq.soft.arqSoft1.entitys.Producto p3 = new arq.soft.arqSoft1.entitys.Producto();
		 	p3.setCantidad(25);
		 	p3.setCategoria(c);
		 	p3.setDescripcion("Balanceado malo de perros");
		 	p3.setIdVendedor(1L);
		 	p3.setNombre("Dogui");
		 	p3.setPrecio(15.00D);
		 	p3.setId(1L);
	    	productoDAO.save(p3);
	    	productos.add(p3);
	    	
	    	return productos;
		}

	public ProductoController getProductoController() {
		return productoController;
	}

	public void setProductoController(ProductoController productoController) {
		this.productoController = productoController;
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
