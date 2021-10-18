package arq.soft.arqSoft1.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import arq.soft.arqSoft1.dao.UsuarioDAO;
import arq.soft.arqSoft1.dto.UsuarioDTO;
import arq.soft.arqSoft1.entitys.Usuario;
import arq.soft.arqSoft1.excepciones.UsuarioFoundException;

@Service
public class UsuarioServices {
	@Autowired
	private UsuarioDAO usuarioDAO;

	public void guardarUsuario(UsuarioDTO dto) throws UsuarioFoundException {
		Optional<Usuario> pop = usuarioDAO.findByEmail(dto.getEmail());
		
		if(!pop.isPresent())
		{
			Usuario u = new Usuario();
			u.setNombre(dto.getNombre());
			u.setApellido(dto.getApellido());
			u.setEmail(dto.getEmail());
			usuarioDAO.save(u);			
		}else {
			throw new UsuarioFoundException();
		}
	}
	
	public List<UsuarioDTO> obtenerAllUsuarios() {
		List<UsuarioDTO> response = new ArrayList<UsuarioDTO>();
		List<Usuario> entitys = usuarioDAO.findAll();
		
		for(Usuario user : entitys) {
			UsuarioDTO u = new UsuarioDTO();
			u.setId(user.getId());
			u.setNombre(user.getNombre());
			u.setApellido(user.getApellido());
			u.setEmail(user.getEmail());
			response.add(u);
		}
		return response;
	}
	
	// Get y Set
	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
}
