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

	@Column(name="avance_resul")
	private Boolean avanceResul;

	@Column(name="dominio_resul")
	private Boolean dominioResul;

	@Column(name="inicio_resul")
	private Boolean inicioResul;

	@Column(name="proceso_resul")
	private Boolean procesoResul;

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

	public Boolean getAvanceResul() {
		return this.avanceResul;
	}

	public void setAvanceResul(Boolean avanceResul) {
		this.avanceResul = avanceResul;
	}

	public Boolean getDominioResul() {
		return this.dominioResul;
	}

	public void setDominioResul(Boolean dominioResul) {
		this.dominioResul = dominioResul;
	}

	public Boolean getInicioResul() {
		return this.inicioResul;
	}

	public void setInicioResul(Boolean inicioResul) {
		this.inicioResul = inicioResul;
	}

	public Boolean getProcesoResul() {
		return this.procesoResul;
	}

	public void setProcesoResul(Boolean procesoResul) {
		this.procesoResul = procesoResul;
	}

	public String getResultadoAprendizaje() {
		return this.resultadoAprendizaje;
	}

	public void setResultadoAprendizaje(String resultadoAprendizaje) {
		this.resultadoAprendizaje = resultadoAprendizaje;
	}

	public Syllabus getSyllabus() {
		return this.syllabus;
	}

	public void setSyllabus(Syllabus syllabus) {
		this.syllabus = syllabus;
	}

}