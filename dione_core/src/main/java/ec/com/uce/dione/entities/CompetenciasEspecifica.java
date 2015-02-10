package ec.com.uce.dione.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the competencias_especificas database table.
 * 
 */
@Entity
@Table(name="competencias_especificas")
@NamedQuery(name="CompetenciasEspecifica.findAll", query="SELECT c FROM CompetenciasEspecifica c")
public class CompetenciasEspecifica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_competencia_especifica")
	private Integer idCompetenciaEspecifica;

	@Column(name="competencia_especifica")
	private String competenciaEspecifica;

	//bi-directional many-to-one association to Syllabus
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_syllabus")
	private Syllabus syllabus;

	public CompetenciasEspecifica() {
	}

	public Integer getIdCompetenciaEspecifica() {
		return this.idCompetenciaEspecifica;
	}

	public void setIdCompetenciaEspecifica(Integer idCompetenciaEspecifica) {
		this.idCompetenciaEspecifica = idCompetenciaEspecifica;
	}

	public String getCompetenciaEspecifica() {
		return this.competenciaEspecifica;
	}

	public void setCompetenciaEspecifica(String competenciaEspecifica) {
		this.competenciaEspecifica = competenciaEspecifica;
	}

	public Syllabus getSyllabus() {
		return this.syllabus;
	}

	public void setSyllabus(Syllabus syllabus) {
		this.syllabus = syllabus;
	}

}