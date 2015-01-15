/**
 * 
 */
package ec.com.uce.dione.dao.impl;

import javax.ejb.Stateless;

import ec.com.uce.dione.dao.CompetenciaDao;
import ec.com.uce.dione.entities.Competencia;

/**
 * <b> Implementacion de la interfaz para realizar operaciones sobre la tabla Competencia. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,05/01/2015
 * @since JDK1.6
 */
@Stateless
public class CompetenciaDaoImpl extends GenericDAOImpl<Competencia, Long> implements CompetenciaDao {

}
