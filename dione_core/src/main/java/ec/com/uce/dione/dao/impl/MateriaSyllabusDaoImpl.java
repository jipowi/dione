package ec.com.uce.dione.dao.impl;

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
public class MateriaSyllabusDaoImpl extends GenericDAOImpl<MateriaSyllabus, Long> implements MateriaSyllabusDao {

	@PersistenceContext(unitName = "dione_core")
	private EntityManager em;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.uce.dione.dao.MateriaSyllabusDao#consultarMateriaSyllabusBySyllabus(java.lang.Integer)
	 */
	@Override
	public MateriaSyllabus consultarMateriaSyllabusBySyllabus(Integer idSyllabus) throws DioneException {

		Query query = em.createNamedQuery("MateriaSyllabus.findBySyllabus");
		query.setParameter("idSyllabus", idSyllabus);

		MateriaSyllabus materiaSyllabus = (MateriaSyllabus) query.getSingleResult();

		return materiaSyllabus;
	}

}
