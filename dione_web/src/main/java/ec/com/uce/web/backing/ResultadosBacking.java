/**
 * 
 */
package ec.com.uce.web.backing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.entities.Competencia;
import ec.com.uce.dione.entities.Docente;
import ec.com.uce.dione.entities.EscuelaUce;
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
					List<MateriaUce> materiasTemp = syllabusService.consultarMateriasByEscuela(new Long(escuelaUce.getIdEscuelaUce()));
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

			List<Objetivo> objetivos = new ArrayList<Objetivo>();
			for (EvaluacionObjetivosDTO objetivoDTO : resultObjetivosDTO) {
				Objetivo objetivo = new Objetivo();

				objetivo.setIdObjetivo(objetivoDTO.getIdObjetivo());
				objetivo.setObjetivo(objetivoDTO.getObjetivo());
				objetivo.setObjetivoCumplido(objetivoDTO.getCumplido());
				objetivo.setSyllabus(syllabus);

				objetivos.add(objetivo);
			}

			syllabusService.actualizarObjetivos(objetivos);

			List<ResultadosAprendizaje> resultados = new ArrayList<ResultadosAprendizaje>();
			for (EvaluacionResAprendizajeDTO resultadoDTO : resultadosDTO) {
				ResultadosAprendizaje resultado = new ResultadosAprendizaje();

				resultado.setIdResultado(resultadoDTO.getIdResultado());
				resultado.setResultadoAprendizaje(resultadoDTO.getResultado());
				resultado.setInicio(resultadoDTO.getInicio());
				resultado.setSyllabus(syllabus);
				resultado.setDominio(resultadoDTO.getDomina());
				resultado.setAvance(resultadoDTO.getAvance());
				resultado.setProceso(resultadoDTO.getProceso());

				resultados.add(resultado);
			}

			syllabusService.actualizarResultados(resultados);
			
			activarGrafico = true;

		} catch (DioneException e) {
			log.error("Error al momento guardar la evaluacion", e);
			throw new DioneException(e);
		}
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

		Long idDocente = docente.getIdDocente();
		Long idMateria = Long.parseLong(resultadoBean.getMateria());

		try {
			syllabus = syllabusService.consultarSyllabusByDocenteAndMateria(idDocente, idMateria);
			List<Objetivo> objetivos = syllabusService.conusltarObjetivos(syllabus.getIdSyllabus());
			List<Competencia> competencias = syllabusService.consultarCompetenciasBySyllabus(syllabus.getIdSyllabus());
			List<ResultadosAprendizaje> resultados = syllabusService.consultarResultadosAprendizaje(syllabus.getIdSyllabus());

			for (Objetivo objetivo : objetivos) {
				EvaluacionObjetivosDTO objetivoDTO = new EvaluacionObjetivosDTO();
				objetivoDTO.setObjetivo(objetivo.getObjetivo());
				objetivoDTO.setIdObjetivo(objetivo.getIdObjetivo());
				resultObjetivosDTO.add(objetivoDTO);
			}
			for (Competencia competencia : competencias) {
				EvaluacionCompetenciasDTO competenciaDTO = new EvaluacionCompetenciasDTO();
				competenciaDTO.setIdCompetencia(competencia.getIdCompetencia());
				competenciaDTO.setCompetencia(competencia.getCompetencia());
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
	 * @param activarGrafico the activarGrafico to set
	 */
	public void setActivarGrafico(Boolean activarGrafico) {
		this.activarGrafico = activarGrafico;
	}

}
