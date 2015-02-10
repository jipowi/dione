/**
 * 
 */
package ec.com.uce.dione.dao;

import java.util.List;

import javax.ejb.Local;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.entities.FormacionAcademica;

/**
 * <b> Interfaz local de la tabla FormacionAcademica para relaizar las operaciones necesarias sobre la base </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,29/12/2014
 * @since JDK1.6
 */
@Local
public interface FormacionADao extends GenericDAO<FormacionAcademica, Long> {

	/**
	 * 
	 * <b> Permite consultar la lista de formaciones academicas que tiene un docente </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 09/02/2015]
	 * </p>
	 * 
	 * @param idDocente
	 * @return
	 * @throws DioneException
	 */
	public List<FormacionAcademica> consultarFormacionByDocente(Long idDocente) throws DioneException;
}
