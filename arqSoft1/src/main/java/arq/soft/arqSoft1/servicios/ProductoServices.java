package arq.soft.arqSoft1.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.annotation.PostConstruct;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import arq.soft.arqSoft1.dao.*;
import arq.soft.arqSoft1.dao.impl.ProductoRepository;
import arq.soft.arqSoft1.dto.CategoriaDTO;
import arq.soft.arqSoft1.dto.ProductoDTO;
import arq.soft.arqSoft1.entitys.Categoria;
import arq.soft.arqSoft1.entitys.Producto;
import arq.soft.arqSoft1.excepciones.CategoriaNotFoundException;
import arq.soft.arqSoft1.excepciones.ProductoNotFoundException;

@Service
public class ProductoServices {
	
	@Autowired
	private ProductoDAO productoDAO;
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@Autowired
	private CategoriaDAO categoriaDAO;
	
	@Value("#{'${arqsoft.categorias}'.split(',')}") 
	private List<String> categorias;
	
	@PostConstruct
	public void initCategorias() {
		
		for(String c : categorias) {
			Categoria catBDD  = categoriaDAO.obtenerCategoriaByNombre(c);
			if(catBDD == null) {
				Categoria cat = new Categoria();
				cat.setNombre(c);
				categoriaDAO.save(cat);
			}
		}
	}
	
	public List<ProductoDTO> obtenerAllProductos() {
		
		List<ProductoDTO> response = new ArrayList<ProductoDTO>();
		List<Producto> entitys = productoDAO.findAll();
		
		for(Producto pbd : entitys) {
			ProductoDTO p = new ProductoDTO();
			p.setId(pbd.getId());
			p.setCantidad(pbd.getCantidad());
			
			CategoriaDTO c = new CategoriaDTO();
			c.setId(pbd.getCategoria().getId());
			c.setNombre(pbd.getCategoria().getNombre());
			p.setCategoria(c);
			
			p.setNombre(pbd.getNombre());
			p.setDescripcion(pbd.getDescripcion());
			p.setPrecio(pbd.getPrecio());
			p.setIdVendedor(pbd.getIdVendedor());
			response.add(p);
		}
		return response;
	}
	
	public void guardarProductoNuevo(ProductoDTO dto) {
		Producto p = new Producto();
		
		Optional<Categoria> cop = categoriaDAO.findById(dto.getCategoria().getId());
		
		if(cop.isPresent()) {
			Categoria c = cop.get();
			p.setCategoria(c);
			
			p.setCantidad(dto.getCantidad());
			p.setNombre(dto.getNombre());
			p.setDescripcion(dto.getDescripcion());
			p.setPrecio(dto.getPrecio());
			p.setIdVendedor(dto.getIdVendedor());
			productoDAO.save(p);
		}
	}
	
	public void modificarProducto(ProductoDTO dto) throws ProductoNotFoundException {
		
		Optional<Producto> pop = productoDAO.findById(dto.getId());
		if(pop.isPresent()) {
			Producto p = pop.get();
			p.setCantidad(dto.getCantidad());
			
			p.setNombre(dto.getNombre());
			p.setDescripcion(dto.getDescripcion());
			p.setPrecio(dto.getPrecio());
			productoDAO.save(p);
		}else {
			throw new ProductoNotFoundException();
		}
	}
	
	public void borrarProducto(long id) {
		
		productoDAO.deleteById(id);
		
	}
	
	public List<ProductoDTO> obtenerProductosByVendedor(long id) {
		
        List<ProductoDTO> response = new ArrayList<ProductoDTO>();
        List<Producto> entitys = productoDAO.obtenerProductosByVendedor(id);
		
		for(Producto pbd : entitys) {
			ProductoDTO p = new ProductoDTO();
			p.setId(pbd.getId());
			p.setCantidad(pbd.getCantidad());
			
			CategoriaDTO c = new CategoriaDTO();
			c.setId(pbd.getCategoria().getId());
			c.setNombre(pbd.getCategoria().getNombre());
			p.setCategoria(c);

			p.setNombre(pbd.getNombre());
			p.setDescripcion(pbd.getDescripcion());
			p.setPrecio(pbd.getPrecio());
			p.setIdVendedor(pbd.getIdVendedor());
			response.add(p);
		}
		
		return response;
	}

	public ProductoDTO obtenerProductoById(long id) throws ProductoNotFoundException {
	
		ProductoDTO dto = new ProductoDTO();
		Optional<Producto> pop = productoDAO.findById(id);
		if(pop.isPresent()) {
			Producto p = pop.get();
			dto.setCantidad(p.getCantidad());
			
			CategoriaDTO c = new CategoriaDTO();
			c.setId(p.getCategoria().getId());
			c.setNombre(p.getCategoria().getNombre());
			dto.setCategoria(c);
			
			dto.setNombre(p.getNombre());
			dto.setDescripcion(p.getDescripcion());
			dto.setPrecio(p.getPrecio());
			dto.setId(p.getId());
			dto.setIdVendedor(p.getIdVendedor());
	        return dto;
		}else {
			throw new ProductoNotFoundException();
		}
	}
	
	public List<ProductoDTO> obtenerProductosByNombreYDescripcion(String nombreDescripcion) 
	{	
        List<ProductoDTO> response = new ArrayList<ProductoDTO>();
		List<Producto> entitys = productoDAO.obtenerProductosByNombreYDescripcion(nombreDescripcion);
		
		for(Producto pbd : entitys) {
			ProductoDTO p = new ProductoDTO();
			p.setId(pbd.getId());
			p.setCantidad(pbd.getCantidad());
			
			CategoriaDTO c = new CategoriaDTO();
			c.setId(pbd.getCategoria().getId());
			c.setNombre(pbd.getCategoria().getNombre());
			p.setCategoria(c);

			p.setNombre(pbd.getNombre());
			p.setDescripcion(pbd.getDescripcion());
			p.setPrecio(pbd.getPrecio());
			p.setIdVendedor(pbd.getIdVendedor());
			response.add(p);
		}
		
		return response; 
	}
	
	public List<ProductoDTO> filtrarProductosPorCategroria(long idCategoria) 
	{	
        List<ProductoDTO> response = new ArrayList<ProductoDTO>();
		List<Producto> entitys = productoDAO.filtrarProductosPorCategoria(idCategoria);
		
		for(Producto pbd : entitys) {
			ProductoDTO p = new ProductoDTO();
			p.setId(pbd.getId());
			p.setCantidad(pbd.getCantidad());
			
			CategoriaDTO c = new CategoriaDTO();
			c.setId(pbd.getCategoria().getId());
			c.setNombre(pbd.getCategoria().getNombre());
			p.setCategoria(c);

			p.setNombre(pbd.getNombre());
			p.setDescripcion(pbd.getDescripcion());
			p.setPrecio(pbd.getPrecio());
			p.setIdVendedor(pbd.getIdVendedor());
			response.add(p);
		}
		
		return response; 
	}
	
	public List<CategoriaDTO> obtenerProductos() {
		
		List<CategoriaDTO> categorias = new ArrayList<CategoriaDTO>();
		List<Categoria> categoriasDB = categoriaDAO.findAll();
		
		for(Categoria cdb : categoriasDB) {
			CategoriaDTO dto = new CategoriaDTO();
			dto.setId(cdb.getId());
			dto.setNombre(cdb.getNombre());
			categorias.add(dto);
		}
		return categorias;
	}
	
	public CategoriaDTO obtenerCategoriaPorNombre(String nombre) throws CategoriaNotFoundException {

		Categoria c = categoriaDAO.obtenerCategoriaByNombre(nombre);
		
		if(c != null) {
			CategoriaDTO dto = new CategoriaDTO();
			dto.setId(c.getId());
			dto.setNombre(c.getNombre());
			return dto;
			
		}else {
			throw new CategoriaNotFoundException();
		}
	}
	
	public List<ProductoDTO> obtenerProductosByFiltro(String descripcion, double precioMinimo, double precioMax) {

		List<ProductoDTO> response = new ArrayList<ProductoDTO>();
		
		List<Producto> entitys = productoRepository.obtenerProductosByNombreYDescripcion(descripcion, precioMinimo, precioMax);
		
		for(Producto pbd : entitys) {
			ProductoDTO p = new ProductoDTO();
			p.setId(pbd.getId());
			p.setCantidad(pbd.getCantidad());
			
			CategoriaDTO c = new CategoriaDTO();
			c.setId(pbd.getCategoria().getId());
			c.setNombre(pbd.getCategoria().getNombre());
			p.setCategoria(c);

			p.setNombre(pbd.getNombre());
			p.setDescripcion(pbd.getDescripcion());
			p.setPrecio(pbd.getPrecio());
			p.setIdVendedor(pbd.getIdVendedor());
			response.add(p);
		}
		
		return response;
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

	public List<String> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<String> categorias) {
		this.categorias = categorias;
	}

	public ProductoRepository getProductoRepository() {
		return productoRepository;
	}

	public void setProductoRepository(ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}

}
