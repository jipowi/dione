/**
 * 
 */
package ec.com.uce.ejb.dto;

/**
 * <b> Permite manejar la informacion de los objetivos </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,07/01/2015
 * @since JDK1.6
 */
public class ObjetivoDTO {

	private String objetivo;

	/**
	 * @param objetivo
	 */
	public ObjetivoDTO(String objetivo) {
		super();
		this.objetivo = objetivo;
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

}
