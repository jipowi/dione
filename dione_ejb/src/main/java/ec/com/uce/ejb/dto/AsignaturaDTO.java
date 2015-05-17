/**
 * 
 */
package ec.com.uce.ejb.dto;

import java.io.Serializable;
import java.util.List;

/**
 * <b>Permite administrar la informacion de la tabla de Escuela</b>
 * 
 * @author Anita Carrera
 * @version 1.0,29/12/2014
 * @since JDK1.6
 */
public class AsignaturaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String escuela;
	private List<MateriaDTO> materias;

	public AsignaturaDTO() {

	}

	/**
	 * @param escuela
	 * @param materias
	 */
	public AsignaturaDTO(String escuela, List<MateriaDTO> materias) {
		super();
		this.escuela = escuela;
		this.materias = materias;
	}

	/**
	 * @return the escuela
	 */
	public String getEscuela() {
		return escuela;
	}

	/**
	 * @param escuela
	 *            the escuela to set
	 */
	public void setEscuela(String escuela) {
		this.escuela = escuela;
	}

	/**
	 * @return the materias
	 */
	public List<MateriaDTO> getMaterias() {
		return materias;
	}

	/**
	 * @param materias
	 *            the materias to set
	 */
	public void setMaterias(List<MateriaDTO> materias) {
		this.materias = materias;
	}

}
