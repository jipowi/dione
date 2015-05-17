/**
 * 
 */
package ec.com.uce.dione.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.dao.CompetenciaGenericaDao;
import ec.com.uce.dione.entities.CompetenciasGenerica;

/**
 * <b> Implementacion de la interfaz para realizar operaciones sobre la tabla CompetenciasGenerica. </b>
 * 
 * @author Anita Carrera
 * @version 1.0,05/01/2015
 * @since JDK1.6
 */
@Stateless
public class CompetenciaGenericaDaoImpl extends GenericDAOImpl<CompetenciasGenerica, Long> implements CompetenciaGenericaDao {

	@PersistenceContext(unitName = "dione_core")
	private EntityManager em;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.uce.dione.dao.CompetenciaGenericaDao#consultarCompGenricasBySyllabus(java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<CompetenciasGenerica> consultarCompGenricasBySyllabus(Integer idSyllabus) throws DioneException {

		Query query = em.createNamedQuery("CompetenciasGenerica.findBySyllabus");
		query.setParameter("idSyllabus", idSyllabus);

		List<CompetenciasGenerica> listCompetencias = query.getResultList();

		return listCompetencias;
	}

}
