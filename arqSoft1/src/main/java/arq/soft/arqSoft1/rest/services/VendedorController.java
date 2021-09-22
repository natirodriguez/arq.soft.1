package arq.soft.arqSoft1.rest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

    @PostMapping(path = "/vendedor", 
    consumes = MediaType.APPLICATION_JSON_VALUE, 
    produces = MediaType.APPLICATION_JSON_VALUE)
	public void crearVendedor(@RequestBody Vendedor request) {
		VendedorDTO dto = new VendedorDTO();
		dto.setRazonSocial(request.getRazonSocial());
		dto.setEmail(request.getEmail());
			
		vendedorServices.guardarVendedor(dto);
	}
    
	// GET y SET
	public VendedorServices getVendedorServices() {
		return vendedorServices;
	}

	public void setVendedorServices(VendedorServices vendedorServices) {
		this.vendedorServices = vendedorServices;
	}
}
