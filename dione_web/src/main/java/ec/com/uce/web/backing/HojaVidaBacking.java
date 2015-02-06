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
import ec.com.uce.dione.entities.FormacionAcademica;
import ec.com.uce.dione.entities.FormacionContinua;
import ec.com.uce.dione.enumeration.TipoDuracionEnum;
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
	 * [Author: Paul Jimenez, Date: 07/01/2015]
	 * </p>
	 * 
	 * @throws DioneException
	 */
	public void buscarDocente() throws DioneException {
		try {
			docente = docenteService.consultarDocenteByCedula(hojaVidaBean.getCedula());
			if (docente != null) {
				docenteEncontrado = true;
				hojaVidaBean.setCedula(docente.getCedulaDocente());
				hojaVidaBean.setApellidosDocente(docente.getApellidosDocente());
				hojaVidaBean.setNombresDocente(docente.getNombresDocente());
				hojaVidaBean.setDireccionDocente(docente.getDireccionDocente());
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
	 * [Author: Paul Jimenez, Date: 06/02/2015]
	 * </p>
	 * 
	 * @throws DioneException
	 */
	@SuppressWarnings("static-access")
	public void guardarHojaVida() throws DioneException {
		try {

			List<FormacionAcademica> formacionAcademicas = new ArrayList<FormacionAcademica>();
			List<FormacionContinua> formacionContinuas = new ArrayList<FormacionContinua>();

			for (FormacionAcademicaDTO formacionAcademicaDTO : hojaVidaBean.getFormacionAcademicaList()) {
				FormacionAcademica formacionAcademica = new FormacionAcademica();
				formacionAcademica.setDocente(docente);
				formacionAcademica.setInstitucionAca(formacionAcademicaDTO.getInstitucion());
				formacionAcademica.setTitulo(formacionAcademicaDTO.getTitulo());
				formacionAcademicas.add(formacionAcademica);
			}

			for (FormacionContinuaDTO formacionContinuaDTO : hojaVidaBean.getFormacionContinuaList()) {
				FormacionContinua formacionContinua = new FormacionContinua();
				formacionContinua.setDocente(docente);
				formacionContinua.setDuracion(formacionContinuaDTO.getDuracion().toString());
				formacionContinua.setTipoDuracion(formacionContinuaDTO.getTipoDuracion());
				formacionContinua.setInstitucionContinua(formacionContinuaDTO.getInstitucion());
				formacionContinuas.add(formacionContinua);
			}

			docenteService.guardarHojaVida(formacionAcademicas, formacionContinuas);
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
