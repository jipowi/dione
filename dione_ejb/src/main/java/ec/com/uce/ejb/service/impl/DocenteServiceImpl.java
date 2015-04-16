/**
 * 
 */
package ec.com.uce.ejb.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.dao.DocenteDao;
import ec.com.uce.dione.dao.DocenteDocumentoDao;
import ec.com.uce.dione.dao.EscuelaDao;
import ec.com.uce.dione.dao.EscuelaUceDao;
import ec.com.uce.dione.dao.ExperienciaDao;
import ec.com.uce.dione.dao.FormacionADao;
import ec.com.uce.dione.dao.FormacionCDao;
import ec.com.uce.dione.dao.MateriaDao;
import ec.com.uce.dione.dao.MateriaUceDao;
import ec.com.uce.dione.entities.Docente;
import ec.com.uce.dione.entities.DocumentoDocente;
import ec.com.uce.dione.entities.Escuela;
import ec.com.uce.dione.entities.EscuelaUce;
import ec.com.uce.dione.entities.Experiencia;
import ec.com.uce.dione.entities.FormacionAcademica;
import ec.com.uce.dione.entities.FormacionContinua;
import ec.com.uce.dione.entities.Materia;
import ec.com.uce.dione.entities.MateriaUce;
import ec.com.uce.ejb.service.DocenteService;

/**
 * <b> Implementacion de la interfaz local. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,29/12/2014
 * @since JDK1.6
 */
@Stateless
public class DocenteServiceImpl implements DocenteService {

	@EJB
	private EscuelaDao escuelaDao;
	@EJB
	private MateriaDao materiaDao;
	@EJB
	private EscuelaUceDao escuelaUceDao;
	@EJB
	private MateriaUceDao materiaUceDao;
	@EJB
	private DocenteDao docenteDao;
	@EJB
	private FormacionADao formacionADao;
	@EJB
	private FormacionCDao formacionCDao;
	@EJB
	private ExperienciaDao experienciaDao;
	@EJB
	private DocenteDocumentoDao docenteDocumentoDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.uce.ejb.service.DocenteService#consultarEscuelas()
	 */
	@Override
	public List<Escuela> consultarEscuelas() throws DioneException {
		return escuelaDao.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.uce.ejb.service.DocenteService#consultarMateriasByEscuela(java.lang.Integer)
	 */
	@Override
	public List<Materia> consultarMateriasByEscuela(Integer idEscuela) throws DioneException {

		return materiaDao.consultarMateriaByEscuela(idEscuela);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.uce.ejb.service.DocenteService#consultarEscuelaById(java.lang.Long)
	 */
	@Override
	public Escuela consultarEscuelaById(Integer escuela) throws DioneException {
		return escuelaDao.findById(escuela);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.uce.ejb.service.DocenteService#guardarDocente(ec.com.uce.dione.entities.Docente)
	 */
	@Override
	public void guardarDocente(Docente docente, List<MateriaUce> materias) throws DioneException {
		docenteDao.persist(docente);
		if (!docente.getEscuelaUces().isEmpty()) {
			for (EscuelaUce escuelaUce : docente.getEscuelaUces()) {
				escuelaUceDao.persist(escuelaUce);
				for (MateriaUce materiaUce : materias) {
					materiaUce.setEscuelaUce(escuelaUce);
					materiaUceDao.persist(materiaUce);
				}
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.uce.ejb.service.DocenteService#consultarDocenteByCedula(java.lang.String)
	 */
	@Override
	public Docente consultarDocenteByCedula(String cedula) throws DioneException {
		return docenteDao.cosultarDocenteByCedula(cedula);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.uce.ejb.service.DocenteService#guardarHojaVida(java.util.List, java.util.List)
	 */
	@Override
	public void guardarHojaVida(Docente docente, List<FormacionAcademica> formacionAcademicas, List<FormacionContinua> formacionContinuas, List<Experiencia> experiencias)
			throws DioneException {
		for (FormacionContinua formacionContinua : formacionContinuas) {
			formacionContinua.setDocente(docente);
			formacionCDao.persist(formacionContinua);
		}
		for (FormacionAcademica formacionAcademinca : formacionAcademicas) {
			formacionAcademinca.setDocente(docente);
			formacionADao.persist(formacionAcademinca);
		}
		for (Experiencia experiencia : experiencias) {
			experiencia.setDocente(docente);
			experienciaDao.persist(experiencia);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.uce.ejb.service.DocenteService#consultarEscuelaUceById(java.lang.Long)
	 */
	@Override
	public EscuelaUce consultarEscuelaUceById(Integer escuela) throws DioneException {
		return escuelaUceDao.findById(escuela);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.uce.ejb.service.DocenteService#consultarFormacionAByDocente(java.lang.Integer)
	 */
	@Override
	public List<FormacionAcademica> consultarFormacionAByDocente(Integer idDocente) throws DioneException {
		return formacionADao.consultarFormacionByDocente(idDocente);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.uce.ejb.service.DocenteService#consultarFormacionCByDocente(java.lang.Integer)
	 */
	@Override
	public List<FormacionContinua> consultarFormacionCByDocente(Integer idDocente) throws DioneException {
		return formacionCDao.consultarFormacionByDocente(idDocente);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.uce.ejb.service.DocenteService#consultarExperienciasByDocente(java.lang.Integer)
	 */
	@Override
	public List<Experiencia> consultarExperienciasByDocente(Integer idDocente) throws DioneException {
		return experienciaDao.consultarExperienciasByDocente(idDocente);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.uce.ejb.service.DocenteService#consultarDocenteById(java.lang.Integer)
	 */
	@Override
	public Docente consultarDocenteById(Integer idDocente) throws DioneException {
		return docenteDao.findById(idDocente);
	}

	/* (non-Javadoc)
	 * @see ec.com.uce.ejb.service.DocenteService#consultarEscuelas(java.lang.String)
	 */
	@Override
	public List<EscuelaUce> consultarEscuelas(String escuela) throws DioneException {
		return escuelaUceDao.consultarEscuelas(escuela);
	}

	/* (non-Javadoc)
	 * @see ec.com.uce.ejb.service.DocenteService#consultarDocumentos(java.lang.Integer)
	 */
	@Override
	public List<DocumentoDocente> consultarDocumentos(Integer idDocente) throws DioneException {
		return docenteDocumentoDao.consultarDocumentos(idDocente);
	}

}
