package arq.soft.arqSoft1.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import arq.soft.arqSoft1.dao.ProductoDAO;
import arq.soft.arqSoft1.dao.VentaProductoDAO;
import arq.soft.arqSoft1.dto.VentaProductoDTO;
import arq.soft.arqSoft1.entitys.Producto;
import arq.soft.arqSoft1.entitys.VentaProducto;
import arq.soft.arqSoft1.excepciones.ProductoNotFoundException;
import arq.soft.arqSoft1.excepciones.ProductoSinStockException;

@Service
public class VentaProductoServices {
	@Autowired
	private VentaProductoDAO ventaProductoDAO;
	@Autowired
	private ProductoDAO productoDAO;
	
	public void guardarProductoNuevo(VentaProductoDTO dto) {		
		VentaProducto vp = new VentaProducto();

		vp.setCantidadComprada(dto.getCantidadComprada());
		vp.setIdProducto(dto.getIdProducto());
		vp.setIdComprador(dto.getIdComprador());
		ventaProductoDAO.save(vp);
	}
	
	public void procesarVentaProducto(VentaProductoDTO dto)  throws ProductoSinStockException {
		Producto producto = productoDAO.getById(dto.getIdProducto());
		
		if(producto != null && producto.getCantidad() >= dto.getCantidadComprada())
		{
			int cantidadADescontar = producto.getCantidad() - dto.getCantidadComprada();
			producto.setCantidad(cantidadADescontar);
			productoDAO.save(producto); 
			
			guardarProductoNuevo(dto);
		}
		else
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Sin stock", new ProductoSinStockException());
		}
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
