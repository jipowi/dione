package ec.com.uce.dione.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.dao.MateriaSyllabusDao;
import ec.com.uce.dione.entities.MateriaSyllabus;

/**
 * <b> Implementacion de la interfaz para realizar operaciones sobre la tabla MateriaSyllabus. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,29/12/2014
 * @since JDK1.6
 */
@Stateless
public class MateriaSyllabusDaoImpl extends GenericDAOImpl<MateriaSyllabus, Integer> implements MateriaSyllabusDao {

	@PersistenceContext(unitName = "dione_core")
	private EntityManager em;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.uce.dione.dao.MateriaSyllabusDao#consultarMateriaSyllabusBySyllabus(java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public MateriaSyllabus consultarMateriaSyllabusBySyllabus(Integer idSyllabus) throws DioneException {

		Query query = em.createNamedQuery("MateriaSyllabus.findBySyllabus");
		query.setParameter("idSyllabus", idSyllabus);

		List<MateriaSyllabus> materiaSyllabus = query.getResultList();
		if (!materiaSyllabus.isEmpty())
			return materiaSyllabus.get(0);
		else
			return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.uce.dione.dao.MateriaSyllabusDao#consultarSyllabus(java.lang.Integer, java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public MateriaSyllabus consultarSyllabus(Integer idDocente, Integer idMateria) throws DioneException {

		Query query = em.createNamedQuery("MateriaSyllabus.findByMateriaAndDocente");
		query.setParameter("idDocente", idDocente);
		query.setParameter("idMateriaUce", idMateria);
		List<MateriaSyllabus> materiaSyllabus = query.getResultList();

		if (!materiaSyllabus.isEmpty()) {
			return materiaSyllabus.get(0);
		} else {
			return null;
		}
	}

}
