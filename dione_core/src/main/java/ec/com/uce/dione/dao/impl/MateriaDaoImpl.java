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
import ec.com.uce.dione.dao.MateriaDao;
import ec.com.uce.dione.entities.Materia;

/**
 * <b> Implementacion de la interfaz para realizar operaciones sobre la tabla Materia. </b>
 * 
 * @author Anita Carrera
 * @version 1.0,29/12/2014
 * @since JDK1.6
 */
@Stateless
public class MateriaDaoImpl extends GenericDAOImpl<Materia, Long> implements MateriaDao {

	Logger log = Logger.getLogger(MateriaDaoImpl.class);

	@PersistenceContext(unitName = "dione_core")
	private EntityManager em;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.uce.dione.dao.MateriaDao#consultarMateriaByEscuela(java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Materia> consultarMateriaByEscuela(Integer idEscuela) throws DioneException {
		try {
			Query query = em.createNamedQuery("Materia.findByEscuela");
			query.setParameter("idEscuela", idEscuela);
			List<Materia> materias = query.getResultList();

			return materias;

		} catch (Exception ex) {
			log.error("Error: No se pudo realizar la Consulta --> consultarMateriaByEscuela", ex);
			throw new DioneException(ex);
		}
	}
}
