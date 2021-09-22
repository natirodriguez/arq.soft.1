package arq.soft.arqSoft1.rest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import arq.soft.arqSoft1.dto.VendedorDTO;
import arq.soft.arqSoft1.rest.response.Vendedor;
import arq.soft.arqSoft1.servicios.VendedorServices;


@RestController
public class VendedorController {
	@Autowired
    private VendedorServices vendedorServices;

    @PostMapping(path = "/vendedores", 
    consumes = MediaType.APPLICATION_JSON_VALUE, 
    produces = MediaType.APPLICATION_JSON_VALUE)
	public void crearVendedor(@RequestBody Vendedor request) {
		VendedorDTO dto = new VendedorDTO();
		dto.setRazonSocial(request.getRazonSocial());
		dto.setEmail(request.getEmail());
			
		vendedorServices.guardarVendedor(dto);
	}
    
    @GetMapping("/vendedores")
	public List<Vendedor> obtenerAllVendedores() {
		
		List<Vendedor> response = new ArrayList<Vendedor>();
		List<VendedorDTO> dtos = vendedorServices.obtenerAllVendedores();
		
		for(VendedorDTO vend : dtos) {
			Vendedor v = new Vendedor();
			v.setId(vend.getId());
			v.setRazonSocial(vend.getRazonSocial());
			v.setEmail(vend.getEmail());
			response.add(v);
		}

		return response;
	}
    
	// GET y SET
	public VendedorServices getVendedorServices() {
		return vendedorServices;
	}

	public void setVendedorServices(VendedorServices vendedorServices) {
		this.vendedorServices = vendedorServices;
	}
}
