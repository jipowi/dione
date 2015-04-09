/**
 * 
 */
package ec.com.uce.dione.dao;

import javax.ejb.Local;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.entities.Docente;

/**
 * <b> Interfaz local de la tabla Docente para realizar las operaciones necesarias sobre la base. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,05/01/2015
 * @since JDK1.6
 */
@Local
public interface DocenteDao extends GenericDAO<Docente, Integer> {

	/**
	 * 
	 * <b> Permite consultar un docente por su numero de identificacion </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 05/01/2015]
	 * </p>
	 * 
	 * @param cedula
	 * @return
	 * @throws DioneException
	 */
	public Docente cosultarDocenteByCedula(String cedula) throws DioneException;

}
