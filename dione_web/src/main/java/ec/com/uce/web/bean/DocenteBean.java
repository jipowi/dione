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

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.ejb.dto.AsignaturaDTO;
import ec.com.uce.ejb.dto.MateriaDTO;

/**
 * <b> Permite manejar la informacion en la pagina y el backing </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Nov 19, 2014
 * @since JDK1.6
 */
@ManagedBean
@SessionScoped
public class DocenteBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String apellidosDocente;
	private String cedulaDocente;
	private String direccionDocente;
	private String nombresDocente;
	private String escuela;
	private List<MateriaDTO> materiasSeleccionadas;
	private static ArrayList<AsignaturaDTO> asignaturasList = new ArrayList<AsignaturaDTO>();

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
	 * @return the escuela
	 */
	public String getEscuela() {
		return escuela;
	}

	/**
	 * @param escuela
	 *            the escuela to set
	 */
	public void setEscuela(String escuela) {
		this.escuela = escuela;
	}

	/**
	 * @return the asignaturasList
	 */
	public ArrayList<AsignaturaDTO> getAsignaturasList() {
		return asignaturasList;
	}

	/**
	 * @param asignaturasList
	 *            the asignaturasList to set
	 */
	public static void setAsignaturasList(ArrayList<AsignaturaDTO> asignaturasList) {
		DocenteBean.asignaturasList = asignaturasList;
	}

	/**
	 * 
	 * <b> Permite agregar una asignatura a la tabla </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 29/12/2014]
	 * </p>
	 * 
	 * @return
	 * @throws DioneException
	 * @throws NumberFormatException
	 */
	public void addAsignatura() {

		AsignaturaDTO item = new AsignaturaDTO(this.escuela, this.materiasSeleccionadas);
		asignaturasList.add(item);
		escuela = "";
		materiasSeleccionadas = new ArrayList<MateriaDTO>();
	}

	/**
	 * 
	 * <b> Permite editar un registro </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 29/12/2014]
	 * </p>
	 * 
	 * @param event
	 */
	public void onEditAsignatura(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Edited", ((AsignaturaDTO) event.getObject()).getEscuela().toString());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	/**
	 * 
	 * <b> Permite eliminar un registro de la tabla de asignaturas </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 29/12/2014]
	 * </p>
	 * 
	 * @param event
	 */
	public void onCancelAsignatura(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Cancelled");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		asignaturasList.remove((AsignaturaDTO) event.getObject());
	}

	/**
	 * @return the materiasSeleccionadas
	 */
	public List<MateriaDTO> getMateriasSeleccionadas() {
		return materiasSeleccionadas;
	}

	/**
	 * @param materiasSeleccionadas
	 *            the materiasSeleccionadas to set
	 */
	public void setMateriasSeleccionadas(List<MateriaDTO> materiasSeleccionadas) {
		this.materiasSeleccionadas = materiasSeleccionadas;
	}

}
