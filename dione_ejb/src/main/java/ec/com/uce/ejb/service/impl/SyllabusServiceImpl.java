/**
 * 
 */
package ec.com.uce.ejb.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.dao.BibliografiaDao;
import ec.com.uce.dione.dao.CompetenciaDao;
import ec.com.uce.dione.dao.CompetenciaEspecificaDao;
import ec.com.uce.dione.dao.CompetenciaGenericaDao;
import ec.com.uce.dione.dao.CorequisitoDao;
import ec.com.uce.dione.dao.ElementoCompetenciaDao;
import ec.com.uce.dione.dao.EscuelaUceDao;
import ec.com.uce.dione.dao.MateriaSyllabusDao;
import ec.com.uce.dione.dao.MateriaUceDao;
import ec.com.uce.dione.dao.ObjetivoDao;
import ec.com.uce.dione.dao.PrerequisitoDao;
import ec.com.uce.dione.dao.ResultadoAprendizajeDao;
import ec.com.uce.dione.dao.SyllabusDao;
import ec.com.uce.dione.dao.UnidadCompetenciaDao;
import ec.com.uce.dione.entities.Bibliografia;
import ec.com.uce.dione.entities.CompetenciaGenerale;
import ec.com.uce.dione.entities.CompetenciasEspecifica;
import ec.com.uce.dione.entities.CompetenciasGenerica;
import ec.com.uce.dione.entities.Corequisito;
import ec.com.uce.dione.entities.ElementoCompetencia;
import ec.com.uce.dione.entities.EscuelaUce;
import ec.com.uce.dione.entities.MateriaSyllabus;
import ec.com.uce.dione.entities.MateriaUce;
import ec.com.uce.dione.entities.Objetivo;
import ec.com.uce.dione.entities.Prerequisito;
import ec.com.uce.dione.entities.ResultadosAprendizaje;
import ec.com.uce.dione.entities.Syllabus;
import ec.com.uce.dione.entities.UnidadCompetencia;
import ec.com.uce.ejb.service.SyllabusService;

/**
 * <b> Inplementacion del servicio para manejar las operaciones del syllabus. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,07/01/2015
 * @since JDK1.6
 */
@Stateless
public class SyllabusServiceImpl implements SyllabusService {

	@EJB
	private MateriaUceDao materiaUceDao;
	@EJB
	private SyllabusDao syllabusDao;
	@EJB
	private BibliografiaDao bibliografiaDao;
	@EJB
	private CompetenciaDao competenciaDao;
	@EJB
	private UnidadCompetenciaDao unidadCompetenciaDao;
	@EJB
	private ElementoCompetenciaDao elementoCompetenciaDao;
	@EJB
	private ResultadoAprendizajeDao resultadoAprendizajeDao;
	@EJB
	private ObjetivoDao objetivoDao;
	@EJB
	private EscuelaUceDao escuelaUceDao;
	@EJB
	private PrerequisitoDao prerequisitoDao;
	@EJB
	private CorequisitoDao corequisitoDao;
	@EJB
	private MateriaSyllabusDao materiaSyllabusDao;
	@EJB
	private CompetenciaGenericaDao competenciaGenericaDao;
	@EJB
	private CompetenciaEspecificaDao competenciaEspecificaDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.uce.ejb.service.SyllabusService#consultarMateriaById(java.lang.Integer)
	 */
	@Override
	public MateriaUce consultarMateriaById(Integer idMateria) throws DioneException {
		return materiaUceDao.findById(idMateria);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.uce.ejb.service.SyllabusService#guardarSyllabus(ec.com.uce.dione.entities.Syllabus, java.util.List, java.util.List, java.util.List,
	 * java.util.List)
	 */
	@Override
	public void guardarSyllabus(Syllabus syllabus, List<Objetivo> objetivos, List<CompetenciaGenerale> competencias, List<Bibliografia> bibliografias,
			List<ResultadosAprendizaje> resultados, List<UnidadCompetencia> unidades) throws DioneException {

		syllabusDao.persist(syllabus);

		for (Objetivo objetivo : objetivos) {
			objetivo.setSyllabus(syllabus);
			objetivoDao.persist(objetivo);
		}
		for (ResultadosAprendizaje resultadosAprendizaje : resultados) {
			resultadosAprendizaje.setSyllabus(syllabus);
			resultadoAprendizajeDao.persist(resultadosAprendizaje);
		}
		for (CompetenciaGenerale competencia : competencias) {
			competencia.setSyllabus(syllabus);
			competenciaDao.persist(competencia);
		}
		for (Bibliografia bibliografia : bibliografias) {
			bibliografia.setSyllabus(syllabus);
			bibliografiaDao.persist(bibliografia);
		}

		for (UnidadCompetencia unidad : unidades) {
			unidad.setSyllabus(syllabus);
			unidadCompetenciaDao.persist(unidad);
			for (ElementoCompetencia elemento : unidad.getElementoCompetencias()) {
				elemento.setUnidadCompetencia(unidad);
				elementoCompetenciaDao.persist(elemento);
			}
		}

		for (MateriaSyllabus materiaSyllabus : syllabus.getMateriaSyllabuses()) {
			materiaSyllabus.setSyllabus(syllabus);
			materiaSyllabusDao.persist(materiaSyllabus);
		}

		for (CompetenciasGenerica competenciasGenerica : syllabus.getCompetenciasGenericas()) {
			competenciasGenerica.setSyllabus(syllabus);
			competenciaGenericaDao.persist(competenciasGenerica);
		}

		for (CompetenciasEspecifica competencia : syllabus.getCompetenciasEspecificas()) {
			competencia.setSyllabus(syllabus);
			competenciaEspecificaDao.persist(competencia);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.uce.ejb.service.SyllabusService#consultarEscuelaById(java.lang.String)
	 */
	@Override
	public EscuelaUce consultarEscuelaById(String idEscuela) throws DioneException {
		return escuelaUceDao.findById(Integer.parseInt(idEscuela));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.uce.ejb.service.SyllabusService#consultarEscuelaByDocente(java.lang.String)
	 */
	@Override
	public List<EscuelaUce> consultarEscuelaByDocente(String idDocente) throws DioneException {
		return escuelaUceDao.consultarEscuelaByDocente(idDocente);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.uce.ejb.service.SyllabusService#consultarMateriasByEscuela(java.lang.Integer)
	 */
	@Override
	public List<MateriaUce> consultarMateriasByEscuela(Integer idEscuela) throws DioneException {
		return materiaUceDao.consultarMateriasByEscuela(idEscuela);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.uce.ejb.service.SyllabusService#conusltarObjetivos(java.lang.Integer)
	 */
	@Override
	public List<Objetivo> conusltarObjetivos(Integer idSyllabus) throws DioneException {
		return objetivoDao.consultarObjetivos(idSyllabus);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.uce.ejb.service.SyllabusService#consultarResultadosAprendizaje(java.lang.Integer)
	 */
	@Override
	public List<ResultadosAprendizaje> consultarResultadosAprendizaje(Integer idSyllabus) throws DioneException {
		return resultadoAprendizajeDao.consultarResultadosAprendizaje(idSyllabus);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.uce.ejb.service.SyllabusService#consultarCompetenciasBySyllabus(java.lang.Integer)
	 */
	@Override
	public List<CompetenciaGenerale> consultarCompetenciasBySyllabus(Integer idSyllabus) throws DioneException {
		return competenciaDao.consultarCompetenciasBySyllabus(idSyllabus);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.uce.ejb.service.SyllabusService#actualizarObjetivos(java.util.List)
	 */
	@Override
	public void actualizarObjetivos(List<Objetivo> objetivos) throws DioneException {
		for (Objetivo objetivo : objetivos) {
			objetivoDao.update(objetivo);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.uce.ejb.service.SyllabusService#actualizarResultados(java.util.List)
	 */
	@Override
	public void actualizarResultados(List<ResultadosAprendizaje> resultados) throws DioneException {
		for (ResultadosAprendizaje resultadosAprendizaje : resultados) {
			resultadoAprendizajeDao.update(resultadosAprendizaje);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.uce.ejb.service.SyllabusService#obtenerPrerequisitos(java.lang.Integer)
	 */
	@Override
	public List<Prerequisito> obtenerPrerequisitos(Integer idMateria) throws DioneException {
		return prerequisitoDao.consultarPreByMateria(idMateria);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.uce.ejb.service.SyllabusService#obtenerCorequisitos(java.lang.Integer)
	 */
	@Override
	public List<Corequisito> obtenerCorequisitos(Integer idMateria) throws DioneException {
		return corequisitoDao.consultarCorequisitoByMateria(idMateria);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.uce.ejb.service.SyllabusService#consultarSyllabusByDocente(java.lang.Integer)
	 */
	@Override
	public Syllabus consultarSyllabusByDocente(Integer idDocente) throws DioneException {
		return syllabusDao.consultarSyllabusByDocente(idDocente);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.uce.ejb.service.SyllabusService#consultarMateriaSyllabusBySyllabus(java.lang.Integer)
	 */
	@Override
	public MateriaSyllabus consultarMateriaSyllabusBySyllabus(Integer idSyllabus) throws DioneException {
		return materiaSyllabusDao.consultarMateriaSyllabusBySyllabus(idSyllabus);
	}
}
