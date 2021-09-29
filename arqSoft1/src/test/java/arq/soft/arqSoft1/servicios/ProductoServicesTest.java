package arq.soft.arqSoft1.servicios;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.anything;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import arq.soft.arqSoft1.dao.ProductoDAO;
import arq.soft.arqSoft1.dto.ProductoDTO;
import arq.soft.arqSoft1.entitys.Producto;


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
		
		ProductoDTO dto = new ProductoDTO();
		dto.setCantidad(34);
		dto.setCategoria("Mascotas");
		dto.setDescripcion("Comida");
		dto.setId(1L);
		dto.setIdVendedor(2L);
		dto.setNombre("Dogui");
		dto.setPrecio("156.00");
		
		ArgumentCaptor<Producto> argument = ArgumentCaptor.forClass(Producto.class);
		
		productoService.guardarProductoNuevo(dto);
		//capura el parametro
		verify(productoDAO).save(argument.capture());
		assertEquals("Dogui", argument.getValue().getNombre());
		verify(productoDAO, times(1)).save(argument.getValue());
		
	}
	
	/*
	@Test
	public void obtener_prodcutos_vendedor() {
		initServicio();
		
		when.
		
		List<ProductoDTO> productos = productoService.obtenerProductosByVendedor(1L);
		
	}*/
	

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
