/**
 * 
 */
package ec.com.uce.ejb.service;

import java.util.List;

import javax.ejb.Local;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.entities.MateriaUce;

/**
 * <b> Interfaz local para el servicio que permite manejar el syllabus. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,07/01/2015
 * @since JDK1.6
 */
@Local
public interface SyllabusService {

	/**
	 * 
	 * <b> Permite consultar las materias relacionadas a un docente </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 07/01/2015]
	 * </p>
	 * 
	 * @param idDocente
	 * @return
	 * @throws DioneException
	 */
	public List<MateriaUce> consultarMateriasByDocente(Integer idDocente) throws DioneException;

}
