/**
 * 
 */
package ec.com.uce.dione.dao;

import java.util.List;

import javax.ejb.Local;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.entities.CompetenciasEspecifica;

/**
 * <b> Interfaz local para realizar las operaciones necesarias en la tabla CompetenciasEspecifica </b>
 * 
 * @author Anita Carrera
 * @version 1.0,29/12/2014
 * @since JDK1.6
 */
@Local
public interface CompetenciaEspecificaDao extends GenericDAO<CompetenciasEspecifica, Long> {

	/**
	 * 
	 * <b> Permiete consultar las competencias especificas por syllabus. </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 02/03/2015]
	 * </p>
	 * 
	 * @param idSyllabus
	 * @return
	 * @throws DioneException
	 */
	public List<CompetenciasEspecifica> consultarCompEspecificaBySyllabus(Integer idSyllabus) throws DioneException;
}
