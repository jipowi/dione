/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.uce.dione.dao;

import java.util.List;

import javax.ejb.Local;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.entities.DetalleCatalogo;

/**
 * 
 * <b> Interfaz local de la tabla DetalleCatalogo para realizar las operaciones necesarias</b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Dec 18, 2013
 * @since JDK1.6
 */
@Local
public interface DetalleCatalogoDao extends GenericDAO<DetalleCatalogo, Long> {

	/**
	 * 
	 * <b> Permite guardar los registros en la tabla
	 * <p>
	 * [Author: Paul Jimemenez, Date: Dec 18, 2013]
	 * </p>
	 * 
	 * @param idCatalogo
	 * @return
	 * @throws DioneException
	 */
	public List<DetalleCatalogo> consultarDetalleCatalogoByCodCatalogo(Long idCatalogo) throws DioneException;

}
