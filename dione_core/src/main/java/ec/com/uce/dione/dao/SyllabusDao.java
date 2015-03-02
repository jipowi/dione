/**
 * 
 */
package ec.com.uce.dione.dao;

import javax.ejb.Local;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.entities.Syllabus;

/**
 * <b> Interfaz local para realizar las operaciones necesarias en la tabla Syllabus </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,29/12/2014
 * @since JDK1.6
 */
@Local
public interface SyllabusDao extends GenericDAO<Syllabus, Integer> {

	
	/**
	 * 
	 * <b> Permite consultar el syllabus de un determinado docente. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 01/03/2015]
	 * </p>
	 * 
	 * @param idDocente
	 * @return
	 * @throws DioneException
	 */
	public Syllabus consultarSyllabusByDocente(Integer idDocente) throws DioneException;
}
