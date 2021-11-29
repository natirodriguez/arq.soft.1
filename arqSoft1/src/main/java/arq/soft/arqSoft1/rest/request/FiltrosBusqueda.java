package arq.soft.arqSoft1.rest.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Datos para buscar productos.")
public class FiltrosBusqueda {
	
	 
	public void setPrecioMinimo(double precioMinimo) {
		this.precioMinimo = precioMinimo;
	}

	@ApiModelProperty(value = "Descripcion del producto, tipo String", example = "Macotas")
	private String descripcion;
	
	@ApiModelProperty(value = "Precio minimo de un producto, tipo Double", example = "20.5")
	private double precioMinimo;
	
	@ApiModelProperty(value = "Precio maximo de un producto, tipo Double", example = "20.5")
	private double precioMaximo;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioMinimo() {
		return precioMinimo;
	}

	public double getPrecioMaximo() {
		return precioMaximo;
	}

	public void setPrecioMaximo(double precioMaximo) {
		this.precioMaximo = precioMaximo;
	}

}
