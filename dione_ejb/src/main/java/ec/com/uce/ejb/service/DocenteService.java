/**
 * 
 */
package ec.com.uce.ejb.service;

import java.util.List;

import javax.ejb.Local;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.entities.Docente;
import ec.com.uce.dione.entities.Escuela;
import ec.com.uce.dione.entities.Materia;

/**
 * <b> Servicio de interface local para realizar las operaciones necesarias. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,29/12/2014
 * @since JDK1.6
 */
@Local
public interface DocenteService {

	/**
	 * 
	 * <b> Permite consultar las escuelas que se encuentran registradas en la base de datos. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 29/12/2014]
	 * </p>
	 * 
	 * @return
	 * @throws DioneException
	 */
	public List<Escuela> consultarEscuelas() throws DioneException;

	/**
	 * 
	 * <b> Permite consultar las materias asignadas a una escuela </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 29/12/2014]
	 * </p>
	 * 
	 * @param idEscuela
	 * @return
	 * @throws DioneException
	 */
	public List<Materia> consultarMateriasByEscuela(Integer idEscuela) throws DioneException;

	/**
	 * 
	 * <b> Permite consultar una escuela por medio del codigo </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 01/01/2015]
	 * </p>
	 * 
	 * @param escuela
	 * @return
	 * @throws DioneException
	 */
	public Escuela consultarEscuelaById(Long escuela) throws DioneException;

	/**
	 * 
	 * <b> Permite guardar la informacion del docente en la base de datos </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 05/01/2015]
	 * </p>
	 * 
	 * @param docente
	 * @throws DioneException
	 */
	public void guardarDocente(Docente docente) throws DioneException;

	/**
	 * 
	 * <b> Permite consultar un docente por medio de la cedula </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 05/01/2015]
	 * </p>
	 * 
	 * @param cedula
	 * @return
	 * @throws DioneException
	 */
	public Docente consultarDocenteByCedula(String cedula) throws DioneException;

}
