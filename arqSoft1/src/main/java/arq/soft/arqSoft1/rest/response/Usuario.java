package arq.soft.arqSoft1.rest.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Datos para crear un usuario.")
public class Usuario {
	
	@ApiModelProperty(value = "Id del usuario, tipo long", example = "1")
	private long id;
	@ApiModelProperty(value = "Nombre del usuario, tipo String", example = "Pepe")
	private String nombre;
	@ApiModelProperty(value = "Apellido del usuario, tipo String", example = "Apellido")
	private String apellido;
	@ApiModelProperty(value = "Email del usuario, tipo String", example = "robhalford@gmal.com")
	private String email;
	 
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}
