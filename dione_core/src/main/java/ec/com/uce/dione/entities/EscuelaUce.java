package ec.com.uce.dione.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the escuela_uce database table.
 * 
 */
@Entity
@Table(name="escuela_uce")
@NamedQuery(name="EscuelaUce.findAll", query="SELECT e FROM EscuelaUce e")
public class EscuelaUce implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_escuela_uce")
	private Integer idEscuelaUce;

	@Column(name="escuela_uce")
	private String escuelaUce;

	//bi-directional many-to-one association to Docente
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_docente")
	private Docente docente;

	public EscuelaUce() {
	}

	public Integer getIdEscuelaUce() {
		return this.idEscuelaUce;
	}

	public void setIdEscuelaUce(Integer idEscuelaUce) {
		this.idEscuelaUce = idEscuelaUce;
	}

	public String getEscuelaUce() {
		return this.escuelaUce;
	}

	public void setEscuelaUce(String escuelaUce) {
		this.escuelaUce = escuelaUce;
	}

	public Docente getDocente() {
		return this.docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

}