/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.uce.ejb.service;

import java.util.List;

import javax.ejb.Local;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.entities.DetalleCatalogo;

/**
 * 
 * <b> Servicio de interface local para realizar las operaciones sobre la tabla Detalle catalogo </b>
 * 
 * @author Dario Vinueza
 * @version 1.0,21/12/2013
 * @since JDK1.6
 */
@Local
public interface DetalleCatalogoService {

	/**
	 * 
	 * <b> Consulta por codigo de catalogo </b>
	 * <p>
	 * [Author: Franklin, Date: 21/12/2013]
	 * </p>
	 * 
	 * @param idCatalogo
	 * @return
	 * @throws DioneException
	 */
	public List<DetalleCatalogo> consultarDetalleCatalogoByCodCatalogo(Long idCatalogo) throws DioneException;

	/**
	 * 
	 * <b> Permite consultar un detalle de catalogo por medio del idCatalogo y idDetalle </b>
	 * <p>
	 * [Author: Anita Carrera, Date: Aug 27, 2014]
	 * </p>
	 * 
	 * @param codCatalogo
	 * @param codDetCalogo
	 * @return
	 * @throws DioneException
	 */
	public DetalleCatalogo consultarDetalleByCatalogoAndDetalle(Integer codCatalogo, Integer codDetCalogo) throws DioneException;

}
