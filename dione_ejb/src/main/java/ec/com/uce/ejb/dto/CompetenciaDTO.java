/**
 * 
 */
package ec.com.uce.ejb.dto;

/**
 * <b> Permite manejar la informacion de competencias </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,07/01/2015
 * @since JDK1.6
 */
public class CompetenciaDTO {
	private String competencia;

	/**
	 * @param competencia
	 */
	public CompetenciaDTO(String competencia) {
		super();
		this.competencia = competencia;
	}

	/**
	 * @return the competencia
	 */
	public String getCompetencia() {
		return competencia;
	}

	/**
	 * @param competencia
	 *            the competencia to set
	 */
	public void setCompetencia(String competencia) {
		this.competencia = competencia;
	}

}
