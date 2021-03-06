/**
 * 
 */
package ec.com.uce.ejb.service;

import java.util.List;

import javax.ejb.Local;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.entities.ArchivoBase;
import ec.com.uce.dione.entities.Docente;
import ec.com.uce.dione.entities.DocumentoDocente;
import ec.com.uce.dione.entities.Escuela;
import ec.com.uce.dione.entities.EscuelaUce;
import ec.com.uce.dione.entities.Experiencia;
import ec.com.uce.dione.entities.FormacionAcademica;
import ec.com.uce.dione.entities.FormacionContinua;
import ec.com.uce.dione.entities.Materia;
import ec.com.uce.dione.entities.MateriaUce;

/**
 * <b> Servicio de interface local para realizar las operaciones necesarias. </b>
 * 
 * @author Anita Carrera
 * @version 1.0,29/12/2014
 * @since JDK1.6
 */
@Local
public interface DocenteService {

	/**
	 * 
	 * <b> Permite concsultar las escuelas por medio de la descripcion. </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 19/03/2015]
	 * </p>
	 * 
	 * @param escuela
	 * @return
	 * @throws DioneException
	 */
	public List<EscuelaUce> consultarEscuelas(String escuela) throws DioneException;

	/**
	 * 
	 * <b> Permite consultar docente por medio del codigo de docente. </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 19/03/2015]
	 * </p>
	 * 
	 * @param idDocente
	 * @throws DioneException
	 */
	public Docente consultarDocenteById(Integer idDocente) throws DioneException;

	/**
	 * 
	 * <b> Permite consultar las escuelas que se encuentran registradas en la base de datos. </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 29/12/2014]
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
	 * [Author: Anita Carrera, Date: 29/12/2014]
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
	 * [Author: Anita Carrera, Date: 01/01/2015]
	 * </p>
	 * 
	 * @param escuela
	 * @return
	 * @throws DioneException
	 */
	public Escuela consultarEscuelaById(Integer escuela) throws DioneException;

	/**
	 * 
	 * <b> Permite consultar la escuela por el Id. </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 09/02/2015]
	 * </p>
	 * 
	 * @param escuela
	 * @return
	 * @throws DioneException
	 */
	public EscuelaUce consultarEscuelaUceById(Integer escuela) throws DioneException;

	/**
	 * 
	 * <b> Permite guardar la informacion del docente en la base de datos </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 05/01/2015]
	 * </p>
	 * 
	 * @param docente
	 * @throws DioneException
	 */
	public void guardarDocente(Docente docente, List<MateriaUce> materias) throws DioneException;

	/**
	 * 
	 * <b> Permite consultar un docente por medio de la cedula </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 05/01/2015]
	 * </p>
	 * 
	 * @param cedula
	 * @return
	 * @throws DioneException
	 */
	public Docente consultarDocenteByCedula(String cedula) throws DioneException;

	/**
	 * 
	 * <b> Permite guardar la hoja de vida del docente </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 04/03/2015]
	 * </p>
	 * 
	 * @param docente
	 * @param formacionAcademicas
	 * @param formacionContinuas
	 * @param experiencias
	 * @throws DioneException
	 */
	public void guardarHojaVida(Docente docente, List<FormacionAcademica> formacionAcademicas, List<FormacionContinua> formacionContinuas, List<Experiencia> experiencias)
			throws DioneException;

	/**
	 * 
	 * <b> Permite consultar la lista de formaciones academicas que tiene un docente </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 09/02/2015]
	 * </p>
	 * 
	 * @param idDocente
	 * @return
	 * @throws DioneException
	 */
	public List<FormacionAcademica> consultarFormacionAByDocente(Integer idDocente) throws DioneException;

	/**
	 * 
	 * <b> Permite consultar la lista de formaciones continuas que tiene un docente </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 09/02/2015]
	 * </p>
	 * 
	 * @param idDocente
	 * @return
	 * @throws DioneException
	 */
	public List<FormacionContinua> consultarFormacionCByDocente(Integer idDocente) throws DioneException;

	/**
	 * 
	 * <b> Permite consultar las experiencias del docente. </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 09/03/2015]
	 * </p>
	 * 
	 * @param idDocente
	 * @return
	 */
	public List<Experiencia> consultarExperienciasByDocente(Integer idDocente) throws DioneException;

	/**
	 * 
	 * <b> Permite consultar los documentos que el docente tiene subidos en el servidor. </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 15/04/2015]
	 * </p>
	 * 
	 * @param idDocente
	 * @return
	 * @throws DioneException
	 */
	public List<DocumentoDocente> consultarDocumentos(Integer idDocente) throws DioneException;

	/**
	 * 
	 * <b> Permite realizar el guardado de los documentos subidos por el docente. </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 16/04/2015]
	 * </p>
	 * 
	 * @param documentos
	 * @throws DioneException
	 */
	public void guardarDocumentos(List<DocumentoDocente> documentos) throws DioneException;

	/**
	 * 
	 * <b> Permite consultar el archivo por medio de la llave primaria. </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 20/04/2015]
	 * </p>
	 * 
	 * @param idArchivo
	 * @throws DioneException
	 */
	public ArchivoBase consultarArchivoById(Integer idArchivo) throws DioneException;

}
