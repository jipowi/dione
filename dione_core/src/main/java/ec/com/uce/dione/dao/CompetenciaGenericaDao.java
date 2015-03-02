/**
 * 
 */
package ec.com.uce.dione.dao;

import javax.ejb.Local;

import ec.com.uce.dione.entities.CompetenciasGenerica;

/**
 * <b> Interfaz local para realizar las operaciones necesarias en la tabla CompetenciasGenerica </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,29/12/2014
 * @since JDK1.6
 */
@Local
public interface CompetenciaGenericaDao extends GenericDAO<CompetenciasGenerica, Long> {

}
