/**
 * 
 */
package ec.com.uce.web.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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

}
