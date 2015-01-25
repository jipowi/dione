/**
 * 
 */
package ec.com.uce.dione.dao;

import java.util.List;

import javax.ejb.Local;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.entities.ResultadosAprendizaje;

/**
 * <b> Interfaz local para realizar las operaciones necesarias en la tabla ResultadosAprendizaje </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,29/12/2014
 * @since JDK1.6
 */
@Local
public interface ResultadoAprendizajeDao extends GenericDAO<ResultadosAprendizaje, Long> {

	/**
	 * 
	 * <b> Permite consultar los resultados de aprendizaje correspondientes a un syllabus. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 23/01/2015]
	 * </p>
	 * 
	 * @param idSyllabus
	 * @return
	 * @throws DioneException
	 */
	public List<ResultadosAprendizaje> consultarResultadosAprendizaje(Integer idSyllabus) throws DioneException;
}
