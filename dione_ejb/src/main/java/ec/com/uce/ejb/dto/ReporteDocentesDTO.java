/**
 * 
 */
package ec.com.uce.ejb.dto;

import java.io.Serializable;
import java.util.List;

import ec.com.uce.dione.entities.FormacionAcademica;
import ec.com.uce.dione.entities.FormacionContinua;

/**
 * <b>Permite administrar la informacion de la tabla de Escuela</b>
 * 
 * @author Paul Jimenez
 * @version 1.0,29/12/2014
 * @since JDK1.6
 */
public class ReporteDocentesDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nombre;
	private String cedula;
	private List<FormacionAcademica> formacionesA;
	private List<FormacionContinua> formacionesC;
	private String formacionesAcademicas;
	private String formacionesContinuas;

	public ReporteDocentesDTO() {

	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the cedula
	 */
	public String getCedula() {
		return cedula;
	}

	/**
	 * @param cedula
	 *            the cedula to set
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	/**
	 * @return the formacionesA
	 */
	public List<FormacionAcademica> getFormacionesA() {
		return formacionesA;
	}

	/**
	 * @param formacionesA
	 *            the formacionesA to set
	 */
	public void setFormacionesA(List<FormacionAcademica> formacionesA) {
		this.formacionesA = formacionesA;
	}

	/**
	 * @return the formacionesC
	 */
	public List<FormacionContinua> getFormacionesC() {
		return formacionesC;
	}

	/**
	 * @param formacionesC
	 *            the formacionesC to set
	 */
	public void setFormacionesC(List<FormacionContinua> formacionesC) {
		this.formacionesC = formacionesC;
	}

	/**
	 * @return the formacionesAcademicas
	 */
	public String getFormacionesAcademicas() {
		return formacionesAcademicas;
	}

	/**
	 * @param formacionesAcademicas
	 *            the formacionesAcademicas to set
	 */
	public void setFormacionesAcademicas(String formacionesAcademicas) {
		this.formacionesAcademicas = formacionesAcademicas;
	}

	/**
	 * @return the formacionesContinuas
	 */
	public String getFormacionesContinuas() {
		return formacionesContinuas;
	}

	/**
	 * @param formacionesContinuas
	 *            the formacionesContinuas to set
	 */
	public void setFormacionesContinuas(String formacionesContinuas) {
		this.formacionesContinuas = formacionesContinuas;
	}

}
