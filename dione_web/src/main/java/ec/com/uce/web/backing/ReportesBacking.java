/**
 * 
 */
package ec.com.uce.web.backing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.apache.log4j.Logger;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.entities.Cumplimiento;
import ec.com.uce.dione.entities.Docente;
import ec.com.uce.dione.entities.Escuela;
import ec.com.uce.dione.entities.EscuelaUce;
import ec.com.uce.dione.entities.FormacionAcademica;
import ec.com.uce.dione.entities.FormacionContinua;
import ec.com.uce.dione.entities.Materia;
import ec.com.uce.dione.entities.MateriaSyllabus;
import ec.com.uce.ejb.dto.ReporteCumplimientoDTO;
import ec.com.uce.ejb.dto.ReporteDocentesDTO;
import ec.com.uce.ejb.service.CatalogoService;
import ec.com.uce.ejb.service.DocenteService;
import ec.com.uce.ejb.service.SyllabusService;
import ec.com.uce.web.bean.ReportesBean;
import ec.com.uce.web.util.HiperionMensajes;
import ec.com.uce.web.util.MessagesController;

/**
 * <b> Permite almacenar la informacion y manejar las acciones de la pagina. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Dec 8, 2014
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class ReportesBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private CatalogoService catalogoService;
	@EJB
	private DocenteService docenteService;
	@EJB
	private SyllabusService syllabusService;

	@ManagedProperty(value = "#{reportesBean}")
	private ReportesBean reportesBean;

	private Docente docente;
	private List<Docente> docentes = new ArrayList<Docente>();
	private Boolean docenteEncontrado = false;
	private List<EscuelaUce> escuelasUces = new ArrayList<EscuelaUce>();

	Logger log = Logger.getLogger(ReportesBacking.class);

	private List<SelectItem> escuelas = new ArrayList<SelectItem>();
	private List<ReporteCumplimientoDTO> cumplimientoDTOs = new ArrayList<ReporteCumplimientoDTO>();
	private List<ReporteDocentesDTO> docentesDTOs = new ArrayList<ReporteDocentesDTO>();

	/**
	 * @return the escuelas
	 * @throws DioneException
	 */
	public List<SelectItem> getEscuelas() throws DioneException {
		escuelas = new ArrayList<SelectItem>();
		List<Escuela> escuelasList;
		try {
			escuelasList = docenteService.consultarEscuelas();

			for (Escuela escuela : escuelasList) {
				SelectItem selectItem = new SelectItem(escuela.getIdEscuela(), escuela.getEscuela());
				escuelas.add(selectItem);
			}

		} catch (DioneException e) {
			log.error("Error al momento consultar las escuelas", e);
			throw new DioneException(e);
		}

		return escuelas;
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
	public void buscarDocente() throws DioneException {
		try {
			docente = docenteService.consultarDocenteByCedula(reportesBean.getCedulaDocente());
			if (docente != null) {
				docenteEncontrado = true;

				escuelas = new ArrayList<SelectItem>();
				escuelasUces = syllabusService.consultarEscuelaByDocente(docente.getIdDocente().toString());

				for (EscuelaUce escuela : escuelasUces) {
					SelectItem selectItem = new SelectItem(escuela.getIdEscuelaUce(), escuela.getEscuelaUce());
					escuelas.add(selectItem);
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
	 * <b> Permite consultar los docentes por escuela. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 20/03/2015]
	 * </p>
	 * 
	 * @throws Exception
	 */
	public void consultarDocentes() throws Exception {
		try {

			docentes = new ArrayList<Docente>();

			EscuelaUce escuelaUce = docenteService.consultarEscuelaUceById(Integer.parseInt(reportesBean.getEscuela().toString()));
			List<EscuelaUce> escuelas = docenteService.consultarEscuelas(escuelaUce.getEscuelaUce());

			for (EscuelaUce escuela : escuelas) {
				Docente docente = docenteService.consultarDocenteById(escuela.getDocente().getIdDocente());
				docentes.add(docente);
			}

			for (Docente docente : docentes) {
				ReporteDocentesDTO reporteDocenteDTO = new ReporteDocentesDTO();
				reporteDocenteDTO.setCedula(docente.getCedulaDocente());
				reporteDocenteDTO.setNombre(docente.getNombresDocente() + " " + docente.getApellidosDocente());

				List<FormacionAcademica> listFormacionesA = docenteService.consultarFormacionAByDocente(docente.getIdDocente());

				List<FormacionContinua> listFormacionesC = docenteService.consultarFormacionCByDocente(docente.getIdDocente());

				String titulos = "";
				for (FormacionAcademica obj : listFormacionesA) {
					titulos += obj.getTitulo() + "\n";
				}

				String cursos = "";
				for (FormacionContinua obj : listFormacionesC) {
					cursos += obj.getCurso() + "\n";
				}
				
				reporteDocenteDTO.setFormacionesAcademicas(titulos);
				reporteDocenteDTO.setFormacionesContinuas(cursos);
				reporteDocenteDTO.setFormacionesA(listFormacionesA);
				reporteDocenteDTO.setFormacionesC(listFormacionesC);

				docentesDTOs.add(reporteDocenteDTO);
			}

		} catch (Exception e) {
			log.error("Error al momento consultar los docentes", e);
			throw new Exception(e);
		}
	}

	/**
	 * 
	 * <b> Permite consultar los datos del Syllabus. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 29/03/2015]
	 * </p>
	 * 
	 * @throws NumberFormatException
	 * @throws DioneException
	 */
	public void consultarDatosSyllabus() throws NumberFormatException, DioneException {

		List<Materia> materias = docenteService.consultarMateriasByEscuela(Integer.parseInt(reportesBean.getEscuela()));

		for (Materia materia : materias) {
			ReporteCumplimientoDTO reporteCumplimientoDTO = new ReporteCumplimientoDTO();
			// Nombre
			reporteCumplimientoDTO.setNombre(docente.getNombresDocente() + " " + docente.getApellidosDocente());
			// Cedula
			reporteCumplimientoDTO.setCedula(docente.getCedulaDocente());
			// Escuela
			EscuelaUce escuela = syllabusService.consultarEscuelaById(reportesBean.getEscuela());
			reporteCumplimientoDTO.setEscuela(escuela.getEscuelaUce());
			// Materia
			reporteCumplimientoDTO.setMateria(materia.getMateria());

			MateriaSyllabus materiaSyllabus = syllabusService.consultarSyllabus(docente.getIdDocente(), materia.getIdMateria());
			if (materiaSyllabus != null) {

				Cumplimiento cumplimiento = syllabusService.consultarCumplimientoByMatSyllabus(materiaSyllabus.getIdMateriaSyllabus());

				reporteCumplimientoDTO.setPorcentajeObjetivos(cumplimiento.getPorcentajeObjetivos());
				reporteCumplimientoDTO.setPorcentajeCompetencias(cumplimiento.getPorcentajeCompetencias());
				reporteCumplimientoDTO.setPorcentajeResultados(cumplimiento.getPorcentajeResultados());
				reporteCumplimientoDTO.setEfectividad(cumplimiento.getEfectividad());

				cumplimientoDTOs.add(reporteCumplimientoDTO);
			}
		}

	}

	/**
	 * 
	 * <b> Permite imprimir el reporte generado en iReport en formato PDF. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 23/03/2015]
	 * </p>
	 * 
	 * @param actionEvent
	 */
	public void imprimirReporteDocentePDF(ActionEvent actionEvent) {
		try {
			JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(docentesDTOs);

			String reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/pages/report/reportDocente.jasper");

			HashMap<String, Object> parametros = new HashMap<String, Object>();
			JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath, parametros, jrBeanCollectionDataSource);

			HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
			httpServletResponse.addHeader("Content-disposition", "attachment; filename=reporteDocumentos.pdf");
			ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();

			JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
			FacesContext.getCurrentInstance().responseComplete();

		} catch (Exception e) {
			log.error("Error al momento de generar el reporte", e);
		}
	}

	/**
	 * 
	 * <b> Permite imprimir el reporte generado en iReport en formato PDF. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 23/03/2015]
	 * </p>
	 * 
	 * @param actionEvent
	 */
	public void imprimirReporteSyllabusPDF(ActionEvent actionEvent) {
		try {
			JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(cumplimientoDTOs);

			String reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/pages/report/reportSyllabus.jasper");

			HashMap<String, Object> parametros = new HashMap<String, Object>();
			JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath, parametros, jrBeanCollectionDataSource);

			HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
			httpServletResponse.addHeader("Content-disposition", "attachment; filename=reporteSyllabus.pdf");
			ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();

			JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
			FacesContext.getCurrentInstance().responseComplete();

		} catch (Exception e) {
			log.error("Error al momento de generar el reporte de syllabus", e);
		}
	}

	/**
	 * @param escuelas
	 *            the escuelas to set
	 */
	public void setEscuelas(List<SelectItem> escuelas) {
		this.escuelas = escuelas;
	}

	/**
	 * @return the reportesBean
	 */
	public ReportesBean getReportesBean() {
		return reportesBean;
	}

	/**
	 * @param reportesBean
	 *            the reportesBean to set
	 */
	public void setReportesBean(ReportesBean reportesBean) {
		this.reportesBean = reportesBean;
	}

	/**
	 * @return the docentes
	 */
	public List<Docente> getDocentes() {
		return docentes;
	}

	/**
	 * @param docentes
	 *            the docentes to set
	 */
	public void setDocentes(List<Docente> docentes) {
		this.docentes = docentes;
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
	 * @param escuelasUces
	 *            the escuelasUces to set
	 */
	public void setEscuelasUces(List<EscuelaUce> escuelasUces) {
		this.escuelasUces = escuelasUces;
	}

	/**
	 * @return the cumplimientoDTOs
	 */
	public List<ReporteCumplimientoDTO> getCumplimientoDTOs() {
		return cumplimientoDTOs;
	}

	/**
	 * @param cumplimientoDTOs
	 *            the cumplimientoDTOs to set
	 */
	public void setCumplimientoDTOs(List<ReporteCumplimientoDTO> cumplimientoDTOs) {
		this.cumplimientoDTOs = cumplimientoDTOs;
	}

	/**
	 * @return the docentesDTOs
	 */
	public List<ReporteDocentesDTO> getDocentesDTOs() {
		return docentesDTOs;
	}

	/**
	 * @param docentesDTOs
	 *            the docentesDTOs to set
	 */
	public void setDocentesDTOs(List<ReporteDocentesDTO> docentesDTOs) {
		this.docentesDTOs = docentesDTOs;
	}

}
