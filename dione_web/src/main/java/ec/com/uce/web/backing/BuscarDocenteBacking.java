/**
 * 
 */
package ec.com.uce.web.backing;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.entities.Docente;
import ec.com.uce.ejb.service.DocenteService;
import ec.com.uce.web.bean.DocenteBean;
import ec.com.uce.web.util.HiperionMensajes;
import ec.com.uce.web.util.MessagesController;

/**
 * <b> Permite buscar los datos del docente </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,06/02/2015
 * @since JDK1.6
 */
@ManagedBean
@SessionScoped
public class BuscarDocenteBacking {

	@EJB
	private DocenteService docenteService;

	@ManagedProperty(value = "#{docenteBean}")
	private DocenteBean docenteBean;

	private Docente docente;

	Logger log = Logger.getLogger(BuscarDocenteBacking.class);

	/**
	 * 
	 * <b> Permite buscar un docente por medio del ingreso de la identificacion. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 07/01/2015]
	 * </p>
	 * 
	 * @throws DioneException
	 */
	public void buscarDocente() throws DioneException {
		try {
			docente = docenteService.consultarDocenteByCedula(docenteBean.getCedulaDocente());
			if (docente != null) {

			} else {
				MessagesController.addError(null, HiperionMensajes.getInstancia().getString("dione.mensaje.error.buscar"));
			}

		} catch (DioneException e) {
			log.error("Error al momento consultar el docente", e);
			throw new DioneException(e);
		}

	}

	/**
	 * @return the docenteBean
	 */
	public DocenteBean getDocenteBean() {
		return docenteBean;
	}

	/**
	 * @param docenteBean
	 *            the docenteBean to set
	 */
	public void setDocenteBean(DocenteBean docenteBean) {
		this.docenteBean = docenteBean;
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
