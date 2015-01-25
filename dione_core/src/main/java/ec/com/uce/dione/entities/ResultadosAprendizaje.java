package ec.com.uce.dione.entities;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the resultados_aprendizaje database table.
 * 
 */
@Entity
@Table(name="resultados_aprendizaje")
@NamedQuery(name="ResultadosAprendizaje.findAll", query="SELECT r FROM ResultadosAprendizaje r")
public class ResultadosAprendizaje implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_resultado")
	private Integer idResultado;

	private Boolean avance;

	private Boolean dominio;

	private Boolean inicio;

	private Boolean proceso;

	@Column(name="resultado_aprendizaje")
	private String resultadoAprendizaje;

	//bi-directional many-to-one association to Syllabus
		@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="id_syllabus")
		private Syllabus syllabus;
		
	public ResultadosAprendizaje() {
	}

	public Integer getIdResultado() {
		return this.idResultado;
	}

	public void setIdResultado(Integer idResultado) {
		this.idResultado = idResultado;
	}

	public Boolean getAvance() {
		return this.avance;
	}

	public void setAvance(Boolean avance) {
		this.avance = avance;
	}

	public Boolean getDominio() {
		return this.dominio;
	}

	public void setDominio(Boolean dominio) {
		this.dominio = dominio;
	}

	public Boolean getInicio() {
		return this.inicio;
	}

	public void setInicio(Boolean inicio) {
		this.inicio = inicio;
	}

	public Boolean getProceso() {
		return this.proceso;
	}

	public void setProceso(Boolean proceso) {
		this.proceso = proceso;
	}

	public String getResultadoAprendizaje() {
		return this.resultadoAprendizaje;
	}

	public void setResultadoAprendizaje(String resultadoAprendizaje) {
		this.resultadoAprendizaje = resultadoAprendizaje;
	}

	/**
	 * @return the syllabus
	 */
	public Syllabus getSyllabus() {
		return syllabus;
	}

	/**
	 * @param syllabus the syllabus to set
	 */
	public void setSyllabus(Syllabus syllabus) {
		this.syllabus = syllabus;
	}

}