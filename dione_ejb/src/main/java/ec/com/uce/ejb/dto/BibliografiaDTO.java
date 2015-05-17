/**
 * 
 */
package ec.com.uce.ejb.dto;

import java.io.Serializable;

/**
 * <b> Permite administrar la informacion de las biografias. </b>
 * 
 * @author Anita Carrera
 * @version 1.0,10/01/2015
 * @since JDK1.6
 */
public class BibliografiaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String biografia;

	/**
	 * @param biografia
	 */
	public BibliografiaDTO(String biografia) {
		super();
		this.biografia = biografia;
	}

	/**
	 * @return the biografia
	 */
	public String getBiografia() {
		return biografia;
	}

	/**
	 * @param biografia
	 *            the biografia to set
	 */
	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

}
