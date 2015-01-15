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
import ec.com.uce.dione.dao.DocenteDao;
import ec.com.uce.dione.entities.Docente;

/**
 * <b> Implementacion de la interfaaz para realizar operaciones sobre la tabla docente. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,05/01/2015
 * @since JDK1.6
 */
@Stateless
public class DocenteDaoImpl extends GenericDAOImpl<Docente, Long> implements DocenteDao {

	Logger log = Logger.getLogger(DocenteDaoImpl.class);

	@PersistenceContext(unitName = "dione_core")
	private EntityManager em;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.uce.dione.dao.DocenteDao#cosultarDocenteByCedula(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Docente cosultarDocenteByCedula(String cedula) throws DioneException {
		try {
			Query query = em.createNamedQuery("Docente.findByCedula");
			query.setParameter("cedula", cedula);
			List<Docente> docentes = query.getResultList();
			if (docentes.isEmpty()) {
				return null;
			} else {
				return docentes.get(0);
			}

		} catch (Exception ex) {
			log.error("Error: No se pudo realizar la Consulta --> cosultarDocenteByCedula", ex);
			throw new DioneException(ex);
		}
	}

}
