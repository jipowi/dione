/**
 * 
 */
package ec.com.uce.dione.dao;

import java.util.List;

import javax.ejb.Local;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.entities.Prerequisito;

/**
 * <b> Interfaz local de la tabla Materia para relaizar las operaciones necesarias sobre la base </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,29/12/2014
 * @since JDK1.6
 */
@Local
public interface PrerequisitoDao extends GenericDAO<Prerequisito, Integer> {

	public List<Prerequisito> consultarPreByMateria(Integer idMateria) throws DioneException;
}
