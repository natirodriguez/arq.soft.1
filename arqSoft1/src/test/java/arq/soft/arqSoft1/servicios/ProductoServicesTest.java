package arq.soft.arqSoft1.servicios;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import arq.soft.arqSoft1.dao.ProductoDAO;
import arq.soft.arqSoft1.dto.CategoriaDTO;
import arq.soft.arqSoft1.dto.ProductoDTO;
import arq.soft.arqSoft1.entitys.Categoria;
import arq.soft.arqSoft1.entitys.Producto;
import arq.soft.arqSoft1.excepciones.ProductoNotFoundException;



@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductoServicesTest {
	
	@Autowired
	private ProductoServices productoService;
	
	@MockBean
	private ProductoDAO productoDAO;
	
	private void initServicio() {
		
		productoService.setProductoDAO(productoDAO);
	} 
	
	@Test
	public void crear_producto() {
		
		initServicio();
		
		CategoriaDTO c = new CategoriaDTO();
	 	c.setId(1L);
	 	c.setNombre("Mascotas");
	 
		
		ProductoDTO dto = new ProductoDTO();
		dto.setCantidad(34);
		dto.setCategoria(c);
		dto.setDescripcion("Comida");
		dto.setId(1L);
		dto.setIdVendedor(2L);
		dto.setNombre("Dogui");
		dto.setPrecio(156.00D);
		
		ArgumentCaptor<Producto> argument = ArgumentCaptor.forClass(Producto.class);
		
		productoService.guardarProductoNuevo(dto);
		//capura el parametro
		verify(productoDAO).save(argument.capture());
		assertEquals("Dogui", argument.getValue().getNombre());
		verify(productoDAO, times(1)).save(argument.getValue());
		
	}
	
	
	@Test
	public void obtener_prodcutos_vendedor() {
		initServicio();
		
	 	Categoria c = new Categoria();
	 	c.setId(1L);
	 	c.setNombre("Mascotas");
		
		List<Producto> productos = new ArrayList<Producto>();
	 	Producto p2 = new Producto();
	 	p2.setCantidad(25);
	 	p2.setCategoria(c);
	 	p2.setCantidad(25);
	 	p2.setIdVendedor(2L);
	 	p2.setNombre("Kongo");
	 	p2.setPrecio(23.00D);
	 	p2.setId(1L);
    	productos.add(p2);
    	
    	Producto p = new Producto();
    	p.setCantidad(25);
	 	p.setCategoria(c);
    	p.setDescripcion("Comida de perros");
    	p.setIdVendedor(2L);
    	p.setNombre("Kongo");
    	p.setPrecio(23.00D);
    	p.setId(1L);
    	productos.add(p);
		
    	long vendedorID = 2L;
    	
		when(productoDAO.obtenerProductosByVendedor(vendedorID)).thenReturn(productos);
		
		List<ProductoDTO> productosDTO = productoService.obtenerProductosByVendedor(vendedorID);
		
		verify(productoDAO, times(1)).obtenerProductosByVendedor(vendedorID);
		assertTrue(productosDTO.size() == 2);
		
	}
	
	@Test
	public void obtener_producto_by_id_inexistente() {
		
		long productoId = 2L;
		
		Optional<Producto> prod = Optional.empty();
		
		when(productoDAO.findById(productoId)).thenReturn(prod);
		
		ProductoNotFoundException thrown = assertThrows(
				ProductoNotFoundException.class,
		           () -> productoService.obtenerProductoById(productoId),
		           "Expected doThing() to throw, but it didn't"
		    );
	}
	

	public ProductoDAO getProductoDAO() {
		return productoDAO;
	}

	public void setProductoDAO(ProductoDAO productoDAO) {
		this.productoDAO = productoDAO;
	}

	public ProductoServices getProductoService() {
		return productoService;
	}

	public void setProductoService(ProductoServices productoService) {
		this.productoService = productoService;
	}

}
