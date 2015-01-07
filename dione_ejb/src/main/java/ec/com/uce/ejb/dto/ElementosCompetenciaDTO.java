/**
 * 
 */
package ec.com.uce.ejb.dto;

/**
 * <b> Permite manejar la informacion de los elementos de competencia. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,07/01/2015
 * @since JDK1.6
 */
public class ElementosCompetenciaDTO {

	private String elementoCompetencia;

	/**
	 * @param elementoCompetencia
	 */
	public ElementosCompetenciaDTO(String elementoCompetencia) {
		super();
		this.elementoCompetencia = elementoCompetencia;
	}

	/**
	 * @return the elementoCompetencia
	 */
	public String getElementoCompetencia() {
		return elementoCompetencia;
	}

	/**
	 * @param elementoCompetencia
	 *            the elementoCompetencia to set
	 */
	public void setElementoCompetencia(String elementoCompetencia) {
		this.elementoCompetencia = elementoCompetencia;
	}

}
