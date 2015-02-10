package ec.com.uce.dione.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the objetivo database table.
 * 
 */
@Entity
@NamedQuery(name="Objetivo.findAll", query="SELECT o FROM Objetivo o")
public class Objetivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_objetivo")
	private Integer idObjetivo;

	@Column(name="avance_obj")
	private Boolean avanceObj;

	@Column(name="dominio_obj")
	private Boolean dominioObj;

	@Column(name="inicio_obj")
	private Boolean inicioObj;

	private String objetivo;

	@Column(name="proceso_obj")
	private Boolean procesoObj;

	//bi-directional many-to-one association to Syllabus
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_syllabus")
	private Syllabus syllabus;

	public Objetivo() {
	}

	public Integer getIdObjetivo() {
		return this.idObjetivo;
	}

	public void setIdObjetivo(Integer idObjetivo) {
		this.idObjetivo = idObjetivo;
	}

	public Boolean getAvanceObj() {
		return this.avanceObj;
	}

	public void setAvanceObj(Boolean avanceObj) {
		this.avanceObj = avanceObj;
	}

	public Boolean getDominioObj() {
		return this.dominioObj;
	}

	public void setDominioObj(Boolean dominioObj) {
		this.dominioObj = dominioObj;
	}

	public Boolean getInicioObj() {
		return this.inicioObj;
	}

	public void setInicioObj(Boolean inicioObj) {
		this.inicioObj = inicioObj;
	}

	public String getObjetivo() {
		return this.objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public Boolean getProcesoObj() {
		return this.procesoObj;
	}

	public void setProcesoObj(Boolean procesoObj) {
		this.procesoObj = procesoObj;
	}

	public Syllabus getSyllabus() {
		return this.syllabus;
	}

	public void setSyllabus(Syllabus syllabus) {
		this.syllabus = syllabus;
	}

}