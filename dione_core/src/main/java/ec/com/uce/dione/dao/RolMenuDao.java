/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.uce.dione.dao;

import javax.ejb.Local;

import ec.com.uce.dione.entities.RolMenu;

/**
 * <b> Interfaz local para operaciones sobre la tabla de rolMenu </b>
 * 
 * @author Anita Carrera
 * @version 1.0,Dec 10, 2014
 * @since JDK1.6
 */
@Local
public interface RolMenuDao extends GenericDAO<RolMenu, Long> {

}
