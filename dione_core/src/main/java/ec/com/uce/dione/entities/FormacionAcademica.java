package ec.com.uce.dione.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the formacion_academica database table.
 * 
 */
@Entity
@Table(name="formacion_academica")
@NamedQuery(name="FormacionAcademica.findAll", query="SELECT f FROM FormacionAcademica f")
public class FormacionAcademica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_f_academica")
	private Integer idFAcademica;

	@Column(name="institucion_aca")
	private String institucionAca;

	private String titulo;

	//bi-directional many-to-one association to Docente
	@ManyToOne
	@JoinColumn(name="id_docente")
	private Docente docente;

	public FormacionAcademica() {
	}

	public Integer getIdFAcademica() {
		return this.idFAcademica;
	}

	public void setIdFAcademica(Integer idFAcademica) {
		this.idFAcademica = idFAcademica;
	}

	public String getInstitucionAca() {
		return this.institucionAca;
	}

	public void setInstitucionAca(String institucionAca) {
		this.institucionAca = institucionAca;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Docente getDocente() {
		return this.docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

}