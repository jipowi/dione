/**
 * 
 */
package ec.com.uce.dione.dao;

import java.util.List;

import javax.ejb.Local;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.entities.MateriaUce;

/**
 * <b> Interfaz local para realizaar operaciones sobre la tabla MateriaUce. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,05/01/2015
 * @since JDK1.6
 */
@Local
public interface MateriaUceDao extends GenericDAO<MateriaUce, Integer> {

	/**
	 * 
	 * <b> Permite consultar las materias correspondientes a una determinada escuela. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 14/01/2015]
	 * </p>
	 * 
	 * @param idEscuela
	 * @return
	 * @throws DioneException
	 */
	public List<MateriaUce> consultarMateriasByEscuela(Integer idEscuela) throws DioneException;
}
