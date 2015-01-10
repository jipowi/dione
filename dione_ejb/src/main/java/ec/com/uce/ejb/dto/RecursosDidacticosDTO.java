/**
 * 
 */
package ec.com.uce.ejb.dto;

import java.io.Serializable;

/**
 * <b> Permite administrar la informacion de los recursos didacticos. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,10/01/2015
 * @since JDK1.6
 */
public class RecursosDidacticosDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String recurso;

	/**
	 * @param recurso
	 */
	public RecursosDidacticosDTO(String recurso) {
		super();
		this.recurso = recurso;
	}

	/**
	 * @return the recurso
	 */
	public String getRecurso() {
		return recurso;
	}

	/**
	 * @param recurso
	 *            the recurso to set
	 */
	public void setRecurso(String recurso) {
		this.recurso = recurso;
	}

}
