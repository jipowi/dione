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
import ec.com.uce.dione.dao.CorequisitoDao;
import ec.com.uce.dione.entities.Corequisito;

/**
 * <b> Implementacion de la interfaz para realizar operaciones sobre la tabla Prerequisito. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,29/12/2014
 * @since JDK1.6
 */
@Stateless
public class CorequisitoDaoImpl extends GenericDAOImpl<Corequisito, Long> implements CorequisitoDao {

	Logger log = Logger.getLogger(CorequisitoDaoImpl.class);

	@PersistenceContext(unitName = "dione_core")
	private EntityManager em;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.uce.dione.dao.CorequisitoDao#consultarCorequisitoByMateria(java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Corequisito> consultarCorequisitoByMateria(Integer idMateria) throws DioneException {
		try {
			Query query = em.createNamedQuery("Corequisito.findByMateria");
			query.setParameter("idMateria", Long.valueOf(idMateria.toString()));
			List<Corequisito> corequisitos = query.getResultList();

			return corequisitos;

		} catch (Exception ex) {
			log.error("Error: No se pudo realizar la Consulta --> consultarCorequisitoByMateria", ex);
			throw new DioneException(ex);
		}
	}
}
