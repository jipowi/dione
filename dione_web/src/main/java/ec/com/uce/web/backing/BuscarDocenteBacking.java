package ec.com.uce.web.backing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.entities.CompetenciaGenerale;
import ec.com.uce.dione.entities.CompetenciasEspecifica;
import ec.com.uce.dione.entities.CompetenciasGenerica;
import ec.com.uce.dione.entities.Docente;
import ec.com.uce.dione.entities.EscuelaUce;
import ec.com.uce.dione.entities.MateriaSyllabus;
import ec.com.uce.dione.entities.MateriaUce;
import ec.com.uce.dione.entities.Syllabus;
import ec.com.uce.ejb.dto.AsignaturaDTO;
import ec.com.uce.ejb.dto.MateriaDTO;
import ec.com.uce.ejb.service.DocenteService;
import ec.com.uce.ejb.service.SyllabusService;
import ec.com.uce.web.bean.BuscarDocenteBean;
import ec.com.uce.web.util.ConstantesUtil;
import ec.com.uce.web.util.GenerarPdfUtil;
import ec.com.uce.web.util.HiperionMensajes;
import ec.com.uce.web.util.JsfUtil;
import ec.com.uce.web.util.MessagesController;

/**
 * <b> Permite buscar los datos del docente </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,06/02/2015
 * @since JDK1.6
 */
@ManagedBean
@SessionScoped
public class BuscarDocenteBacking implements Serializable {

	private static final long serialVersionUID = 1L;
	@EJB
	private DocenteService docenteService;
	@EJB
	private SyllabusService syllabusService;

	@ManagedProperty(value = "#{buscarDocenteBean}")
	private BuscarDocenteBean buscarDocenteBean;

	private Docente docente;
	private Syllabus syllabus;
	private Boolean docenteEncontrado = false;

	private Boolean activarHojaVida = false;
	private List<SelectItem> materias = new ArrayList<SelectItem>();
	private List<MateriaUce> materiaUces = new ArrayList<MateriaUce>();

	Logger log = Logger.getLogger(BuscarDocenteBacking.class);

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
			docente = docenteService.consultarDocenteByCedula(buscarDocenteBean.getCedulaDocente());
			if (docente != null) {
				docenteEncontrado = true;
				activarHojaVida = true;
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
	 * <b> Permite buscar un docente por medio del ingreso de la identificacion. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 07/01/2015]
	 * </p>
	 * 
	 * @throws DioneException
	 */
	public void buscarDatosDocente() throws DioneException {
		try {
			// Hoja de vida
			if (docente != null) {
				
				buscarDocenteBean.setApellidosDocente(docente.getApellidosDocente());
				buscarDocenteBean.setNombresDocente(docente.getNombresDocente());
				buscarDocenteBean.setDireccionDocente(docente.getDireccionDocente());

				List<AsignaturaDTO> escuelasMateriasDTO = new ArrayList<AsignaturaDTO>();

				List<EscuelaUce> escuelas = syllabusService.consultarEscuelaByDocente(docente.getIdDocente().toString());

				for (EscuelaUce escuelaUce : escuelas) {
					AsignaturaDTO asignaturaDTO = new AsignaturaDTO();
					asignaturaDTO.setEscuela(escuelaUce.getEscuelaUce());

					List<MateriaUce> materias = syllabusService.consultarMateriasByEscuela(escuelaUce.getIdEscuelaUce());
					List<MateriaDTO> materiasDTO = new ArrayList<MateriaDTO>();
					for (MateriaUce materia : materias) {
						MateriaDTO materiaDTO = new MateriaDTO();
						materiaDTO.setDesMateria(materia.getMateriaUce());
						materiasDTO.add(materiaDTO);
					}

					asignaturaDTO.setMaterias(materiasDTO);

					escuelasMateriasDTO.add(asignaturaDTO);
				}
				buscarDocenteBean.setEscuelaMateriasList(escuelasMateriasDTO);

				buscarDocenteBean.setFormacionesA(docenteService.consultarFormacionAByDocente(docente.getIdDocente()));
				buscarDocenteBean.setFormacionesC(docenteService.consultarFormacionCByDocente(docente.getIdDocente()));
				buscarDocenteBean.setExperiencias(docenteService.consultarExperienciasByDocente(docente.getIdDocente()));

				// Syllabus
				
				Integer idDocente = docente.getIdDocente();
				Integer idMateria = Integer.parseInt(buscarDocenteBean.getMateria().toString());
				
				MateriaSyllabus materiaSyllabus = syllabusService.consultarSyllabus(idDocente, idMateria);
				
				Integer idSyllabus = materiaSyllabus.getSyllabus().getIdSyllabus();
				
				syllabus = syllabusService.consultarSyllabusById(idSyllabus);
				
				buscarDocenteBean.setMateria(materiaSyllabus.getMateriaUce().getMateriaUce());
				buscarDocenteBean.setNumHorasPresenciales(syllabus.getNumHorasPresenciales());
				buscarDocenteBean.setNumHorasTutorias(syllabus.getHorasTutorias());
				buscarDocenteBean.setDesAsignatura(syllabus.getDescripcionAsignatura());

				// Prerequisitos
				buscarDocenteBean.setPrerequisitos(syllabusService.obtenerPrerequisitos(materiaSyllabus.getIdMateriaSyllabus()));
				buscarDocenteBean.setCorequisitos(syllabusService.obtenerCorequisitos(materiaSyllabus.getIdMateriaSyllabus()));

				// Objetivos
				buscarDocenteBean.setObjetivos(syllabusService.consultarObjetivos(idSyllabus));

				List<CompetenciaGenerale> competenciasGenerales = syllabusService.consultarCompetenciasBySyllabus(idSyllabus);
				List<CompetenciasGenerica> competenciasGenericas = syllabusService.consultarCompGenricasBySyllabus(idSyllabus);
				List<CompetenciasEspecifica> competenciasEspecificas = syllabusService.consultarCompEspecificaBySyllabus(idSyllabus);

				List<CompetenciasGenerica> competenciasInstrumentales = new ArrayList<CompetenciasGenerica>();
				List<CompetenciasGenerica> competenciasInterpersonales = new ArrayList<CompetenciasGenerica>();
				List<CompetenciasGenerica> competenciasSistematicas = new ArrayList<CompetenciasGenerica>();
				buscarDocenteBean.setCompetenciasGenerales(competenciasGenerales);

				for (CompetenciasGenerica competencia : competenciasGenericas) {
					if (competencia.getTipoCompetencia() == 1) {
						competenciasInstrumentales.add(competencia);
					} else if (competencia.getTipoCompetencia() == 2) {
						competenciasInterpersonales.add(competencia);
					} else if (competencia.getTipoCompetencia() == 3) {
						competenciasSistematicas.add(competencia);
					}
				}

				buscarDocenteBean.setCompetenciasInstrumentales(competenciasInstrumentales);
				buscarDocenteBean.setCompetenciasInterpersonales(competenciasInterpersonales);
				buscarDocenteBean.setCompetenciasSistematicas(competenciasSistematicas);

				buscarDocenteBean.setCompetenciasEspecificas(competenciasEspecificas);

				// Bibliografias
				buscarDocenteBean.setBibliografias(syllabusService.consultarBibliografiasBySyllabus(idSyllabus));

				// Resultados
				buscarDocenteBean.setResultados(syllabusService.consultarResultadosAprendizaje(idSyllabus));

				// Unidades de competencias
				buscarDocenteBean.setUnidadesDTO(syllabusService.consultarUnidadesDTO(idSyllabus));

			} else {
				MessagesController.addError(null, HiperionMensajes.getInstancia().getString("dione.mensaje.error.buscar"));
			}

		} catch (Exception e) {
			log.error("Error al momento consultar el docente", e);
			throw new DioneException(e);
		}

	}

	/**
	 * @return the buscarDocenteBean
	 */
	public BuscarDocenteBean getBuscarDocenteBean() {
		return buscarDocenteBean;
	}

	/**
	 * @param buscarDocenteBean
	 *            the buscarDocenteBean to set
	 */
	public void setBuscarDocenteBean(BuscarDocenteBean buscarDocenteBean) {
		this.buscarDocenteBean = buscarDocenteBean;
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
	 * @return the activarHojaVida
	 */
	public Boolean getActivarHojaVida() {
		return activarHojaVida;
	}

	/**
	 * @param activarHojaVida
	 *            the activarHojaVida to set
	 */
	public void setActivarHojaVida(Boolean activarHojaVida) {
		this.activarHojaVida = activarHojaVida;
	}

	/**
	 * 
	 * <b> Permite generar y descargar la hoja de vida en formato PDF. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 01/03/2015]
	 * </p>
	 * 
	 * @throws DioneException
	 */
	public void descargarHojaVidaPDF() throws DioneException {
		try {
			Map<String, Object> parametrosReporte = new HashMap<String, Object>();

			parametrosReporte.put(ConstantesUtil.CONTENT_TYPE_IDENTIFICADOR, ConstantesUtil.CONTENT_TYPE_PDF);
			parametrosReporte.put(ConstantesUtil.NOMBRE_ARCHIVO_IDENTIFICADOR, docente.getCedulaDocente());

			parametrosReporte
					.put(ConstantesUtil.CONTENIDO_BYTES_IDENTIFICADOR,
							GenerarPdfUtil.generarAchivoPDFHojaVida(docente, buscarDocenteBean.getFormacionesA(), buscarDocenteBean.getFormacionesC(),
									buscarDocenteBean.getExperiencias()));

			JsfUtil.setSessionAttribute(ConstantesUtil.PARAMETROS_DESCARGADOR_IDENTIFICADOR, parametrosReporte);
			JsfUtil.downloadFile();

		} catch (Exception e) {
			log.error("Error al momento generar el a hoja de vida en PDF", e);
			throw new DioneException(e);
		}

	}

	/**
	 * 
	 * <b> Permite generar y descargar el syllabus en formato PDF. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 01/03/2015]
	 * </p>
	 * 
	 * @throws DioneException
	 */
	public void descargarSyllabusPDF() throws DioneException {
		try {
			Map<String, Object> parametrosReporte = new HashMap<String, Object>();

			parametrosReporte.put(ConstantesUtil.CONTENT_TYPE_IDENTIFICADOR, ConstantesUtil.CONTENT_TYPE_PDF);
			parametrosReporte.put(ConstantesUtil.NOMBRE_ARCHIVO_IDENTIFICADOR, "syllabus " + docente.getCedulaDocente());

			parametrosReporte.put(ConstantesUtil.CONTENIDO_BYTES_IDENTIFICADOR, GenerarPdfUtil.generarAchivoPDFSyllabus(syllabus, buscarDocenteBean.getPrerequisitos(),
					buscarDocenteBean.getCorequisitos(), buscarDocenteBean.getObjetivos(), buscarDocenteBean.getCompetenciasGenerales(),
					buscarDocenteBean.getCompetenciasInstrumentales(), buscarDocenteBean.getCompetenciasInterpersonales(), buscarDocenteBean.getCompetenciasSistematicas(),
					buscarDocenteBean.getCompetenciasEspecificas(), buscarDocenteBean.getBibliografias(), buscarDocenteBean.getResultados(), buscarDocenteBean.getUnidadesDTO()));

			JsfUtil.setSessionAttribute(ConstantesUtil.PARAMETROS_DESCARGADOR_IDENTIFICADOR, parametrosReporte);

			JsfUtil.downloadFile();

		} catch (Exception e) {
			log.error("Error al momento generar el a hoja de vida en PDF", e);
			throw new DioneException(e);
		}

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

}
