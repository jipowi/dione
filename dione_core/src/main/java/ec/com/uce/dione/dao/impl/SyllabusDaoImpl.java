package ec.com.uce.dione.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.dao.SyllabusDao;
import ec.com.uce.dione.entities.Syllabus;

/**
 * <b> Implementacion de la interfaz para realizar operaciones sobre la tabla Escuela. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,05/01/2015
 * @since JDK1.6
 */
@Stateless
public class SyllabusDaoImpl extends GenericDAOImpl<Syllabus, Long> implements SyllabusDao {

	@PersistenceContext(unitName = "dione_core")
	private EntityManager em;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.uce.dione.dao.SyllabusDao#consultarSyllabusByDocenteAndMateria(java.lang.Long, java.lang.Long)
	 */
	@Override
	public Syllabus consultarSyllabusByDocenteAndMateria(Long idDocente, Long idMateria) throws DioneException {

		Query query = em.createNamedQuery("Syllabus.findByDocenteAndMateria");
		query.setParameter("idDocente", idDocente);
		query.setParameter("idMateria", idMateria);

		Syllabus syllabus = (Syllabus) query.getSingleResult();

		return syllabus;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.uce.dione.dao.SyllabusDao#consultarSyllabusByDocente(java.lang.Long)
	 */
	@Override
	public Syllabus consultarSyllabusByDocente(Long idDocente) throws DioneException {

		Query query = em.createNamedQuery("Syllabus.findByDocente");
		query.setParameter("idDocente", idDocente);

		Syllabus syllabus = (Syllabus) query.getSingleResult();

		return syllabus;
	}

}
