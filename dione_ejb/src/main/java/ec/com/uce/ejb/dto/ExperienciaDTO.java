/**
 * 
 */
package ec.com.uce.ejb.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Dec 9, 2014
 * @since JDK1.6
 */
public class ExperienciaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String institucion;
	private Date fechaInicio;
	private Date fechaFin;
	private String funciones;

	
	/**
	 * 
	 */
	public ExperienciaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param institucion
	 * @param fechaInicio
	 * @param fechaFin
	 * @param funciones
	 */
	public ExperienciaDTO(String institucion, Date fechaInicio, Date fechaFin, String funciones) {
		super();
		this.institucion = institucion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.funciones = funciones;
	}

	/**
	 * @return the institucion
	 */
	public String getInstitucion() {
		return institucion;
	}

	/**
	 * @param institucion
	 *            the institucion to set
	 */
	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}

	/**
	 * @return the fechaInicio
	 */
	public Date getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * @param fechaInicio
	 *            the fechaInicio to set
	 */
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * @return the fechaFin
	 */
	public Date getFechaFin() {
		return fechaFin;
	}

	/**
	 * @param fechaFin
	 *            the fechaFin to set
	 */
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * @return the funciones
	 */
	public String getFunciones() {
		return funciones;
	}

	/**
	 * @param funciones
	 *            the funciones to set
	 */
	public void setFunciones(String funciones) {
		this.funciones = funciones;
	}

}
