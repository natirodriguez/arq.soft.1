package arq.soft.arqSoft1.rest.services;

import org.springframework.web.bind.annotation.RestController;
import arq.soft.arqSoft1.dao.ProductoDAO;
import arq.soft.arqSoft1.rest.response.Producto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class ProductoController {
	
	@Autowired
	private ProductoDAO productoDAO;
	
	@GetMapping("/productos")
	public List<Producto> greeting() {
		
		List<Producto> response = new ArrayList<Producto>();
		
		List<arq.soft.arqSoft1.entitys.Producto> entitys = productoDAO.findAll();
		
		for(arq.soft.arqSoft1.entitys.Producto pbd : entitys) {
			Producto p = new Producto();
			p.setCantidad(pbd.getCantidad());
			p.setCategoria(pbd.getCategoria());
			p.setNombre(pbd.getNombre());
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

}
