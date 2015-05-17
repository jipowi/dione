/**
 * 
 */
package ec.com.uce.ejb.dto;

import java.io.Serializable;

/**
 * <b>Permite manejar la informacion de la tabla Formacion Continua</b>
 * 
 * @author Anita Carrera
 * @version 1.0,Dec 1, 2014
 * @since JDK1.6
 */
public class FormacionContinuaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String institucion;
	private String curso;
	private Integer duracion;
	private String tipoDuracion;
	private Integer id;

	/**
	 * 
	 */
	public FormacionContinuaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param institucion
	 * @param curso
	 * @param duracion
	 * @param tipoDuracion
	 */
	public FormacionContinuaDTO(String institucion, String curso, Integer duracion, String tipoDuracion) {
		this.institucion = institucion;
		this.curso = curso;
		this.duracion = duracion;
		this.tipoDuracion = tipoDuracion;
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
	 * @return the curso
	 */
	public String getCurso() {
		return curso;
	}

	/**
	 * @param curso
	 *            the curso to set
	 */
	public void setCurso(String curso) {
		this.curso = curso;
	}

	/**
	 * @return the duracion
	 */
	public Integer getDuracion() {
		return duracion;
	}

	/**
	 * @param duracion
	 *            the duracion to set
	 */
	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	/**
	 * @return the tipoDuracion
	 */
	public String getTipoDuracion() {
		return tipoDuracion;
	}

	/**
	 * @param tipoDuracion
	 *            the tipoDuracion to set
	 */
	public void setTipoDuracion(String tipoDuracion) {
		this.tipoDuracion = tipoDuracion;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

}
