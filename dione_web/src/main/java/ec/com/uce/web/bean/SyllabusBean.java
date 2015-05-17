/**
 * 
 */
package ec.com.uce.web.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import ec.com.uce.ejb.dto.BibliografiaDTO;
import ec.com.uce.ejb.dto.CompetenciaEspecificaDTO;
import ec.com.uce.ejb.dto.CompetenciaGeneralDTO;
import ec.com.uce.ejb.dto.ElementosCompetenciaDTO;
import ec.com.uce.ejb.dto.ObjetivoDTO;
import ec.com.uce.ejb.dto.ResultadoAprendizajeDTO;
import ec.com.uce.ejb.dto.UnidadCompetenciaDTO;

/**
 * <b> Permite manejar la informacion de la interfaz del cliente. </b>
 * 
 * @author Anita Carrera
 * @version 1.0,05/01/2015
 * @since JDK1.6
 */
@ManagedBean
@SessionScoped
public class SyllabusBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String materia;
	private Integer numHorasPresenciales;
	private Integer numHorasTutorias;

	private String desAsigantura;
	private String cedula;
	private String objetivo;
	private String competenciaGeneral;
	private String competenciaEspecifica;
	private String unidadCompetencia;
	private Integer planificacion;
	private String elementoCompetencia;
	private String metodologia;
	private String bibliografia;
	private String resultadoAprendizaje;
	private static List<ElementosCompetenciaDTO> elementosCompetenciaDTOs = new ArrayList<ElementosCompetenciaDTO>();
	private List<ElementosCompetenciaDTO> elementosCompetenciasDTOList = new ArrayList<ElementosCompetenciaDTO>();
	private static List<BibliografiaDTO> bibliografiaDTOs = new ArrayList<BibliografiaDTO>();
	private static List<ObjetivoDTO> objetivosDTOs = new ArrayList<ObjetivoDTO>();
	private static List<CompetenciaGeneralDTO> competenciasGeneralesDTOs = new ArrayList<CompetenciaGeneralDTO>();
	private static List<CompetenciaEspecificaDTO> competenciasEspecificasDTOs = new ArrayList<CompetenciaEspecificaDTO>();
	private static List<UnidadCompetenciaDTO> unidadesDTOs = new ArrayList<UnidadCompetenciaDTO>();
	private static List<ResultadoAprendizajeDTO> resultadoAprendizajeDTOs = new ArrayList<ResultadoAprendizajeDTO>();

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
	 * @return the desAsigantura
	 */
	public String getDesAsigantura() {
		return desAsigantura;
	}

	/**
	 * @param desAsigantura
	 *            the desAsigantura to set
	 */
	public void setDesAsigantura(String desAsigantura) {
		this.desAsigantura = desAsigantura;
	}

	/**
	 * @return the cedula
	 */
	public String getCedula() {
		return cedula;
	}

	/**
	 * @param cedula
	 *            the cedula to set
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	/**
	 * @return the objetivosDTOs
	 */
	public List<ObjetivoDTO> getObjetivosDTOs() {
		return objetivosDTOs;
	}

	/**
	 * @return the elementosCompetenciaDTOs
	 */
	public List<ElementosCompetenciaDTO> getElementosCompetenciaDTOs() {
		return elementosCompetenciaDTOs;
	}

	/**
	 * @param elementosCompetenciaDTOs
	 *            the elementosCompetenciaDTOs to set
	 */
	public static void setElementosCompetenciaDTOs(List<ElementosCompetenciaDTO> elementosCompetenciaDTOs) {
		SyllabusBean.elementosCompetenciaDTOs = elementosCompetenciaDTOs;
	}

	/**
	 * @return the elementosCompetenciasDTOList
	 */
	public List<ElementosCompetenciaDTO> getElementosCompetenciasDTOList() {
		return elementosCompetenciasDTOList;
	}

	/**
	 * @param elementosCompetenciasDTOList
	 *            the elementosCompetenciasDTOList to set
	 */
	public void setElementosCompetenciasDTOList(List<ElementosCompetenciaDTO> elementosCompetenciasDTOList) {
		this.elementosCompetenciasDTOList = elementosCompetenciasDTOList;
	}

	/**
	 * @param objetivosDTOs
	 *            the objetivosDTOs to set
	 */
	public static void setObjetivosDTOs(List<ObjetivoDTO> objetivosDTOs) {
		SyllabusBean.objetivosDTOs = objetivosDTOs;
	}

	/**
	 * @return the objetivo
	 */
	public String getObjetivo() {
		return objetivo;
	}

	/**
	 * @param objetivo
	 *            the objetivo to set
	 */
	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	/**
	 * @return the unidadCompetencia
	 */
	public String getUnidadCompetencia() {
		return unidadCompetencia;
	}

	/**
	 * @param unidadCompetencia
	 *            the unidadCompetencia to set
	 */
	public void setUnidadCompetencia(String unidadCompetencia) {
		this.unidadCompetencia = unidadCompetencia;
	}

	/**
	 * @return the planificacion
	 */
	public Integer getPlanificacion() {
		return planificacion;
	}

	/**
	 * @param planificacion
	 *            the planificacion to set
	 */
	public void setPlanificacion(Integer planificacion) {
		this.planificacion = planificacion;
	}

	/**
	 * @return the bibliografia
	 */
	public String getBibliografia() {
		return bibliografia;
	}

	/**
	 * @param bibliografia
	 *            the bibliografia to set
	 */
	public void setBibliografia(String bibliografia) {
		this.bibliografia = bibliografia;
	}

	/**
	 * @return the resultadoAprendizaje
	 */
	public String getResultadoAprendizaje() {
		return resultadoAprendizaje;
	}

	/**
	 * @param resultadoAprendizaje
	 *            the resultadoAprendizaje to set
	 */
	public void setResultadoAprendizaje(String resultadoAprendizaje) {
		this.resultadoAprendizaje = resultadoAprendizaje;
	}

	/**
	 * @return the unidadesDTOs
	 */
	public List<UnidadCompetenciaDTO> getUnidadesDTOs() {
		return unidadesDTOs;
	}

	/**
	 * @param unidadesDTOs
	 *            the unidadesDTOs to set
	 */
	public static void setUnidadesDTOs(List<UnidadCompetenciaDTO> unidadesDTOs) {
		SyllabusBean.unidadesDTOs = unidadesDTOs;
	}

	/**
	 * @return the elementoCompetencia
	 */
	public String getElementoCompetencia() {
		return elementoCompetencia;
	}

	/**
	 * @param elementoCompetencia
	 *            the elementoCompetencia to set
	 */
	public void setElementoCompetencia(String elementoCompetencia) {
		this.elementoCompetencia = elementoCompetencia;
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
	 * @return the bibliografiaDTOs
	 */
	public List<BibliografiaDTO> getBibliografiaDTOs() {
		return bibliografiaDTOs;
	}

	/**
	 * @param bibliografiaDTOs
	 *            the bibliografiaDTOs to set
	 */
	public static void setBibliografiaDTOs(List<BibliografiaDTO> bibliografiaDTOs) {
		SyllabusBean.bibliografiaDTOs = bibliografiaDTOs;
	}

	/**
	 * @return the resultadoAprendizajeDTOs
	 */
	public List<ResultadoAprendizajeDTO> getResultadoAprendizajeDTOs() {
		return resultadoAprendizajeDTOs;
	}

	/**
	 * @param resultadoAprendizajeDTOs
	 *            the resultadoAprendizajeDTOs to set
	 */
	public static void setResultadoAprendizajeDTOs(List<ResultadoAprendizajeDTO> resultadoAprendizajeDTOs) {
		SyllabusBean.resultadoAprendizajeDTOs = resultadoAprendizajeDTOs;
	}

	/**
	 * @return the competenciaGeneral
	 */
	public String getCompetenciaGeneral() {
		return competenciaGeneral;
	}

	/**
	 * @param competenciaGeneral
	 *            the competenciaGeneral to set
	 */
	public void setCompetenciaGeneral(String competenciaGeneral) {
		this.competenciaGeneral = competenciaGeneral;
	}

	/**
	 * @return the competenciaEspecifica
	 */
	public String getCompetenciaEspecifica() {
		return competenciaEspecifica;
	}

	/**
	 * @param competenciaEspecifica
	 *            the competenciaEspecifica to set
	 */
	public void setCompetenciaEspecifica(String competenciaEspecifica) {
		this.competenciaEspecifica = competenciaEspecifica;
	}

	/**
	 * @return the competenciasGeneralesDTOs
	 */
	public List<CompetenciaGeneralDTO> getCompetenciasGeneralesDTOs() {
		return competenciasGeneralesDTOs;
	}

	/**
	 * @param competenciasGeneralesDTOs
	 *            the competenciasGeneralesDTOs to set
	 */
	public static void setCompetenciasGeneralesDTOs(List<CompetenciaGeneralDTO> competenciasGeneralesDTOs) {
		SyllabusBean.competenciasGeneralesDTOs = competenciasGeneralesDTOs;
	}

	/**
	 * @return the competenciasEspecificasDTOs
	 */
	public List<CompetenciaEspecificaDTO> getCompetenciasEspecificasDTOs() {
		return competenciasEspecificasDTOs;
	}

	/**
	 * @param competenciasEspecificasDTOs
	 *            the competenciasEspecificasDTOs to set
	 */
	public static void setCompetenciasEspecificasDTOs(List<CompetenciaEspecificaDTO> competenciasEspecificasDTOs) {
		SyllabusBean.competenciasEspecificasDTOs = competenciasEspecificasDTOs;
	}

	// OBJETIVOS
	/**
	 * 
	 * <b> Permite agregar un registro de objetivos. </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 07/01/2015]
	 * </p>
	 * 
	 */
	public void addObjetivo() {
		ObjetivoDTO item = new ObjetivoDTO(this.objetivo);
		objetivosDTOs.add(item);

		objetivo = "";
	}

	/**
	 * 
	 * <b> Permite editar un registro </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 07/01/2015]
	 * </p>
	 * 
	 * @param event
	 */
	public void onEditObjetivo(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Edited", ((ObjetivoDTO) event.getObject()).getObjetivo());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	/**
	 * 
	 * <b> Permite eliminar un objetivo </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 07/01/2015]
	 * </p>
	 * 
	 * @param event
	 */
	public void onCancelObjetivo(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Cancelled");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		objetivosDTOs.remove((ObjetivoDTO) event.getObject());
	}

	// COMPETENCIAS GENERALES
	/**
	 * 
	 * <b> Permite agregar un registro de competencias. </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 07/01/2015]
	 * </p>
	 * 
	 */
	public void addCompetenciaGeneral() {
		CompetenciaGeneralDTO item = new CompetenciaGeneralDTO(this.competenciaGeneral);
		competenciasGeneralesDTOs.add(item);

		competenciaGeneral = "";
	}

	/**
	 * 
	 * <b> Permite editar un registro </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 07/01/2015]
	 * </p>
	 * 
	 * @param event
	 */
	public void onEditCompetenciaGeneral(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Edited", ((CompetenciaGeneralDTO) event.getObject()).getCompetenciaGeneral());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	/**
	 * 
	 * <b> Permite eliminar un registro </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 07/01/2015]
	 * </p>
	 * 
	 * @param event
	 */
	public void onCancelCompetenciaGeneral(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Cancelled");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		competenciasGeneralesDTOs.remove((CompetenciaGeneralDTO) event.getObject());
	}

	// COMPETENCIAS ESPECIFICAS
	/**
	 * 
	 * <b> Permite agregar un registro de competencias. </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 07/01/2015]
	 * </p>
	 * 
	 */
	public void addCompetenciaEspecifica() {
		CompetenciaEspecificaDTO item = new CompetenciaEspecificaDTO(this.competenciaEspecifica);
		competenciasEspecificasDTOs.add(item);

		competenciaGeneral = "";
	}

	/**
	 * 
	 * <b> Permite editar un registro </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 07/01/2015]
	 * </p>
	 * 
	 * @param event
	 */
	public void onEditCompetenciaEspecifica(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Edited", ((CompetenciaEspecificaDTO) event.getObject()).getCompetenciaEspecifica());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	/**
	 * 
	 * <b> Permite eliminar un registro </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 07/01/2015]
	 * </p>
	 * 
	 * @param event
	 */
	public void onCancelCompetenciaEspecifica(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Cancelled");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		competenciasEspecificasDTOs.remove((CompetenciaEspecificaDTO) event.getObject());
	}

	// UNIDADES DE COMPETENCIA
	/**
	 * 
	 * <b> Permite agregar un registro de uniades de competencias. </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 07/01/2015]
	 * </p>
	 * 
	 */
	public void addUnidad() {
		this.elementosCompetenciasDTOList = this.getElementosCompetenciaDTOs();
		UnidadCompetenciaDTO item = new UnidadCompetenciaDTO(this.unidadCompetencia, this.planificacion, this.elementosCompetenciasDTOList);
		unidadesDTOs.add(item);

		unidadCompetencia = "";
		planificacion = 0;
		elementosCompetenciaDTOs = new ArrayList<ElementosCompetenciaDTO>();
	}

	/**
	 * 
	 * <b> Permite editar un registro </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 07/01/2015]
	 * </p>
	 * 
	 * @param event
	 */
	public void onEditUnidad(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Edited", ((UnidadCompetenciaDTO) event.getObject()).getUnidadCompetencia());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	/**
	 * 
	 * <b> Permite eliminar un registro </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 07/01/2015]
	 * </p>
	 * 
	 * @param event
	 */
	public void onCancelUnidad(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Cancelled");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		unidadesDTOs.remove((UnidadCompetenciaDTO) event.getObject());
	}

	// ELEMENTOS DE COMPETENCIA
	/**
	 * 
	 * <b> Permite agregar un registro de elementos de competencias. </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 07/01/2015]
	 * </p>
	 * 
	 */
	public void addElemento() {
		ElementosCompetenciaDTO item = new ElementosCompetenciaDTO(this.elementoCompetencia);
		elementosCompetenciaDTOs.add(item);

		elementoCompetencia = "";

	}

	/**
	 * 
	 * <b> Permite editar un registro </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 07/01/2015]
	 * </p>
	 * 
	 * @param event
	 */
	public void onEditElemento(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Edited", ((ElementosCompetenciaDTO) event.getObject()).getElementoCompetencia());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	/**
	 * 
	 * <b> Permite eliminar un registro </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 07/01/2015]
	 * </p>
	 * 
	 * @param event
	 */
	public void onCancelElemento(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Cancelled");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		unidadesDTOs.remove((ElementosCompetenciaDTO) event.getObject());
	}

	// BIBLIOGRAFIA
	/**
	 * 
	 * <b> Permite agregar un registro. </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 07/01/2015]
	 * </p>
	 * 
	 */
	public void addBibliografia() {
		BibliografiaDTO item = new BibliografiaDTO(this.bibliografia);
		bibliografiaDTOs.add(item);

		bibliografia = "";

	}

	/**
	 * 
	 * <b> Permite editar un registro </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 07/01/2015]
	 * </p>
	 * 
	 * @param event
	 */
	public void onEditBibliografia(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Edited", ((BibliografiaDTO) event.getObject()).getBiografia());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	/**
	 * 
	 * <b> Permite eliminar un registro </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 07/01/2015]
	 * </p>
	 * 
	 * @param event
	 */
	public void onCancelBibliografia(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Cancelled");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		bibliografiaDTOs.remove((BibliografiaDTO) event.getObject());
	}

	// RESULTADO APRENDIZAJE
	/**
	 * 
	 * <b> Permite agregar un registro. </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 07/01/2015]
	 * </p>
	 * 
	 */
	public void addResultado() {
		ResultadoAprendizajeDTO item = new ResultadoAprendizajeDTO(this.resultadoAprendizaje);
		resultadoAprendizajeDTOs.add(item);

		resultadoAprendizaje = "";

	}

	/**
	 * 
	 * <b> Permite editar un registro </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 07/01/2015]
	 * </p>
	 * 
	 * @param event
	 */
	public void onEditResultado(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Edited", ((ResultadoAprendizajeDTO) event.getObject()).getResultado());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	/**
	 * 
	 * <b> Permite eliminar un registro </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 07/01/2015]
	 * </p>
	 * 
	 * @param event
	 */
	public void onCancelResultado(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Cancelled");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		resultadoAprendizajeDTOs.remove((ResultadoAprendizajeDTO) event.getObject());
	}
}
