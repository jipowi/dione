/**
 * 
 */
package ec.com.uce.ejb.dto;

import java.io.Serializable;

/**
 * <b> Permite manejar la iformacion de los objetivos por unidad. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,21/01/2015
 * @since JDK1.6
 */
public class EvaluacionObjetivosDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idObjetivo;
	private String objetivo;
	private Boolean cumplido;

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
	 * @return the idObjetivo
	 */
	public Integer getIdObjetivo() {
		return idObjetivo;
	}

	/**
	 * @param idObjetivo
	 *            the idObjetivo to set
	 */
	public void setIdObjetivo(Integer idObjetivo) {
		this.idObjetivo = idObjetivo;
	}

}
