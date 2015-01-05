package ec.com.uce.dione.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * The persistent class for the docente database table.
 * 
 */
@Entity
@NamedQuery(name = "Docente.findAll", query = "SELECT d FROM Docente d")
public class Docente extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_docente")
	private Integer idDocente;

	@Column(name = "apellidos_docente")
	private String apellidosDocente;

	@Column(name = "cedula_docente")
	private String cedulaDocente;

	@Column(name = "direccion_docente")
	private String direccionDocente;

	@Column(name = "nombres_docente")
	private String nombresDocente;

	// bi-directional many-to-one association to EscuelaUce
	@OneToMany(mappedBy = "docente")
	private List<EscuelaUce> escuelaUces;

	public Docente() {
	}

	public Integer getIdDocente() {
		return this.idDocente;
	}

	public void setIdDocente(Integer idDocente) {
		this.idDocente = idDocente;
	}

	public String getApellidosDocente() {
		return this.apellidosDocente;
	}

	public void setApellidosDocente(String apellidosDocente) {
		this.apellidosDocente = apellidosDocente;
	}

	public String getCedulaDocente() {
		return this.cedulaDocente;
	}

	public void setCedulaDocente(String cedulaDocente) {
		this.cedulaDocente = cedulaDocente;
	}

	public String getDireccionDocente() {
		return this.direccionDocente;
	}

	public void setDireccionDocente(String direccionDocente) {
		this.direccionDocente = direccionDocente;
	}

	public String getNombresDocente() {
		return this.nombresDocente;
	}

	public void setNombresDocente(String nombresDocente) {
		this.nombresDocente = nombresDocente;
	}

	public List<EscuelaUce> getEscuelaUces() {
		return this.escuelaUces;
	}

	public void setEscuelaUces(List<EscuelaUce> escuelaUces) {
		this.escuelaUces = escuelaUces;
	}

	public EscuelaUce addEscuelaUce(EscuelaUce escuelaUce) {
		getEscuelaUces().add(escuelaUce);
		escuelaUce.setDocente(this);

		return escuelaUce;
	}

	public EscuelaUce removeEscuelaUce(EscuelaUce escuelaUce) {
		getEscuelaUces().remove(escuelaUce);
		escuelaUce.setDocente(null);

		return escuelaUce;
	}

}