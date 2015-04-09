package ec.com.uce.dione.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the materia_syllabus database table.
 * 
 */
@Entity
@Table(name="materia_syllabus")
@NamedQuery(name="MateriaSyllabus.findAll", query="SELECT m FROM MateriaSyllabus m")
public class MateriaSyllabus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_materia_syllabus")
	private Integer idMateriaSyllabus;

	//bi-directional many-to-one association to Cumplimiento
	@OneToMany(mappedBy="materiaSyllabus")
	private List<Cumplimiento> cumplimientos;

	//bi-directional many-to-one association to Docente
	@ManyToOne
	@JoinColumn(name="id_docente")
	private Docente docente;

	//bi-directional many-to-one association to MateriaUce
	@ManyToOne
	@JoinColumn(name="id_materia_uce")
	private MateriaUce materiaUce;

	//bi-directional many-to-one association to Syllabus
	@ManyToOne
	@JoinColumn(name="id_syllabus")
	private Syllabus syllabus;

	public MateriaSyllabus() {
	}

	public Integer getIdMateriaSyllabus() {
		return this.idMateriaSyllabus;
	}

	public void setIdMateriaSyllabus(Integer idMateriaSyllabus) {
		this.idMateriaSyllabus = idMateriaSyllabus;
	}

	public List<Cumplimiento> getCumplimientos() {
		return this.cumplimientos;
	}

	public void setCumplimientos(List<Cumplimiento> cumplimientos) {
		this.cumplimientos = cumplimientos;
	}

	public Cumplimiento addCumplimiento(Cumplimiento cumplimiento) {
		getCumplimientos().add(cumplimiento);
		cumplimiento.setMateriaSyllabus(this);

		return cumplimiento;
	}

	public Cumplimiento removeCumplimiento(Cumplimiento cumplimiento) {
		getCumplimientos().remove(cumplimiento);
		cumplimiento.setMateriaSyllabus(null);

		return cumplimiento;
	}

	public Docente getDocente() {
		return this.docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public MateriaUce getMateriaUce() {
		return this.materiaUce;
	}

	public void setMateriaUce(MateriaUce materiaUce) {
		this.materiaUce = materiaUce;
	}

	public Syllabus getSyllabus() {
		return this.syllabus;
	}

	public void setSyllabus(Syllabus syllabus) {
		this.syllabus = syllabus;
	}

}