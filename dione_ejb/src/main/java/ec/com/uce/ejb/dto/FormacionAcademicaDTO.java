/**
 * 
 */
package ec.com.uce.ejb.dto;

import java.io.Serializable;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Dec 1, 2014
 * @since JDK1.6
 */
public class FormacionAcademicaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String institucion;
	private String titulo;

	/**
	 * 
	 */
	public FormacionAcademicaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param institucion
	 * @param titulo
	 */
	public FormacionAcademicaDTO(String institucion, String titulo) {
		this.institucion = institucion;
		this.titulo = titulo;
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
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo
	 *            the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
