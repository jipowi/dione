/**
 * 
 */
package ec.com.uce.ejb.dto;

/**
 * <b> Permite manejar la informacion de competencias </b>
 * 
 * @author Anita Carrera
 * @version 1.0,07/01/2015
 * @since JDK1.6
 */
public class CompetenciaGeneralDTO {
	private String competenciaGeneral;

	/**
	 * @param competenciaGeneral
	 */
	public CompetenciaGeneralDTO(String competenciaGeneral) {
		super();
		this.competenciaGeneral = competenciaGeneral;
	}

	/**
	 * @return the competenciaGeneral
	 */
	public String getCompetenciaGeneral() {
		return competenciaGeneral;
	}

	/**
	 * @param competenciaGeneral
	 *            the competenciaGeneral to set
	 */
	public void setCompetenciaGeneral(String competenciaGeneral) {
		this.competenciaGeneral = competenciaGeneral;
	}

}
