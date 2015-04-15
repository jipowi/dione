/**
 * 
 */
package ec.com.uce.ejb.dto;

import java.io.Serializable;

/**
 * <b> Permite manejar la informacion de la tabla de documentos de docente </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,29/12/2014
 * @since JDK1.6
 */
public class DocumentoDocenteDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idDocente;
	private String idDocumento;

	/**
	 * @return the idDocente
	 */
	public Integer getIdDocente() {
		return idDocente;
	}

	/**
	 * @param idDocente
	 *            the idDocente to set
	 */
	public void setIdDocente(Integer idDocente) {
		this.idDocente = idDocente;
	}

	/**
	 * @return the idDocumento
	 */
	public String getIdDocumento() {
		return idDocumento;
	}

	/**
	 * @param idDocumento
	 *            the idDocumento to set
	 */
	public void setIdDocumento(String idDocumento) {
		this.idDocumento = idDocumento;
	}

}
