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
public interface SyllabusDao extends GenericDAO<Syllabus, Long> {

	/**
	 * 
	 * <b> Permite consutlar un syllabus por docente y materia </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 21/01/2015]
	 * </p>
	 * 
	 * @param idDocente
	 * @param idMateria
	 * @return
	 * @throws DioneException
	 */
	public Syllabus consultarSyllabusByDocenteAndMateria(Long idDocente, Long idMateria) throws DioneException;
}
