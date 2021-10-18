package arq.soft.arqSoft1.rest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import arq.soft.arqSoft1.dto.UsuarioDTO;
import arq.soft.arqSoft1.excepciones.UsuarioFoundException;
import arq.soft.arqSoft1.rest.response.Usuario;
import arq.soft.arqSoft1.servicios.UsuarioServices;

@RestController
public class UsuarioController {
	@Autowired
    private UsuarioServices usuarioService;

    @PostMapping(path = "/usuarios", 
    consumes = MediaType.APPLICATION_JSON_VALUE, 
    produces = MediaType.APPLICATION_JSON_VALUE)
	public void crearUsuario(@RequestBody Usuario request) {
    	UsuarioDTO dto = new UsuarioDTO();
    	
    	try
    	{
    		dto.setNombre(request.getNombre());
    		dto.setApellido(request.getApellido());
    		dto.setEmail(request.getEmail());
    		
    		usuarioService.guardarUsuario(dto);    		
		} catch (UsuarioFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario Found", e);
		}
	}
    
    @GetMapping("/usuarios")
	public List<Usuario> obtenerAllUsuarios() {
		
		List<Usuario> response = new ArrayList<Usuario>();
		List<UsuarioDTO> dtos = usuarioService.obtenerAllUsuarios();
		
		for(UsuarioDTO user : dtos) {
			Usuario u = new Usuario();
			u.setId(user.getId());
			u.setNombre(user.getNombre());
			u.setApellido(user.getApellido());
			u.setEmail(user.getEmail());
			response.add(u);
		}

		return response;
	}
    
	// Get y Set
	public UsuarioServices getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioServices usuarioService) {
		this.usuarioService = usuarioService;
	}
	
}
