package ec.com.uce.dione.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the materia database table.
 * 
 */
@Entity
@NamedQuery(name="Materia.findAll", query="SELECT m FROM Materia m")
public class Materia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_materia")
	private Integer idMateria;

	private String materia;

	//bi-directional many-to-one association to Escuela
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_escuela")
	private Escuela escuela;

	public Materia() {
	}

	public Integer getIdMateria() {
		return this.idMateria;
	}

	public void setIdMateria(Integer idMateria) {
		this.idMateria = idMateria;
	}

	public String getMateria() {
		return this.materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public Escuela getEscuela() {
		return this.escuela;
	}

	public void setEscuela(Escuela escuela) {
		this.escuela = escuela;
	}

}