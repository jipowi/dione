/**
 * 
 */
package ec.com.uce.web.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

import ec.com.uce.ejb.dto.EvaluacionCompetenciasDTO;
import ec.com.uce.ejb.dto.EvaluacionObjetivosDTO;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Anita Carrera
 * @version 1.0,24/01/2015
 * @since JDK1.6
 */
@ManagedBean
@SessionScoped
public class EvaluacionBean implements Serializable {

	private static final long serialVersionUID = 6401166601481931346L;

	@ManagedProperty(value = "#{resultadoBean}")
	private ResultadoBean resultadoBean;

	private CartesianChartModel evaluacion;

	/**
	 * @return the resultadoBean
	 */
	public ResultadoBean getResultadoBean() {
		return resultadoBean;
	}

	/**
	 * @param resultadoBean
	 *            the resultadoBean to set
	 */
	public void setResultadoBean(ResultadoBean resultadoBean) {
		this.resultadoBean = resultadoBean;
	}

	/**
	 * @return the evaluacion
	 */
	public CartesianChartModel getEvaluacion() {
		return evaluacion;
	}

	/**
	 * @param evaluacion
	 *            the evaluacion to set
	 */
	public void setEvaluacion(CartesianChartModel evaluacion) {
		this.evaluacion = evaluacion;
	}

	@PostConstruct
	public void init() {

		evaluacion = new CartesianChartModel();

		Integer numObjetivos = resultadoBean.getResultObjetivosDTO().size();
		Integer valorObjetivo = 100 / numObjetivos;
		Integer valorYObjetivo = 0;

		ChartSeries objetivosReales = new ChartSeries("Objetivo Real");
		for (EvaluacionObjetivosDTO objetivoDTO : resultadoBean.getResultObjetivosDTO()) {
//			if (objetivoDTO.getCumplido()) {
//				valorYObjetivo += valorObjetivo;
//			}
		}
		objetivosReales.set("Objetivos", valorYObjetivo);
		
		ChartSeries objetivosEsperados = new ChartSeries("Objetivo Esperado");
		objetivosEsperados.set("Esperado", 100);
		
		evaluacion.addSeries(objetivosReales);
		evaluacion.addSeries(objetivosEsperados);
		

		
		Integer numCompetencias = resultadoBean.getResultCompetenciasDTO().size();
		Integer valorCompetencia = 100 / numCompetencias;
		Integer valorYCompetencia = 0;

		ChartSeries competenciasReales = new ChartSeries("Competencias");
		for (EvaluacionCompetenciasDTO competenciaDTO : resultadoBean.getResultCompetenciasDTO()) {
//			if (competenciaDTO.getCumplido()) {
//				valorYCompetencia += valorCompetencia;
//			}
		}
		competenciasReales.set("Competencias", valorYCompetencia);
		
		ChartSeries competenciasEsperadas = new ChartSeries("Competencia Esperada");
		competenciasEsperadas.set("Esperado", 100);
		
		evaluacion.addSeries(competenciasReales);
		evaluacion.addSeries(competenciasEsperadas);
	}
}