package ec.com.uce.dione.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the formacion_continua database table.
 * 
 */
@Entity
@Table(name="formacion_continua")
@NamedQuery(name="FormacionContinua.findAll", query="SELECT f FROM FormacionContinua f")
public class FormacionContinua implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_f_continua")
	private Integer idFContinua;

	private String curso;

	private String duracion;

	@Column(name="institucion_continua")
	private String institucionContinua;

	@Column(name="tipo_duracion")
	private String tipoDuracion;

	//bi-directional many-to-one association to Docente
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_docente")
	private Docente docente;

	public FormacionContinua() {
	}

	public Integer getIdFContinua() {
		return this.idFContinua;
	}

	public void setIdFContinua(Integer idFContinua) {
		this.idFContinua = idFContinua;
	}

	public String getCurso() {
		return this.curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getDuracion() {
		return this.duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getInstitucionContinua() {
		return this.institucionContinua;
	}

	public void setInstitucionContinua(String institucionContinua) {
		this.institucionContinua = institucionContinua;
	}

	public String getTipoDuracion() {
		return this.tipoDuracion;
	}

	public void setTipoDuracion(String tipoDuracion) {
		this.tipoDuracion = tipoDuracion;
	}

	public Docente getDocente() {
		return this.docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

}