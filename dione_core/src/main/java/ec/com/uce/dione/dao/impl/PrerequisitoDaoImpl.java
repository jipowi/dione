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
import ec.com.uce.dione.dao.PrerequisitoDao;
import ec.com.uce.dione.entities.Prerequisito;

/**
 * <b> Implementacion de la interfaz para realizar operaciones sobre la tabla Materia. </b>
 * 
 * @author Anita Carrera
 * @version 1.0,29/12/2014
 * @since JDK1.6
 */
@Stateless
public class PrerequisitoDaoImpl extends GenericDAOImpl<Prerequisito, Integer> implements PrerequisitoDao {

	Logger log = Logger.getLogger(PrerequisitoDaoImpl.class);

	@PersistenceContext(unitName = "dione_core")
	private EntityManager em;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.uce.dione.dao.PrerequisitoDao#consultarPreByMateria(java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Prerequisito> consultarPreByMateria(Integer idMateria) throws DioneException {
		try {
			Query query = em.createNamedQuery("Prerequisito.findByMateria");
			query.setParameter("idMateria", idMateria);
			List<Prerequisito> prerequisitos = query.getResultList();

			return prerequisitos;

		} catch (Exception ex) {
			log.error("Error: No se pudo realizar la Consulta --> consultarPreByMateria", ex);
			throw new DioneException(ex);
		}
	}
}
