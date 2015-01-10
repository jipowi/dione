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

import ec.com.uce.ejb.dto.CompetenciaDTO;
import ec.com.uce.ejb.dto.ElementosCompetenciaDTO;
import ec.com.uce.ejb.dto.ObjetivoDTO;
import ec.com.uce.ejb.dto.UnidadCompetenciaDTO;

/**
 * <b> Permite manejar la informacion de la interfaz del cliente. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,05/01/2015
 * @since JDK1.6
 */
@ManagedBean
@SessionScoped
public class SyllabusBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String materia;
	private Integer numHorasClase;
	private String prerequisito;
	private String corequisito;
	private String desAsigantura;
	private String cedula;
	private String objetivo;
	private String competencia;
	private String unidadCompetencia;
	private Integer planificacion;
	private String elementoCompetencia;
	private List<ElementosCompetenciaDTO> elementosCompetencia = new ArrayList<ElementosCompetenciaDTO>();

	private static List<ObjetivoDTO> objetivosDTOs = new ArrayList<ObjetivoDTO>();
	private static List<CompetenciaDTO> competenciasDTOs = new ArrayList<CompetenciaDTO>();
	private static List<UnidadCompetenciaDTO> unidadesDTOs = new ArrayList<UnidadCompetenciaDTO>();

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
	 * @return the numHorasClase
	 */
	public Integer getNumHorasClase() {
		return numHorasClase;
	}

	/**
	 * @param numHorasClase
	 *            the numHorasClase to set
	 */
	public void setNumHorasClase(Integer numHorasClase) {
		this.numHorasClase = numHorasClase;
	}

	/**
	 * @return the prerequisito
	 */
	public String getPrerequisito() {
		return prerequisito;
	}

	/**
	 * @param prerequisito
	 *            the prerequisito to set
	 */
	public void setPrerequisito(String prerequisito) {
		this.prerequisito = prerequisito;
	}

	/**
	 * @return the corequisito
	 */
	public String getCorequisito() {
		return corequisito;
	}

	/**
	 * @param corequisito
	 *            the corequisito to set
	 */
	public void setCorequisito(String corequisito) {
		this.corequisito = corequisito;
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
	 * @param objetivosDTOs
	 *            the objetivosDTOs to set
	 */
	public static void setObjetivosDTOs(List<ObjetivoDTO> objetivosDTOs) {
		SyllabusBean.objetivosDTOs = objetivosDTOs;
	}

	/**
	 * @return the competenciasDTOs
	 */
	public List<CompetenciaDTO> getCompetenciasDTOs() {
		return competenciasDTOs;
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
	 * @return the elementosCompetencia
	 */
	public List<ElementosCompetenciaDTO> getElementosCompetencia() {
		return elementosCompetencia;
	}

	/**
	 * @param elementosCompetencia
	 *            the elementosCompetencia to set
	 */
	public void setElementosCompetencia(List<ElementosCompetenciaDTO> elementosCompetencia) {
		this.elementosCompetencia = elementosCompetencia;
	}

	/**
	 * @return the competencia
	 */
	public String getCompetencia() {
		return competencia;
	}

	/**
	 * @param competencia
	 *            the competencia to set
	 */
	public void setCompetencia(String competencia) {
		this.competencia = competencia;
	}

	/**
	 * @param competenciasDTOs
	 *            the competenciasDTOs to set
	 */
	public static void setCompetenciasDTOs(List<CompetenciaDTO> competenciasDTOs) {
		SyllabusBean.competenciasDTOs = competenciasDTOs;
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

	// OBJETIVOS
	/**
	 * 
	 * <b> Permite agregar un registro de objetivos. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 07/01/2015]
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
	 * [Author: Paul Jimenez, Date: 07/01/2015]
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
	 * [Author: Paul Jimenez, Date: 07/01/2015]
	 * </p>
	 * 
	 * @param event
	 */
	public void onCancelObjetivo(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Cancelled");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		objetivosDTOs.remove((ObjetivoDTO) event.getObject());
	}

	// COMPETENCIAS
	/**
	 * 
	 * <b> Permite agregar un registro de competencias. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 07/01/2015]
	 * </p>
	 * 
	 */
	public void addCompetencia() {
		CompetenciaDTO item = new CompetenciaDTO(this.competencia);
		competenciasDTOs.add(item);

		competencia = "";
	}

	/**
	 * 
	 * <b> Permite editar un registro </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 07/01/2015]
	 * </p>
	 * 
	 * @param event
	 */
	public void onEditCompetencia(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Edited", ((CompetenciaDTO) event.getObject()).getCompetencia());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	/**
	 * 
	 * <b> Permite eliminar un registro </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 07/01/2015]
	 * </p>
	 * 
	 * @param event
	 */
	public void onCancelCompetencia(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Cancelled");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		competenciasDTOs.remove((CompetenciaDTO) event.getObject());
	}

	// UNIDADES DE COMPETENCIA
	/**
	 * 
	 * <b> Permite agregar un registro de uniades de competencias. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 07/01/2015]
	 * </p>
	 * 
	 */
	public void addUnidad() {
		UnidadCompetenciaDTO item = new UnidadCompetenciaDTO(this.unidadCompetencia, this.planificacion, this.elementosCompetencia);
		unidadesDTOs.add(item);

		unidadCompetencia = "";
		planificacion = 0;
		elementosCompetencia = new ArrayList<ElementosCompetenciaDTO>();
	}

	/**
	 * 
	 * <b> Permite editar un registro </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 07/01/2015]
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
	 * [Author: Paul Jimenez, Date: 07/01/2015]
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
	 * [Author: Paul Jimenez, Date: 07/01/2015]
	 * </p>
	 * 
	 */
	public void addElemento() {
		ElementosCompetenciaDTO item = new ElementosCompetenciaDTO(this.elementoCompetencia);
		elementosCompetencia.add(item);

		elementoCompetencia = "";
		
	}

	/**
	 * 
	 * <b> Permite editar un registro </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 07/01/2015]
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
	 * [Author: Paul Jimenez, Date: 07/01/2015]
	 * </p>
	 * 
	 * @param event
	 */
	public void onCancelElemento(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Cancelled");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		unidadesDTOs.remove((ElementosCompetenciaDTO) event.getObject());
	}
}
