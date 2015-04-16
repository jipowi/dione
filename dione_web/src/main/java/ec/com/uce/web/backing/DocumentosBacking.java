/**
 * 
 */
package ec.com.uce.web.backing;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.entities.ArchivoBase;
import ec.com.uce.dione.entities.Docente;
import ec.com.uce.ejb.service.DocenteService;
import ec.com.uce.web.bean.DocumentosBean;
import ec.com.uce.web.util.ArchivoUtil;

/**
 * <b> Permite almacenar la informacion y manejar las acciones de la pagina. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Dec 8, 2014
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class DocumentosBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private DocenteService docenteService;

	@ManagedProperty(value = "#{documentosBean}")
	private DocumentosBean documentosBean;

	private Docente docente;

	Logger log = Logger.getLogger(DocumentosBacking.class);

	/**
	 * 
	 * <b>
	 * Permite buscar el docente por medio de la CI.
	 * </b>
	 * <p>[Author: Paul Jimenez, Date: 15/04/2015]</p>
	 *
	 * @throws DioneException
	 */
	public void buscarDocente() throws DioneException {
		try {
			docente = docenteService.consultarDocenteByCedula(documentosBean.getCedulaDocente());
			
		} catch (DioneException e) {
			log.error("Error al momento consultar el docente", e);
			throw new DioneException(e);
		}

	}

	/**
	 * 
	 * <b> Permite cargar el archivo en memoria antes de ser guardado </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Sep 28, 2014]
	 * </p>
	 * 
	 * @param event
	 */
	public void cargarArchivoDocente(FileUploadEvent event) {

		if (event.getFile() != null) {

			try {

				UploadedFile file = event.getFile();

				ArchivoBase archivoBase = new ArchivoBase();

				documentosBean.setDocumento(archivoBase);
				ArchivoUtil.getInstancia().agregarArchivo(archivoBase, file);

				FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
				FacesContext.getCurrentInstance().addMessage(null, message);

			} catch (Exception e) {
				log.error("Error {}", e);
			}
		}
	}
	
	/**
	 * @return the documentosBean
	 */
	public DocumentosBean getDocumentosBean() {
		return documentosBean;
	}

	/**
	 * @param documentosBean
	 *            the documentosBean to set
	 */
	public void setDocumentosBean(DocumentosBean documentosBean) {
		this.documentosBean = documentosBean;
	}

	/**
	 * @return the docente
	 */
	public Docente getDocente() {
		return docente;
	}

	/**
	 * @param docente
	 *            the docente to set
	 */
	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	
}
