/**
 * 
 */
package ec.com.uce.web.backing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.entities.Docente;
import ec.com.uce.dione.entities.EscuelaUce;
import ec.com.uce.dione.entities.MateriaUce;
import ec.com.uce.ejb.service.DocenteService;
import ec.com.uce.ejb.service.SyllabusService;
import ec.com.uce.web.bean.ResultadoBean;
import ec.com.uce.web.util.HiperionMensajes;
import ec.com.uce.web.util.MessagesController;

/**
 * <b> Permite administrar las acciones de la pagina web </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,15/01/2015
 * @since JDK1.6
 */
@ManagedBean
@SessionScoped
public class ResultadosBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{resultadoBean}")
	private ResultadoBean resultadoBean;

	@EJB
	private DocenteService docenteService;
	@EJB
	private SyllabusService syllabusService;

	private Docente docente;
	private Boolean docenteEncontrado = false;
	private List<MateriaUce> materiaUces = new ArrayList<MateriaUce>();
	private List<SelectItem> materias = new ArrayList<SelectItem>();

	Logger log = Logger.getLogger(SyllabusBacking.class);

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
			docente = docenteService.consultarDocenteByCedula(resultadoBean.getCedula());
			if (docente != null) {
				docenteEncontrado = true;
				List<EscuelaUce> escuelas = syllabusService.consultarEscuelaByDocente(docente.getIdDocente().toString());

				for (EscuelaUce escuelaUce : escuelas) {
					List<MateriaUce> materiasTemp = syllabusService.consultarMateriasByEscuela(new Long(escuelaUce.getIdEscuelaUce()));
					for (MateriaUce materiaUce : materiasTemp) {
						materiaUces.add(materiaUce);
					}
				}

			} else {
				docenteEncontrado = false;
				MessagesController.addError(null, HiperionMensajes.getInstancia().getString("dione.mensaje.error.buscar"));
			}

		} catch (DioneException e) {
			log.error("Error al momento consultar el docente", e);
			throw new DioneException(e);
		}

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
	 * @return the docenteEncontrado
	 */
	public Boolean getDocenteEncontrado() {
		return docenteEncontrado;
	}

	/**
	 * @param docenteEncontrado
	 *            the docenteEncontrado to set
	 */
	public void setDocenteEncontrado(Boolean docenteEncontrado) {
		this.docenteEncontrado = docenteEncontrado;
	}

	/**
	 * @return the resultadoBean
	 */
	public ResultadoBean getResultadoBean() {
		return resultadoBean;
	}

	/**
	 * @param resultadoBean
	 *            the resultadoBean to set
	 */
	public void setResultadoBean(ResultadoBean resultadoBean) {
		this.resultadoBean = resultadoBean;
	}

	/**
	 * @return the materiaUces
	 */
	public List<MateriaUce> getMateriaUces() {
		return materiaUces;
	}

	/**
	 * @param materiaUces
	 *            the materiaUces to set
	 */
	public void setMateriaUces(List<MateriaUce> materiaUces) {
		this.materiaUces = materiaUces;
	}

	/**
	 * @return the materias
	 */
	public List<SelectItem> getMaterias() {
		materias = new ArrayList<SelectItem>();
		for (MateriaUce materiaUce : materiaUces) {
			SelectItem selectItem = new SelectItem(materiaUce.getIdMateriaUce(), materiaUce.getMateriaUce());
			materias.add(selectItem);
		}
		return materias;
	}

	/**
	 * @param materias
	 *            the materias to set
	 */
	public void setMaterias(List<SelectItem> materias) {
		this.materias = materias;
	}

}
