/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.uce.ejb.service;

import java.util.List;

import javax.ejb.Local;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.entities.Usuario;

/**
 * 
 * <b> Servicio de interfaz local para realizar las operaciones sobre la tabla Usuario </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,22/12/2013
 * @since JDK1.6
 */
@Local
public interface UsuarioService {

	/**
	 * 
	 * <b> Permite guardar los registros en la tabla Usuarios. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 22/12/2013]
	 * </p>
	 * 
	 * @param usuario
	 * @throws DioneException
	 */
	public void guardarUsuario(Usuario usuario) throws DioneException;

	/**
	 * 
	 * <b> permite obtener lista de usuarios que se encuentran en la base de datos </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 22/12/2013]
	 * </p>
	 * 
	 * @return
	 * @throws DioneException
	 */
	public List<Usuario> consultarUsuarios() throws DioneException;

	/**
	 * 
	 * <b> Permite consultar el usuario por medio del alias </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 22/12/2013]
	 * </p>
	 * 
	 * @param nombreUsuario
	 * @return
	 * @throws DioneException
	 */
	public Usuario consultarUsuarioByAlias(String nombreUsuario) throws DioneException;

	/**
	 * 
	 * <b> Permite modificar los objetos de la tabla Usuario </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 29/12/2013]
	 * </p>
	 * 
	 * @param usuario
	 * @throws DioneException
	 */
	public void modificarUsuario(Usuario usuario) throws DioneException;
}
