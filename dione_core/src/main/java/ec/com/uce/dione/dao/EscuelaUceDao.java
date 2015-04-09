/**
 * 
 */
package ec.com.uce.dione.dao;

import java.util.List;

import javax.ejb.Local;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.entities.EscuelaUce;

/**
 * <b> Interfaz local para realizar las operaciones sobre la tabla EscuelaUce. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,05/01/2015
 * @since JDK1.6
 */
@Local
public interface EscuelaUceDao extends GenericDAO<EscuelaUce, Integer> {

	/**
	 * 
	 * <b> Permite consultar las escuelas en las que se encuetra el docente </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 14/01/2015]
	 * </p>
	 * 
	 * @return
	 * @throws DioneException
	 */
	public List<EscuelaUce> consultarEscuelaByDocente(String idDocente) throws DioneException;
	
	/**
	 * 
	 * <b> Permite concsultar las escuelas por medio de la descripcion. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 19/03/2015]
	 * </p>
	 * 
	 * @param escuela
	 * @return
	 * @throws DioneException
	 */
	public List<EscuelaUce> consultarEscuelas(String escuela) throws DioneException;

}
