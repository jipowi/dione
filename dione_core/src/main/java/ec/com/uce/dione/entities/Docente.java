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
	private Long idDocente;

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

	// bi-directional many-to-one association to EscuelaUce
	@OneToMany(mappedBy = "docente")
	private List<FormacionAcademica> formacionAcademicas;

	// bi-directional many-to-one association to EscuelaUce
	@OneToMany(mappedBy = "docente")
	private List<FormacionContinua> formacionContinuas;

	// bi-directional many-to-one association to Syllabus
	@OneToMany(mappedBy = "docente")
	private List<Syllabus> syllabuses;

	public Docente() {
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

	public List<Syllabus> getSyllabuses() {
		return this.syllabuses;
	}

	public void setSyllabuses(List<Syllabus> syllabuses) {
		this.syllabuses = syllabuses;
	}

	public Syllabus addSyllabus(Syllabus syllabus) {
		getSyllabuses().add(syllabus);
		syllabus.setDocente(this);

		return syllabus;
	}

	public Syllabus removeSyllabus(Syllabus syllabus) {
		getSyllabuses().remove(syllabus);
		syllabus.setDocente(null);

		return syllabus;
	}

	/**
	 * @return the idDocente
	 */
	public Long getIdDocente() {
		return idDocente;
	}

	/**
	 * @param idDocente
	 *            the idDocente to set
	 */
	public void setIdDocente(Long idDocente) {
		this.idDocente = idDocente;
	}

	/**
	 * @return the formacionAcademicas
	 */
	public List<FormacionAcademica> getFormacionAcademicas() {
		return formacionAcademicas;
	}

	/**
	 * @param formacionAcademicas
	 *            the formacionAcademicas to set
	 */
	public void setFormacionAcademicas(List<FormacionAcademica> formacionAcademicas) {
		this.formacionAcademicas = formacionAcademicas;
	}

	/**
	 * @return the formacionContinuas
	 */
	public List<FormacionContinua> getFormacionContinuas() {
		return formacionContinuas;
	}

	/**
	 * @param formacionContinuas
	 *            the formacionContinuas to set
	 */
	public void setFormacionContinuas(List<FormacionContinua> formacionContinuas) {
		this.formacionContinuas = formacionContinuas;
	}

}