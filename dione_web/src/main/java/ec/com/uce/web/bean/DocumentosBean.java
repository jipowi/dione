/**
 * 
 */
package ec.com.uce.web.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ec.com.uce.dione.entities.ArchivoBase;
import ec.com.uce.ejb.dto.DocumentoDocenteDTO;

/**
 * <b> Permite manejar la informacion en la pagina y el backing. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,13/04/2015
 * @since JDK1.6
 */
@ManagedBean
@SessionScoped
public class DocumentosBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String cedulaDocente;
	private List<DocumentoDocenteDTO> documentos;
	private ArchivoBase documento;
	private String descripcion;
	private Date fechaSubida;
	

	/**
	 * @return the cedulaDocente
	 */
	public String getCedulaDocente() {
		return cedulaDocente;
	}

	/**
	 * @param cedulaDocente
	 *            the cedulaDocente to set
	 */
	public void setCedulaDocente(String cedulaDocente) {
		this.cedulaDocente = cedulaDocente;
	}

	/**
	 * @return the documentos
	 */
	public List<DocumentoDocenteDTO> getDocumentos() {
		return documentos;
	}

	/**
	 * @param documentos
	 *            the documentos to set
	 */
	public void setDocumentos(List<DocumentoDocenteDTO> documentos) {
		this.documentos = documentos;
	}

	/**
	 * @return the documento
	 */
	public ArchivoBase getDocumento() {
		return documento;
	}

	/**
	 * @param documento the documento to set
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
	 * @param descripcion the descripcion to set
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
	 * @param fechaSubida the fechaSubida to set
	 */
	public void setFechaSubida(Date fechaSubida) {
		this.fechaSubida = fechaSubida;
	}

	
}
