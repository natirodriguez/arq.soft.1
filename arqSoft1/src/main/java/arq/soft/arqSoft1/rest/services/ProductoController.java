package arq.soft.arqSoft1.rest.services;

import org.springframework.web.bind.annotation.RestController;
import arq.soft.arqSoft1.dto.ProductoDTO;
import arq.soft.arqSoft1.excepciones.ProductoNotFoundException;
import arq.soft.arqSoft1.rest.response.Producto;
import arq.soft.arqSoft1.servicios.ProductoServices;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class ProductoController {
	
	@Autowired
    private  ProductoServices  productoServices;
    
	
    @GetMapping("/productos/{productId}")
	public Producto obtenerProducto(@PathVariable(value = "productId") long id) {
		
    	Producto p = new Producto();
		try {
			
			ProductoDTO response = productoServices.obtenerProductoById(id);
			
			p.setId(response.getId());
			p.setCantidad(response.getCantidad());
			p.setCategoria(response.getCategoria());
			p.setNombre(response.getNombre());
			p.setDescripcion(response.getDescripcion());
			p.setPrecio(response.getPrecio());
			p.setIdVendedor(response.getIdVendedor());
		
		} catch (ProductoNotFoundException e) {
			// TODO
		}
		return p;
	}
    
	
    @GetMapping("/productos")
	public List<Producto> obtenerAllProductos() {
		
		List<Producto> response = new ArrayList<Producto>();
		List<ProductoDTO> dtos = productoServices.obtenerAllProductos();
		
		for(ProductoDTO pbd : dtos) {
			Producto p = new Producto();
			p.setId(pbd.getId());
			p.setCantidad(pbd.getCantidad());
			p.setCategoria(pbd.getCategoria());
			p.setNombre(pbd.getNombre());
			p.setDescripcion(pbd.getDescripcion());
			p.setPrecio(pbd.getPrecio());
			p.getIdVendedor();
			response.add(p);
		}

		return response;
	}
    
    @PostMapping(path = "/productos", 
    consumes = MediaType.APPLICATION_JSON_VALUE, 
    produces = MediaType.APPLICATION_JSON_VALUE)
	public void crearProducto(@RequestBody Producto request) {
		
			ProductoDTO dto = new ProductoDTO();
			dto.setCantidad(request.getCantidad());
			dto.setCategoria(request.getCategoria());
			dto.setNombre(request.getNombre());
			dto.setDescripcion(request.getDescripcion());
			dto.setPrecio(request.getPrecio());
			dto.setIdVendedor(request.getIdVendedor());
			
			productoServices.guardarProductoNuevo(dto);
	}
    
    @PutMapping(path = "/productos", 
    consumes = MediaType.APPLICATION_JSON_VALUE, 
    produces = MediaType.APPLICATION_JSON_VALUE)
	public void modificarProducto(@RequestBody Producto request) {
		
			ProductoDTO dto = new ProductoDTO();
			dto.setId(request.getId());
			dto.setCantidad(request.getCantidad());
			dto.setCategoria(request.getCategoria());
			dto.setNombre(request.getNombre());
			dto.setDescripcion(request.getDescripcion());
			dto.setPrecio(request.getPrecio());
			
			try {
				
				productoServices.modificarProducto(dto);
				
			} catch (ProductoNotFoundException e) {
				//TODO manejar excepcion
			}
	}
    
    @DeleteMapping(path = "/productos/{productId}")
	public void borrarProducto(@PathVariable(value = "productId") long id) {
		
			productoServices.borrarProducto(id);
	}

	public ProductoServices getProductoServices() {
		return productoServices;
	}

	public void setProductoServices(ProductoServices productoServices) {
		this.productoServices = productoServices;
	}

}
