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
import ec.com.uce.dione.entities.MateriaUce;
import ec.com.uce.ejb.service.DocenteService;
import ec.com.uce.ejb.service.SyllabusService;
import ec.com.uce.web.bean.SyllabusBean;

/**
 * <b> Permite almacenar la informacion de la pagina web y administrar las acciones de la misma </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,05/01/2015
 * @since JDK1.6
 */
@ManagedBean
@SessionScoped
public class SyllabusBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private DocenteService docenteService;
	
	@EJB
	private SyllabusService syllabusService;

	@ManagedProperty(value = "#{syllabusBean}")
	private SyllabusBean syllabusBean;

	private List<SelectItem> materias = new ArrayList<SelectItem>();
	private List<MateriaUce> materiaUces = new ArrayList<MateriaUce>();
	private Docente docente;
	private Boolean docenteEncontrado = false;

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
			docente = docenteService.consultarDocenteByCedula(syllabusBean.getCedula());
			if (docente != null) {
				docenteEncontrado = true;
				materiaUces = syllabusService.consultarMateriasByDocente(docente.getIdDocente());
			} else {
				docenteEncontrado = false;
			}

		} catch (DioneException e) {
			log.error("Error al momento consultar el docente", e);
			throw new DioneException(e);
		}

	}

	/**
	 * @return the materias
	 * @throws DioneException
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

	/**
	 * @return the syllabusBean
	 */
	public SyllabusBean getSyllabusBean() {
		return syllabusBean;
	}

	/**
	 * @param syllabusBean
	 *            the syllabusBean to set
	 */
	public void setSyllabusBean(SyllabusBean syllabusBean) {
		this.syllabusBean = syllabusBean;
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

}
