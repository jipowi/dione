/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.uce.dione.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.dao.RolDao;
import ec.com.uce.dione.entities.Rol;
import ec.com.uce.dione.entities.Usuario;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Anita Carrera
 * @version 1.0,Dec 10, 2014
 * @since JDK1.6
 */
@Stateless
public class RolDaoImpl extends GenericDAOImpl<Rol, Long> implements RolDao {

	Logger log = Logger.getLogger(RolDaoImpl.class);

	@PersistenceContext(unitName = "dione_core")
	protected EntityManager em;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.dao.RolDao#consultarRolByUsuario(ec.com.avila.hiperion.emision.entities.Usuario)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Rol> consultarRolByUsuario(Usuario usuario) throws DioneException {
		try {
			Query query = em.createNamedQuery("Rol.findByUsuario");
			query.setParameter("idUsuario", usuario.getIdUsuario());
			List<Rol> roles = query.getResultList();
			return roles;

		} catch (Exception ex) {
			log.error("Error: No se pudo realizar la Consulta --> consultarRolByUsuario", ex);
			throw new DioneException(ex);
		}
	}

}
