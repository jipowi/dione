package ec.com.uce.dione.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the unidad_competencia database table.
 * 
 */
@Entity
@Table(name = "unidad_competencia")
@NamedQuery(name = "UnidadCompetencia.findAll", query = "SELECT u FROM UnidadCompetencia u")
public class UnidadCompetencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_unidad_competencia")
	private Integer idUnidadCompetencia;

	@Column(name = "horas_competencia")
	private Integer horasCompetencia;

	// bi-directional many-to-one association to Syllabus
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_syllabus")
	private Syllabus syllabus;

	// bi-directional many-to-one association to ElementoCompetencia
	@OneToMany(mappedBy = "unidadCompetencia")
	private List<ElementoCompetencia> elementoCompetencias;

	@Column(name = "unidad_competencia")
	private String unidadCompetencia;

	public UnidadCompetencia() {
	}

	public Integer getIdUnidadCompetencia() {
		return this.idUnidadCompetencia;
	}

	public void setIdUnidadCompetencia(Integer idUnidadCompetencia) {
		this.idUnidadCompetencia = idUnidadCompetencia;
	}

	public Integer getHorasCompetencia() {
		return this.horasCompetencia;
	}

	public void setHorasCompetencia(Integer horasCompetencia) {
		this.horasCompetencia = horasCompetencia;
	}

	/**
	 * @return the syllabus
	 */
	public Syllabus getSyllabus() {
		return syllabus;
	}

	/**
	 * @param syllabus
	 *            the syllabus to set
	 */
	public void setSyllabus(Syllabus syllabus) {
		this.syllabus = syllabus;
	}

	public String getUnidadCompetencia() {
		return this.unidadCompetencia;
	}

	public void setUnidadCompetencia(String unidadCompetencia) {
		this.unidadCompetencia = unidadCompetencia;
	}

	/**
	 * @return the elementoCompetencias
	 */
	public List<ElementoCompetencia> getElementoCompetencias() {
		return elementoCompetencias;
	}

	/**
	 * @param elementoCompetencias
	 *            the elementoCompetencias to set
	 */
	public void setElementoCompetencias(List<ElementoCompetencia> elementoCompetencias) {
		this.elementoCompetencias = elementoCompetencias;
	}

}