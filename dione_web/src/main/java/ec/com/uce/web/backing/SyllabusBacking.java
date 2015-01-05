/**
 * 
 */
package ec.com.uce.web.backing;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.entities.Docente;
import ec.com.uce.dione.entities.EscuelaUce;
import ec.com.uce.ejb.service.DocenteService;
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

	@ManagedProperty(value = "#{syllabusBean}")
	private SyllabusBean syllabusBean;
	
	Logger log = Logger.getLogger(SyllabusBacking.class);

	public void buscarDocente() throws DioneException{
		try {
			
			Docente docente = docenteService.consultarDocenteByCedula(syllabusBean.getCedula());
			for(EscuelaUce escuelaUce: docente.getEscuelaUces()){
				escuelaUce.getMateriaUces();
			}
			
		} catch (DioneException e) {
			log.error("Error al momento consultar el docente", e);
			throw new DioneException(e);
		}
		
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

}
