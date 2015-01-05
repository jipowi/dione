/**
 * 
 */
package ec.com.uce.dione.dao;

import java.util.List;

import javax.ejb.Local;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.entities.Materia;

/**
 * <b> Interfaz local para realizar las operaciones necesarias en la tabla Materia </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,29/12/2014
 * @since JDK1.6
 */
@Local
public interface MateriaDao  {

	/**
	 * 
	 * <b> Permite consultar la lista de materias correspondientes a una escuela </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 29/12/2014]
	 * </p>
	 * 
	 * @param idEscuela
	 * @return
	 */
	public List<Materia> consultarMateriaByEscuela(Integer idEscuela) throws DioneException;
}
