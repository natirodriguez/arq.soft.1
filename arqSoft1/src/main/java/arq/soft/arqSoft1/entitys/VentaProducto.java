package arq.soft.arqSoft1.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ventaProducto")
public class VentaProducto extends Entidad{

	/**
	* 
	*/
	private static final long serialVersionUID = 2881342164483944098L;

	@Id
	@GeneratedValue
	@Column(name = "venta_id")
	private long id;
	
	@Column(name = "producto_id")
	private Long idProducto;	
		 
	@Column(name = "cantidadComprada")
	private int cantidadComprada; 
		 
	@Column(name = "comprador_id")
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
