/**
 * 
 */
package ec.com.uce.dione.dao;

import java.util.List;

import javax.ejb.Local;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.entities.ElementoCompetencia;

/**
 * <b> Interfaz local para realizar las operaciones necesarias en la tabla ElementoCompetencia </b>
 * 
 * @author Anita Carrera
 * @version 1.0,29/12/2014
 * @since JDK1.6
 */
@Local
public interface ElementoCompetenciaDao extends GenericDAO<ElementoCompetencia, Long> {

	/**
	 * 
	 * <b> Permite consultar los elementos de competencia por unidad. </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 03/03/2015]
	 * </p>
	 * 
	 * @param idUnidad
	 * @return
	 * @throws DioneException
	 */
	public List<ElementoCompetencia> consultarElementoByUnidad(Integer idUnidad) throws DioneException;
}
