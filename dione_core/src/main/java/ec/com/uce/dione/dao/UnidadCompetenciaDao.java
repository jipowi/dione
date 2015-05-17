/**
 * 
 */
package ec.com.uce.dione.dao;

import java.util.List;

import javax.ejb.Local;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.entities.UnidadCompetencia;

/**
 * <b> Interfaz local para realizar las operaciones necesarias en la tabla UnidadCompetencia </b>
 * 
 * @author Anita Carrera
 * @version 1.0,29/12/2014
 * @since JDK1.6
 */
@Local
public interface UnidadCompetenciaDao extends GenericDAO<UnidadCompetencia, Integer> {

	/**
	 * 
	 * <b> Permite consutar las unidades de competencia de un determinado sylalbus. </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 03/03/2015]
	 * </p>
	 * 
	 * @param idSyllabus
	 * @return
	 * @throws DioneException
	 */
	public List<UnidadCompetencia> consultarUnidadesBySyllabus(Integer idSyllabus) throws DioneException;
}
