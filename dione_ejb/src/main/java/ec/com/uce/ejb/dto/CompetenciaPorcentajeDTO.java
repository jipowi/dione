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
public class CompetenciaPorcentajeDTO {

	private String materia;
	private String competencia;
	private Double inicio;
	private Double avance;
	private Double dominio;
	private Double proceso;

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
	 * @return the inicio
	 */
	public Double getInicio() {
		return inicio;
	}

	/**
	 * @param inicio
	 *            the inicio to set
	 */
	public void setInicio(Double inicio) {
		this.inicio = inicio;
	}

	/**
	 * @return the avance
	 */
	public Double getAvance() {
		return avance;
	}

	/**
	 * @param avance
	 *            the avance to set
	 */
	public void setAvance(Double avance) {
		this.avance = avance;
	}

	/**
	 * @return the dominio
	 */
	public Double getDominio() {
		return dominio;
	}

	/**
	 * @param dominio
	 *            the dominio to set
	 */
	public void setDominio(Double dominio) {
		this.dominio = dominio;
	}

	/**
	 * @return the proceso
	 */
	public Double getProceso() {
		return proceso;
	}

	/**
	 * @param proceso
	 *            the proceso to set
	 */
	public void setProceso(Double proceso) {
		this.proceso = proceso;
	}

	/**
	 * @return the materia
	 */
	public String getMateria() {
		return materia;
	}

	/**
	 * @param materia
	 *            the materia to set
	 */
	public void setMateria(String materia) {
		this.materia = materia;
	}

}
