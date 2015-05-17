/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.uce.dione.comun;

/**
 * <b> Clase con la exception para el proyecto </b>
 * 
 * @author Anita Carrera
 * @version 1.0,Jan 19, 2014
 * @since JDK1.6
 */

public class DioneException extends Exception {

	private static final long serialVersionUID = 1L;

	public DioneException() {
		super();
	}

	public DioneException(String message) {
		super(message);
	}

	public DioneException(String message, Throwable cause) {
		super(message, cause);
	}

	public DioneException(Throwable cause) {
		super(cause);
	}
}
