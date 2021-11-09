package arq.soft.arqSoft1.rest.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Datos para crear un producto.")
public class Producto {
	
	@ApiModelProperty(value = "Id del producto, tipo long", example = "1")
	private long id;
	@ApiModelProperty(value = "Id del vendedor, tipo long", example = "4")
	private long idVendedor;
	@ApiModelProperty(value = "Cantidad de stock de un producto, tipo int", example = "999999")
	private int cantidad = 0;
	@ApiModelProperty(value = "Categoria del producto")
	private Categoria categoria;
	@ApiModelProperty(value = "Nombre de un producto, tipo String", example = "Royal canin")
	private String nombre;
	@ApiModelProperty(value = "Descripcion de un producto, tipo String", example = "Esto es un balanceado para perros")
	private String descripcion;
	@ApiModelProperty(value = "Precio de un producto, tipo Double", example = "20.5")
	private String precio;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public long getIdVendedor() {
		return idVendedor;
	}
	public void setIdVendedor(long idVendedor) {
		this.idVendedor = idVendedor;
	}
	

}
