/**
 * 
 */
package ec.com.uce.ejb.dto;

import java.io.Serializable;
import java.util.Date;

import ec.com.uce.dione.entities.ArchivoBase;

/**
 * <b> Permite manejar la informacion de la tabla de documentos de docente </b>
 * 
 * @author Anita Carrera
 * @version 1.0,29/12/2014
 * @since JDK1.6
 */
public class DocumentoDocenteDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private ArchivoBase documento;
	private String descripcion;
	private Date fechaSubida;

	/**
	 * @param documento
	 * @param descripcion
	 * @param fechaSubida
	 */
	public DocumentoDocenteDTO(ArchivoBase documento, String descripcion, Date fechaSubida) {
		super();
		this.documento = documento;
		this.descripcion = descripcion;
		this.fechaSubida = fechaSubida;
	}

	/**
	 * @return the documento
	 */
	public ArchivoBase getDocumento() {
		return documento;
	}

	/**
	 * @param documento
	 *            the documento to set
	 */
	public void setDocumento(ArchivoBase documento) {
		this.documento = documento;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion
	 *            the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the fechaSubida
	 */
	public Date getFechaSubida() {
		return fechaSubida;
	}

	/**
	 * @param fechaSubida
	 *            the fechaSubida to set
	 */
	public void setFechaSubida(Date fechaSubida) {
		this.fechaSubida = fechaSubida;
	}

}
