/**
 * 
 */
package ec.com.uce.ejb.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.dao.MateriaUceDao;
import ec.com.uce.dione.entities.MateriaUce;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.uce.ejb.service.SyllabusService#consultarMateriasByDocente(java.lang.Integer)
	 */
	@Override
	public List<MateriaUce> consultarMateriasByDocente(Integer idDocente) throws DioneException {

		return materiaUceDao.consultarMateriasByDocente(idDocente);
	}

}
