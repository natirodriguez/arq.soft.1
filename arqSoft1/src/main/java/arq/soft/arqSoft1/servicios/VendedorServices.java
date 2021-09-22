package arq.soft.arqSoft1.servicios;

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
	
	// Getter y setter
	public VendedorDAO getVendedorDAO() {
		return vendedorDAO;
	}

	public void setVendedorDAO(VendedorDAO vendedorDAO) {
		this.vendedorDAO = vendedorDAO;
	}
}
