/**
 * 
 */
package ec.com.uce.web.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * <b> Permiteencapsular varios objetos en un unico objeto.</b>
 * 
 * @author Anita Carrera
 * @version 1.0,24/01/2015
 * @since JDK1.6
 */
@ManagedBean
@SessionScoped
public class ReportesBean implements Serializable {

	private static final long serialVersionUID = 6401166601481931346L;

	private String escuela;
	private String cedulaDocente;
	private String materia;

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

}