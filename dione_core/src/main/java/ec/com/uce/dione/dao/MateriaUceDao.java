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
public interface MateriaUceDao extends GenericDAO<MateriaUce, Long> {

	/**
	 * 
	 * <b> Permite consultar las materias relacionadas a un docente </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 07/01/2015]
	 * </p>
	 * 
	 * @param idDocente
	 * @return
	 * @throws DioneException
	 */
	public List<MateriaUce> consultarMateriasByDocente(Integer idDocente) throws DioneException;

}