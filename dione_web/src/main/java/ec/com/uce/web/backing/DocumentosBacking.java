/**
 * 
 */
package ec.com.uce.web.backing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.UploadedFile;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.entities.ArchivoBase;
import ec.com.uce.dione.entities.Docente;
import ec.com.uce.dione.entities.DocumentoDocente;
import ec.com.uce.ejb.dto.DocumentoDocenteDTO;
import ec.com.uce.ejb.service.DocenteService;
import ec.com.uce.web.bean.DocumentosBean;
import ec.com.uce.web.util.ArchivoUtil;
import ec.com.uce.web.util.ConstantesUtil;
import ec.com.uce.web.util.GenerarPdfUtil;
import ec.com.uce.web.util.HiperionMensajes;
import ec.com.uce.web.util.JsfUtil;
import ec.com.uce.web.util.MessagesController;

/**
 * <b> Permite almacenar la informacion y manejar las acciones de la pagina. </b>
 * 
 * @author Anita Carrera
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
	private Boolean existeDocente = false;

	private List<ArchivoBase> archivos = new ArrayList<ArchivoBase>();
	private ArchivoBase selectedArchivo;

	Logger log = Logger.getLogger(DocumentosBacking.class);

	/**
	 * 
	 * <b> Permite buscar el docente por medio de la CI. </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 15/04/2015]
	 * </p>
	 * 
	 * @throws DioneException
	 */
	public void buscarDocente() throws DioneException {
		try {
			List<DocumentoDocente> documentosDocente = new ArrayList<DocumentoDocente>();

			docente = docenteService.consultarDocenteByCedula(documentosBean.getCedulaDocente());

			documentosDocente = docenteService.consultarDocumentos(docente.getIdDocente());

			for (DocumentoDocente documentoDocente : documentosDocente) {
				ArchivoBase archivo = new ArchivoBase();

				archivo = docenteService.consultarArchivoById(documentoDocente.getArchivoBase().getIdArchivo());

				archivos.add(archivo);
			}

		} catch (DioneException e) {
			log.error("Error al momento consultar el docente", e);
			throw new DioneException(e);
		}

	}

	/**
	 * 
	 * <b> Permite agregar nuevos documentos. </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 20/04/2015]
	 * </p>
	 * 
	 */
	public void agregarDocumentos() {
		existeDocente = true;
	}

	/**
	 * 
	 * <b> Permite guardar los archivos del docente en la base de datos. </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 20/04/2015]
	 * </p>
	 * 
	 * @throws DioneException
	 */
	public void guardarDocumentos() throws DioneException {

		List<DocumentoDocente> documentos = new ArrayList<DocumentoDocente>();

		for (DocumentoDocenteDTO documentoDTO : documentosBean.getDocumentosList()) {

			DocumentoDocente documento = new DocumentoDocente();

			ArchivoBase archivo = new ArchivoBase();

			archivo = documentoDTO.getDocumento();
			archivo.setDescripcionDocumento(documentoDTO.getDescripcion());
			archivo.setFechaCarga(documentoDTO.getFechaSubida());

			documento.setArchivoBase(archivo);
			documento.setDocente(docente);

			documentos.add(documento);
		}
		try {
			docenteService.guardarDocumentos(documentos);
			MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("dione.mensaje.exito.save"));

		} catch (DioneException e) {
			log.error("Error al momento guardar los documentos del docente", e);
			MessagesController.addError(null, HiperionMensajes.getInstancia().getString("dione.mensaje.error.save"));
			throw new DioneException(e);
		}
	}

	/**
	 * 
	 * <b> Permite cargar el archivo en memoria antes de ser guardado </b>
	 * <p>
	 * [Author: Anita Carrera, Date: Sep 28, 2014]
	 * </p>
	 * 
	 * @param event
	 */
	public void cargarArchivoDocente(FileUploadEvent event) {

		if (event.getFile() != null) {

			try {

				UploadedFile file = event.getFile();

				ArchivoBase archivoBase = new ArchivoBase();

				ArchivoUtil.getInstancia().agregarArchivo(archivoBase, file);
				documentosBean.setDocumento(archivoBase);

				FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
				FacesContext.getCurrentInstance().addMessage(null, message);

			} catch (Exception e) {
				log.error("Error {}", e);
			}
		}
	}

	public void descargarDocumentosPDF(SelectEvent event) throws DioneException {
		try {

			ArchivoBase archivo = (ArchivoBase) event.getObject();
			archivo.getDescripcionDocumento();

			Map<String, Object> parametrosReporte = new HashMap<String, Object>();

			parametrosReporte.put(ConstantesUtil.CONTENT_TYPE_IDENTIFICADOR, ConstantesUtil.CONTENT_TYPE_PDF);
			parametrosReporte.put(ConstantesUtil.NOMBRE_ARCHIVO_IDENTIFICADOR, archivo.getDescripcionDocumento());

			parametrosReporte.put(ConstantesUtil.CONTENIDO_BYTES_IDENTIFICADOR, GenerarPdfUtil.generarPDFs(archivo.getDocumentoByte()));

			JsfUtil.setSessionAttribute(ConstantesUtil.PARAMETROS_DESCARGADOR_IDENTIFICADOR, parametrosReporte);
			JsfUtil.downloadFile();
		} catch (Exception e) {
			log.error("Error al momento de descargar el PDF", e);
			throw new DioneException(e);
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

	/**
	 * @return the existeDocente
	 */
	public Boolean getExisteDocente() {
		return existeDocente;
	}

	/**
	 * @param existeDocente
	 *            the existeDocente to set
	 */
	public void setExisteDocente(Boolean existeDocente) {
		this.existeDocente = existeDocente;
	}

	/**
	 * @return the archivos
	 */
	public List<ArchivoBase> getArchivos() {
		return archivos;
	}

	/**
	 * @param archivos
	 *            the archivos to set
	 */
	public void setArchivos(List<ArchivoBase> archivos) {
		this.archivos = archivos;
	}

	/**
	 * @return the selectedArchivo
	 */
	public ArchivoBase getSelectedArchivo() {
		return selectedArchivo;
	}

	/**
	 * @param selectedArchivo
	 *            the selectedArchivo to set
	 */
	public void setSelectedArchivo(ArchivoBase selectedArchivo) {
		this.selectedArchivo = selectedArchivo;
	}

}
