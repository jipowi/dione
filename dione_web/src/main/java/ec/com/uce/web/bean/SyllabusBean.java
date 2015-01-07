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
import ec.com.uce.ejb.dto.ObjetivoDTO;

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

	private static List<ObjetivoDTO> objetivosDTOs = new ArrayList<ObjetivoDTO>();
	private static List<CompetenciaDTO> competenciasDTOs = new ArrayList<CompetenciaDTO>();

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
}
