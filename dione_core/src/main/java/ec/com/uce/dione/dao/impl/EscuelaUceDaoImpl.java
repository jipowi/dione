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
import ec.com.uce.dione.dao.EscuelaUceDao;
import ec.com.uce.dione.entities.EscuelaUce;

/**
 * <b> Implementacion de la interfaz para realizar operaciones sobre la tabla Escuela. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,05/01/2015
 * @since JDK1.6
 */
@Stateless
public class EscuelaUceDaoImpl extends GenericDAOImpl<EscuelaUce, Integer> implements EscuelaUceDao {

	Logger log = Logger.getLogger(EscuelaUceDaoImpl.class);

	@PersistenceContext(unitName = "dione_core")
	private EntityManager em;


	
	/* (non-Javadoc)
	 * @see ec.com.uce.dione.dao.EscuelaUceDao#consultarEscuelaByDocente()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<EscuelaUce> consultarEscuelaByDocente(String idDocente) throws DioneException {
		try {
			Query query = em.createNamedQuery("EscuelaUce.findByDocente");
			query.setParameter("idDocente", Integer.parseInt(idDocente));
			List<EscuelaUce> escuelas = query.getResultList();

			return escuelas;

		} catch (Exception ex) {
			log.error("Error: No se pudo realizar la Consulta --> consultarEscuelaByDocente", ex);
			throw new DioneException(ex);
		}
	}

}
