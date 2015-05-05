/**
 * 
 */
package ec.com.uce.web.backing;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.entities.CompetenciaGenerale;
import ec.com.uce.dione.entities.Cumplimiento;
import ec.com.uce.dione.entities.Docente;
import ec.com.uce.dione.entities.EscuelaUce;
import ec.com.uce.dione.entities.MateriaSyllabus;
import ec.com.uce.dione.entities.MateriaUce;
import ec.com.uce.dione.entities.Objetivo;
import ec.com.uce.dione.entities.ResultadosAprendizaje;
import ec.com.uce.dione.entities.Syllabus;
import ec.com.uce.ejb.dto.EvaluacionCompetenciasDTO;
import ec.com.uce.ejb.dto.EvaluacionObjetivosDTO;
import ec.com.uce.ejb.dto.EvaluacionResAprendizajeDTO;
import ec.com.uce.ejb.service.DocenteService;
import ec.com.uce.ejb.service.SyllabusService;
import ec.com.uce.web.bean.ResultadoBean;
import ec.com.uce.web.util.ConstantesUtil;
import ec.com.uce.web.util.HiperionMensajes;
import ec.com.uce.web.util.MessagesController;

/**
 * <b> Permite administrar las acciones de la pagina web </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,15/01/2015
 * @since JDK1.6
 */
@ManagedBean
@SessionScoped
public class ResultadosBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{resultadoBean}")
	private ResultadoBean resultadoBean;

	@EJB
	private DocenteService docenteService;
	@EJB
	private SyllabusService syllabusService;

	private Syllabus syllabus;
	private Docente docente;
	private Boolean docenteEncontrado = false;
	private List<MateriaUce> materiaUces = new ArrayList<MateriaUce>();
	private List<SelectItem> materias = new ArrayList<SelectItem>();
	private List<EvaluacionObjetivosDTO> resultObjetivosDTO = new ArrayList<EvaluacionObjetivosDTO>();
	private List<EvaluacionCompetenciasDTO> resultCompetenciasDTO = new ArrayList<EvaluacionCompetenciasDTO>();
	private List<EvaluacionResAprendizajeDTO> resultadosDTO = new ArrayList<EvaluacionResAprendizajeDTO>();
	private Boolean activarGrafico = false;
	MateriaSyllabus materiaSyllabus;

	Logger log = Logger.getLogger(SyllabusBacking.class);

	/**
	 * 
	 * <b> Permite buscar un docente por medio del ingreso de la identificacion. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 07/01/2015]
	 * </p>
	 * 
	 * @throws DioneException
	 */
	public void buscarDocente() throws DioneException {
		try {
			docente = docenteService.consultarDocenteByCedula(resultadoBean.getCedula());
			if (docente != null) {
				docenteEncontrado = true;
				List<EscuelaUce> escuelas = syllabusService.consultarEscuelaByDocente(docente.getIdDocente().toString());

				for (EscuelaUce escuelaUce : escuelas) {
					List<MateriaUce> materiasTemp = syllabusService.consultarMateriasByEscuela(escuelaUce.getIdEscuelaUce());
					for (MateriaUce materiaUce : materiasTemp) {
						materiaUces.add(materiaUce);
					}
				}

			} else {
				docenteEncontrado = false;
				MessagesController.addError(null, HiperionMensajes.getInstancia().getString("dione.mensaje.error.buscar"));
			}

		} catch (DioneException e) {
			log.error("Error al momento consultar el docente", e);
			throw new DioneException(e);
		}

	}

	/**
	 * 
	 * <b> Permite actualizar la tabla de obetivos, elementos de competencia y resultados de aprendizaje. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 25/01/2015]
	 * </p>
	 * 
	 * @throws DioneException
	 */
	public void guardarEvaluacion() throws DioneException {
		try {

			// Actualizar objetivos
			List<Objetivo> objetivos = new ArrayList<Objetivo>();
			for (EvaluacionObjetivosDTO objetivoDTO : resultObjetivosDTO) {
				Objetivo objetivo = new Objetivo();

				objetivo.setIdObjetivo(objetivoDTO.getIdObjetivo());
				objetivo.setObjetivo(objetivoDTO.getObjetivo());
				objetivo.setInicioObj(objetivoDTO.getInicio());
				objetivo.setProcesoObj(objetivoDTO.getProceso());
				objetivo.setAvanceObj(objetivoDTO.getAvance());
				objetivo.setDominioObj(objetivoDTO.getDomina());

				objetivo.setSyllabus(syllabus);

				objetivos.add(objetivo);
			}

			// Actualizar competencias generales
			List<CompetenciaGenerale> competenciasGenerales = new ArrayList<CompetenciaGenerale>();
			for (EvaluacionCompetenciasDTO competenciaGeneralDTO : resultCompetenciasDTO) {
				CompetenciaGenerale competencia = new CompetenciaGenerale();

				competencia.setIdCompetenciaGeneral(competenciaGeneralDTO.getIdCompetencia());
				competencia.setCompetenciaGeneral(competenciaGeneralDTO.getCompetencia());
				competencia.setInicioComp(competenciaGeneralDTO.getInicio());
				competencia.setDominioComp(competenciaGeneralDTO.getDomina());
				competencia.setAvanceComp(competenciaGeneralDTO.getAvance());
				competencia.setProcesoComp(competenciaGeneralDTO.getProceso());

				competencia.setSyllabus(syllabus);

				competenciasGenerales.add(competencia);
			}

			// Actualizar resultados
			List<ResultadosAprendizaje> resultados = new ArrayList<ResultadosAprendizaje>();
			for (EvaluacionResAprendizajeDTO resultadoDTO : resultadosDTO) {
				ResultadosAprendizaje resultado = new ResultadosAprendizaje();

				resultado.setIdResultado(resultadoDTO.getIdResultado());
				resultado.setResultadoAprendizaje(resultadoDTO.getResultado());
				resultado.setInicioResul(resultadoDTO.getInicio());
				resultado.setDominioResul(resultadoDTO.getDomina());
				resultado.setAvanceResul(resultadoDTO.getAvance());
				resultado.setProcesoResul(resultadoDTO.getProceso());

				resultado.setSyllabus(syllabus);

				resultados.add(resultado);
			}

			Cumplimiento cumplimiento = new Cumplimiento();
			cumplimiento.setPorcentajeObjetivos(BigDecimal.valueOf(resultadoBean.getTotalObjetivos()));
			cumplimiento.setPorcentajeCompetencias(BigDecimal.valueOf(resultadoBean.getTotalCompetencias()));
			cumplimiento.setPorcentajeResultados(BigDecimal.valueOf(resultadoBean.getTotalResultados()));
			cumplimiento.setEfectividad(BigDecimal.valueOf(resultadoBean.getEfectividad()));
			cumplimiento.setMateriaSyllabus(materiaSyllabus);

			syllabusService.guardarCumplimiento(objetivos, competenciasGenerales, resultados, cumplimiento);
			resultCompetenciasDTO = new ArrayList<EvaluacionCompetenciasDTO>();
			resultObjetivosDTO = new ArrayList<EvaluacionObjetivosDTO>();
			resultadosDTO = new ArrayList<EvaluacionResAprendizajeDTO>();

			resultadoBean.setTotalObjetivos(null);
			resultadoBean.setTotalCompetencias(null);
			resultadoBean.setTotalResultados(null);
			resultadoBean.setEfectividad(null);

			MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("dione.mensaje.exito.save"));

		} catch (DioneException e) {
			log.error("Error al momento guardar la evaluacion", e);
			throw new DioneException(e);
		}
	}

	/**
	 * 
	 * <b> Permite calcular el porcentaje de cada uno de los cumplimientos. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 30/03/2015]
	 * </p>
	 * 
	 */
	public void calcularPorcentajes() {
		int inicio = 0;
		int proceso = 0;
		int avance = 0;
		int domina = 0;

		for (EvaluacionObjetivosDTO objetivo : resultObjetivosDTO) {
			if (objetivo.getInicio()) {
				inicio += ConstantesUtil.INICIO;
			}
			if (objetivo.getProceso()) {
				proceso += ConstantesUtil.PROCESO;
			}
			if (objetivo.getAvance()) {
				avance += ConstantesUtil.AVANCE;
			}
			if (objetivo.getDomina()) {
				domina += ConstantesUtil.DOMINIO;
			}
		}
		Double resultadoObjetivos = (double) ((inicio + proceso + avance + domina) / resultObjetivosDTO.size());
		resultadoBean.setTotalObjetivos(resultadoObjetivos);

		inicio = 0;
		proceso = 0;
		avance = 0;
		domina = 0;
		for (EvaluacionCompetenciasDTO competencia : resultCompetenciasDTO) {
			if (competencia.getInicio()) {
				inicio += ConstantesUtil.INICIO;
			}
			if (competencia.getProceso()) {
				proceso += ConstantesUtil.PROCESO;
			}
			if (competencia.getAvance()) {
				avance += ConstantesUtil.AVANCE;
			}
			if (competencia.getDomina()) {
				domina += ConstantesUtil.DOMINIO;
			}
		}
		Double resultadoCompetencias = (double) ((inicio + proceso + avance + domina) / resultCompetenciasDTO.size());
		resultadoBean.setTotalCompetencias(resultadoCompetencias);

		inicio = 0;
		proceso = 0;
		avance = 0;
		domina = 0;
		for (EvaluacionResAprendizajeDTO resultado : resultadosDTO) {
			if (resultado.getInicio()) {
				inicio += ConstantesUtil.INICIO;
			}
			if (resultado.getProceso()) {
				proceso += ConstantesUtil.PROCESO;
			}
			if (resultado.getAvance()) {
				avance += ConstantesUtil.AVANCE;
			}
			if (resultado.getDomina()) {
				domina += ConstantesUtil.DOMINIO;
			}
		}
		Double resultado = (double) ((inicio + proceso + avance + domina) / resultadosDTO.size());
		resultadoBean.setTotalResultados(resultado);

		Double efectividad = ((resultadoObjetivos * 50) + (resultadoCompetencias * 25) + (resultado * 25)) / 100;

		resultadoBean.setEfectividad(efectividad);
	}

	/**
	 * 
	 * <b> Permite buscar el syllabus y con este objeto agregar ls objetivos, competencias y resultados de aprendizaje </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 21/01/2015]
	 * </p>
	 * 
	 * @throws DioneException
	 */
	public void buscarSyllabus() throws DioneException {

		resultObjetivosDTO = new ArrayList<EvaluacionObjetivosDTO>();
		resultCompetenciasDTO = new ArrayList<EvaluacionCompetenciasDTO>();
		resultadosDTO = new ArrayList<EvaluacionResAprendizajeDTO>();

		Integer idDocente = docente.getIdDocente();
		Integer idMateria = Integer.parseInt(resultadoBean.getMateria().toString());

		materiaSyllabus = syllabusService.consultarSyllabus(idDocente, idMateria);

		MateriaSyllabus materiaSyllabusTemp = syllabusService.consultarMateriaSyllabusById(materiaSyllabus.getIdMateriaSyllabus());

		Integer idSyllabus = materiaSyllabusTemp.getSyllabus().getIdSyllabus();

		syllabus = syllabusService.consultarSyllabusById(idSyllabus);

		try {

			List<Objetivo> objetivos = syllabusService.consultarObjetivos(syllabus.getIdSyllabus());
			List<CompetenciaGenerale> competencias = syllabusService.consultarCompetenciasBySyllabus(syllabus.getIdSyllabus());
			List<ResultadosAprendizaje> resultados = syllabusService.consultarResultadosAprendizaje(syllabus.getIdSyllabus());

			for (Objetivo objetivo : objetivos) {
				EvaluacionObjetivosDTO objetivoDTO = new EvaluacionObjetivosDTO();
				objetivoDTO.setObjetivo(objetivo.getObjetivo());
				objetivoDTO.setIdObjetivo(objetivo.getIdObjetivo());
				resultObjetivosDTO.add(objetivoDTO);
			}
			for (CompetenciaGenerale competencia : competencias) {
				EvaluacionCompetenciasDTO competenciaDTO = new EvaluacionCompetenciasDTO();
				competenciaDTO.setIdCompetencia(competencia.getIdCompetenciaGeneral());
				competenciaDTO.setCompetencia(competencia.getCompetenciaGeneral());
				resultCompetenciasDTO.add(competenciaDTO);
			}
			for (ResultadosAprendizaje resultado : resultados) {
				EvaluacionResAprendizajeDTO resultadoDTO = new EvaluacionResAprendizajeDTO();
				resultadoDTO.setIdResultado(resultado.getIdResultado());
				resultadoDTO.setResultado(resultado.getResultadoAprendizaje());
				resultadosDTO.add(resultadoDTO);
			}

			resultadoBean.setResultObjetivosDTO(resultObjetivosDTO);
			resultadoBean.setResultCompetenciasDTO(resultCompetenciasDTO);
			resultadoBean.setResultadosDTO(resultadosDTO);

		} catch (DioneException e) {
			log.error("Error al momento consultar el syllabus", e);
			throw new DioneException(e);
		}
	}

	/**
	 * @return the docente
	 */
	public Docente getDocente() {
		return docente;
	}

	/**
	 * @param docente
	 *            the docente to set
	 */
	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	/**
	 * @return the docenteEncontrado
	 */
	public Boolean getDocenteEncontrado() {
		return docenteEncontrado;
	}

	/**
	 * @param docenteEncontrado
	 *            the docenteEncontrado to set
	 */
	public void setDocenteEncontrado(Boolean docenteEncontrado) {
		this.docenteEncontrado = docenteEncontrado;
	}

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
	 * @return the materiaUces
	 */
	public List<MateriaUce> getMateriaUces() {
		return materiaUces;
	}

	/**
	 * @param materiaUces
	 *            the materiaUces to set
	 */
	public void setMateriaUces(List<MateriaUce> materiaUces) {
		this.materiaUces = materiaUces;
	}

	/**
	 * @return the materias
	 */
	public List<SelectItem> getMaterias() {
		materias = new ArrayList<SelectItem>();
		for (MateriaUce materiaUce : materiaUces) {
			SelectItem selectItem = new SelectItem(materiaUce.getIdMateriaUce(), materiaUce.getMateriaUce());
			materias.add(selectItem);
		}
		return materias;
	}

	/**
	 * @param materias
	 *            the materias to set
	 */
	public void setMaterias(List<SelectItem> materias) {
		this.materias = materias;
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
	 * @return the activarGrafico
	 */
	public Boolean getActivarGrafico() {
		return activarGrafico;
	}

	/**
	 * @param activarGrafico
	 *            the activarGrafico to set
	 */
	public void setActivarGrafico(Boolean activarGrafico) {
		this.activarGrafico = activarGrafico;
	}

}
