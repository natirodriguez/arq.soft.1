package arq.soft.arqSoft1.rest.services;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import arq.soft.arqSoft1.dto.CategoriaDTO;
import arq.soft.arqSoft1.dto.ProductoDTO;
import arq.soft.arqSoft1.excepciones.CategoriaNotFoundException;
import arq.soft.arqSoft1.excepciones.ProductoNotFoundException;
import arq.soft.arqSoft1.rest.request.FiltrosBusqueda;
import arq.soft.arqSoft1.rest.response.Categoria;
import arq.soft.arqSoft1.rest.response.Producto;
import arq.soft.arqSoft1.servicios.ProductoServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ProductoController {
	
	@Autowired
    private  ProductoServices  productoServices;
    
	
    @GetMapping("/productos/{productId}")
    @ApiOperation(nickname = "obtener_producto_id", value = "Obtiene un producto por su id")
	public Producto obtenerProducto(@PathVariable(value = "productId") long id) {
		
    	Producto p = new Producto();
		try {
			
			ProductoDTO response = productoServices.obtenerProductoById(id);
			
			p.setId(response.getId());
			p.setCantidad(response.getCantidad());
			
			Categoria c = new Categoria();
			c.setId(response.getCategoria().getId());
			c.setNombre(response.getCategoria().getNombre());
			p.setCategoria(c);
			
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
    @ApiOperation(nickname = "obtener_productos", value = "Obtiene todos los productos creados")
	public List<Producto> obtenerAllProductos() {
		
		List<Producto> response = new ArrayList<Producto>();
		List<ProductoDTO> dtos = productoServices.obtenerAllProductos();
		
		for(ProductoDTO pbd : dtos) {
			Producto p = new Producto();
			p.setId(pbd.getId());
			p.setCantidad(pbd.getCantidad());
			
			Categoria c = new Categoria();
			c.setId(pbd.getCategoria().getId());
			c.setNombre(pbd.getCategoria().getNombre());
			p.setCategoria(c);
			
			p.setNombre(pbd.getNombre());
			p.setDescripcion(pbd.getDescripcion());
			p.setPrecio(pbd.getPrecio());
			p.getIdVendedor();
			response.add(p);
		}

		return response;
	}
    
    @GetMapping("/productos/vendedor/{vendedorId}")
    @ApiOperation(nickname = "obtener_productos_vendedor", value = "Obtiene todos los productos de un vendedor")
	public List<Producto> obtenerProductosByVendedor(@PathVariable(value = "vendedorId") long id) {
		
		List<Producto> response = new ArrayList<Producto>();
		List<ProductoDTO> dtos = productoServices.obtenerProductosByVendedor(id);
		
		for(ProductoDTO pbd : dtos) {
			Producto p = new Producto();
			p.setId(pbd.getId());
			p.setCantidad(pbd.getCantidad());
			
			Categoria c = new Categoria();
			c.setId(pbd.getCategoria().getId());
			c.setNombre(pbd.getCategoria().getNombre());
			p.setCategoria(c);
			
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
    @ApiOperation(nickname = "crear_producto", value = "Crea un producto")
	public void crearProducto(@RequestBody Producto request) {
		
		ProductoDTO dto = new ProductoDTO();
		dto.setCantidad(request.getCantidad());
		
		CategoriaDTO c = new CategoriaDTO();
		c.setId(request.getCategoria().getId());
		c.setNombre(request.getCategoria().getNombre());
		dto.setCategoria(c);
		
		dto.setNombre(request.getNombre());
		dto.setDescripcion(request.getDescripcion());
		dto.setPrecio(request.getPrecio());
		dto.setIdVendedor(request.getIdVendedor());
		
		productoServices.guardarProductoNuevo(dto);
	}
    
    @PutMapping(path = "/productos", 
    consumes = MediaType.APPLICATION_JSON_VALUE, 
    produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(nickname = "modificar_producto", value = "Modifica un producto por su id")
	public void modificarProducto(@RequestBody Producto request) {
		
		ProductoDTO dto = new ProductoDTO();
		dto.setId(request.getId());
		dto.setCantidad(request.getCantidad());
			
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
    @ApiOperation(nickname = "borrar_producto", value = "Borra un producto por su id")
	public void borrarProducto(@PathVariable(value = "productId") long id) {
		
			productoServices.borrarProducto(id);
	}

    @GetMapping("/productos/find/{nombreDescripcion}")
    @ApiOperation(nickname = "filtrar_prod_by_descripcion", value = "Busca productos por una descripcion")
	public List<Producto> obtenerProductosByNombreYDescripcion(@PathVariable(value = "nombreDescripcion") String nombreDescripcion) {
		
		List<Producto> response = new ArrayList<Producto>();
		List<ProductoDTO> dtos = productoServices.obtenerProductosByNombreYDescripcion(nombreDescripcion);
		
		for(ProductoDTO pbd : dtos) {
			Producto p = new Producto();
			p.setId(pbd.getId());
			p.setCantidad(pbd.getCantidad());
			
			Categoria c = new Categoria();
			c.setId(pbd.getCategoria().getId());
			c.setNombre(pbd.getCategoria().getNombre());
			p.setCategoria(c);
			
			p.setNombre(pbd.getNombre());
			p.setDescripcion(pbd.getDescripcion());
			p.setPrecio(pbd.getPrecio());
			p.getIdVendedor();
			response.add(p);
		}

		return response;
	}
    
    @GetMapping("/productos/filter/{categoriaId}")
    @ApiOperation(nickname = "filtrar_prod_by_categoria", value = "Busca productos por una categoria")
	public List<Producto> filtrarProductosPorCategroria(@PathVariable(value = "categoriaId") long idCategoria) {
		List<Producto> response = new ArrayList<Producto>();
		List<ProductoDTO> dtos = productoServices.filtrarProductosPorCategroria(idCategoria);
		
		for(ProductoDTO pbd : dtos) {
			Producto p = new Producto();
			p.setId(pbd.getId());
			p.setCantidad(pbd.getCantidad());
			
			Categoria c = new Categoria();
			c.setId(pbd.getCategoria().getId());
			c.setNombre(pbd.getCategoria().getNombre());
			p.setCategoria(c);
			
			p.setNombre(pbd.getNombre());
			p.setDescripcion(pbd.getDescripcion());
			p.setPrecio(pbd.getPrecio());
			p.getIdVendedor();
			response.add(p);
		}

		return response;
	}
    
    @GetMapping("/categorias")
    @ApiOperation(nickname = "obtener_categorias", value = "Devuelve todas las categorias")
	public List<Categoria> obtenerAllcategorias() {
		
		List<Categoria> response = new ArrayList<Categoria>();
		List<CategoriaDTO> dtos = productoServices.obtenerProductos();
		
		for(CategoriaDTO dto : dtos) {
			Categoria c = new Categoria();
			c.setId(dto.getId());
			c.setNombre(dto.getNombre());
			response.add(c);
		}
		
		return response;
	}
    
    @GetMapping("/categorias/{nombre}")
    @ApiOperation(nickname = "obtener_categoria_nombre", value = "Devuelve todas las categorias")
	public Categoria obtenerCategoriaByNombre(@PathVariable(value = "nombre") String nombre) {
		
		Categoria c = new Categoria();
		try {
			CategoriaDTO dto = productoServices.obtenerCategoriaPorNombre(nombre);
			c.setId(dto.getId());
			c.setNombre(dto.getNombre());
		} catch (CategoriaNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Categoria not  Found", e);
		}

		return c;
	}
    
    @PostMapping(path = "/productos/buscar", 
    consumes = MediaType.APPLICATION_JSON_VALUE, 
    produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(nickname = "buscar_productos", value = "Busca  productos")
	public List<Producto> buscarProducto(@RequestBody FiltrosBusqueda request) {
    	List<Producto> response = new ArrayList<Producto>();
    	
    	List<ProductoDTO> dtos = productoServices.obtenerProductosByFiltro(request.getDescripcion(),request.getPrecioMinimo(), request.getPrecioMaximo());
    	
    	for(ProductoDTO pbd : dtos) {
			Producto p = new Producto();
			p.setId(pbd.getId());
			p.setCantidad(pbd.getCantidad());
			
			Categoria c = new Categoria();
			c.setId(pbd.getCategoria().getId());
			c.setNombre(pbd.getCategoria().getNombre());
			p.setCategoria(c);
			
			p.setNombre(pbd.getNombre());
			p.setDescripcion(pbd.getDescripcion());
			p.setPrecio(pbd.getPrecio());
			p.getIdVendedor();
			response.add(p);
		}
    	
    	return response;

	}
    
	public ProductoServices getProductoServices() {
		return productoServices;
	}

	public void setProductoServices(ProductoServices productoServices) {
		this.productoServices = productoServices;
	}

}
