package arq.soft.arqSoft1.rest.services;

import org.springframework.web.bind.annotation.RestController;
import arq.soft.arqSoft1.rest.response.Producto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class ProductoController {
	
	@GetMapping("/productos")
	public List<Producto> greeting() {
		List<Producto> response = new ArrayList<Producto>();
		Producto p1 = new Producto();
		p1.setCantidad(6);
		p1.setCategoria("Limpieza");
		p1.setNombre("Ayudin");
		response.add(p1);
		Producto p2 = new Producto();
		p2.setCantidad(6);
		p2.setCategoria("Limpieza");
		p2.setNombre("Querubin");
		response.add(p2);
		return response;
	}

}
