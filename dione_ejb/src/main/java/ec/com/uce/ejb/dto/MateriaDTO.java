/**
 * 
 */
package ec.com.uce.ejb.dto;

import java.io.Serializable;

/**
 * <b> Permite manejar la informacion de la tabla de materia </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,29/12/2014
 * @since JDK1.6
 */
public class MateriaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idMateria;
	private String desMateria;
	private Boolean seleccion;

	/**
	 * @return the idMateria
	 */
	public Integer getIdMateria() {
		return idMateria;
	}

	/**
	 * @param idMateria
	 *            the idMateria to set
	 */
	public void setIdMateria(Integer idMateria) {
		this.idMateria = idMateria;
	}

	/**
	 * @return the desMateria
	 */
	public String getDesMateria() {
		return desMateria;
	}

	/**
	 * @param desMateria
	 *            the desMateria to set
	 */
	public void setDesMateria(String desMateria) {
		this.desMateria = desMateria;
	}

	/**
	 * @return the seleccion
	 */
	public Boolean getSeleccion() {
		return seleccion;
	}

	/**
	 * @param seleccion
	 *            the seleccion to set
	 */
	public void setSeleccion(Boolean seleccion) {
		this.seleccion = seleccion;
	}

}
