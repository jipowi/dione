/**
 * 
 */
package ec.com.uce.dione.dao;

import java.util.List;

import javax.ejb.Local;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.entities.CompetenciasGenerica;

/**
 * <b> Interfaz local para realizar las operaciones necesarias en la tabla CompetenciasGenerica </b>
 * 
 * @author Anita Carrera
 * @version 1.0,29/12/2014
 * @since JDK1.6
 */
@Local
public interface CompetenciaGenericaDao extends GenericDAO<CompetenciasGenerica, Long> {

	/**
	 * 
	 * <b> Permite consultar las competencias por syllabus. </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 02/03/2015]
	 * </p>
	 * 
	 * @param idSyllabus
	 * @return
	 * @throws DioneException
	 */
	public List<CompetenciasGenerica> consultarCompGenricasBySyllabus(Integer idSyllabus) throws DioneException;
}
