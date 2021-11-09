package arq.soft.arqSoft1.rest.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Datos para crear un vendedor.")
public class Vendedor {
	
	@ApiModelProperty(value = "Id del vendedor, tipo long", example = "1")
	private long id;
	@ApiModelProperty(value = "Razon social del vendedor, tipo String", example = "Pepemeras")
	private String razonSocial;
	@ApiModelProperty(value = "Email del vendedor, tipo String", example = "pepe.remeras@gmal.com")
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
