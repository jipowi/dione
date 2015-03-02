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
import ec.com.uce.dione.dao.CompetenciaEspecificaDao;
import ec.com.uce.dione.entities.CompetenciasEspecifica;

/**
 * <b> Implementacion de la interfaz para realizar operaciones sobre la tabla CompetenciasEspecifica. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,05/01/2015
 * @since JDK1.6
 */
@Stateless
public class CompetenciaEspecificaDaoImpl extends GenericDAOImpl<CompetenciasEspecifica, Long> implements CompetenciaEspecificaDao {

	@PersistenceContext(unitName = "dione_core")
	private EntityManager em;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.uce.dione.dao.CompetenciaEspecificaDao#consultarCompEspecificaBySyllabus(java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<CompetenciasEspecifica> consultarCompEspecificaBySyllabus(Integer idSyllabus) throws DioneException {

		Query query = em.createNamedQuery("CompetenciasEspecifica.findBySyllabus");
		query.setParameter("idSyllabus", idSyllabus);

		List<CompetenciasEspecifica> listCompetencias = query.getResultList();

		return listCompetencias;
	}

}
