package ec.com.uce.dione.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the escuela database table.
 * 
 */
@Entity
@NamedQuery(name="Escuela.findAll", query="SELECT e FROM Escuela e")
public class Escuela implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_escuela")
	private Integer idEscuela;

	private String escuela;

	//bi-directional many-to-one association to Materia
	@OneToMany(mappedBy="escuela")
	private List<Materia> materias;

	public Escuela() {
	}

	public Integer getIdEscuela() {
		return this.idEscuela;
	}

	public void setIdEscuela(Integer idEscuela) {
		this.idEscuela = idEscuela;
	}

	public String getEscuela() {
		return this.escuela;
	}

	public void setEscuela(String escuela) {
		this.escuela = escuela;
	}

	public List<Materia> getMaterias() {
		return this.materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}

	public Materia addMateria(Materia materia) {
		getMaterias().add(materia);
		materia.setEscuela(this);

		return materia;
	}

	public Materia removeMateria(Materia materia) {
		getMaterias().remove(materia);
		materia.setEscuela(null);

		return materia;
	}

}