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

	//bi-directional many-to-one association to CorequisitoUce
	@OneToMany(mappedBy="materiaUce")
	private List<CorequisitoUce> corequisitoUces;

	//bi-directional many-to-one association to MateriaSyllabus
	@OneToMany(mappedBy="materiaUce")
	private List<MateriaSyllabus> materiaSyllabuses;

	//bi-directional many-to-one association to EscuelaUce
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_escuela_uce")
	private EscuelaUce escuelaUce;

	//bi-directional many-to-one association to PrerequisitoUce
	@OneToMany(mappedBy="materiaUce")
	private List<PrerequisitoUce> prerequisitoUces;

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

	public List<CorequisitoUce> getCorequisitoUces() {
		return this.corequisitoUces;
	}

	public void setCorequisitoUces(List<CorequisitoUce> corequisitoUces) {
		this.corequisitoUces = corequisitoUces;
	}

	public CorequisitoUce addCorequisitoUce(CorequisitoUce corequisitoUce) {
		getCorequisitoUces().add(corequisitoUce);
		corequisitoUce.setMateriaUce(this);

		return corequisitoUce;
	}

	public CorequisitoUce removeCorequisitoUce(CorequisitoUce corequisitoUce) {
		getCorequisitoUces().remove(corequisitoUce);
		corequisitoUce.setMateriaUce(null);

		return corequisitoUce;
	}

	public List<MateriaSyllabus> getMateriaSyllabuses() {
		return this.materiaSyllabuses;
	}

	public void setMateriaSyllabuses(List<MateriaSyllabus> materiaSyllabuses) {
		this.materiaSyllabuses = materiaSyllabuses;
	}

	public MateriaSyllabus addMateriaSyllabus(MateriaSyllabus materiaSyllabus) {
		getMateriaSyllabuses().add(materiaSyllabus);
		materiaSyllabus.setMateriaUce(this);

		return materiaSyllabus;
	}

	public MateriaSyllabus removeMateriaSyllabus(MateriaSyllabus materiaSyllabus) {
		getMateriaSyllabuses().remove(materiaSyllabus);
		materiaSyllabus.setMateriaUce(null);

		return materiaSyllabus;
	}

	public EscuelaUce getEscuelaUce() {
		return this.escuelaUce;
	}

	public void setEscuelaUce(EscuelaUce escuelaUce) {
		this.escuelaUce = escuelaUce;
	}

	public List<PrerequisitoUce> getPrerequisitoUces() {
		return this.prerequisitoUces;
	}

	public void setPrerequisitoUces(List<PrerequisitoUce> prerequisitoUces) {
		this.prerequisitoUces = prerequisitoUces;
	}

	public PrerequisitoUce addPrerequisitoUce(PrerequisitoUce prerequisitoUce) {
		getPrerequisitoUces().add(prerequisitoUce);
		prerequisitoUce.setMateriaUce(this);

		return prerequisitoUce;
	}

	public PrerequisitoUce removePrerequisitoUce(PrerequisitoUce prerequisitoUce) {
		getPrerequisitoUces().remove(prerequisitoUce);
		prerequisitoUce.setMateriaUce(null);

		return prerequisitoUce;
	}

}