package arq.soft.arqSoft1.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import arq.soft.arqSoft1.dao.VendedorDAO;
import arq.soft.arqSoft1.dto.VendedorDTO;
import arq.soft.arqSoft1.entitys.Vendedor;

@Service
public class VendedorServices {
	@Autowired
	private VendedorDAO vendedorDAO;

	public void guardarVendedor(VendedorDTO dto) {
		Vendedor v = new Vendedor();
		v.setRazonSocial(dto.getRazonSocial());
		v.setEmail(dto.getEmail());
		vendedorDAO.save(v);
	}
	
	public List<VendedorDTO> obtenerAllVendedores() {
		List<VendedorDTO> response = new ArrayList<VendedorDTO>();
		List<Vendedor> entitys = vendedorDAO.findAll();
		
		for(Vendedor vend : entitys) {
			VendedorDTO p = new VendedorDTO();
			p.setId(vend.getId());
			p.setRazonSocial(vend.getRazonSocial());
			p.setEmail(vend.getEmail());
			response.add(p);
		}
		return response;
	}
	
	// Getter y setter
	public VendedorDAO getVendedorDAO() {
		return vendedorDAO;
	}

	public void setVendedorDAO(VendedorDAO vendedorDAO) {
		this.vendedorDAO = vendedorDAO;
	}
}
