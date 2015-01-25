package ec.com.uce.dione.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the unidad_competencia database table.
 * 
 */
@Entity
@Table(name="unidad_competencia")
@NamedQuery(name="UnidadCompetencia.findAll", query="SELECT u FROM UnidadCompetencia u")
public class UnidadCompetencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_unidad_competencia")
	private Integer idUnidadCompetencia;

	@Column(name="horas_competencia")
	private Integer horasCompetencia;

	@Column(name="unidad_competencia")
	private String unidadCompetencia;

	//bi-directional many-to-one association to ElementoCompetencia
	@OneToMany(mappedBy="unidadCompetencia")
	private List<ElementoCompetencia> elementoCompetencias;

	//bi-directional many-to-one association to Syllabus
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_syllabus")
	private Syllabus syllabus;

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

	public String getUnidadCompetencia() {
		return this.unidadCompetencia;
	}

	public void setUnidadCompetencia(String unidadCompetencia) {
		this.unidadCompetencia = unidadCompetencia;
	}

	public List<ElementoCompetencia> getElementoCompetencias() {
		return this.elementoCompetencias;
	}

	public void setElementoCompetencias(List<ElementoCompetencia> elementoCompetencias) {
		this.elementoCompetencias = elementoCompetencias;
	}

	public ElementoCompetencia addElementoCompetencia(ElementoCompetencia elementoCompetencia) {
		getElementoCompetencias().add(elementoCompetencia);
		elementoCompetencia.setUnidadCompetencia(this);

		return elementoCompetencia;
	}

	public ElementoCompetencia removeElementoCompetencia(ElementoCompetencia elementoCompetencia) {
		getElementoCompetencias().remove(elementoCompetencia);
		elementoCompetencia.setUnidadCompetencia(null);

		return elementoCompetencia;
	}

	public Syllabus getSyllabus() {
		return this.syllabus;
	}

	public void setSyllabus(Syllabus syllabus) {
		this.syllabus = syllabus;
	}

}