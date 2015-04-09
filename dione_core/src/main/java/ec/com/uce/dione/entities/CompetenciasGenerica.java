package ec.com.uce.dione.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the competencias_genericas database table.
 * 
 */
@Entity
@Table(name="competencias_genericas")
@NamedQuery(name="CompetenciasGenerica.findAll", query="SELECT c FROM CompetenciasGenerica c")
public class CompetenciasGenerica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_competencia_generica")
	private Integer idCompetenciaGenerica;

	@Column(name="competencia_generica")
	private String competenciaGenerica;

	@Column(name="tipo_competencia")
	private Integer tipoCompetencia;

	//bi-directional many-to-one association to Syllabus
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_syllabus")
	private Syllabus syllabus;

	public CompetenciasGenerica() {
	}

	public Integer getIdCompetenciaGenerica() {
		return this.idCompetenciaGenerica;
	}

	public void setIdCompetenciaGenerica(Integer idCompetenciaGenerica) {
		this.idCompetenciaGenerica = idCompetenciaGenerica;
	}

	public String getCompetenciaGenerica() {
		return this.competenciaGenerica;
	}

	public void setCompetenciaGenerica(String competenciaGenerica) {
		this.competenciaGenerica = competenciaGenerica;
	}

	public Integer getTipoCompetencia() {
		return this.tipoCompetencia;
	}

	public void setTipoCompetencia(Integer tipoCompetencia) {
		this.tipoCompetencia = tipoCompetencia;
	}

	public Syllabus getSyllabus() {
		return this.syllabus;
	}

	public void setSyllabus(Syllabus syllabus) {
		this.syllabus = syllabus;
	}

}