/**
 * 
 */
package ec.com.uce.ejb.dto;

import java.io.Serializable;

/**
 * <b> Permite manejar la informacion del resultado de aprendizaje. </b>
 * 
 * @author Anita Carrera
 * @version 1.0,21/01/2015
 * @since JDK1.6
 */
public class EvaluacionResAprendizajeDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idResultado;
	private String resultado;
	private Boolean domina;
	private Boolean avance;
	private Boolean proceso;
	private Boolean inicio;

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
	 * @return the resultado
	 */
	public String getResultado() {
		return resultado;
	}

	/**
	 * @param resultado
	 *            the resultado to set
	 */
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	/**
	 * @return the idResultado
	 */
	public Integer getIdResultado() {
		return idResultado;
	}

	/**
	 * @param idResultado
	 *            the idResultado to set
	 */
	public void setIdResultado(Integer idResultado) {
		this.idResultado = idResultado;
	}

}
