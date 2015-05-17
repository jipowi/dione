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
import ec.com.uce.dione.entities.Docente;
import ec.com.uce.dione.entities.Experiencia;
import ec.com.uce.dione.entities.FormacionAcademica;
import ec.com.uce.dione.entities.FormacionContinua;
import ec.com.uce.dione.enumeration.TipoDuracionEnum;
import ec.com.uce.ejb.dto.ExperienciaDTO;
import ec.com.uce.ejb.dto.FormacionAcademicaDTO;
import ec.com.uce.ejb.dto.FormacionContinuaDTO;
import ec.com.uce.ejb.service.DocenteService;
import ec.com.uce.web.bean.HojaVidaBean;
import ec.com.uce.web.util.HiperionMensajes;
import ec.com.uce.web.util.MessagesController;

@ManagedBean
@SessionScoped
public class HojaVidaBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{hojaVidaBean}")
	private HojaVidaBean hojaVidaBean;

	@EJB
	private DocenteService docenteService;

	private Docente docente;

	private List<SelectItem> tipoDuracionList;

	private Boolean docenteEncontrado = false;

	Logger log = Logger.getLogger(HojaVidaBacking.class);

	/**
	 * @return the hojaVidaBean
	 */
	public HojaVidaBean getHojaVidaBean() {
		return hojaVidaBean;
	}

	/**
	 * @param hojaVidaBean
	 *            the hojaVidaBean to set
	 */
	public void setHojaVidaBean(HojaVidaBean hojaVidaBean) {
		this.hojaVidaBean = hojaVidaBean;
	}

	/**
	 * 
	 * <b> Permite buscar un docente por medio del ingreso de la identificacion. </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 07/01/2015]
	 * </p>
	 * 
	 * @throws DioneException
	 */
	@SuppressWarnings("static-access")
	public void buscarDocente() throws DioneException {
		try {
			docente = docenteService.consultarDocenteByCedula(hojaVidaBean.getCedula());
			if (docente != null) {
				docenteEncontrado = true;
				hojaVidaBean.setCedula(docente.getCedulaDocente());
				hojaVidaBean.setApellidosDocente(docente.getApellidosDocente());
				hojaVidaBean.setNombresDocente(docente.getNombresDocente());
				hojaVidaBean.setDireccionDocente(docente.getDireccionDocente());

				ArrayList<FormacionAcademicaDTO> formacionesDTO = new ArrayList<FormacionAcademicaDTO>();
				List<FormacionAcademica> formacionesA = docenteService.consultarFormacionAByDocente(docente.getIdDocente());
				for (FormacionAcademica formacionAcademica : formacionesA) {
					FormacionAcademicaDTO formacionAcademicaDTO = new FormacionAcademicaDTO();
					formacionAcademicaDTO.setInstitucion(formacionAcademica.getInstitucionAca());
					formacionAcademicaDTO.setTitulo(formacionAcademica.getTitulo());
					formacionAcademicaDTO.setId(formacionAcademica.getIdFAcademica());

					formacionesDTO.add(formacionAcademicaDTO);
				}
				hojaVidaBean.setFormacionAcademicaList(formacionesDTO);

				ArrayList<FormacionContinuaDTO> formacionesCDTO = new ArrayList<FormacionContinuaDTO>();
				List<FormacionContinua> formacionesC = docenteService.consultarFormacionCByDocente(docente.getIdDocente());
				for (FormacionContinua formacionContinua : formacionesC) {
					FormacionContinuaDTO formacionContinuaDTO = new FormacionContinuaDTO();
					formacionContinuaDTO.setInstitucion(formacionContinua.getInstitucionContinua());
					formacionContinuaDTO.setDuracion(Integer.parseInt(formacionContinua.getDuracion()));
					formacionContinuaDTO.setCurso(formacionContinua.getCurso());
					formacionContinuaDTO.setId(formacionContinua.getIdFContinua());

					formacionesCDTO.add(formacionContinuaDTO);
				}
				hojaVidaBean.setFormacionContinuaList(formacionesCDTO);

				ArrayList<ExperienciaDTO> experienciasDTO = new ArrayList<ExperienciaDTO>();
				List<Experiencia> experiencias = docenteService.consultarExperienciasByDocente(docente.getIdDocente());
				for (Experiencia experiencia : experiencias) {
					ExperienciaDTO experienciaDTO = new ExperienciaDTO();
					experienciaDTO.setInstitucion(experiencia.getInstitucionExp());
					experienciaDTO.setFechaInicio(experiencia.getFechaFinExp());
					experienciaDTO.setFunciones(experiencia.getFuncionExp());
					experienciaDTO.setId(experiencia.getIdExperiencia());

					experienciasDTO.add(experienciaDTO);
				}
				hojaVidaBean.setExperienciaList(experienciasDTO);

			} else {
				MessagesController.addError(null, HiperionMensajes.getInstancia().getString("dione.mensaje.error.buscar"));
			}

		} catch (DioneException e) {
			log.error("Error al momento consultar el docente", e);
			throw new DioneException(e);
		}

	}

	public List<SelectItem> getTipoDuracionList() {
		if (this.tipoDuracionList == null) {
			this.tipoDuracionList = new ArrayList<SelectItem>();

			SelectItem anios = new SelectItem(TipoDuracionEnum.A, TipoDuracionEnum.A.getLabel());
			this.tipoDuracionList.add(anios);
			SelectItem meses = new SelectItem(TipoDuracionEnum.M, TipoDuracionEnum.M.getLabel());
			this.tipoDuracionList.add(meses);
			SelectItem dias = new SelectItem(TipoDuracionEnum.D, TipoDuracionEnum.D.getLabel());
			this.tipoDuracionList.add(dias);
			SelectItem horas = new SelectItem(TipoDuracionEnum.H, TipoDuracionEnum.H.getLabel());
			this.tipoDuracionList.add(horas);

		}
		return this.tipoDuracionList;
	}

	/**
	 * 
	 * <b> Permite guardar la hoja de vida de un docente </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 06/02/2015]
	 * </p>
	 * 
	 * @throws DioneException
	 */
	@SuppressWarnings("static-access")
	public void guardarHojaVida() throws DioneException {
		try {

			List<FormacionAcademica> formacionAcademicas = new ArrayList<FormacionAcademica>();
			List<FormacionContinua> formacionContinuas = new ArrayList<FormacionContinua>();
			List<Experiencia> experiencias = new ArrayList<Experiencia>();

			for (FormacionAcademicaDTO formacionAcademicaDTO : hojaVidaBean.getFormacionAcademicaList()) {
				FormacionAcademica formacionAcademica = new FormacionAcademica();
				formacionAcademica.setDocente(docente);
				formacionAcademica.setInstitucionAca(formacionAcademicaDTO.getInstitucion());
				formacionAcademica.setTitulo(formacionAcademicaDTO.getTitulo());
				if (formacionAcademicaDTO.getId() != null) {
					formacionAcademica.setIdFAcademica(formacionAcademicaDTO.getId());
				}

				formacionAcademicas.add(formacionAcademica);
			}

			for (FormacionContinuaDTO formacionContinuaDTO : hojaVidaBean.getFormacionContinuaList()) {
				FormacionContinua formacionContinua = new FormacionContinua();
				formacionContinua.setDocente(docente);
				formacionContinua.setDuracion(formacionContinuaDTO.getDuracion().toString());
				formacionContinua.setTipoDuracion(formacionContinuaDTO.getTipoDuracion());
				formacionContinua.setInstitucionContinua(formacionContinuaDTO.getInstitucion());
				formacionContinua.setCurso(formacionContinuaDTO.getCurso());
				if (formacionContinuaDTO.getId() != null) {
					formacionContinua.setIdFContinua(formacionContinuaDTO.getId());
				}
				formacionContinuas.add(formacionContinua);
			}

			for (ExperienciaDTO experienciaDTO : hojaVidaBean.getExperienciaList()) {
				Experiencia experiencia = new Experiencia();
				experiencia.setInstitucionExp(experienciaDTO.getInstitucion());
				experiencia.setFechaInicioExp(experienciaDTO.getFechaInicio());
				experiencia.setFechaFinExp(experienciaDTO.getFechaFin());
				experiencia.setFuncionExp(experienciaDTO.getFunciones());
				if (experienciaDTO.getId() != null) {
					experiencia.setIdExperiencia(experienciaDTO.getId());
				}
				experiencias.add(experiencia);
			}

			docenteService.guardarHojaVida(docente, formacionAcademicas, formacionContinuas, experiencias);
			MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("dione.mensaje.exito.save"));

			hojaVidaBean.setCedula(null);
			hojaVidaBean.setApellidosDocente(null);
			hojaVidaBean.setNombresDocente(null);
			hojaVidaBean.setDireccionDocente(null);
			hojaVidaBean.setInstitucionFa(null);
			hojaVidaBean.setTitulo(null);
			hojaVidaBean.setCurso(null);
			hojaVidaBean.setDuracion(null);
			hojaVidaBean.setInstitucionFc(null);
			hojaVidaBean.setFormacionAcademicaList(null);
			hojaVidaBean.setFormacionContinuaList(null);
			HojaVidaBean.setExperienciaList(null);

		} catch (DioneException e) {
			log.error("Error al momento guardar la hoja de vida", e);
			throw new DioneException(e);
		}
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
