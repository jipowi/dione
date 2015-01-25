/**
 * 
 */
package ec.com.uce.ejb.dto;

import java.io.Serializable;

/**
 * <b> Permite manejar la informacion de competencias del syllabus. </sb>
 * 
 * @author Paul Jimenez
 * @version 1.0,21/01/2015
 * @since JDK1.6
 */
public class EvaluacionCompetenciasDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idCompetencia;
	private String competencia;
	private Boolean cumplido;

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

	/**
	 * @return the cumplido
	 */
	public Boolean getCumplido() {
		return cumplido;
	}

	/**
	 * @param cumplido
	 *            the cumplido to set
	 */
	public void setCumplido(Boolean cumplido) {
		this.cumplido = cumplido;
	}

	/**
	 * @return the idCompetencia
	 */
	public Integer getIdCompetencia() {
		return idCompetencia;
	}

	/**
	 * @param idCompetencia
	 *            the idCompetencia to set
	 */
	public void setIdCompetencia(Integer idCompetencia) {
		this.idCompetencia = idCompetencia;
	}

}
