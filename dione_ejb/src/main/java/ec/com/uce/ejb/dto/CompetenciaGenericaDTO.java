/**
 * 
 */
package ec.com.uce.ejb.dto;

import java.io.Serializable;

/**
 * <b> Permite manejar la informacion de las competencias genericas </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,12/02/2015
 * @since JDK1.6
 */
public class CompetenciaGenericaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idCompetenciaGenerica;
	private String competenciaGenerica;
	private Integer tipoCompetencia;
	private Boolean seleccion;

	/**
	 * @return the tipoCompetencia
	 */
	public Integer getTipoCompetencia() {
		return tipoCompetencia;
	}

	/**
	 * @param tipoCompetencia
	 *            the tipoCompetencia to set
	 */
	public void setTipoCompetencia(Integer tipoCompetencia) {
		this.tipoCompetencia = tipoCompetencia;
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

	/**
	 * @return the idCompetenciaGenerica
	 */
	public Integer getIdCompetenciaGenerica() {
		return idCompetenciaGenerica;
	}

	/**
	 * @param idCompetenciaGenerica
	 *            the idCompetenciaGenerica to set
	 */
	public void setIdCompetenciaGenerica(Integer idCompetenciaGenerica) {
		this.idCompetenciaGenerica = idCompetenciaGenerica;
	}

	/**
	 * @return the competenciaGenerica
	 */
	public String getCompetenciaGenerica() {
		return competenciaGenerica;
	}

	/**
	 * @param competenciaGenerica
	 *            the competenciaGenerica to set
	 */
	public void setCompetenciaGenerica(String competenciaGenerica) {
		this.competenciaGenerica = competenciaGenerica;
	}

}
