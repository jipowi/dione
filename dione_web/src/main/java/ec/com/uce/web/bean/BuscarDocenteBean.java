/**
 * 
 */
package ec.com.uce.web.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ec.com.uce.dione.entities.Bibliografia;
import ec.com.uce.dione.entities.CompetenciaGenerale;
import ec.com.uce.dione.entities.CompetenciasEspecifica;
import ec.com.uce.dione.entities.CompetenciasGenerica;
import ec.com.uce.dione.entities.Corequisito;
import ec.com.uce.dione.entities.EscuelaUce;
import ec.com.uce.dione.entities.FormacionAcademica;
import ec.com.uce.dione.entities.FormacionContinua;
import ec.com.uce.dione.entities.Objetivo;
import ec.com.uce.dione.entities.Prerequisito;
import ec.com.uce.dione.entities.ResultadosAprendizaje;
import ec.com.uce.ejb.dto.AsignaturaDTO;
import ec.com.uce.ejb.dto.UnidadCompetenciaDTO;

/**
 * <b> Permite manejar la informacion en la pagina y el backing </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Nov 19, 2014
 * @since JDK1.6
 */
@ManagedBean
@SessionScoped
public class BuscarDocenteBean implements Serializable {

	private static final long serialVersionUID = 1L;
	// Informacion hoja de vida
	private String apellidosDocente;
	private String cedulaDocente;
	private String direccionDocente;
	private String nombresDocente;
	private List<EscuelaUce> escuelas;
	private List<AsignaturaDTO> escuelaMateriasList;
	private List<FormacionAcademica> formacionesA;
	private List<FormacionContinua> formacionesC;

	// Informacion syllabus
	private String materia;
	private Integer numHorasPresenciales;
	private Integer numHorasTutorias;
	private String desAsignatura;
	private String metodologia;
	private List<CompetenciaGenerale> competenciasGenerales = new ArrayList<CompetenciaGenerale>();
	private List<CompetenciasGenerica> competenciasInstrumentales = new ArrayList<CompetenciasGenerica>();
	private List<CompetenciasGenerica> competenciasInterpersonales = new ArrayList<CompetenciasGenerica>();
	private List<CompetenciasGenerica> competenciasSistematicas = new ArrayList<CompetenciasGenerica>();
	private List<CompetenciasEspecifica> competenciasEspecificas = new ArrayList<CompetenciasEspecifica>();
	private List<Prerequisito> prerequisitos = new ArrayList<Prerequisito>();
	private List<Corequisito> corequisitos = new ArrayList<Corequisito>();
	private List<Objetivo> objetivos = new ArrayList<Objetivo>();
	private List<Bibliografia> bibliografias = new ArrayList<Bibliografia>();
	private List<ResultadosAprendizaje> resultados = new ArrayList<ResultadosAprendizaje>();
	private List<UnidadCompetenciaDTO> unidadesDTO = new ArrayList<UnidadCompetenciaDTO>();

	/**
	 * @return the apellidosDocente
	 */
	public String getApellidosDocente() {
		return apellidosDocente;
	}

	/**
	 * @param apellidosDocente
	 *            the apellidosDocente to set
	 */
	public void setApellidosDocente(String apellidosDocente) {
		this.apellidosDocente = apellidosDocente;
	}

	/**
	 * @return the cedulaDocente
	 */
	public String getCedulaDocente() {
		return cedulaDocente;
	}

	/**
	 * @param cedulaDocente
	 *            the cedulaDocente to set
	 */
	public void setCedulaDocente(String cedulaDocente) {
		this.cedulaDocente = cedulaDocente;
	}

	/**
	 * @return the direccionDocente
	 */
	public String getDireccionDocente() {
		return direccionDocente;
	}

	/**
	 * @param direccionDocente
	 *            the direccionDocente to set
	 */
	public void setDireccionDocente(String direccionDocente) {
		this.direccionDocente = direccionDocente;
	}

	/**
	 * @return the nombresDocente
	 */
	public String getNombresDocente() {
		return nombresDocente;
	}

	/**
	 * @param nombresDocente
	 *            the nombresDocente to set
	 */
	public void setNombresDocente(String nombresDocente) {
		this.nombresDocente = nombresDocente;
	}

	/**
	 * @return the escuelas
	 */
	public List<EscuelaUce> getEscuelas() {
		return escuelas;
	}

	/**
	 * @param escuelas
	 *            the escuelas to set
	 */
	public void setEscuelas(List<EscuelaUce> escuelas) {
		this.escuelas = escuelas;
	}

	/**
	 * @return the escuelaMateriasList
	 */
	public List<AsignaturaDTO> getEscuelaMateriasList() {
		return escuelaMateriasList;
	}

	/**
	 * @param escuelaMateriasList
	 *            the escuelaMateriasList to set
	 */
	public void setEscuelaMateriasList(List<AsignaturaDTO> escuelaMateriasList) {
		this.escuelaMateriasList = escuelaMateriasList;
	}

	/**
	 * @return the formacionesA
	 */
	public List<FormacionAcademica> getFormacionesA() {
		return formacionesA;
	}

	/**
	 * @param formacionesA
	 *            the formacionesA to set
	 */
	public void setFormacionesA(List<FormacionAcademica> formacionesA) {
		this.formacionesA = formacionesA;
	}

	/**
	 * @return the formacionesC
	 */
	public List<FormacionContinua> getFormacionesC() {
		return formacionesC;
	}

	/**
	 * @param formacionesC
	 *            the formacionesC to set
	 */
	public void setFormacionesC(List<FormacionContinua> formacionesC) {
		this.formacionesC = formacionesC;
	}

	/**
	 * @return the materia
	 */
	public String getMateria() {
		return materia;
	}

	/**
	 * @param materia
	 *            the materia to set
	 */
	public void setMateria(String materia) {
		this.materia = materia;
	}

	/**
	 * @return the numHorasPresenciales
	 */
	public Integer getNumHorasPresenciales() {
		return numHorasPresenciales;
	}

	/**
	 * @param numHorasPresenciales
	 *            the numHorasPresenciales to set
	 */
	public void setNumHorasPresenciales(Integer numHorasPresenciales) {
		this.numHorasPresenciales = numHorasPresenciales;
	}

	/**
	 * @return the numHorasTutorias
	 */
	public Integer getNumHorasTutorias() {
		return numHorasTutorias;
	}

	/**
	 * @param numHorasTutorias
	 *            the numHorasTutorias to set
	 */
	public void setNumHorasTutorias(Integer numHorasTutorias) {
		this.numHorasTutorias = numHorasTutorias;
	}

	/**
	 * @return the desAsignatura
	 */
	public String getDesAsignatura() {
		return desAsignatura;
	}

	/**
	 * @param desAsignatura
	 *            the desAsignatura to set
	 */
	public void setDesAsignatura(String desAsignatura) {
		this.desAsignatura = desAsignatura;
	}

	/**
	 * @return the metodologia
	 */
	public String getMetodologia() {
		return metodologia;
	}

	/**
	 * @param metodologia
	 *            the metodologia to set
	 */
	public void setMetodologia(String metodologia) {
		this.metodologia = metodologia;
	}

	/**
	 * @return the competenciasGenerales
	 */
	public List<CompetenciaGenerale> getCompetenciasGenerales() {
		return competenciasGenerales;
	}

	/**
	 * @param competenciasGenerales
	 *            the competenciasGenerales to set
	 */
	public void setCompetenciasGenerales(List<CompetenciaGenerale> competenciasGenerales) {
		this.competenciasGenerales = competenciasGenerales;
	}

	/**
	 * @return the competenciasInstrumentales
	 */
	public List<CompetenciasGenerica> getCompetenciasInstrumentales() {
		return competenciasInstrumentales;
	}

	/**
	 * @param competenciasInstrumentales
	 *            the competenciasInstrumentales to set
	 */
	public void setCompetenciasInstrumentales(List<CompetenciasGenerica> competenciasInstrumentales) {
		this.competenciasInstrumentales = competenciasInstrumentales;
	}

	/**
	 * @return the competenciasInterpersonales
	 */
	public List<CompetenciasGenerica> getCompetenciasInterpersonales() {
		return competenciasInterpersonales;
	}

	/**
	 * @param competenciasInterpersonales
	 *            the competenciasInterpersonales to set
	 */
	public void setCompetenciasInterpersonales(List<CompetenciasGenerica> competenciasInterpersonales) {
		this.competenciasInterpersonales = competenciasInterpersonales;
	}

	/**
	 * @return the competenciasSistematicas
	 */
	public List<CompetenciasGenerica> getCompetenciasSistematicas() {
		return competenciasSistematicas;
	}

	/**
	 * @param competenciasSistematicas
	 *            the competenciasSistematicas to set
	 */
	public void setCompetenciasSistematicas(List<CompetenciasGenerica> competenciasSistematicas) {
		this.competenciasSistematicas = competenciasSistematicas;
	}

	/**
	 * @return the competenciasEspeciificas
	 */
	public List<CompetenciasEspecifica> getCompetenciasEspecificas() {
		return competenciasEspecificas;
	}

	/**
	 * @param competenciasEspeciificas
	 *            the competenciasEspeciificas to set
	 */
	public void setCompetenciasEspecificas(List<CompetenciasEspecifica> competenciasEspecificas) {
		this.competenciasEspecificas = competenciasEspecificas;
	}

	/**
	 * @return the prerequisitos
	 */
	public List<Prerequisito> getPrerequisitos() {
		return prerequisitos;
	}

	/**
	 * @param prerequisitos
	 *            the prerequisitos to set
	 */
	public void setPrerequisitos(List<Prerequisito> prerequisitos) {
		this.prerequisitos = prerequisitos;
	}

	/**
	 * @return the corequisitos
	 */
	public List<Corequisito> getCorequisitos() {
		return corequisitos;
	}

	/**
	 * @param corequisitos
	 *            the corequisitos to set
	 */
	public void setCorequisitos(List<Corequisito> corequisitos) {
		this.corequisitos = corequisitos;
	}

	/**
	 * @return the objetivos
	 */
	public List<Objetivo> getObjetivos() {
		return objetivos;
	}

	/**
	 * @param objetivos
	 *            the objetivos to set
	 */
	public void setObjetivos(List<Objetivo> objetivos) {
		this.objetivos = objetivos;
	}

	/**
	 * @return the bibliografias
	 */
	public List<Bibliografia> getBibliografias() {
		return bibliografias;
	}

	/**
	 * @param bibliografias
	 *            the bibliografias to set
	 */
	public void setBibliografias(List<Bibliografia> bibliografias) {
		this.bibliografias = bibliografias;
	}

	/**
	 * @return the resultados
	 */
	public List<ResultadosAprendizaje> getResultados() {
		return resultados;
	}

	/**
	 * @param resultados
	 *            the resultados to set
	 */
	public void setResultados(List<ResultadosAprendizaje> resultados) {
		this.resultados = resultados;
	}

	/**
	 * @return the unidadesDTO
	 */
	public List<UnidadCompetenciaDTO> getUnidadesDTO() {
		return unidadesDTO;
	}

	/**
	 * @param unidadesDTO
	 *            the unidadesDTO to set
	 */
	public void setUnidadesDTO(List<UnidadCompetenciaDTO> unidadesDTO) {
		this.unidadesDTO = unidadesDTO;
	}

}
