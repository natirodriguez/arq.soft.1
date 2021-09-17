package arq.soft.arqSoft1.servicios;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import arq.soft.arqSoft1.dao.ProductoDAO;
import arq.soft.arqSoft1.dto.ProductoDTO;
import arq.soft.arqSoft1.entitys.Producto;

@Service
public class ProductoServices {
	
	@Autowired
	private ProductoDAO productoDAO;
	
	
	public List<ProductoDTO> obtenerAllProductos() {
		
		List<ProductoDTO> response = new ArrayList<ProductoDTO>();
		List<Producto> entitys = productoDAO.findAll();
		
		for(arq.soft.arqSoft1.entitys.Producto pbd : entitys) {
			ProductoDTO p = new ProductoDTO();
			p.setCantidad(pbd.getCantidad());
			p.setCategoria(pbd.getCategoria());
			p.setNombre(pbd.getNombre());
			response.add(p);
		}
		return response;
	}
	
	public void guardarProductoNuevo(ProductoDTO dto) {
		Producto p = new Producto();
		p.setCantidad(dto.getCantidad());
		p.setCategoria(dto.getCategoria());
		p.setNombre(dto.getNombre());
		productoDAO.save(p);
	}

	public ProductoDAO getProductoDAO() {
		return productoDAO;
	}

	public void setProductoDAO(ProductoDAO productoDAO) {
		this.productoDAO = productoDAO;
	}

}
