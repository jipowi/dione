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
 * @author Paul Jimenez
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

}
