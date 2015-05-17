/**
 * 
 */
package ec.com.uce.dione.dao;

import java.util.List;

import javax.ejb.Local;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.entities.FormacionContinua;

/**
 * <b> Interfaz local de la tabla FormacionContinua para relaizar las operaciones necesarias sobre la base </b>
 * 
 * @author Anita Carrera
 * @version 1.0,29/12/2014
 * @since JDK1.6
 */
@Local
public interface FormacionCDao extends GenericDAO<FormacionContinua, Integer> {

	/**
	 * 
	 * <b> Permite consultar la lista de formaciones continuas que tiene un docente </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 09/02/2015]
	 * </p>
	 * 
	 * @param idDocente
	 * @return
	 * @throws DioneException
	 */
	public List<FormacionContinua> consultarFormacionByDocente(Integer idDocente) throws DioneException;

}
