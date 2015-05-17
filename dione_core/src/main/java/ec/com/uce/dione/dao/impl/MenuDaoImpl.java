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
import ec.com.uce.dione.dao.MenuDao;
import ec.com.uce.dione.entities.Menu;
import ec.com.uce.dione.entities.Rol;
import ec.com.uce.dione.entities.RolMenu;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Anita Carrera
 * @version 1.0,Dec 10, 2014
 * @since JDK1.6
 */
@Stateless
public class MenuDaoImpl extends GenericDAOImpl<Menu, Long> implements MenuDao {

	Logger log = Logger.getLogger(MenuDaoImpl.class);

	@PersistenceContext(unitName = "dione_core")
	protected EntityManager em;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.dao.MenuDao#consultarMenuByRol(ec.com.avila.hiperion.emision.entities.Rol)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<RolMenu> consultarMenuByRol(Rol rol) throws DioneException {
		try {
			Query query = em.createNamedQuery("Menu.findByRol");
			query.setParameter("idRol", rol.getIdRol());
			List<RolMenu> menus = query.getResultList();
			
			return menus;
		} catch (Exception ex) {
			log.error("Error: No se pudo realizar la Consulta --> consultarMenuByRol", ex);
			throw new DioneException(ex);
		}
	}

}
