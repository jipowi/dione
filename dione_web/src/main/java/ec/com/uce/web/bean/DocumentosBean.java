/**
 * 
 */
package ec.com.uce.web.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * <b> Permite manejar la informacion en la pagina y el backing. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,13/04/2015
 * @since JDK1.6
 */
@ManagedBean
@SessionScoped
public class DocumentosBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String cedulaDocente;

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

}
