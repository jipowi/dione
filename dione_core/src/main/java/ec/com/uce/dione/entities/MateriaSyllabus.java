package ec.com.uce.dione.entities;

import java.io.Serializable;
import javax.persistence.*;


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