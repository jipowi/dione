/**
 * 
 */
package ec.com.uce.web.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

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
	private ArchivoBase documento;
	private String descripcion;
	private Date fechaSubida;
	private static ArrayList<DocumentoDocenteDTO> documentosList = new ArrayList<DocumentoDocenteDTO>();

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

	/**
	 * @return the documentosList
	 */
	public ArrayList<DocumentoDocenteDTO> getDocumentosList() {
		return documentosList;
	}

	/**
	 * @param documentosList
	 *            the documentosList to set
	 */
	public static void setDocumentosList(ArrayList<DocumentoDocenteDTO> documentosList) {
		DocumentosBean.documentosList = documentosList;
	}

	/**
	 * 
	 * <b> Permite agregar un registro de documento </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Dec 1, 2014]
	 * </p>
	 * 
	 * @return
	 */
	public String addDocumentos() {
		DocumentoDocenteDTO item = new DocumentoDocenteDTO(this.documento, this.descripcion, this.fechaSubida);
		documentosList.add(item);

		documento = null;
		descripcion = "";
		fechaSubida = null;

		return null;
	}

	/**
	 * 
	 * <b> Permite editar un registro de la tabla </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Dec 1, 2014]
	 * </p>
	 * 
	 * @param event
	 */
	public void onEditDocumento(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Edited", ((DocumentoDocenteDTO) event.getObject()).getDescripcion());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	/**
	 * 
	 * <b> Permite eliminar un registro de la tabla </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Dec 1, 2014]
	 * </p>
	 * 
	 * @param event
	 */
	public void onCancelDocumento(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Cancelled");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		documentosList.remove((DocumentoDocenteDTO) event.getObject());
	}

}
