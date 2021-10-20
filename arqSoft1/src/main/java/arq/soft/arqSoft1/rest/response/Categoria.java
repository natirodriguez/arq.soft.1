package arq.soft.arqSoft1.rest.response;

import io.swagger.annotations.ApiModelProperty;

public class Categoria {
     
	 //@ApiModelProperty(notes = "Name of the Student",name="name",required=true,value="test name")
	 private Long id;
	 
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
