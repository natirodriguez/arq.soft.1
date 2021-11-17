package arq.soft.arqSoft1.rest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import arq.soft.arqSoft1.dto.VentaProductoDTO;
import arq.soft.arqSoft1.excepciones.ProductoNotFoundException;
import arq.soft.arqSoft1.excepciones.ProductoSinStockException;
import arq.soft.arqSoft1.rest.response.VentaProducto;
import arq.soft.arqSoft1.servicios.VentaProductoServices;
import io.swagger.annotations.ApiOperation;

@RestController
public class VentaProductoController {
	@Autowired
    private  VentaProductoServices ventaProductoServices;
	
    @PostMapping(path = "/ventaProductos", 
    consumes = MediaType.APPLICATION_JSON_VALUE, 
    produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(nickname = "generar_venta_producto", value = "Generar la venta de un producto")
	public void crearProducto(@RequestBody VentaProducto request) {
    	try
    	{
    		VentaProductoDTO dto = new VentaProductoDTO();
    		dto.setCantidadComprada(request.getCantidadComprada());
    		dto.setIdProducto(request.getIdProducto());
    		dto.setIdComprador(request.getIdComprador());
    		
    		ventaProductoServices.procesarVentaProducto(dto);
    	}catch(ProductoSinStockException e)
    	{
    		
    	}
	}
    
    @GetMapping("/ventaProductos")
    @ApiOperation(nickname = "obtener_ventas_productos", value = "Obtiene todas las ventas de los productos")
	public List<VentaProducto> obtenerAllVentaProductos() {
		
		List<VentaProducto> response = new ArrayList<VentaProducto>();
		List<VentaProductoDTO> dtos = ventaProductoServices.obtenerAllVentasProducto();
		
		for(VentaProductoDTO pbd : dtos) {
			VentaProducto p = new VentaProducto();
			p.setId(pbd.getId());
			p.setCantidadComprada(pbd.getCantidadComprada());			
			p.setIdProducto(pbd.getIdProducto());
			p.setIdComprador(pbd.getIdComprador());
			response.add(p);
		}

		return response;
	}
}
