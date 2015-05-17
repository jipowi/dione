/**
 * 
 */
package ec.com.uce.dione.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.dao.FormacionCDao;
import ec.com.uce.dione.entities.FormacionContinua;

/**
 * <b> Implementacion de la interfaz para realizar operaciones sobre la tabla FormacionContinua. </b>
 * 
 * @author Anita Carrera
 * @version 1.0,29/12/2014
 * @since JDK1.6
 */
@Stateless
public class FormacionCDaoImpl extends GenericDAOImpl<FormacionContinua, Integer> implements FormacionCDao {

	Logger log = Logger.getLogger(FormacionCDaoImpl.class);

	@PersistenceContext(unitName = "dione_core")
	private EntityManager em;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.uce.dione.dao.FormacionCDao#consultarFormacionByDocente(java.lang.Long)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<FormacionContinua> consultarFormacionByDocente(Integer idDocente) throws DioneException {
		try {
			Query query = em.createNamedQuery("FormacionContinua.findByDocente");
			query.setParameter("idDocente", idDocente);
			List<FormacionContinua> formaciones = query.getResultList();

			return formaciones;

		} catch (Exception ex) {
			log.error("Error: No se pudo realizar la Consulta --> consultarFormacionByDocente", ex);
			throw new DioneException(ex);
		}
	}

}
