package ec.com.uce.dione.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.com.uce.dione.dao.DetalleCatalogoDao;
import ec.com.uce.dione.entities.DetalleCatalogo;

/**
 * 
 * <b> Permite implementar las operaciones de la tabla DetalleCatalogo </b>
 * 
 * @author Dario Vinueza
 * @version 1.0,21/12/2013
 * @since JDK1.6
 */
@Stateless
public class DetalleCatalogoDaoImpl extends GenericDAOImpl<DetalleCatalogo, Long> implements DetalleCatalogoDao {

	@PersistenceContext(unitName = "dione_core")
	private EntityManager em;

	public DetalleCatalogoDaoImpl() {
	}

	@SuppressWarnings("unchecked")
	public List<DetalleCatalogo> consultarDetalleCatalogoByCodCatalogo(Long idCatalogo) {
		Query query = em.createNamedQuery("DetalleCatalogo.findByCodCatalogo");
		query.setParameter("idCatalogo", idCatalogo);
		List<DetalleCatalogo> detalleCatalogo = query.getResultList();

		return detalleCatalogo;
	}

		
}
