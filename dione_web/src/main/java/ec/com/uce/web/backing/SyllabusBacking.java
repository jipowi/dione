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
import ec.com.uce.dione.entities.Bibliografia;
import ec.com.uce.dione.entities.Catalogo;
import ec.com.uce.dione.entities.CompetenciaGenerale;
import ec.com.uce.dione.entities.CompetenciasEspecifica;
import ec.com.uce.dione.entities.CompetenciasGenerica;
import ec.com.uce.dione.entities.Corequisito;
import ec.com.uce.dione.entities.DetalleCatalogo;
import ec.com.uce.dione.entities.Docente;
import ec.com.uce.dione.entities.ElementoCompetencia;
import ec.com.uce.dione.entities.EscuelaUce;
import ec.com.uce.dione.entities.MateriaSyllabus;
import ec.com.uce.dione.entities.MateriaUce;
import ec.com.uce.dione.entities.Objetivo;
import ec.com.uce.dione.entities.Prerequisito;
import ec.com.uce.dione.entities.ResultadosAprendizaje;
import ec.com.uce.dione.entities.Syllabus;
import ec.com.uce.dione.entities.UnidadCompetencia;
import ec.com.uce.ejb.dto.BibliografiaDTO;
import ec.com.uce.ejb.dto.CompetenciaEspecificaDTO;
import ec.com.uce.ejb.dto.CompetenciaGeneralDTO;
import ec.com.uce.ejb.dto.CompetenciaGenericaDTO;
import ec.com.uce.ejb.dto.ElementosCompetenciaDTO;
import ec.com.uce.ejb.dto.ObjetivoDTO;
import ec.com.uce.ejb.dto.ResultadoAprendizajeDTO;
import ec.com.uce.ejb.dto.UnidadCompetenciaDTO;
import ec.com.uce.ejb.service.CatalogoService;
import ec.com.uce.ejb.service.DocenteService;
import ec.com.uce.ejb.service.SyllabusService;
import ec.com.uce.web.bean.SyllabusBean;
import ec.com.uce.web.util.HiperionMensajes;
import ec.com.uce.web.util.MessagesController;

/**
 * <b> Permite almacenar la informacion de la pagina web y administrar las acciones de la misma </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,05/01/2015
 * @since JDK1.6
 */
@ManagedBean
@SessionScoped
public class SyllabusBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private DocenteService docenteService;
	@EJB
	private SyllabusService syllabusService;
	@EJB
	private CatalogoService catalogoService;

	@ManagedProperty(value = "#{syllabusBean}")
	private SyllabusBean syllabusBean;

	private List<SelectItem> materias = new ArrayList<SelectItem>();
	private List<MateriaUce> materiaUces = new ArrayList<MateriaUce>();
	private List<Prerequisito> prerequisitos = new ArrayList<Prerequisito>();
	private List<Corequisito> corequisitos = new ArrayList<Corequisito>();
	private List<CompetenciaGenericaDTO> competenciasInterpersonalesDTO = new ArrayList<CompetenciaGenericaDTO>();
	private List<CompetenciaGenericaDTO> competenciasInstrumentalesDTO = new ArrayList<CompetenciaGenericaDTO>();
	private List<CompetenciaGenericaDTO> competenciasSistematicasDTO = new ArrayList<CompetenciaGenericaDTO>();
	private List<CompetenciasGenerica> competenciasInterpersonales = new ArrayList<CompetenciasGenerica>();
	private List<CompetenciasGenerica> competenciasInstrumentales = new ArrayList<CompetenciasGenerica>();
	private List<CompetenciasGenerica> competenciasSistematicas = new ArrayList<CompetenciasGenerica>();

	private Docente docente;
	private Boolean docenteEncontrado = false;
	private Boolean activarRequisitos = false;

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
			docente = docenteService.consultarDocenteByCedula(syllabusBean.getCedula());
			if (docente != null) {
				materiaUces = new ArrayList<MateriaUce>();
				docenteEncontrado = true;
				List<EscuelaUce> escuelas = syllabusService.consultarEscuelaByDocente(docente.getIdDocente().toString());

				for (EscuelaUce escuelaUce : escuelas) {
					List<MateriaUce> materiasTemp = syllabusService.consultarMateriasByEscuela(escuelaUce.getIdEscuelaUce());
					for (MateriaUce materiaUce : materiasTemp) {
						materiaUces.add(materiaUce);
					}
				}
				obtenerCompetenciasGenericas();

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
	 * <b> Permite obtener los prerequisitos de la materia seleccionada </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 11/02/2015]
	 * </p>
	 * 
	 * @throws DioneException
	 */
	public void obtenerPrerequisitos() throws DioneException {
		Integer idMateria = Integer.parseInt(syllabusBean.getMateria());
		prerequisitos = syllabusService.obtenerPrerequisitos(idMateria);
		corequisitos = syllabusService.obtenerCorequisitos(idMateria);
		activarRequisitos = true;
	}

	/**
	 * 
	 * <b> Permite visualizar las competencias seleccionadas en el popup </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 12/02/2015]
	 * </p>
	 * 
	 */
	public void agregarCompetenciasGenericas() {
		for (CompetenciaGenericaDTO instrumentalDTO : competenciasInterpersonalesDTO) {
			CompetenciasGenerica compGenerica = new CompetenciasGenerica();
			if (instrumentalDTO.getSeleccion()) {
				compGenerica.setCompetenciaGenerica(instrumentalDTO.getCompetenciaGenerica());
				compGenerica.setTipoCompetencia(instrumentalDTO.getTipoCompetencia());
				competenciasInterpersonales.add(compGenerica);
			}
		}
		for (CompetenciaGenericaDTO instrumentalDTO : competenciasInstrumentalesDTO) {
			CompetenciasGenerica compGenerica = new CompetenciasGenerica();
			if (instrumentalDTO.getSeleccion()) {
				compGenerica.setCompetenciaGenerica(instrumentalDTO.getCompetenciaGenerica());
				compGenerica.setTipoCompetencia(instrumentalDTO.getTipoCompetencia());
				competenciasInstrumentales.add(compGenerica);
			}
		}
		for (CompetenciaGenericaDTO instrumentalDTO : competenciasSistematicasDTO) {
			CompetenciasGenerica compGenerica = new CompetenciasGenerica();
			if (instrumentalDTO.getSeleccion()) {
				compGenerica.setCompetenciaGenerica(instrumentalDTO.getCompetenciaGenerica());
				compGenerica.setTipoCompetencia(instrumentalDTO.getTipoCompetencia());
				competenciasSistematicas.add(compGenerica);
			}
		}

	}

	/**
	 * 
	 * <b> Permite guardar el syllabus en la base de datos </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 14/01/2015]
	 * </p>
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	public void guardarSyllabus() throws Exception {
		try {
			// Cabecera Syllabus
			Syllabus syllabus = new Syllabus();

			MateriaUce materiaUce = syllabusService.consultarMateriaById(Integer.parseInt(syllabusBean.getMateria()));

			List<MateriaSyllabus> materiaSyllabuses = new ArrayList<MateriaSyllabus>();
			MateriaSyllabus materiaSyllabus = new MateriaSyllabus();
			materiaSyllabus.setMateriaUce(materiaUce);
			materiaSyllabus.setSyllabus(syllabus);
			materiaSyllabus.setDocente(docente);
			materiaSyllabuses.add(materiaSyllabus);

			syllabus.setMateriaSyllabuses(materiaSyllabuses);

			syllabus.setDescripcionAsignatura(syllabusBean.getDesAsigantura());
			syllabus.setNumHorasPresenciales(syllabusBean.getNumHorasPresenciales());
			syllabus.setHorasTutorias(syllabusBean.getNumHorasTutorias());
			syllabus.setMetodologia(syllabusBean.getMetodologia());

			syllabusBean.setDesAsigantura("");
			syllabusBean.setNumHorasPresenciales(0);
			syllabusBean.setNumHorasTutorias(0);
			syllabusBean.setMetodologia("");

			// Objetivos
			List<Objetivo> objetivos = new ArrayList<Objetivo>();
			for (ObjetivoDTO objetivoDTO : syllabusBean.getObjetivosDTOs()) {
				Objetivo objetivo = new Objetivo();
				objetivo.setObjetivo(objetivoDTO.getObjetivo());
				objetivos.add(objetivo);
			}
			syllabusBean.setObjetivo("");
			syllabusBean.setObjetivosDTOs(null);

			// Competencias Generales
			List<CompetenciaGenerale> competenciasGenerales = new ArrayList<CompetenciaGenerale>();
			for (CompetenciaGeneralDTO competenciaDTO : syllabusBean.getCompetenciasGeneralesDTOs()) {
				CompetenciaGenerale competencia = new CompetenciaGenerale();
				competencia.setCompetenciaGeneral(competenciaDTO.getCompetenciaGeneral());

				competenciasGenerales.add(competencia);
			}
			syllabusBean.setCompetenciaGeneral("");
			syllabusBean.setCompetenciasGeneralesDTOs(null);

			List<CompetenciasGenerica> competenciasGenericas = new ArrayList<CompetenciasGenerica>();
			// Instrumentales
			for (CompetenciasGenerica competenciaInstrumental : competenciasInstrumentales) {
				CompetenciasGenerica competenciaGenericaInst = new CompetenciasGenerica();

				competenciaGenericaInst.setTipoCompetencia(1);
				competenciaGenericaInst.setCompetenciaGenerica(competenciaInstrumental.getCompetenciaGenerica());

				competenciasGenericas.add(competenciaGenericaInst);
			}
			// Interpersonales
			for (CompetenciasGenerica competenciaInterpersonal : competenciasInterpersonales) {
				CompetenciasGenerica competenciaGenericaInter = new CompetenciasGenerica();

				competenciaGenericaInter.setTipoCompetencia(2);
				competenciaGenericaInter.setCompetenciaGenerica(competenciaInterpersonal.getCompetenciaGenerica());

				competenciasGenericas.add(competenciaGenericaInter);
			}
			// Sistematicas
			for (CompetenciasGenerica competenciaSistematica : competenciasSistematicas) {
				CompetenciasGenerica competenciaGenericaSis = new CompetenciasGenerica();

				competenciaGenericaSis.setTipoCompetencia(3);
				competenciaGenericaSis.setCompetenciaGenerica(competenciaSistematica.getCompetenciaGenerica());

				competenciasGenericas.add(competenciaGenericaSis);
			}

			syllabus.setCompetenciasGenericas(competenciasGenericas);

			// Competencias Especificas
			List<CompetenciasEspecifica> competenciasEspecificas = new ArrayList<CompetenciasEspecifica>();
			for (CompetenciaEspecificaDTO competenciaEspecificaDTO : syllabusBean.getCompetenciasEspecificasDTOs()) {
				CompetenciasEspecifica competencia = new CompetenciasEspecifica();
				competencia.setCompetenciaEspecifica(competenciaEspecificaDTO.getCompetenciaEspecifica());

				competenciasEspecificas.add(competencia);
			}
			syllabus.setCompetenciasEspecificas(competenciasEspecificas);
			syllabusBean.setCompetenciaEspecifica("");
			syllabusBean.setCompetenciasEspecificasDTOs(null);

			List<UnidadCompetencia> unidades = new ArrayList<UnidadCompetencia>();

			for (UnidadCompetenciaDTO unidadCompetenciaDTO : syllabusBean.getUnidadesDTOs()) {
				UnidadCompetencia unidadCompetencia = new UnidadCompetencia();
				unidadCompetencia.setUnidadCompetencia(unidadCompetenciaDTO.getUnidadCompetencia());
				unidadCompetencia.setHorasCompetencia(unidadCompetenciaDTO.getPlanificacionHoras());

				List<ElementoCompetencia> elementos = new ArrayList<ElementoCompetencia>();
				for (ElementosCompetenciaDTO elemCompetenciaDTO : unidadCompetenciaDTO.getElementosCompetencias()) {
					ElementoCompetencia elementoCompetencia = new ElementoCompetencia();
					elementoCompetencia.setElementoCompetencia(elemCompetenciaDTO.getElementoCompetencia());
					elementos.add(elementoCompetencia);
				}
				unidades.add(unidadCompetencia);
				unidadCompetencia.setElementoCompetencias(elementos);
			}
			syllabusBean.setUnidadesDTOs(null);

			// Bibliografias
			List<Bibliografia> bibliografias = new ArrayList<Bibliografia>();
			for (BibliografiaDTO bibliografiaDTO : syllabusBean.getBibliografiaDTOs()) {
				Bibliografia bibliografia = new Bibliografia();
				bibliografia.setBibliografia(bibliografiaDTO.getBiografia());
				bibliografias.add(bibliografia);
			}
			syllabusBean.setBibliografia("");
			syllabusBean.setBibliografiaDTOs(null);

			// Resultados Aprendizaje
			List<ResultadosAprendizaje> resultados = new ArrayList<ResultadosAprendizaje>();
			for (ResultadoAprendizajeDTO resultadoAprendizajeDTO : syllabusBean.getResultadoAprendizajeDTOs()) {
				ResultadosAprendizaje resultado = new ResultadosAprendizaje();
				resultado.setResultadoAprendizaje(resultadoAprendizajeDTO.getResultado());
				resultados.add(resultado);
			}
			syllabusBean.setResultadoAprendizaje("");
			syllabusBean.setResultadoAprendizajeDTOs(null);

			syllabusService.guardarSyllabus(syllabus, objetivos, competenciasGenerales, bibliografias, resultados, unidades);
			MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("dione.mensaje.exito.save"));

		} catch (Exception e) {
			log.error("Error al momento guardar los datos del syllabus", e);
			MessagesController.addError(null, HiperionMensajes.getInstancia().getString("dione.mensaje.error.save"));
			throw new Exception(e);
		}

	}

	/**
	 * @return the materias
	 * @throws DioneException
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
	 * 
	 * <b> Permite obtener las competencias interpersonales, instrumentales y sistematicas. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 12/02/2015]
	 * </p>
	 * 
	 * @throws DioneException
	 */
	public void obtenerCompetenciasGenericas() throws DioneException {
		try {
			// Interpersonales
			Catalogo catalogoInterpersonales = catalogoService.consultarCatalogoById(HiperionMensajes.getInstancia().getLong("recursos.catalogoCompetenciasInterpersonales"));

			List<DetalleCatalogo> competenciasInter = catalogoInterpersonales.getDetalleCatalogos();

			for (DetalleCatalogo detalle : competenciasInter) {
				CompetenciaGenericaDTO competenciaInterpersonal = new CompetenciaGenericaDTO();
				competenciaInterpersonal.setIdCompetenciaGenerica(detalle.getIdDetalleCatalogo());
				competenciaInterpersonal.setCompetenciaGenerica(detalle.getDescDetCatalogo());
				competenciaInterpersonal.setTipoCompetencia(1);
				competenciasInterpersonalesDTO.add(competenciaInterpersonal);
			}
			// Instrumentales
			Catalogo catalogoInstr = catalogoService.consultarCatalogoById(HiperionMensajes.getInstancia().getLong("recursos.catalogoCompetenciasInstrumentales"));

			List<DetalleCatalogo> competenciasInstr = catalogoInstr.getDetalleCatalogos();

			for (DetalleCatalogo detalle : competenciasInstr) {
				CompetenciaGenericaDTO competenciaInstrumental = new CompetenciaGenericaDTO();
				competenciaInstrumental.setIdCompetenciaGenerica(detalle.getIdDetalleCatalogo());
				competenciaInstrumental.setCompetenciaGenerica(detalle.getDescDetCatalogo());
				competenciaInstrumental.setTipoCompetencia(2);
				competenciasInstrumentalesDTO.add(competenciaInstrumental);
			}
			// Sistematicas
			Catalogo catalogoSist = catalogoService.consultarCatalogoById(HiperionMensajes.getInstancia().getLong("recursos.catalogoCompetenciasSistematicas"));

			List<DetalleCatalogo> competenciasSist = catalogoSist.getDetalleCatalogos();

			for (DetalleCatalogo detalle : competenciasSist) {
				CompetenciaGenericaDTO competenciaSistematica = new CompetenciaGenericaDTO();
				competenciaSistematica.setIdCompetenciaGenerica(detalle.getIdDetalleCatalogo());
				competenciaSistematica.setCompetenciaGenerica(detalle.getDescDetCatalogo());
				competenciaSistematica.setTipoCompetencia(3);
				competenciasSistematicasDTO.add(competenciaSistematica);
			}
		} catch (DioneException e) {
			log.error("Error al momento consultar las competencias genericas", e);
			throw new DioneException(e);
		}
	}

	/**
	 * @param materias
	 *            the materias to set
	 */
	public void setMaterias(List<SelectItem> materias) {
		this.materias = materias;
	}

	/**
	 * @return the syllabusBean
	 */
	public SyllabusBean getSyllabusBean() {
		return syllabusBean;
	}

	/**
	 * @param syllabusBean
	 *            the syllabusBean to set
	 */
	public void setSyllabusBean(SyllabusBean syllabusBean) {
		this.syllabusBean = syllabusBean;
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
	 * @return the prerequisitos
	 */
	public List<Prerequisito> getPrerequisitos() {
		return prerequisitos;
	}

	/**
	 * @param prerequisitos
	 *            the prerequisitos to set
	 */
	public void setPrerequisitos(List<Prerequisito> prerequisitos) {
		this.prerequisitos = prerequisitos;
	}

	/**
	 * @return the corequisitos
	 */
	public List<Corequisito> getCorequisitos() {
		return corequisitos;
	}

	/**
	 * @param corequisitos
	 *            the corequisitos to set
	 */
	public void setCorequisitos(List<Corequisito> corequisitos) {
		this.corequisitos = corequisitos;
	}

	/**
	 * @return the activarRequisitos
	 */
	public Boolean getActivarRequisitos() {
		return activarRequisitos;
	}

	/**
	 * @param activarRequisitos
	 *            the activarRequisitos to set
	 */
	public void setActivarRequisitos(Boolean activarRequisitos) {
		this.activarRequisitos = activarRequisitos;
	}

	/**
	 * @return the competenciasInterpersonalesDTO
	 */
	public List<CompetenciaGenericaDTO> getCompetenciasInterpersonalesDTO() {
		return competenciasInterpersonalesDTO;
	}

	/**
	 * @param competenciasInterpersonalesDTO
	 *            the competenciasInterpersonalesDTO to set
	 */
	public void setCompetenciasInterpersonalesDTO(List<CompetenciaGenericaDTO> competenciasInterpersonalesDTO) {
		this.competenciasInterpersonalesDTO = competenciasInterpersonalesDTO;
	}

	/**
	 * @return the competenciasInstrumentalesDTO
	 */
	public List<CompetenciaGenericaDTO> getCompetenciasInstrumentalesDTO() {
		return competenciasInstrumentalesDTO;
	}

	/**
	 * @param competenciasInstrumentalesDTO
	 *            the competenciasInstrumentalesDTO to set
	 */
	public void setCompetenciasInstrumentalesDTO(List<CompetenciaGenericaDTO> competenciasInstrumentalesDTO) {
		this.competenciasInstrumentalesDTO = competenciasInstrumentalesDTO;
	}

	/**
	 * @return the competenciasSistematicasDTO
	 */
	public List<CompetenciaGenericaDTO> getCompetenciasSistematicasDTO() {
		return competenciasSistematicasDTO;
	}

	/**
	 * @param competenciasSistematicasDTO
	 *            the competenciasSistematicasDTO to set
	 */
	public void setCompetenciasSistematicasDTO(List<CompetenciaGenericaDTO> competenciasSistematicasDTO) {
		this.competenciasSistematicasDTO = competenciasSistematicasDTO;
	}

	/**
	 * @return the competenciasInterpersonales
	 */
	public List<CompetenciasGenerica> getCompetenciasInterpersonales() {
		return competenciasInterpersonales;
	}

	/**
	 * @param competenciasInterpersonales
	 *            the competenciasInterpersonales to set
	 */
	public void setCompetenciasInterpersonales(List<CompetenciasGenerica> competenciasInterpersonales) {
		this.competenciasInterpersonales = competenciasInterpersonales;
	}

	/**
	 * @return the competenciasInstrumentales
	 */
	public List<CompetenciasGenerica> getCompetenciasInstrumentales() {
		return competenciasInstrumentales;
	}

	/**
	 * @param competenciasInstrumentales
	 *            the competenciasInstrumentales to set
	 */
	public void setCompetenciasInstrumentales(List<CompetenciasGenerica> competenciasInstrumentales) {
		this.competenciasInstrumentales = competenciasInstrumentales;
	}

	/**
	 * @return the competenciasSistematicas
	 */
	public List<CompetenciasGenerica> getCompetenciasSistematicas() {
		return competenciasSistematicas;
	}

	/**
	 * @param competenciasSistematicas
	 *            the competenciasSistematicas to set
	 */
	public void setCompetenciasSistematicas(List<CompetenciasGenerica> competenciasSistematicas) {
		this.competenciasSistematicas = competenciasSistematicas;
	}

}
