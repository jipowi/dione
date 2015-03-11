package ec.com.uce.dione.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the prerequisito database table.
 * 
 */
@Entity
@NamedQuery(name="Prerequisito.findAll", query="SELECT p FROM Prerequisito p")
public class Prerequisito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_prerequisito")
	private Integer idPrerequisito;

	private String prerequisito;

	//bi-directional many-to-one association to Materia
	@ManyToOne
	@JoinColumn(name="id_materia")
	private Materia materia;

	public Prerequisito() {
	}

	public Integer getIdPrerequisito() {
		return this.idPrerequisito;
	}

	public void setIdPrerequisito(Integer idPrerequisito) {
		this.idPrerequisito = idPrerequisito;
	}

	public String getPrerequisito() {
		return this.prerequisito;
	}

	public void setPrerequisito(String prerequisito) {
		this.prerequisito = prerequisito;
	}

	public Materia getMateria() {
		return this.materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

}