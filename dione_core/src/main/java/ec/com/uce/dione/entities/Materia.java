package ec.com.uce.dione.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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

	//bi-directional many-to-one association to Corequisito
	@OneToMany(mappedBy="materia")
	private List<Corequisito> corequisitos;

	//bi-directional many-to-one association to Escuela
	@ManyToOne
	@JoinColumn(name="id_escuela")
	private Escuela escuela;

	//bi-directional many-to-one association to Prerequisito
	@OneToMany(mappedBy="materia")
	private List<Prerequisito> prerequisitos;

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

	public List<Corequisito> getCorequisitos() {
		return this.corequisitos;
	}

	public void setCorequisitos(List<Corequisito> corequisitos) {
		this.corequisitos = corequisitos;
	}

	public Corequisito addCorequisito(Corequisito corequisito) {
		getCorequisitos().add(corequisito);
		corequisito.setMateria(this);

		return corequisito;
	}

	public Corequisito removeCorequisito(Corequisito corequisito) {
		getCorequisitos().remove(corequisito);
		corequisito.setMateria(null);

		return corequisito;
	}

	public Escuela getEscuela() {
		return this.escuela;
	}

	public void setEscuela(Escuela escuela) {
		this.escuela = escuela;
	}

	public List<Prerequisito> getPrerequisitos() {
		return this.prerequisitos;
	}

	public void setPrerequisitos(List<Prerequisito> prerequisitos) {
		this.prerequisitos = prerequisitos;
	}

	public Prerequisito addPrerequisito(Prerequisito prerequisito) {
		getPrerequisitos().add(prerequisito);
		prerequisito.setMateria(this);

		return prerequisito;
	}

	public Prerequisito removePrerequisito(Prerequisito prerequisito) {
		getPrerequisitos().remove(prerequisito);
		prerequisito.setMateria(null);

		return prerequisito;
	}

}