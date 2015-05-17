/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.uce.ejb.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.dao.DetalleCatalogoDao;
import ec.com.uce.dione.entities.DetalleCatalogo;
import ec.com.uce.ejb.service.DetalleCatalogoService;

/**
 * 
 * <b> Implemtacion del servicio de Detalle de catalogo </b>
 * 
 * @author Anita Carrera
 * @version 1.0,Dec 1, 2014
 * @since JDK1.6
 */
@Stateless
public class DetalleCatalogoServiceImpl implements DetalleCatalogoService {

	@EJB
	private DetalleCatalogoDao detalleCatalogoDao;

	public DetalleCatalogoServiceImpl() {
	}

	public List<DetalleCatalogo> consultarDetalleCatalogoByCodCatalogo(Long idCatalogo) throws DioneException {
		return detalleCatalogoDao.consultarDetalleCatalogoByCodCatalogo(idCatalogo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.DetalleCatalogoService#consultarDetalleByCatalogoAndDetalle(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public DetalleCatalogo consultarDetalleByCatalogoAndDetalle(Integer codCatalogo, Integer codDetCalogo) throws DioneException {
		return detalleCatalogoDao.consultarDetalleByCatalogoAndDetalle(codCatalogo, codDetCalogo);
	}

}
