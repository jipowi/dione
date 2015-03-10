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
import ec.com.uce.dione.dao.ExperienciaDao;
import ec.com.uce.dione.entities.Experiencia;

/**
 * <b> Implementacion de la interfaz para realizar operaciones sobre la tabla Experiencia. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,29/12/2014
 * @since JDK1.6
 */
@Stateless
public class ExperienciaDaoImpl extends GenericDAOImpl<Experiencia, Long> implements ExperienciaDao {

	Logger log = Logger.getLogger(EscuelaUceDaoImpl.class);

	@PersistenceContext(unitName = "dione_core")
	private EntityManager em;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.uce.dione.dao.ExperienciaDao#consultarExperienciasByDocente(java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Experiencia> consultarExperienciasByDocente(Integer idDocente) throws DioneException {
		try {
			Query query = em.createNamedQuery("Experiencia.findByDocente");
			query.setParameter("idDocente", idDocente);
			List<Experiencia> experiencias = query.getResultList();

			return experiencias;

		} catch (Exception ex) {
			log.error("Error: No se pudo realizar la Consulta --> consultarExperienciasByDocente", ex);
			throw new DioneException(ex);
		}
	}

}
