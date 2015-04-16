/**
 * 
 */
package ec.com.uce.dione.dao;

import java.util.List;

import javax.ejb.Local;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.entities.DocumentoDocente;

/**
 * <b> Interfaz local para realizar las operaciones necesarias en la tabla Cumplimiento </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,29/12/2014
 * @since JDK1.6
 */
@Local
public interface DocenteDocumentoDao extends GenericDAO<DocumentoDocente, Integer> {

	/**
	 * 
	 * <b> Permite consultar los documentos que el docente tiene subidos en el servidor. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 15/04/2015]
	 * </p>
	 * 
	 * @param idDocente
	 * @return
	 * @throws DioneException
	 */
	public List<DocumentoDocente> consultarDocumentos(Integer idDocente) throws DioneException;

}
