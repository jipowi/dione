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
import ec.com.uce.dione.dao.FormacionADao;
import ec.com.uce.dione.entities.FormacionAcademica;

/**
 * <b> Implementacion de la interfaz para realizar operaciones sobre la tabla FormacionAcademica. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,29/12/2014
 * @since JDK1.6
 */
@Stateless
public class FormacionADaoImpl extends GenericDAOImpl<FormacionAcademica, Long> implements FormacionADao {

	Logger log = Logger.getLogger(FormacionADaoImpl.class);

	@PersistenceContext(unitName = "dione_core")
	private EntityManager em;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.uce.dione.dao.FormacionADao#consultarFormacionByDocente(java.lang.Long)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<FormacionAcademica> consultarFormacionByDocente(Long idDocente) throws DioneException {
		try {
			Query query = em.createNamedQuery("FormacionAcademica.findByDocente");
			query.setParameter("idDocente", new Long(idDocente));
			List<FormacionAcademica> formaciones = query.getResultList();

			return formaciones;

		} catch (Exception ex) {
			log.error("Error: No se pudo realizar la Consulta --> consultarFormacionByDocente", ex);
			throw new DioneException(ex);
		}
	}

}
