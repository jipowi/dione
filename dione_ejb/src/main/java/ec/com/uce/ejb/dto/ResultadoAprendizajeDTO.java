/**
 * 
 */
package ec.com.uce.ejb.dto;

import java.io.Serializable;

/**
 * <b> Permite manejar la informacon de la tabla de resultados de aprendizaje. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,14/01/2015
 * @since JDK1.6
 */
public class ResultadoAprendizajeDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String  resultado;

	/**
	 * @param resultado
	 */
	public ResultadoAprendizajeDTO(String resultado) {
		super();
		this.resultado = resultado;
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

}
