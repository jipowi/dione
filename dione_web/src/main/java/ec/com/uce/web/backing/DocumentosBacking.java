/**
 * 
 */
package ec.com.uce.web.backing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.entities.Docente;
import ec.com.uce.dione.entities.Escuela;
import ec.com.uce.dione.entities.EscuelaUce;
import ec.com.uce.dione.entities.Materia;
import ec.com.uce.dione.entities.MateriaUce;
import ec.com.uce.dione.enumeration.EstadoEnum;
import ec.com.uce.ejb.dto.AsignaturaDTO;
import ec.com.uce.ejb.dto.MateriaDTO;
import ec.com.uce.ejb.service.CatalogoService;
import ec.com.uce.ejb.service.DocenteService;
import ec.com.uce.web.bean.DocenteBean;
import ec.com.uce.web.bean.DocumentosBean;
import ec.com.uce.web.util.HiperionMensajes;
import ec.com.uce.web.util.MessagesController;
import ec.com.uce.web.validator.ValidatorCedula;

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

	public void buscarDocente() throws DioneException {
		try {
			docente = docenteService.consultarDocenteByCedula(documentosBean.getCedulaDocente());
			
		} catch (DioneException e) {
			log.error("Error al momento consultar el docente", e);
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

}
