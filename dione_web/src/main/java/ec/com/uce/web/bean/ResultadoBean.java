/**
 * 
 */
package ec.com.uce.web.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ec.com.uce.ejb.dto.EvaluacionCompetenciasDTO;
import ec.com.uce.ejb.dto.EvaluacionObjetivosDTO;
import ec.com.uce.ejb.dto.EvaluacionResAprendizajeDTO;

/**
 * <b> Permite manejar la informacion de la interfaz del cliente. </b>
 * 
 * @author Anita Carrera
 * @version 1.0,05/01/2015
 * @since JDK1.6
 */
@ManagedBean
@SessionScoped
public class ResultadoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String cedula;
	private String materia;
	private List<EvaluacionObjetivosDTO> resultObjetivosDTO = new ArrayList<EvaluacionObjetivosDTO>();
	private List<EvaluacionCompetenciasDTO> resultCompetenciasDTO = new ArrayList<EvaluacionCompetenciasDTO>();
	private List<EvaluacionResAprendizajeDTO> resultadosDTO = new ArrayList<EvaluacionResAprendizajeDTO>();
	private Double totalObjetivos;
	private Double totalCompetencias;
	private Double totalResultados;
	private Double efectividad;

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
	 * @return the resultObjetivosDTO
	 */
	public List<EvaluacionObjetivosDTO> getResultObjetivosDTO() {
		return resultObjetivosDTO;
	}

	/**
	 * @param resultObjetivosDTO
	 *            the resultObjetivosDTO to set
	 */
	public void setResultObjetivosDTO(List<EvaluacionObjetivosDTO> resultObjetivosDTO) {
		this.resultObjetivosDTO = resultObjetivosDTO;
	}

	/**
	 * @return the resultCompetenciasDTO
	 */
	public List<EvaluacionCompetenciasDTO> getResultCompetenciasDTO() {
		return resultCompetenciasDTO;
	}

	/**
	 * @param resultCompetenciasDTO
	 *            the resultCompetenciasDTO to set
	 */
	public void setResultCompetenciasDTO(List<EvaluacionCompetenciasDTO> resultCompetenciasDTO) {
		this.resultCompetenciasDTO = resultCompetenciasDTO;
	}

	/**
	 * @return the resultadosDTO
	 */
	public List<EvaluacionResAprendizajeDTO> getResultadosDTO() {
		return resultadosDTO;
	}

	/**
	 * @param resultadosDTO
	 *            the resultadosDTO to set
	 */
	public void setResultadosDTO(List<EvaluacionResAprendizajeDTO> resultadosDTO) {
		this.resultadosDTO = resultadosDTO;
	}

	/**
	 * @return the totalObjetivos
	 */
	public Double getTotalObjetivos() {
		return totalObjetivos;
	}

	/**
	 * @param totalObjetivos
	 *            the totalObjetivos to set
	 */
	public void setTotalObjetivos(Double totalObjetivos) {
		this.totalObjetivos = totalObjetivos;
	}

	/**
	 * @return the totalCompetencias
	 */
	public Double getTotalCompetencias() {
		return totalCompetencias;
	}

	/**
	 * @param totalCompetencias
	 *            the totalCompetencias to set
	 */
	public void setTotalCompetencias(Double totalCompetencias) {
		this.totalCompetencias = totalCompetencias;
	}

	/**
	 * @return the totalResultados
	 */
	public Double getTotalResultados() {
		return totalResultados;
	}

	/**
	 * @param totalResultados
	 *            the totalResultados to set
	 */
	public void setTotalResultados(Double totalResultados) {
		this.totalResultados = totalResultados;
	}

	/**
	 * @return the efectividad
	 */
	public Double getEfectividad() {
		return efectividad;
	}

	/**
	 * @param efectividad
	 *            the efectividad to set
	 */
	public void setEfectividad(Double efectividad) {
		this.efectividad = efectividad;
	}

}
