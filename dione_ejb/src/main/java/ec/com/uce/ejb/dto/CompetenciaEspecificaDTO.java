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
public class CompetenciaEspecificaDTO {
	private String competenciaEspecifica;

	/**
	 * @param competenciaEspecifica
	 */
	public CompetenciaEspecificaDTO(String competenciaEspecifica) {
		super();
		this.competenciaEspecifica = competenciaEspecifica;
	}

	/**
	 * @return the competenciaEspecifica
	 */
	public String getCompetenciaEspecifica() {
		return competenciaEspecifica;
	}

	/**
	 * @param competenciaEspecifica
	 *            the competenciaEspecifica to set
	 */
	public void setCompetenciaEspecifica(String competenciaEspecifica) {
		this.competenciaEspecifica = competenciaEspecifica;
	}

}
