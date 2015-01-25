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
import ec.com.uce.dione.entities.Competencia;
import ec.com.uce.dione.entities.Docente;
import ec.com.uce.dione.entities.ElementoCompetencia;
import ec.com.uce.dione.entities.EscuelaUce;
import ec.com.uce.dione.entities.MateriaUce;
import ec.com.uce.dione.entities.Objetivo;
import ec.com.uce.dione.entities.ResultadosAprendizaje;
import ec.com.uce.dione.entities.Syllabus;
import ec.com.uce.dione.entities.UnidadCompetencia;
import ec.com.uce.ejb.dto.BibliografiaDTO;
import ec.com.uce.ejb.dto.CompetenciaDTO;
import ec.com.uce.ejb.dto.ElementosCompetenciaDTO;
import ec.com.uce.ejb.dto.ObjetivoDTO;
import ec.com.uce.ejb.dto.ResultadoAprendizajeDTO;
import ec.com.uce.ejb.dto.UnidadCompetenciaDTO;
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

	@ManagedProperty(value = "#{syllabusBean}")
	private SyllabusBean syllabusBean;

	private List<SelectItem> materias = new ArrayList<SelectItem>();
	private List<MateriaUce> materiaUces = new ArrayList<MateriaUce>();
	private Docente docente;
	private Boolean docenteEncontrado = false;

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

			syllabus.setDocente(docente);
			MateriaUce materiaUce = syllabusService.consultarMateriaById(Integer.parseInt(syllabusBean.getMateria()));
			syllabus.setMateriaUce(materiaUce);

			syllabus.setDescripcionAsignatura(syllabusBean.getDesAsigantura());
			syllabus.setNumHorasClase(syllabusBean.getNumHorasClase());
			syllabus.setPrerequisito(syllabusBean.getPrerequisito());
			syllabus.setCorequisito(syllabusBean.getCorequisito());
			syllabus.setMetodologia(syllabusBean.getMetodologia());

			syllabusBean.setDesAsigantura("");
			syllabusBean.setNumHorasClase(0);
			syllabusBean.setPrerequisito("");
			syllabusBean.setCorequisito("");
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

			// Competencias
			List<Competencia> competencias = new ArrayList<Competencia>();
			for (CompetenciaDTO competenciaDTO : syllabusBean.getCompetenciasDTOs()) {
				Competencia competencia = new Competencia();
				competencia.setCompetencia(competenciaDTO.getCompetencia());

				competencias.add(competencia);
			}
			syllabusBean.setCompetencia("");
			syllabusBean.setCompetenciasDTOs(null);

			List<UnidadCompetencia> unidades = new ArrayList<UnidadCompetencia>();
			
			for (UnidadCompetenciaDTO unidadCompetenciaDTO : syllabusBean.getUnidadesDTOs()) {
				UnidadCompetencia unidadCompetencia = new UnidadCompetencia();
				unidadCompetencia.setUnidadCompetencia(unidadCompetenciaDTO.getUnidadCompetencia());
				unidadCompetencia.setHorasCompetencia(unidadCompetenciaDTO.getPlanificacionHoras());
				
				List<ElementoCompetencia> elementos = new ArrayList<ElementoCompetencia>();
				for(ElementosCompetenciaDTO elemCompetenciaDTO: unidadCompetenciaDTO.getElementosCompetencias()){
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

			syllabusService.guardarSyllabus(syllabus, objetivos, competencias, bibliografias, resultados, unidades);
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

}
