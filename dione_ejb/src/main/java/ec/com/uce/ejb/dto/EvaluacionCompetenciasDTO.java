/**
 * 
 */
package ec.com.uce.ejb.dto;

import java.io.Serializable;

/**
 * <b> Permite manejar la informacion de competencias del syllabus. </sb>
 * 
 * @author Anita Carrera
 * @version 1.0,21/01/2015
 * @since JDK1.6
 */
public class EvaluacionCompetenciasDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idCompetencia;
	private String competencia;
	private Boolean domina;
	private Boolean avance;
	private Boolean proceso;
	private Boolean inicio;

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
	 * @return the domina
	 */
	public Boolean getDomina() {
		return domina;
	}

	/**
	 * @param domina
	 *            the domina to set
	 */
	public void setDomina(Boolean domina) {
		this.domina = domina;
	}

	/**
	 * @return the avance
	 */
	public Boolean getAvance() {
		return avance;
	}

	/**
	 * @param avance
	 *            the avance to set
	 */
	public void setAvance(Boolean avance) {
		this.avance = avance;
	}

	/**
	 * @return the proceso
	 */
	public Boolean getProceso() {
		return proceso;
	}

	/**
	 * @param proceso
	 *            the proceso to set
	 */
	public void setProceso(Boolean proceso) {
		this.proceso = proceso;
	}

	/**
	 * @return the inicio
	 */
	public Boolean getInicio() {
		return inicio;
	}

	/**
	 * @param inicio
	 *            the inicio to set
	 */
	public void setInicio(Boolean inicio) {
		this.inicio = inicio;
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
