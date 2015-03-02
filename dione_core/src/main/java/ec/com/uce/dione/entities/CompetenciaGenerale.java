package ec.com.uce.dione.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the competencia_generales database table.
 * 
 */
@Entity
@Table(name="competencia_generales")
@NamedQuery(name="CompetenciaGenerale.findAll", query="SELECT c FROM CompetenciaGenerale c")
public class CompetenciaGenerale implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_competencia_general")
	private Integer idCompetenciaGeneral;

	@Column(name="avance_comp")
	private Boolean avanceComp;

	@Column(name="competencia_general")
	private String competenciaGeneral;

	@Column(name="dominio_comp")
	private Boolean dominioComp;

	@Column(name="inicio_comp")
	private Boolean inicioComp;

	@Column(name="proceso_comp")
	private Boolean procesoComp;

	//bi-directional many-to-one association to Syllabus
	@ManyToOne
	@JoinColumn(name="id_syllabus")
	private Syllabus syllabus;

	public CompetenciaGenerale() {
	}

	public Integer getIdCompetenciaGeneral() {
		return this.idCompetenciaGeneral;
	}

	public void setIdCompetenciaGeneral(Integer idCompetenciaGeneral) {
		this.idCompetenciaGeneral = idCompetenciaGeneral;
	}

	public Boolean getAvanceComp() {
		return this.avanceComp;
	}

	public void setAvanceComp(Boolean avanceComp) {
		this.avanceComp = avanceComp;
	}

	public String getCompetenciaGeneral() {
		return this.competenciaGeneral;
	}

	public void setCompetenciaGeneral(String competenciaGeneral) {
		this.competenciaGeneral = competenciaGeneral;
	}

	public Boolean getDominioComp() {
		return this.dominioComp;
	}

	public void setDominioComp(Boolean dominioComp) {
		this.dominioComp = dominioComp;
	}

	public Boolean getInicioComp() {
		return this.inicioComp;
	}

	public void setInicioComp(Boolean inicioComp) {
		this.inicioComp = inicioComp;
	}

	public Boolean getProcesoComp() {
		return this.procesoComp;
	}

	public void setProcesoComp(Boolean procesoComp) {
		this.procesoComp = procesoComp;
	}

	public Syllabus getSyllabus() {
		return this.syllabus;
	}

	public void setSyllabus(Syllabus syllabus) {
		this.syllabus = syllabus;
	}

}