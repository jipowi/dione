/**
 * 
 */
package ec.com.uce.ejb.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.dao.DocenteDao;
import ec.com.uce.dione.dao.EscuelaDao;
import ec.com.uce.dione.dao.EscuelaUceDao;
import ec.com.uce.dione.dao.MateriaDao;
import ec.com.uce.dione.dao.MateriaUceDao;
import ec.com.uce.dione.entities.Docente;
import ec.com.uce.dione.entities.Escuela;
import ec.com.uce.dione.entities.EscuelaUce;
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
	public Escuela consultarEscuelaById(Long escuela) throws DioneException {
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

}
