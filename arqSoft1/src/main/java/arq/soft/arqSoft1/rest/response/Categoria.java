package arq.soft.arqSoft1.rest.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Datos para crear una categoria.")
public class Categoria {
     
	 @ApiModelProperty(value = "Id de la categoria, tipo long", example = "1")
	 private Long id;
	 
	 @ApiModelProperty(value = "Nombre de la categoria, tipo String", example = "Macotas")
	 private String nombre;

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

}
