/**
 * 
 */
package ec.com.uce.dione.dao;

import javax.ejb.Local;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.entities.MateriaSyllabus;

/**
 * <b> Interfaz local de la tabla MateriaSyllabus para realizar las operaciones necesarias sobre la base </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,29/12/2014
 * @since JDK1.6
 */
@Local
public interface MateriaSyllabusDao extends GenericDAO<MateriaSyllabus, Long> {

	/**
	 * 
	 * <b> Permite consultar la materia y el syllabus de la tabla MateriaSyllabus. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 02/03/2015]
	 * </p>
	 * 
	 * @param idSyllabus
	 * @return
	 * @throws DioneException
	 */
	public MateriaSyllabus consultarMateriaSyllabusBySyllabus(Integer idSyllabus) throws DioneException;
}
