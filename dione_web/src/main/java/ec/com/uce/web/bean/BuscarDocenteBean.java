/**
 * 
 */
package ec.com.uce.web.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ec.com.uce.dione.entities.EscuelaUce;
import ec.com.uce.dione.entities.FormacionAcademica;
import ec.com.uce.dione.entities.FormacionContinua;
import ec.com.uce.ejb.dto.AsignaturaDTO;

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
	private String apellidosDocente;
	private String cedulaDocente;
	private String direccionDocente;
	private String nombresDocente;
	private List<EscuelaUce> escuelas;
	private List<AsignaturaDTO> escuelaMateriasList;
	private List<FormacionAcademica> formacionesA;
	private List<FormacionContinua> formacionesC;

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

}
