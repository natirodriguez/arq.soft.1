package arq.soft.arqSoft1.dto;

public class VentaProductoDTO {
	private long id;
	private long idProducto;
	private int cantidadComprada; 
	private long idComprador; 	 
	 
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}

	public int getCantidadComprada() {
		return cantidadComprada;
	}

	public void setCantidadComprada(int cantidadComprada) {
		this.cantidadComprada = cantidadComprada;
	}

	public long getIdComprador() {
		return idComprador;
	}

	public void setIdComprador(long idComprador) {
		this.idComprador = idComprador;
	}
}
