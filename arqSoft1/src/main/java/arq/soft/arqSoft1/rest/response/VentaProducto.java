package arq.soft.arqSoft1.rest.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Datos para generar la venta de un producto.")
public class VentaProducto {
	@ApiModelProperty(value = "Id de la venta del producto, tipo long", example = "1")
	private long id;
	@ApiModelProperty(value = "Id del producto, tipo long", example = "1")
	private Long idProducto;
	@ApiModelProperty(value = "Cantidad comprada, tipo int", example = "5")
	private int cantidadComprada; 
	@ApiModelProperty(value = "Id del comprador, tipo long", example = "1")
	private Long idComprador; 	 
	 
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public int getCantidadComprada() {
		return cantidadComprada;
	}

	public void setCantidadComprada(int cantidadComprada) {
		this.cantidadComprada = cantidadComprada;
	}

	public Long getIdComprador() {
		return idComprador;
	}

	public void setIdComprador(Long idComprador) {
		this.idComprador = idComprador;
	}
}
