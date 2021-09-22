package arq.soft.arqSoft1.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vendedor")
public class Vendedor extends Entidad {
	 
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	 @Id
	 @GeneratedValue
	 @Column(name = "vendedor_id")
	 private Long id;

	 @Column(name = "razonSocial")
	 private String razonSocial;
	 
	 @Column(name = "email")
	 private String email;
	
	 
	 public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}
