/**
 * 
 */
package ec.com.uce.dione.dao;

import java.util.List;

import javax.ejb.Local;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.entities.Corequisito;

/**
 * <b> Interfaz local de la tabla Materia para relaizar las operaciones necesarias sobre la base </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,29/12/2014
 * @since JDK1.6
 */
@Local
public interface CorequisitoDao extends GenericDAO<Corequisito, Long> {

	public List<Corequisito> consultarCorequisitoByMateria(Integer idMateria) throws DioneException;
}
