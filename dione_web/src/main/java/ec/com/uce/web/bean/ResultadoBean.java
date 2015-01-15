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
public class ResultadoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String cedula;

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
