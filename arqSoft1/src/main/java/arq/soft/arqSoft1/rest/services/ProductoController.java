package arq.soft.arqSoft1.rest.services;

import org.springframework.web.bind.annotation.RestController;
import arq.soft.arqSoft1.dto.ProductoDTO;
import arq.soft.arqSoft1.rest.response.Producto;
import arq.soft.arqSoft1.servicios.ProductoServices;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class ProductoController {
	
	@Autowired
    private  ProductoServices  productoServices;
    
    @GetMapping("/productos")
	public List<Producto> obtenerAllProductos() {
		
		List<Producto> response = new ArrayList<Producto>();
		
		List<ProductoDTO> dtos = productoServices.obtenerAllProductos();
		
		for(ProductoDTO pbd : dtos) {
			Producto p = new Producto();
			p.setCantidad(pbd.getCantidad());
			p.setCategoria(pbd.getCategoria());
			p.setNombre(pbd.getNombre());
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
