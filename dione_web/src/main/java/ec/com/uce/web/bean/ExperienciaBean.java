/**
 * 
 */
package ec.com.uce.web.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import ec.com.uce.ejb.dto.ExperienciaDTO;

/**
 * <b> Permite manejar la informacion en la pagina y el backing </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Nov 19, 2014
 * @since JDK1.6
 */
@ManagedBean
@SessionScoped
public class ExperienciaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String institucion;
	private String funciones;
	private Date fechaInicio;
	private Date fechaFin;

	private static ArrayList<ExperienciaDTO> experienciaList = new ArrayList<ExperienciaDTO>();

	/**
	 * @return the institucion
	 */
	public String getInstitucion() {
		return institucion;
	}

	/**
	 * @param institucion
	 *            the institucion to set
	 */
	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}

	/**
	 * @return the funciones
	 */
	public String getFunciones() {
		return funciones;
	}

	/**
	 * @param funciones
	 *            the funciones to set
	 */
	public void setFunciones(String funciones) {
		this.funciones = funciones;
	}

	/**
	 * @return the fechaInicio
	 */
	public Date getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * @param fechaInicio
	 *            the fechaInicio to set
	 */
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * @return the fechaFin
	 */
	public Date getFechaFin() {
		return fechaFin;
	}

	/**
	 * @param fechaFin
	 *            the fechaFin to set
	 */
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * @return the experienciaList
	 */
	public ArrayList<ExperienciaDTO> getExperienciaList() {
		return experienciaList;
	}

	/**
	 * @param experienciaList
	 *            the experienciaList to set
	 */
	public static void setExperienciaList(ArrayList<ExperienciaDTO> experienciaList) {
		ExperienciaBean.experienciaList = experienciaList;
	}

	/**
	 * 
	 * <b> Permite agregar un registro de experiencia </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Dec 1, 2014]
	 * </p>
	 * 
	 * @return
	 */
	public String addExperiencia() {
		ExperienciaDTO item = new ExperienciaDTO(this.institucion, this.fechaInicio, this.fechaFin, this.funciones);
		experienciaList.add(item);

		institucion = "";
		fechaInicio = null;
		fechaFin = null;
		funciones = "";
		return null;
	}

	/**
	 * 
	 * <b> Permite editar un registro de la tabla </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Dec 1, 2014]
	 * </p>
	 * 
	 * @param event
	 */
	public void onEditExperiencia(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Edited", ((ExperienciaDTO) event.getObject()).getInstitucion().toString());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	/**
	 * 
	 * <b> Permite eliminar un registro de la tabla </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Dec 1, 2014]
	 * </p>
	 * 
	 * @param event
	 */
	public void onCancelExperiencia(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Cancelled");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		experienciaList.remove((ExperienciaDTO) event.getObject());
	}

}
