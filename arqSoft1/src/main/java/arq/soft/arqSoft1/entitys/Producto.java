package arq.soft.arqSoft1.entitys;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="producto")
public class Producto extends Entidad {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1681466025686029913L;

	
	 @Id
	 @GeneratedValue
	 @Column(name = "producto_id")
	 private Long id;
	 
	 @Column(name = "vendedor_id")
	 private Long idVendedor;

	 @Column(name = "nombre")
	 private String nombre;
	 
	 @Column(name = "categoria")
	 private String categoria;
	 
	 @Column(name = "cantidad")
	 private int cantidad;
	 
	 @Column(name = "precio")
	 private String precio;
	 
	 @Column(name = "descripcion")
	 private String descripcion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getIdVendedor() {
		return idVendedor;
	}

	public void setIdVendedor(Long idVendedor) {
		this.idVendedor = idVendedor;
	}

	
}
