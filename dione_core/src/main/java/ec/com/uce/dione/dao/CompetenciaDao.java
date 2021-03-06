/**
 * 
 */
package ec.com.uce.dione.dao;

import java.util.List;

import javax.ejb.Local;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.entities.CompetenciaGenerale;

/**
 * <b> Interfaz local para realizar las operaciones necesarias en la tabla Competencia </b>
 * 
 * @author Anita Carrera
 * @version 1.0,29/12/2014
 * @since JDK1.6
 */
@Local
public interface CompetenciaDao extends GenericDAO<CompetenciaGenerale, Long> {

	/**
	 * 
	 * <b> Permite consultar las competencias correspondientes a un syllabus. </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 23/01/2015]
	 * </p>
	 * 
	 * @param idSyllabus
	 * @return
	 * @throws DioneException
	 */
	public List<CompetenciaGenerale> consultarCompetenciasBySyllabus(Integer idSyllabus) throws DioneException;
}
