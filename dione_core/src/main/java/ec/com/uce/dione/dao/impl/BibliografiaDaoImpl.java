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
import ec.com.uce.dione.dao.BibliografiaDao;
import ec.com.uce.dione.entities.Bibliografia;

/**
 * <b> Implementacion de la interfaz para realizar operaciones sobre la tabla Bibliografia. </b>
 * 
 * @author Anita Carrera
 * @version 1.0,05/01/2015
 * @since JDK1.6
 */
@Stateless
public class BibliografiaDaoImpl extends GenericDAOImpl<Bibliografia, Long> implements BibliografiaDao {

	@PersistenceContext(unitName = "dione_core")
	private EntityManager em;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.uce.dione.dao.BibliografiaDao#consultarBibliografiasBySyllabus(java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Bibliografia> consultarBibliografiasBySyllabus(Integer idSyllabus) throws DioneException {

		Query query = em.createNamedQuery("Bibliografia.findBySyllabus");
		query.setParameter("idSyllabus", idSyllabus);

		List<Bibliografia> bibliografias = query.getResultList();
		if (bibliografias.isEmpty()) {
			return null;
		} else {
			return bibliografias;
		}

	}

}
