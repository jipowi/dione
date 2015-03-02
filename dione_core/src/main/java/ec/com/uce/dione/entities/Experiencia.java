package ec.com.uce.dione.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the experiencia database table.
 * 
 */
@Entity
@NamedQuery(name="Experiencia.findAll", query="SELECT e FROM Experiencia e")
public class Experiencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_experiencia")
	private Integer idExperiencia;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_fin_exp")
	private Date fechaFinExp;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_inicio_exp")
	private Date fechaInicioExp;

	@Column(name="funcion_exp")
	private String funcionExp;

	@Column(name="institucion_exp")
	private String institucionExp;

	//bi-directional many-to-one association to Docente
	@ManyToOne
	@JoinColumn(name="id_docente")
	private Docente docente;

	public Experiencia() {
	}

	public Integer getIdExperiencia() {
		return this.idExperiencia;
	}

	public void setIdExperiencia(Integer idExperiencia) {
		this.idExperiencia = idExperiencia;
	}

	public Date getFechaFinExp() {
		return this.fechaFinExp;
	}

	public void setFechaFinExp(Date fechaFinExp) {
		this.fechaFinExp = fechaFinExp;
	}

	public Date getFechaInicioExp() {
		return this.fechaInicioExp;
	}

	public void setFechaInicioExp(Date fechaInicioExp) {
		this.fechaInicioExp = fechaInicioExp;
	}

	public String getFuncionExp() {
		return this.funcionExp;
	}

	public void setFuncionExp(String funcionExp) {
		this.funcionExp = funcionExp;
	}

	public String getInstitucionExp() {
		return this.institucionExp;
	}

	public void setInstitucionExp(String institucionExp) {
		this.institucionExp = institucionExp;
	}

	public Docente getDocente() {
		return this.docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

}