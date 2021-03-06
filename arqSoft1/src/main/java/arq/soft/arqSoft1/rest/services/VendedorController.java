package arq.soft.arqSoft1.rest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import arq.soft.arqSoft1.dto.VendedorDTO;
import arq.soft.arqSoft1.excepciones.UsuarioFoundException;
import arq.soft.arqSoft1.excepciones.UsuarioNotFoundException;
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
		
		try
		{
			dto.setRazonSocial(request.getRazonSocial());
			dto.setEmail(request.getEmail());
			
			vendedorServices.guardarVendedor(dto);			
		} catch (UsuarioFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Vendedor Found", e);
		}
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
    
    @GetMapping("/vendedores/vendedor/{email}")
	public Vendedor obtenerVendedorByEmail(@PathVariable(value = "email") String email) {
		
    	Vendedor v = new Vendedor();

		try {
			VendedorDTO vend = vendedorServices.obtenerVendedorByEmail(email);
			v.setId(vend.getId());
			v.setRazonSocial(vend.getRazonSocial());
			v.setEmail(vend.getEmail());
		} catch (UsuarioNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Vendedor Not Found", e);
		}

		return v;
	}
    
	// GET y SET
	public VendedorServices getVendedorServices() {
		return vendedorServices;
	}

	public void setVendedorServices(VendedorServices vendedorServices) {
		this.vendedorServices = vendedorServices;
	}
}
