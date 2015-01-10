/**
 * 
 */
package ec.com.uce.ejb.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <b> Clase que peermite manejar la informacion de la tabla de Competencias. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,09/01/2015
 * @since JDK1.6
 */
public class UnidadCompetenciaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String unidadCompetencia;
	private Integer planificacionHoras;
	private List<ElementosCompetenciaDTO> elementosCompetencias = new ArrayList<ElementosCompetenciaDTO>();

	/**
	 * @param unidadCompetencia
	 * @param planificacionHoras
	 * @param elementosCompetencias
	 */
	public UnidadCompetenciaDTO(String unidadCompetencia, Integer planificacionHoras, List<ElementosCompetenciaDTO> elementosCompetencias) {
		super();
		this.unidadCompetencia = unidadCompetencia;
		this.planificacionHoras = planificacionHoras;
		this.elementosCompetencias = elementosCompetencias;
	}

	/**
	 * @return the unidadCompetencia
	 */
	public String getUnidadCompetencia() {
		return unidadCompetencia;
	}

	/**
	 * @param unidadCompetencia
	 *            the unidadCompetencia to set
	 */
	public void setUnidadCompetencia(String unidadCompetencia) {
		this.unidadCompetencia = unidadCompetencia;
	}

	/**
	 * @return the planificacionHoras
	 */
	public Integer getPlanificacionHoras() {
		return planificacionHoras;
	}

	/**
	 * @param planificacionHoras
	 *            the planificacionHoras to set
	 */
	public void setPlanificacionHoras(Integer planificacionHoras) {
		this.planificacionHoras = planificacionHoras;
	}

	/**
	 * @return the elementosCompetencias
	 */
	public List<ElementosCompetenciaDTO> getElementosCompetencias() {
		return elementosCompetencias;
	}

	/**
	 * @param elementosCompetencias
	 *            the elementosCompetencias to set
	 */
	public void setElementosCompetencias(List<ElementosCompetenciaDTO> elementosCompetencias) {
		this.elementosCompetencias = elementosCompetencias;
	}

}
