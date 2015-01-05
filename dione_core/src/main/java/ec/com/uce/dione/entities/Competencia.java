package ec.com.uce.dione.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the competencia database table.
 * 
 */
@Entity
@NamedQuery(name="Competencia.findAll", query="SELECT c FROM Competencia c")
public class Competencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_competencia")
	private Integer idCompetencia;

	private String competencia;

	//bi-directional many-to-one association to Syllabus
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_syllabus")
	private Syllabus syllabus;

	//bi-directional many-to-one association to ElementoCompetencia
	@OneToMany(mappedBy="competencia")
	private List<ElementoCompetencia> elementoCompetencias;

	public Competencia() {
	}

	public Integer getIdCompetencia() {
		return this.idCompetencia;
	}

	public void setIdCompetencia(Integer idCompetencia) {
		this.idCompetencia = idCompetencia;
	}

	public String getCompetencia() {
		return this.competencia;
	}

	public void setCompetencia(String competencia) {
		this.competencia = competencia;
	}

	public Syllabus getSyllabus() {
		return this.syllabus;
	}

	public void setSyllabus(Syllabus syllabus) {
		this.syllabus = syllabus;
	}

	public List<ElementoCompetencia> getElementoCompetencias() {
		return this.elementoCompetencias;
	}

	public void setElementoCompetencias(List<ElementoCompetencia> elementoCompetencias) {
		this.elementoCompetencias = elementoCompetencias;
	}

	public ElementoCompetencia addElementoCompetencia(ElementoCompetencia elementoCompetencia) {
		getElementoCompetencias().add(elementoCompetencia);
		elementoCompetencia.setCompetencia(this);

		return elementoCompetencia;
	}

	public ElementoCompetencia removeElementoCompetencia(ElementoCompetencia elementoCompetencia) {
		getElementoCompetencias().remove(elementoCompetencia);
		elementoCompetencia.setCompetencia(null);

		return elementoCompetencia;
	}

}