package arq.soft.arqSoft1.entitys;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transaccion")
public class Transaccion implements Serializable {

	private static final long serialVersionUID = 921874136985876600L;
	
	 @Id
	 @GeneratedValue
	 @Column(name = "transaccion_id")
	 private Long id;
	 
	 @Column(name = "fecha")
	 private Date fecha;
	 
	 @Column(name = "cantidad")
	 private int cantidad;
	 
	 @Column(name = "producto_nombre")
	 private String productoNombre;
	 
	 @Column(name = "precio")
	 private double precio;
	 
	 @Column(name = "vendedor")
	 private String vendedor;
	 
	 @Column(name = "comprador")
	 private String comprador;
	 
	 @Column(name = "codigo_respuesta")
	 private String codigoRespuesta;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getProductoNombre() {
		return productoNombre;
	}

	public void setProductoNombre(String productoNombre) {
		this.productoNombre = productoNombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

	public String getComprador() {
		return comprador;
	}

	public void setComprador(String comprador) {
		this.comprador = comprador;
	}

	public String getCodigoRespuesta() {
		return codigoRespuesta;
	}

	public void setCodigoRespuesta(String codigoRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
	}

}
