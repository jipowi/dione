package ec.com.uce.dione.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the elemento_competencia database table.
 * 
 */
@Entity
@Table(name="elemento_competencia")
@NamedQuery(name="ElementoCompetencia.findAll", query="SELECT e FROM ElementoCompetencia e")
public class ElementoCompetencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_elemento_competencia")
	private Integer idElementoCompetencia;

	@Column(name="elemento_competencia")
	private String elementoCompetencia;

	@Column(name="elemento_cumplido")
	private Boolean elementoCumplido;

	//bi-directional many-to-one association to UnidadCompetencia
	@ManyToOne
	@JoinColumn(name="id_unidad_competencia")
	private UnidadCompetencia unidadCompetencia;

	public ElementoCompetencia() {
	}

	public Integer getIdElementoCompetencia() {
		return this.idElementoCompetencia;
	}

	public void setIdElementoCompetencia(Integer idElementoCompetencia) {
		this.idElementoCompetencia = idElementoCompetencia;
	}

	public String getElementoCompetencia() {
		return this.elementoCompetencia;
	}

	public void setElementoCompetencia(String elementoCompetencia) {
		this.elementoCompetencia = elementoCompetencia;
	}

	public Boolean getElementoCumplido() {
		return this.elementoCumplido;
	}

	public void setElementoCumplido(Boolean elementoCumplido) {
		this.elementoCumplido = elementoCumplido;
	}

	public UnidadCompetencia getUnidadCompetencia() {
		return this.unidadCompetencia;
	}

	public void setUnidadCompetencia(UnidadCompetencia unidadCompetencia) {
		this.unidadCompetencia = unidadCompetencia;
	}

}