/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.uce.dione.dao;

import java.util.List;

import javax.ejb.Local;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.entities.Rol;
import ec.com.uce.dione.entities.Usuario;

/**
 * <b> Interfaz local para operaciones sobre la tabla de roles </b>
 * 
 * @author Anita Carrera
 * @version 1.0,Dec 10, 2014
 * @since JDK1.6
 */
@Local
public interface RolDao extends GenericDAO<Rol, Long> {

	/**
	 * 
	 * <b> Permite consultar los roles que tiene un usuario </b>
	 * <p>
	 * [Author: Anita Carrera, Date: Dec 10, 2014]
	 * </p>
	 * 
	 * @param usuario
	 * @return
	 * @throws DioneException
	 */
	public List<Rol> consultarRolByUsuario(Usuario usuario) throws DioneException;
}
