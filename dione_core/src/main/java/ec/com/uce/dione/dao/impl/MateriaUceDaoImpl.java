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
import ec.com.uce.dione.dao.MateriaUceDao;
import ec.com.uce.dione.entities.MateriaUce;

/**
 * <b> Implementacion de la interfaz para realizar operaciones sobre la tabla MateriaUce. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,29/12/2014
 * @since JDK1.6
 */
@Stateless
public class MateriaUceDaoImpl extends GenericDAOImpl<MateriaUce, Long> implements MateriaUceDao {

	Logger log = Logger.getLogger(MateriaUceDaoImpl.class);

	@PersistenceContext(unitName = "dione_core")
	private EntityManager em;

	/* (non-Javadoc)
	 * @see ec.com.uce.dione.dao.MateriaUceDao#consultarMateriasByEscuela(java.lang.Long)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<MateriaUce> consultarMateriasByEscuela(Long idEscuela) throws DioneException {
		try {
			Query query = em.createNamedQuery("MateriaUce.findByEscuela");
			query.setParameter("idEscuela", idEscuela);
			List<MateriaUce> materias = query.getResultList();

			return materias;

		} catch (Exception ex) {
			log.error("Error: No se pudo realizar la Consulta --> consultarMateriasByEscuela", ex);
			throw new DioneException(ex);
		}
	}


}
