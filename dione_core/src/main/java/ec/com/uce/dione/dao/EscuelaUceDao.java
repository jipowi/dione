/**
 * 
 */
package ec.com.uce.dione.dao;

import javax.ejb.Local;

import ec.com.uce.dione.entities.EscuelaUce;

/**
 * <b> Interfaz local para realizar las operaciones sobre la tabla EscuelaUce. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,05/01/2015
 * @since JDK1.6
 */
@Local
public interface EscuelaUceDao extends GenericDAO<EscuelaUce, Long> {

}
