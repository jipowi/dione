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

	// bi-directional many-to-one association to Experiencia
	@OneToMany(mappedBy = "docente")
	private List<Experiencia> experiencias;

	// bi-directional many-to-one association to FormacionAcademica
	@OneToMany(mappedBy = "docente")
	private List<FormacionAcademica> formacionAcademicas;

	// bi-directional many-to-one association to FormacionContinua
	@OneToMany(mappedBy = "docente")
	private List<FormacionContinua> formacionContinuas;

	// bi-directional many-to-one association to MateriaSyllabus
	@OneToMany(mappedBy = "docente")
	private List<MateriaSyllabus> materiaSyllabuses;

	// bi-directional many-to-one association to ArchivoBase
	@OneToMany(mappedBy = "docente")
	private List<ArchivoBase> archivoBases;

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

	public List<Experiencia> getExperiencias() {
		return this.experiencias;
	}

	public void setExperiencias(List<Experiencia> experiencias) {
		this.experiencias = experiencias;
	}

	public Experiencia addExperiencia(Experiencia experiencia) {
		getExperiencias().add(experiencia);
		experiencia.setDocente(this);

		return experiencia;
	}

	public Experiencia removeExperiencia(Experiencia experiencia) {
		getExperiencias().remove(experiencia);
		experiencia.setDocente(null);

		return experiencia;
	}

	public List<FormacionAcademica> getFormacionAcademicas() {
		return this.formacionAcademicas;
	}

	public void setFormacionAcademicas(List<FormacionAcademica> formacionAcademicas) {
		this.formacionAcademicas = formacionAcademicas;
	}

	public FormacionAcademica addFormacionAcademica(FormacionAcademica formacionAcademica) {
		getFormacionAcademicas().add(formacionAcademica);
		formacionAcademica.setDocente(this);

		return formacionAcademica;
	}

	public FormacionAcademica removeFormacionAcademica(FormacionAcademica formacionAcademica) {
		getFormacionAcademicas().remove(formacionAcademica);
		formacionAcademica.setDocente(null);

		return formacionAcademica;
	}

	public List<FormacionContinua> getFormacionContinuas() {
		return this.formacionContinuas;
	}

	public void setFormacionContinuas(List<FormacionContinua> formacionContinuas) {
		this.formacionContinuas = formacionContinuas;
	}

	public FormacionContinua addFormacionContinua(FormacionContinua formacionContinua) {
		getFormacionContinuas().add(formacionContinua);
		formacionContinua.setDocente(this);

		return formacionContinua;
	}

	public FormacionContinua removeFormacionContinua(FormacionContinua formacionContinua) {
		getFormacionContinuas().remove(formacionContinua);
		formacionContinua.setDocente(null);

		return formacionContinua;
	}

	public List<MateriaSyllabus> getMateriaSyllabuses() {
		return this.materiaSyllabuses;
	}

	public void setMateriaSyllabuses(List<MateriaSyllabus> materiaSyllabuses) {
		this.materiaSyllabuses = materiaSyllabuses;
	}

	public MateriaSyllabus addMateriaSyllabus(MateriaSyllabus materiaSyllabus) {
		getMateriaSyllabuses().add(materiaSyllabus);
		materiaSyllabus.setDocente(this);

		return materiaSyllabus;
	}

	public MateriaSyllabus removeMateriaSyllabus(MateriaSyllabus materiaSyllabus) {
		getMateriaSyllabuses().remove(materiaSyllabus);
		materiaSyllabus.setDocente(null);

		return materiaSyllabus;
	}

	/**
	 * @return the archivoBases
	 */
	public List<ArchivoBase> getArchivoBases() {
		return archivoBases;
	}

	/**
	 * @param archivoBases
	 *            the archivoBases to set
	 */
	public void setArchivoBases(List<ArchivoBase> archivoBases) {
		this.archivoBases = archivoBases;
	}

}