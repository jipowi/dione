/**
 * 
 */
package ec.com.uce.ejb.service;

import java.util.List;

import javax.ejb.Local;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.entities.Bibliografia;
import ec.com.uce.dione.entities.CompetenciaGenerale;
import ec.com.uce.dione.entities.Corequisito;
import ec.com.uce.dione.entities.EscuelaUce;
import ec.com.uce.dione.entities.MateriaUce;
import ec.com.uce.dione.entities.Objetivo;
import ec.com.uce.dione.entities.Prerequisito;
import ec.com.uce.dione.entities.ResultadosAprendizaje;
import ec.com.uce.dione.entities.Syllabus;
import ec.com.uce.dione.entities.UnidadCompetencia;

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
	 * <b> Permite consultar una escuela por </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 14/01/2015]
	 * </p>
	 * 
	 * @param idEscuela
	 * @throws DioneException
	 */
	public EscuelaUce consultarEscuelaById(String idEscuela) throws DioneException;

	/**
	 * 
	 * <b> Permite consultar las escuelas en las que se encuetra el docente </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 14/01/2015]
	 * </p>
	 * 
	 * @return
	 * @throws DioneException
	 */
	public List<EscuelaUce> consultarEscuelaByDocente(String idDocente) throws DioneException;

	/**
	 * 
	 * <b> Permite consultar la materia por medio del id </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 14/01/2015]
	 * </p>
	 * 
	 * @param idMateria
	 * @return
	 * @throws DioneException
	 */
	public MateriaUce consultarMateriaById(Integer idMateria) throws DioneException;

	/**
	 * 
	 * <b> Permite consultar las materias correspondientes a una determinada escuela. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 14/01/2015]
	 * </p>
	 * 
	 * @param idEscuela
	 * @return
	 * @throws DioneException
	 */
	public List<MateriaUce> consultarMateriasByEscuela(Long idEscuela) throws DioneException;

	/**
	 * 
	 * <b> Permite guardar el syllabus </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 14/01/2015]
	 * </p>
	 * 
	 * @param syllabus
	 * @param objetivos
	 * @param competencias
	 * @param bibliografias
	 * @param resultados
	 * @throws DioneException
	 */
	public void guardarSyllabus(Syllabus syllabus, List<Objetivo> objetivos, List<CompetenciaGenerale> competencias, List<Bibliografia> bibliografias,
			List<ResultadosAprendizaje> resultados, List<UnidadCompetencia> unidades) throws DioneException;

	/**
	 * 
	 * <b> Permite consutlar un syllabus por docente y materia </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 21/01/2015]
	 * </p>
	 * 
	 * @param idDocente
	 * @param idMateria
	 * @return
	 * @throws DioneException
	 */
	public Syllabus consultarSyllabusByDocenteAndMateria(Long idDocente, Long idMateria) throws DioneException;

	/**
	 * 
	 * <b> Permite consultar los objetivos correspondientes a un syllabus </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 23/01/2015]
	 * </p>
	 * 
	 * @param idSyllabus
	 * @return
	 * @throws DioneException
	 */
	public List<Objetivo> conusltarObjetivos(Integer idSyllabus) throws DioneException;

	/**
	 * 
	 * <b> Permite consultar los resultados de aprendizaje correspondientes a un syllabus. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 23/01/2015]
	 * </p>
	 * 
	 * @param idSyllabus
	 * @return
	 * @throws DioneException
	 */
	public List<ResultadosAprendizaje> consultarResultadosAprendizaje(Integer idSyllabus) throws DioneException;

	/**
	 * 
	 * <b> Permite consultar las competencias correspondientes a un syllabus. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 23/01/2015]
	 * </p>
	 * 
	 * @param idSyllabus
	 * @return
	 * @throws DioneException
	 */
	public List<CompetenciaGenerale> consultarCompetenciasBySyllabus(Integer idSyllabus) throws DioneException;

	/**
	 * 
	 * <b> Permite actualizar los objetivos. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 25/01/2015]
	 * </p>
	 * 
	 * @param objetivos
	 * @throws DioneException
	 */
	public void actualizarObjetivos(List<Objetivo> objetivos) throws DioneException;

	/**
	 * 
	 * <b> Permite actualizar el registro de los resultados en la tabla. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 25/01/2015]
	 * </p>
	 * 
	 * @param resultados
	 * @throws DioneException
	 */
	public void actualizarResultados(List<ResultadosAprendizaje> resultados) throws DioneException;

	/**
	 * 
	 * <b> Permite obtener los corequisitos por materia seleccionada </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 11/02/2015]
	 * </p>
	 * 
	 * @param idMateria
	 * @return
	 * @throws DioneException
	 */
	public List<Corequisito> obtenerCorequisitos(Integer idMateria) throws DioneException;

	/**
	 * 
	 * <b> Permite obtener los prerequisitos por materia seleccionada </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 11/02/2015]
	 * </p>
	 * 
	 * @param idMateria
	 * @return
	 * @throws DioneException
	 */
	public List<Prerequisito> obtenerPrerequisitos(Integer idMateria) throws DioneException;
}
