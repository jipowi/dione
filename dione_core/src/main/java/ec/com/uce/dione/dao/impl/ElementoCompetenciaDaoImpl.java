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
import ec.com.uce.dione.dao.ElementoCompetenciaDao;
import ec.com.uce.dione.entities.ElementoCompetencia;

/**
 * <b> Implementacion de la interfaz para realizar operaciones sobre la tabla ElementoCompetencia. </b>
 * 
 * @author Anita Carrera
 * @version 1.0,05/01/2015
 * @since JDK1.6
 */
@Stateless
public class ElementoCompetenciaDaoImpl extends GenericDAOImpl<ElementoCompetencia, Long> implements ElementoCompetenciaDao {

	@PersistenceContext(unitName = "dione_core")
	private EntityManager em;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.uce.dione.dao.ElementoCompetenciaDao#consultarElementoByUnidad(java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ElementoCompetencia> consultarElementoByUnidad(Integer idUnidad) throws DioneException {
		Query query = em.createNamedQuery("ElementoCompetencia.findBySyllabus");
		query.setParameter("idUnidadCompetencia", idUnidad);

		List<ElementoCompetencia> elementos = query.getResultList();
		if (elementos.isEmpty()) {
			return null;
		} else {
			return elementos;
		}
	}

}
