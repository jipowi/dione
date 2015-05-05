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
import ec.com.uce.dione.dao.CumplimientoDao;
import ec.com.uce.dione.entities.Cumplimiento;

/**
 * <b> Implementacion de la interfaz para realizar operaciones sobre la tabla Cumplimiento. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,29/12/2014
 * @since JDK1.6
 */
@Stateless
public class CumplimientoDaoImpl extends GenericDAOImpl<Cumplimiento, Integer> implements CumplimientoDao {

	Logger log = Logger.getLogger(CumplimientoDaoImpl.class);

	@PersistenceContext(unitName = "dione_core")
	private EntityManager em;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.uce.dione.dao.CumplimientoDao#consultarCumplimientoByMatSyllabus(java.lang.Integer)
	 */
	@Override
	public Cumplimiento consultarCumplimientoByMatSyllabus(Integer idMateriaSyllabus) throws DioneException {
		Query query = em.createNamedQuery("Cumplimiento.findByIdMateriaSyllabus");
		query.setParameter("idMateriaSyllabus", idMateriaSyllabus);

		@SuppressWarnings("unchecked")
		List<Cumplimiento> cumplimientos = query.getResultList();

		if (cumplimientos.isEmpty()) {
			return null;
		} else {
			return cumplimientos.get(0);
		}

	}
}
