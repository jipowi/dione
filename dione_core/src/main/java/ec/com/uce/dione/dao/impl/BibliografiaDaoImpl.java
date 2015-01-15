/**
 * 
 */
package ec.com.uce.dione.dao.impl;

import javax.ejb.Stateless;

import ec.com.uce.dione.dao.BibliografiaDao;
import ec.com.uce.dione.entities.Bibliografia;

/**
 * <b> Implementacion de la interfaz para realizar operaciones sobre la tabla Bibliografia. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,05/01/2015
 * @since JDK1.6
 */
@Stateless
public class BibliografiaDaoImpl extends GenericDAOImpl<Bibliografia, Long> implements BibliografiaDao {

}
