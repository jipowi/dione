package ec.com.uce.dione.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the syllabus database table.
 * 
 */
@Entity
@NamedQuery(name="Syllabus.findAll", query="SELECT s FROM Syllabus s")
public class Syllabus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_syllabus")
	private Integer idSyllabus;

	private String corequisito;

	@Column(name="descripcion_asignatura")
	private String descripcionAsignatura;

	private String metodologia;

	@Column(name="num_horas_clase")
	private Integer numHorasClase;

	private String prerequisito;

	//bi-directional many-to-one association to Bibliografia
	@OneToMany(mappedBy="syllabus")
	private List<Bibliografia> bibliografias;

	//bi-directional many-to-one association to Competencia
	@OneToMany(mappedBy="syllabus")
	private List<Competencia> competencias;

	//bi-directional many-to-one association to Objetivo
	@OneToMany(mappedBy="syllabus")
	private List<Objetivo> objetivos;

	//bi-directional many-to-one association to RecursosDidactico
	@OneToMany(mappedBy="syllabus")
	private List<RecursosDidactico> recursosDidacticos;

	//bi-directional many-to-one association to ResultadosAprendizaje
	@OneToMany(mappedBy="syllabus")
	private List<ResultadosAprendizaje> resultadosAprendizajes;

	//bi-directional many-to-one association to MateriaUce
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_materia_uce")
	private MateriaUce materiaUce;

	//bi-directional many-to-one association to Docente
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_docente")
	private Docente docente;

	//bi-directional many-to-one association to UnidadCompetencia
	@OneToMany(mappedBy="syllabus")
	private List<UnidadCompetencia> unidadCompetencias;

	public Syllabus() {
	}

	public Integer getIdSyllabus() {
		return this.idSyllabus;
	}

	public void setIdSyllabus(Integer idSyllabus) {
		this.idSyllabus = idSyllabus;
	}

	public String getCorequisito() {
		return this.corequisito;
	}

	public void setCorequisito(String corequisito) {
		this.corequisito = corequisito;
	}

	public String getDescripcionAsignatura() {
		return this.descripcionAsignatura;
	}

	public void setDescripcionAsignatura(String descripcionAsignatura) {
		this.descripcionAsignatura = descripcionAsignatura;
	}

	public String getMetodologia() {
		return this.metodologia;
	}

	public void setMetodologia(String metodologia) {
		this.metodologia = metodologia;
	}

	public Integer getNumHorasClase() {
		return this.numHorasClase;
	}

	public void setNumHorasClase(Integer numHorasClase) {
		this.numHorasClase = numHorasClase;
	}

	public String getPrerequisito() {
		return this.prerequisito;
	}

	public void setPrerequisito(String prerequisito) {
		this.prerequisito = prerequisito;
	}

	public List<Bibliografia> getBibliografias() {
		return this.bibliografias;
	}

	public void setBibliografias(List<Bibliografia> bibliografias) {
		this.bibliografias = bibliografias;
	}

	public Bibliografia addBibliografia(Bibliografia bibliografia) {
		getBibliografias().add(bibliografia);
		bibliografia.setSyllabus(this);

		return bibliografia;
	}

	public Bibliografia removeBibliografia(Bibliografia bibliografia) {
		getBibliografias().remove(bibliografia);
		bibliografia.setSyllabus(null);

		return bibliografia;
	}

	public List<Competencia> getCompetencias() {
		return this.competencias;
	}

	public void setCompetencias(List<Competencia> competencias) {
		this.competencias = competencias;
	}

	public Competencia addCompetencia(Competencia competencia) {
		getCompetencias().add(competencia);
		competencia.setSyllabus(this);

		return competencia;
	}

	public Competencia removeCompetencia(Competencia competencia) {
		getCompetencias().remove(competencia);
		competencia.setSyllabus(null);

		return competencia;
	}

	public List<Objetivo> getObjetivos() {
		return this.objetivos;
	}

	public void setObjetivos(List<Objetivo> objetivos) {
		this.objetivos = objetivos;
	}

	public Objetivo addObjetivo(Objetivo objetivo) {
		getObjetivos().add(objetivo);
		objetivo.setSyllabus(this);

		return objetivo;
	}

	public Objetivo removeObjetivo(Objetivo objetivo) {
		getObjetivos().remove(objetivo);
		objetivo.setSyllabus(null);

		return objetivo;
	}

	public List<RecursosDidactico> getRecursosDidacticos() {
		return this.recursosDidacticos;
	}

	public void setRecursosDidacticos(List<RecursosDidactico> recursosDidacticos) {
		this.recursosDidacticos = recursosDidacticos;
	}

	public RecursosDidactico addRecursosDidactico(RecursosDidactico recursosDidactico) {
		getRecursosDidacticos().add(recursosDidactico);
		recursosDidactico.setSyllabus(this);

		return recursosDidactico;
	}

	public RecursosDidactico removeRecursosDidactico(RecursosDidactico recursosDidactico) {
		getRecursosDidacticos().remove(recursosDidactico);
		recursosDidactico.setSyllabus(null);

		return recursosDidactico;
	}

	public List<ResultadosAprendizaje> getResultadosAprendizajes() {
		return this.resultadosAprendizajes;
	}

	public void setResultadosAprendizajes(List<ResultadosAprendizaje> resultadosAprendizajes) {
		this.resultadosAprendizajes = resultadosAprendizajes;
	}

	public ResultadosAprendizaje addResultadosAprendizaje(ResultadosAprendizaje resultadosAprendizaje) {
		getResultadosAprendizajes().add(resultadosAprendizaje);
		resultadosAprendizaje.setSyllabus(this);

		return resultadosAprendizaje;
	}

	public ResultadosAprendizaje removeResultadosAprendizaje(ResultadosAprendizaje resultadosAprendizaje) {
		getResultadosAprendizajes().remove(resultadosAprendizaje);
		resultadosAprendizaje.setSyllabus(null);

		return resultadosAprendizaje;
	}

	public MateriaUce getMateriaUce() {
		return this.materiaUce;
	}

	public void setMateriaUce(MateriaUce materiaUce) {
		this.materiaUce = materiaUce;
	}

	public Docente getDocente() {
		return this.docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public List<UnidadCompetencia> getUnidadCompetencias() {
		return this.unidadCompetencias;
	}

	public void setUnidadCompetencias(List<UnidadCompetencia> unidadCompetencias) {
		this.unidadCompetencias = unidadCompetencias;
	}

	public UnidadCompetencia addUnidadCompetencia(UnidadCompetencia unidadCompetencia) {
		getUnidadCompetencias().add(unidadCompetencia);
		unidadCompetencia.setSyllabus(this);

		return unidadCompetencia;
	}

	public UnidadCompetencia removeUnidadCompetencia(UnidadCompetencia unidadCompetencia) {
		getUnidadCompetencias().remove(unidadCompetencia);
		unidadCompetencia.setSyllabus(null);

		return unidadCompetencia;
	}

}