package arq.soft.arqSoft1.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categoria")
public class Categoria {

	 @Id
	 @GeneratedValue
	 @Column(name = "categoria_id")
	 private Long id;

	 @Column(name = "nombre")
	 private String nombre;
}
