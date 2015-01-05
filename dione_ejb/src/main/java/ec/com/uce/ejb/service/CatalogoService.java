/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.uce.ejb.service;

import javax.ejb.Local;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.entities.Catalogo;

/**
 * 
 * <b> Servicio de interface local para realizar las operaciones sobre la tabla Catalogo</b>
 * 
 * @author Dario Vinueza
 * @version 1.0,21/12/2013
 * @since JDK1.6
 */
@Local
public interface CatalogoService {

	/**
	 * 
	 * <b> Consulta por codigo Catalogo </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 21/12/2013]
	 * </p>
	 * 
	 * @param idCatalogo
	 * @return
	 * @throws DioneException
	 */

	public Catalogo consultarCatalogoById(Long idCatalogo) throws DioneException;

}