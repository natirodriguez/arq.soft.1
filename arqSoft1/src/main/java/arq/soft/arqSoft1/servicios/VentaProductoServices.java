package arq.soft.arqSoft1.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import arq.soft.arqSoft1.dao.VentaProductoDAO;
import arq.soft.arqSoft1.dto.VentaProductoDTO;
import arq.soft.arqSoft1.entitys.VentaProducto;

@Service
public class VentaProductoServices {
	@Autowired
	private VentaProductoDAO ventaProductoDAO;
	
	public void guardarProductoNuevo(VentaProductoDTO dto) {
		VentaProducto vp = new VentaProducto();

		vp.setCantidadComprada(dto.getCantidadComprada());
		vp.setIdProducto(dto.getIdProducto());
		vp.setIdComprador(dto.getIdComprador());
		ventaProductoDAO.save(vp);
	}
	
	public List<VentaProductoDTO> obtenerAllVentasProducto() {
		
		List<VentaProductoDTO> response = new ArrayList<VentaProductoDTO>();
		List<VentaProducto> entitys = ventaProductoDAO.findAll();
		
		for(VentaProducto pbd : entitys) {
			VentaProductoDTO p = new VentaProductoDTO();
			p.setId(pbd.getId());
			p.setCantidadComprada(pbd.getCantidadComprada());
			p.setIdProducto(pbd.getIdProducto());
			p.setIdComprador(pbd.getIdComprador());
			response.add(p);
		}
		return response;
	}
}
