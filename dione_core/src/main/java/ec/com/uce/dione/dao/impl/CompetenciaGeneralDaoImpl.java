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
import ec.com.uce.dione.dao.CompetenciaDao;
import ec.com.uce.dione.entities.CompetenciaGenerale;

/**
 * <b> Implementacion de la interfaz para realizar operaciones sobre la tabla Competencia. </b>
 * 
 * @author Anita Carrera
 * @version 1.0,05/01/2015
 * @since JDK1.6
 */
@Stateless
public class CompetenciaGeneralDaoImpl extends GenericDAOImpl<CompetenciaGenerale, Long> implements CompetenciaDao {

	@PersistenceContext(unitName = "dione_core")
	private EntityManager em;

	/* (non-Javadoc)
	 * @see ec.com.uce.dione.dao.CompetenciaDao#consultarCompetenciasBySyllabus(java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<CompetenciaGenerale> consultarCompetenciasBySyllabus(Integer idSyllabus) throws DioneException {
		Query query = em.createNamedQuery("CompetenciaGenerale.findBySyllabus");
		query.setParameter("idSyllabus", idSyllabus);

		List<CompetenciaGenerale> listSyllabus = query.getResultList();

		return listSyllabus;
	}
	
	
	
}
