package arq.soft.arqSoft1.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import arq.soft.arqSoft1.dao.ProductoDAO;
import arq.soft.arqSoft1.dto.ProductoDTO;
import arq.soft.arqSoft1.entitys.Producto;
import arq.soft.arqSoft1.excepciones.ProductoNotFoundException;

@Service
public class ProductoServices {
	
	@Autowired
	private ProductoDAO productoDAO;
	
	
	public List<ProductoDTO> obtenerAllProductos() {
		
		List<ProductoDTO> response = new ArrayList<ProductoDTO>();
		List<Producto> entitys = productoDAO.findAll();
		
		for(Producto pbd : entitys) {
			ProductoDTO p = new ProductoDTO();
			p.setId(pbd.getId());
			p.setCantidad(pbd.getCantidad());
			p.setCategoria(pbd.getCategoria());
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
		p.setCantidad(dto.getCantidad());
		p.setCategoria(dto.getCategoria());
		p.setNombre(dto.getNombre());
		p.setDescripcion(dto.getDescripcion());
		p.setPrecio(dto.getPrecio());
		p.setIdVendedor(dto.getIdVendedor());
		productoDAO.save(p);
	}
	
	public void modificarProducto(ProductoDTO dto) throws ProductoNotFoundException {
		
		Optional<Producto> pop = productoDAO.findById(dto.getId());
		if(pop.isPresent()) {
			Producto p = pop.get();
			p.setCantidad(dto.getCantidad());
			p.setCategoria(dto.getCategoria());
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
			p.setCategoria(pbd.getCategoria());
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
			dto.setCategoria(p.getCategoria());
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

	public ProductoDAO getProductoDAO() {
		return productoDAO;
	}

	public void setProductoDAO(ProductoDAO productoDAO) {
		this.productoDAO = productoDAO;
	}


}
