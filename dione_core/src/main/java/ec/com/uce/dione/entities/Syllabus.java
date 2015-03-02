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

	@Column(name="descripcion_asignatura")
	private String descripcionAsignatura;

	@Column(name="horas_tutorias")
	private Integer horasTutorias;

	private String metodologia;

	@Column(name="num_horas_presenciales")
	private Integer numHorasPresenciales;

	//bi-directional many-to-one association to Bibliografia
	@OneToMany(mappedBy="syllabus")
	private List<Bibliografia> bibliografias;

	//bi-directional many-to-one association to CompetenciaGenerale
	@OneToMany(mappedBy="syllabus")
	private List<CompetenciaGenerale> competenciaGenerales;

	//bi-directional many-to-one association to CompetenciasEspecifica
	@OneToMany(mappedBy="syllabus")
	private List<CompetenciasEspecifica> competenciasEspecificas;

	//bi-directional many-to-one association to CompetenciasGenerica
	@OneToMany(mappedBy="syllabus")
	private List<CompetenciasGenerica> competenciasGenericas;

	//bi-directional many-to-one association to MateriaSyllabus
	@OneToMany(mappedBy="syllabus")
	private List<MateriaSyllabus> materiaSyllabuses;

	//bi-directional many-to-one association to Objetivo
	@OneToMany(mappedBy="syllabus")
	private List<Objetivo> objetivos;

	//bi-directional many-to-one association to RecursosDidactico
	@OneToMany(mappedBy="syllabus")
	private List<RecursosDidactico> recursosDidacticos;

	//bi-directional many-to-one association to ResultadosAprendizaje
	@OneToMany(mappedBy="syllabus")
	private List<ResultadosAprendizaje> resultadosAprendizajes;

	//bi-directional many-to-one association to Docente
	@ManyToOne
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

	public String getDescripcionAsignatura() {
		return this.descripcionAsignatura;
	}

	public void setDescripcionAsignatura(String descripcionAsignatura) {
		this.descripcionAsignatura = descripcionAsignatura;
	}

	public Integer getHorasTutorias() {
		return this.horasTutorias;
	}

	public void setHorasTutorias(Integer horasTutorias) {
		this.horasTutorias = horasTutorias;
	}

	public String getMetodologia() {
		return this.metodologia;
	}

	public void setMetodologia(String metodologia) {
		this.metodologia = metodologia;
	}

	public Integer getNumHorasPresenciales() {
		return this.numHorasPresenciales;
	}

	public void setNumHorasPresenciales(Integer numHorasPresenciales) {
		this.numHorasPresenciales = numHorasPresenciales;
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

	public List<CompetenciaGenerale> getCompetenciaGenerales() {
		return this.competenciaGenerales;
	}

	public void setCompetenciaGenerales(List<CompetenciaGenerale> competenciaGenerales) {
		this.competenciaGenerales = competenciaGenerales;
	}

	public CompetenciaGenerale addCompetenciaGenerale(CompetenciaGenerale competenciaGenerale) {
		getCompetenciaGenerales().add(competenciaGenerale);
		competenciaGenerale.setSyllabus(this);

		return competenciaGenerale;
	}

	public CompetenciaGenerale removeCompetenciaGenerale(CompetenciaGenerale competenciaGenerale) {
		getCompetenciaGenerales().remove(competenciaGenerale);
		competenciaGenerale.setSyllabus(null);

		return competenciaGenerale;
	}

	public List<CompetenciasEspecifica> getCompetenciasEspecificas() {
		return this.competenciasEspecificas;
	}

	public void setCompetenciasEspecificas(List<CompetenciasEspecifica> competenciasEspecificas) {
		this.competenciasEspecificas = competenciasEspecificas;
	}

	public CompetenciasEspecifica addCompetenciasEspecifica(CompetenciasEspecifica competenciasEspecifica) {
		getCompetenciasEspecificas().add(competenciasEspecifica);
		competenciasEspecifica.setSyllabus(this);

		return competenciasEspecifica;
	}

	public CompetenciasEspecifica removeCompetenciasEspecifica(CompetenciasEspecifica competenciasEspecifica) {
		getCompetenciasEspecificas().remove(competenciasEspecifica);
		competenciasEspecifica.setSyllabus(null);

		return competenciasEspecifica;
	}

	public List<CompetenciasGenerica> getCompetenciasGenericas() {
		return this.competenciasGenericas;
	}

	public void setCompetenciasGenericas(List<CompetenciasGenerica> competenciasGenericas) {
		this.competenciasGenericas = competenciasGenericas;
	}

	public CompetenciasGenerica addCompetenciasGenerica(CompetenciasGenerica competenciasGenerica) {
		getCompetenciasGenericas().add(competenciasGenerica);
		competenciasGenerica.setSyllabus(this);

		return competenciasGenerica;
	}

	public CompetenciasGenerica removeCompetenciasGenerica(CompetenciasGenerica competenciasGenerica) {
		getCompetenciasGenericas().remove(competenciasGenerica);
		competenciasGenerica.setSyllabus(null);

		return competenciasGenerica;
	}

	public List<MateriaSyllabus> getMateriaSyllabuses() {
		return this.materiaSyllabuses;
	}

	public void setMateriaSyllabuses(List<MateriaSyllabus> materiaSyllabuses) {
		this.materiaSyllabuses = materiaSyllabuses;
	}

	public MateriaSyllabus addMateriaSyllabus(MateriaSyllabus materiaSyllabus) {
		getMateriaSyllabuses().add(materiaSyllabus);
		materiaSyllabus.setSyllabus(this);

		return materiaSyllabus;
	}

	public MateriaSyllabus removeMateriaSyllabus(MateriaSyllabus materiaSyllabus) {
		getMateriaSyllabuses().remove(materiaSyllabus);
		materiaSyllabus.setSyllabus(null);

		return materiaSyllabus;
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