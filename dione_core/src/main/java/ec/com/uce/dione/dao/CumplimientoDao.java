/**
 * 
 */
package ec.com.uce.dione.dao;

import javax.ejb.Local;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.entities.Cumplimiento;

/**
 * <b> Interfaz local para realizar las operaciones necesarias en la tabla Cumplimiento </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,29/12/2014
 * @since JDK1.6
 */
@Local
public interface CumplimientoDao extends GenericDAO<Cumplimiento, Integer> {

	/**
	 * 
	 * <b> Permite consultar el complimiento por materiaSyllabus. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 08/04/2015]
	 * </p>
	 * 
	 * @param idMateriaSyllabus
	 * @return
	 * @throws DioneException
	 */
	public Cumplimiento consultarCumplimientoByMatSyllabus(Integer idMateriaSyllabus) throws DioneException;
}
