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

	
	private String objetivo;
	

	//bi-directional many-to-one association to Syllabus
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_syllabus")
	private Syllabus syllabus;

	@Column(name="objetivo_cumplido")
	private Boolean objetivoCumplido;

	public Objetivo() {
	}

	public Integer getIdObjetivo() {
		return this.idObjetivo;
	}

	public void setIdObjetivo(Integer idObjetivo) {
		this.idObjetivo = idObjetivo;
	}

	

	public String getObjetivo() {
		return this.objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public Boolean getObjetivoCumplido() {
		return this.objetivoCumplido;
	}

	public void setObjetivoCumplido(Boolean objetivoCumplido) {
		this.objetivoCumplido = objetivoCumplido;
	}
	public Syllabus getSyllabus() {
		return this.syllabus;
	}

	public void setSyllabus(Syllabus syllabus) {
		this.syllabus = syllabus;
	}
}