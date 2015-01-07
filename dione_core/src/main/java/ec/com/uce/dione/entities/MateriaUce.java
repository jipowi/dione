package ec.com.uce.dione.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the materia_uce database table.
 * 
 */
@Entity
@Table(name="materia_uce")
@NamedQuery(name="MateriaUce.findAll", query="SELECT m FROM MateriaUce m")
public class MateriaUce implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_materia_uce")
	private Integer idMateriaUce;

	@Column(name="materia_uce")
	private String materiaUce;

	//bi-directional many-to-one association to Docente
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_docente")
	private Docente docente;

	//bi-directional many-to-one association to Syllabus
	@OneToMany(mappedBy="materiaUce")
	private List<Syllabus> syllabuses;

	public MateriaUce() {
	}

	public Integer getIdMateriaUce() {
		return this.idMateriaUce;
	}

	public void setIdMateriaUce(Integer idMateriaUce) {
		this.idMateriaUce = idMateriaUce;
	}

	public String getMateriaUce() {
		return this.materiaUce;
	}

	public void setMateriaUce(String materiaUce) {
		this.materiaUce = materiaUce;
	}

	public Docente getDocente() {
		return this.docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public List<Syllabus> getSyllabuses() {
		return this.syllabuses;
	}

	public void setSyllabuses(List<Syllabus> syllabuses) {
		this.syllabuses = syllabuses;
	}

	public Syllabus addSyllabus(Syllabus syllabus) {
		getSyllabuses().add(syllabus);
		syllabus.setMateriaUce(this);

		return syllabus;
	}

	public Syllabus removeSyllabus(Syllabus syllabus) {
		getSyllabuses().remove(syllabus);
		syllabus.setMateriaUce(null);

		return syllabus;
	}

}