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
import ec.com.uce.dione.dao.UnidadCompetenciaDao;
import ec.com.uce.dione.entities.UnidadCompetencia;

/**
 * <b> Implementacion de la interfaz para realizar operaciones sobre la tabla UnidadCompetencia. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,05/01/2015
 * @since JDK1.6
 */
@Stateless
public class UnidadCompetenciaDaoImpl extends GenericDAOImpl<UnidadCompetencia, Long> implements UnidadCompetenciaDao {

	@PersistenceContext(unitName = "dione_core")
	private EntityManager em;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.uce.dione.dao.UnidadCompetenciaDao#consultarUnidadesBySyllabus(java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<UnidadCompetencia> consultarUnidadesBySyllabus(Integer idSyllabus) throws DioneException {

		Query query = em.createNamedQuery("UnidadCompetencia.findBySyllabus");
		query.setParameter("idSyllabus", idSyllabus);

		List<UnidadCompetencia> unidades = query.getResultList();
		if (unidades.isEmpty()) {
			return null;
		} else {
			return unidades;
		}
	}
}
