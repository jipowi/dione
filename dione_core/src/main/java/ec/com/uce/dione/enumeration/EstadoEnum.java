/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.uce.dione.enumeration;

/**
 * 
 * <b> Enumeracion que contiene la lista de estados </b>
 * 
 * @author Anita Carrera
 * @version 1.0,Nov 24, 2014
 * @since JDK1.6
 */
public enum EstadoEnum {

	A("ACTIVO"), I("INACTIVO");

	private String label;

	EstadoEnum(String label) {
		this.label = label;
	}

	/**
	 * @return el valor de la variable label
	 */
	public String getLabel() {
		return label;
	}

}
