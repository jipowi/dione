/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.uce.dione.dao;

import java.util.List;

import javax.ejb.Local;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.entities.Menu;
import ec.com.uce.dione.entities.Rol;
import ec.com.uce.dione.entities.RolMenu;

/**
 * <b> Interfaz local para operaciones con la tabla Menu. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Dec 10, 2014
 * @since JDK1.6
 */
@Local
public interface MenuDao extends GenericDAO<Menu, Long> {

	/**
	 * 
	 * <b> Permite consultar los menus a los cuales un rol tiene acceso </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Dec 10, 2014]
	 * </p>
	 * 
	 * @param rol
	 * @return
	 * @throws DioneException
	 */
	public List<RolMenu> consultarMenuByRol(Rol rol) throws DioneException;
}
