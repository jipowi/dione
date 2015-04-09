/**
 * 
 */
package ec.com.uce.ejb.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <b>Permite administrar la informacion de la tabla de Escuela</b>
 * 
 * @author Paul Jimenez
 * @version 1.0,29/12/2014
 * @since JDK1.6
 */
public class ReporteCumplimientoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nombre;
	private String cedula;
	private String escuela;
	private String materia;
	private BigDecimal efectividad;
	private BigDecimal porcentajeCompetencias;
	private BigDecimal porcentajeObjetivos;
	private BigDecimal porcentajeResultados;

	public ReporteCumplimientoDTO() {

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
	 * @return the materia
	 */
	public String getMateria() {
		return materia;
	}

	/**
	 * @param materia
	 *            the materia to set
	 */
	public void setMateria(String materia) {
		this.materia = materia;
	}

	/**
	 * @return the efectividad
	 */
	public BigDecimal getEfectividad() {
		return efectividad;
	}

	/**
	 * @param efectividad
	 *            the efectividad to set
	 */
	public void setEfectividad(BigDecimal efectividad) {
		this.efectividad = efectividad;
	}

	/**
	 * @return the porcentajeCompetencias
	 */
	public BigDecimal getPorcentajeCompetencias() {
		return porcentajeCompetencias;
	}

	/**
	 * @param porcentajeCompetencias
	 *            the porcentajeCompetencias to set
	 */
	public void setPorcentajeCompetencias(BigDecimal porcentajeCompetencias) {
		this.porcentajeCompetencias = porcentajeCompetencias;
	}

	/**
	 * @return the porcentajeObjetivos
	 */
	public BigDecimal getPorcentajeObjetivos() {
		return porcentajeObjetivos;
	}

	/**
	 * @param porcentajeObjetivos
	 *            the porcentajeObjetivos to set
	 */
	public void setPorcentajeObjetivos(BigDecimal porcentajeObjetivos) {
		this.porcentajeObjetivos = porcentajeObjetivos;
	}

	/**
	 * @return the porcentajeResultados
	 */
	public BigDecimal getPorcentajeResultados() {
		return porcentajeResultados;
	}

	/**
	 * @param porcentajeResultados
	 *            the porcentajeResultados to set
	 */
	public void setPorcentajeResultados(BigDecimal porcentajeResultados) {
		this.porcentajeResultados = porcentajeResultados;
	}

}
