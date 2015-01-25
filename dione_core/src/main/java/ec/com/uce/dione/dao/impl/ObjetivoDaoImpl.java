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
import ec.com.uce.dione.dao.ObjetivoDao;
import ec.com.uce.dione.entities.Objetivo;

/**
 * <b> Implementacion de la interfaz para realizar operaciones sobre la tabla Objetivo. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,05/01/2015
 * @since JDK1.6
 */
@Stateless
public class ObjetivoDaoImpl extends GenericDAOImpl<Objetivo, Long> implements ObjetivoDao {

	@PersistenceContext(unitName = "dione_core")
	private EntityManager em;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.uce.dione.dao.ObjetivoDao#consultarObjetivos(java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Objetivo> consultarObjetivos(Integer idSyllabus) throws DioneException {

		Query query = em.createNamedQuery("Objetivo.findBysyllabus");
		query.setParameter("idSyllabus", idSyllabus);

		List<Objetivo> listSyllabus = query.getResultList();

		return listSyllabus;
	}

}
