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
import ec.com.uce.dione.dao.ResultadoAprendizajeDao;
import ec.com.uce.dione.entities.ResultadosAprendizaje;

/**
 * <b> Implementacion de la interfaz para realizar operaciones sobre la tabla ResultadosAprendizaje. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,05/01/2015
 * @since JDK1.6
 */
@Stateless
public class ResultadoAprendizajeDaoImpl extends GenericDAOImpl<ResultadosAprendizaje, Long> implements ResultadoAprendizajeDao {

	@PersistenceContext(unitName = "dione_core")
	private EntityManager em;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.uce.dione.dao.ResultadoAprendizajeDao#consultarResultadosAprendizaje(java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ResultadosAprendizaje> consultarResultadosAprendizaje(Integer idSyllabus) throws DioneException {

		Query query = em.createNamedQuery("ResultadosAprendizaje.findBySyllabus");
		query.setParameter("idSyllabus", idSyllabus);

		List<ResultadosAprendizaje> listSyllabus = query.getResultList();

		return listSyllabus;
	}

}
