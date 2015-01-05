/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.uce.ejb.service.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.dao.CatalogoDao;
import ec.com.uce.dione.entities.Catalogo;
import ec.com.uce.ejb.service.CatalogoService;

@Stateless
public class CatalogoServiceImpl implements CatalogoService {

	// @EJB(lookup =
	// "java:global/hiperion_core-1.0/CatalogoDaoImpl!ec.com.avila.hiperion.dao.CatalogoDao")
	@EJB
	private CatalogoDao catalogoDao;

	public CatalogoServiceImpl() {
	}

	public Catalogo consultarCatalogoById(Long idCatalogo) throws DioneException {
		return catalogoDao.findById(idCatalogo);
	}

}
