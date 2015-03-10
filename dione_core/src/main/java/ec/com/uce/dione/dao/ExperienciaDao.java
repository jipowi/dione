/**
 * 
 */
package ec.com.uce.dione.dao;

import java.util.List;

import javax.ejb.Local;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.entities.Experiencia;

/**
 * <b> Interfaz local de la tabla Experiencia para realizar las operaciones necesarias sobre la base </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,29/12/2014
 * @since JDK1.6
 */
@Local
public interface ExperienciaDao extends GenericDAO<Experiencia, Long> {

	/**
	 * 
	 * <b> Permite consultar las experiencias del docente. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 09/03/2015]
	 * </p>
	 * 
	 * @param idExperiencia
	 * @return
	 */
	public List<Experiencia> consultarExperienciasByDocente(Integer idDocente) throws DioneException;
}
