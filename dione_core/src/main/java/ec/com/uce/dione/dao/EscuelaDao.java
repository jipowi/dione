/**
 * 
 */
package ec.com.uce.dione.dao;

import javax.ejb.Local;

import ec.com.uce.dione.entities.Escuela;

/**
 * <b> Interfaz local de la tabla Escuela para relaizar las operaciones necesarias sobre la base </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,29/12/2014
 * @since JDK1.6
 */
@Local
public interface EscuelaDao extends GenericDAO<Escuela, Integer> {

}
