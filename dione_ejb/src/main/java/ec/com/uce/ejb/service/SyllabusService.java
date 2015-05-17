package ec.com.uce.ejb.service;

import java.util.List;

import javax.ejb.Local;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.entities.Bibliografia;
import ec.com.uce.dione.entities.CompetenciaGenerale;
import ec.com.uce.dione.entities.CompetenciasEspecifica;
import ec.com.uce.dione.entities.CompetenciasGenerica;
import ec.com.uce.dione.entities.Corequisito;
import ec.com.uce.dione.entities.Cumplimiento;
import ec.com.uce.dione.entities.EscuelaUce;
import ec.com.uce.dione.entities.MateriaSyllabus;
import ec.com.uce.dione.entities.MateriaUce;
import ec.com.uce.dione.entities.Objetivo;
import ec.com.uce.dione.entities.Prerequisito;
import ec.com.uce.dione.entities.ResultadosAprendizaje;
import ec.com.uce.dione.entities.Syllabus;
import ec.com.uce.dione.entities.UnidadCompetencia;
import ec.com.uce.ejb.dto.UnidadCompetenciaDTO;

/**
 * <b> Interfaz local para el servicio que permite manejar el syllabus. </b>
 * 
 * @author Anita Carrera
 * @version 1.0,07/01/2015
 * @since JDK1.6
 */
@Local
public interface SyllabusService {

	/**
	 * 
	 * <b> Permite consultar una escuela por </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 14/01/2015]
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
	 * [Author: Anita Carrera, Date: 14/01/2015]
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
	 * [Author: Anita Carrera, Date: 14/01/2015]
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
	 * [Author: Anita Carrera, Date: 14/01/2015]
	 * </p>
	 * 
	 * @param idEscuela
	 * @return
	 * @throws DioneException
	 */
	public List<MateriaUce> consultarMateriasByEscuela(Integer idEscuela) throws DioneException;

	/**
	 * 
	 * <b> Permite guardar el syllabus </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 14/01/2015]
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
	 * <b> Permite guardar el cumplimiento y actualizar los valor de los objetivos, condiciones y resultados. </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 03/04/2015]
	 * </p>
	 * 
	 * @param objetivos
	 * @param competenciasGenerales
	 * @param resultados
	 * @param cumplimiento
	 * @throws DioneException
	 */
	public void guardarCumplimiento(List<Objetivo> objetivos, List<CompetenciaGenerale> competenciasGenerales, List<ResultadosAprendizaje> resultados, Cumplimiento cumplimiento)
			throws DioneException;

	/**
	 * 
	 * <b> Permite consultar los objetivos correspondientes a un syllabus </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 23/01/2015]
	 * </p>
	 * 
	 * @param idSyllabus
	 * @return
	 * @throws DioneException
	 */
	public List<Objetivo> consultarObjetivos(Integer idSyllabus) throws DioneException;

	/**
	 * 
	 * <b> Permite consultar los resultados de aprendizaje correspondientes a un syllabus. </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 23/01/2015]
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
	 * [Author: Anita Carrera, Date: 23/01/2015]
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
	 * [Author: Anita Carrera, Date: 25/01/2015]
	 * </p>
	 * 
	 * @param objetivos
	 * @throws DioneException
	 */
	public void actualizarObjetivos(List<Objetivo> objetivos) throws DioneException;

	/**
	 * 
	 * <b> Permite actualizar las competencias. </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 25/01/2015]
	 * </p>
	 * 
	 * @param objetivos
	 * @throws DioneException
	 */
	public void actualizarCompetenciasGenerales(List<CompetenciaGenerale> competencias) throws DioneException;

	/**
	 * 
	 * <b> Permite actualizar el registro de los resultados en la tabla. </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 25/01/2015]
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
	 * [Author: Anita Carrera, Date: 11/02/2015]
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
	 * [Author: Anita Carrera, Date: 11/02/2015]
	 * </p>
	 * 
	 * @param idMateria
	 * @return
	 * @throws DioneException
	 */
	public List<Prerequisito> obtenerPrerequisitos(Integer idMateria) throws DioneException;

	/**
	 * 
	 * <b> Permite consultar el syllabus por un medio de un docente. </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 02/03/2015]
	 * </p>
	 * 
	 * @param idDocente
	 * @return
	 * @throws DioneException
	 */
	public Syllabus consultarSyllabusByDocente(Integer idDocente) throws DioneException;

	/**
	 * 
	 * <b> Permite consultar la materia y el syllabus de la tabla MateriaSyllabus. </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 02/03/2015]
	 * </p>
	 * 
	 * @param idSyllabus
	 * @return
	 * @throws DioneException
	 */
	public MateriaSyllabus consultarMateriaSyllabusBySyllabus(Integer idSyllabus) throws DioneException;

	/**
	 * 
	 * <b> Permite consultar Materia syllabus por id. </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 08/04/2015]
	 * </p>
	 * 
	 * @param idMateriaSyllabus
	 * @return
	 * @throws DioneException
	 */
	public MateriaSyllabus consultarMateriaSyllabusById(Integer idMateriaSyllabus) throws DioneException;

	/**
	 * 
	 * <b> Permite consultar las competencias por syllabus. </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 02/03/2015]
	 * </p>
	 * 
	 * @param idSyllabus
	 * @return
	 * @throws DioneException
	 */
	public List<CompetenciasGenerica> consultarCompGenricasBySyllabus(Integer idSyllabus) throws DioneException;

	/**
	 * 
	 * <b> Permiete consultar las competencias especificas por syllabus. </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 02/03/2015]
	 * </p>
	 * 
	 * @param idSyllabus
	 * @return
	 * @throws DioneException
	 */
	public List<CompetenciasEspecifica> consultarCompEspecificaBySyllabus(Integer idSyllabus) throws DioneException;

	/**
	 * 
	 * <b> Permite consultar las bibliografias por syllabus. </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 03/03/2015]
	 * </p>
	 * 
	 * @param idSyllabus
	 * @return
	 * @throws DioneException
	 */
	public List<Bibliografia> consultarBibliografiasBySyllabus(Integer idSyllabus) throws DioneException;

	/**
	 * 
	 * <b> Permite consultar las unidades de competencia y sus elementos por medio del syllabus </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 03/03/2015]
	 * </p>
	 * 
	 * @param idSyllabus
	 * @return
	 * @throws DioneException
	 */
	public List<UnidadCompetenciaDTO> consultarUnidadesDTO(Integer idSyllabus) throws DioneException;

	/**
	 * 
	 * <b> Permite consultar el syllabus de un docente por medio de la materia y el codigo de docente. </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 10/03/2015]
	 * </p>
	 * 
	 * @param idDocente
	 * @param idMateria
	 * @return
	 * @throws DioneException
	 */
	public MateriaSyllabus consultarSyllabus(Integer idDocente, Integer idMateria) throws DioneException;

	/**
	 * 
	 * <b> Permite consultar el syllabus por el id. </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 10/03/2015]
	 * </p>
	 * 
	 * @param idSyllabus
	 * @return
	 * @throws DioneException
	 */
	public Syllabus consultarSyllabusById(Integer idSyllabus) throws DioneException;

	/**
	 * 
	 * <b> Permite consultar el complimiento por materiaSyllabus. </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 08/04/2015]
	 * </p>
	 * 
	 * @param idMateriaSyllabus
	 * @return
	 * @throws DioneException
	 */
	public Cumplimiento consultarCumplimientoByMatSyllabus(Integer idMateriaSyllabus) throws DioneException;
}
