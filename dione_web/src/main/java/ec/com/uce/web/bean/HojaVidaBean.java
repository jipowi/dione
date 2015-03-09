/**
 * 
 */
package ec.com.uce.web.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.primefaces.event.RowEditEvent;

import ec.com.uce.dione.entities.Experiencia;
import ec.com.uce.ejb.dto.ExperienciaDTO;
import ec.com.uce.ejb.dto.FormacionAcademicaDTO;
import ec.com.uce.ejb.dto.FormacionContinuaDTO;

/**
 * <b> Permite manejar la informacion en la pagina y el backing </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Nov 19, 2014
 * @since JDK1.6
 */
@ManagedBean
@SessionScoped
public class HojaVidaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String institucionFc;
	private String institucionFa;
	private String titulo;
	private String curso;
	private Integer duracion;
	private String tipoDuracion;
	private List<SelectItem> tipoDuracionItems;
	private String cedula;
	private String apellidosDocente;
	private String direccionDocente;
	private String nombresDocente;
	private String institucion;
	private String funciones;
	private Date fechaInicio;
	private Date fechaFin;

	private static ArrayList<ExperienciaDTO> experienciaList = new ArrayList<ExperienciaDTO>();
	private static ArrayList<FormacionAcademicaDTO> formacionAcademicaList = new ArrayList<FormacionAcademicaDTO>();
	private static ArrayList<FormacionContinuaDTO> formacionContinuaList = new ArrayList<FormacionContinuaDTO>();
	private List<Experiencia> experiencias = new ArrayList<Experiencia>();

	/**
	 * @return the institucionFc
	 */
	public String getInstitucionFc() {
		return institucionFc;
	}

	/**
	 * @param institucionFc
	 *            the institucionFc to set
	 */
	public void setInstitucionFc(String institucionFc) {
		this.institucionFc = institucionFc;
	}

	/**
	 * @return the institucionFa
	 */
	public String getInstitucionFa() {
		return institucionFa;
	}

	/**
	 * @param institucionFa
	 *            the institucionFa to set
	 */
	public void setInstitucionFa(String institucionFa) {
		this.institucionFa = institucionFa;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo
	 *            the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the curso
	 */
	public String getCurso() {
		return curso;
	}

	/**
	 * @param curso
	 *            the curso to set
	 */
	public void setCurso(String curso) {
		this.curso = curso;
	}

	/**
	 * @return the duracion
	 */
	public Integer getDuracion() {
		return duracion;
	}

	/**
	 * @param duracion
	 *            the duracion to set
	 */
	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	/**
	 * @return the formacionAcademicaList
	 */
	public ArrayList<FormacionAcademicaDTO> getFormacionAcademicaList() {
		return formacionAcademicaList;
	}

	/**
	 * @param formacionAcademicaList
	 *            the formacionAcademicaList to set
	 */
	public static void setFormacionAcademicaList(ArrayList<FormacionAcademicaDTO> formacionAcademicaList) {
		HojaVidaBean.formacionAcademicaList = formacionAcademicaList;
	}

	/**
	 * 
	 * <b> Permite agregar un registro de formacion academica </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Dec 1, 2014]
	 * </p>
	 * 
	 * @return
	 */
	public String addActionFa() {
		FormacionAcademicaDTO item = new FormacionAcademicaDTO(this.institucionFa, this.titulo);
		formacionAcademicaList.add(item);

		institucionFa = "";
		titulo = "";
		return null;
	}

	/**
	 * 
	 * <b> Permite agregar un registro de formacion continua </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Dec 2, 2014]
	 * </p>
	 * 
	 * @return
	 */
	public String addActionFc() {
		FormacionContinuaDTO item = new FormacionContinuaDTO(this.institucionFc, this.curso, this.duracion, this.tipoDuracion);
		formacionContinuaList.add(item);

		institucionFc = "";
		curso = "";
		duracion = 0;
		tipoDuracion = "";
		return null;
	}

	/**
	 * 
	 * <b> Permite editar un registro de la tabla </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Dec 1, 2014]
	 * </p>
	 * 
	 * @param event
	 */
	public void onEditFa(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Edited", ((FormacionAcademicaDTO) event.getObject()).getInstitucion().toString());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	/**
	 * 
	 * <b> Permite editar un registro de formacion continua </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Dec 2, 2014]
	 * </p>
	 * 
	 * @param event
	 */
	public void onEditFc(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Edited", ((FormacionContinuaDTO) event.getObject()).getInstitucion().toString());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	/**
	 * 
	 * <b> Permite eliminar un registro de la tabla </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Dec 1, 2014]
	 * </p>
	 * 
	 * @param event
	 */
	public void onCancelFa(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Cancelled");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		formacionAcademicaList.remove((FormacionAcademicaDTO) event.getObject());
	}

	/**
	 * 
	 * <b> Permite eliminar un registro de formacion continua </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Dec 2, 2014]
	 * </p>
	 * 
	 * @param event
	 */
	public void onCancelFc(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Cancelled");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		formacionContinuaList.remove((FormacionContinuaDTO) event.getObject());
	}

	/**
	 * @return the tipoDuracion
	 */
	public String getTipoDuracion() {
		return tipoDuracion;
	}

	/**
	 * @param tipoDuracion
	 *            the tipoDuracion to set
	 */
	public void setTipoDuracion(String tipoDuracion) {
		this.tipoDuracion = tipoDuracion;
	}

	/**
	 * @return the tipoDuracionItems
	 */
	public List<SelectItem> getTipoDuracionItems() {
		return tipoDuracionItems;
	}

	/**
	 * @param tipoDuracionItems
	 *            the tipoDuracionItems to set
	 */
	public void setTipoDuracionItems(List<SelectItem> tipoDuracionItems) {
		this.tipoDuracionItems = tipoDuracionItems;
	}

	/**
	 * @return the formacionContinuaList
	 */
	public ArrayList<FormacionContinuaDTO> getFormacionContinuaList() {
		return formacionContinuaList;
	}

	/**
	 * @param formacionContinuaList
	 *            the formacionContinuaList to set
	 */
	public static void setFormacionContinuaList(ArrayList<FormacionContinuaDTO> formacionContinuaList) {
		HojaVidaBean.formacionContinuaList = formacionContinuaList;
	}

	/**
	 * @return the cedula
	 */
	public String getCedula() {
		return cedula;
	}

	/**
	 * @param cedula
	 *            the cedula to set
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	/**
	 * @return the apellidosDocente
	 */
	public String getApellidosDocente() {
		return apellidosDocente;
	}

	/**
	 * @param apellidosDocente
	 *            the apellidosDocente to set
	 */
	public void setApellidosDocente(String apellidosDocente) {
		this.apellidosDocente = apellidosDocente;
	}

	/**
	 * @return the direccionDocente
	 */
	public String getDireccionDocente() {
		return direccionDocente;
	}

	/**
	 * @param direccionDocente
	 *            the direccionDocente to set
	 */
	public void setDireccionDocente(String direccionDocente) {
		this.direccionDocente = direccionDocente;
	}

	/**
	 * @return the nombresDocente
	 */
	public String getNombresDocente() {
		return nombresDocente;
	}

	/**
	 * @param nombresDocente
	 *            the nombresDocente to set
	 */
	public void setNombresDocente(String nombresDocente) {
		this.nombresDocente = nombresDocente;
	}

	/**
	 * 
	 * <b> Permite agregar un registro de experiencia </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Dec 1, 2014]
	 * </p>
	 * 
	 * @return
	 */
	public String addExperiencia() {
		ExperienciaDTO item = new ExperienciaDTO(this.institucion, this.fechaInicio, this.fechaFin, this.funciones);
		experienciaList.add(item);

		institucion = "";
		fechaInicio = null;
		fechaFin = null;
		funciones = "";
		return null;
	}

	/**
	 * 
	 * <b> Permite editar un registro de la tabla </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Dec 1, 2014]
	 * </p>
	 * 
	 * @param event
	 */
	public void onEditExperiencia(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Edited", ((ExperienciaDTO) event.getObject()).getInstitucion().toString());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	/**
	 * 
	 * <b> Permite eliminar un registro de la tabla </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Dec 1, 2014]
	 * </p>
	 * 
	 * @param event
	 */
	public void onCancelExperiencia(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Cancelled");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		experienciaList.remove((ExperienciaDTO) event.getObject());
	}

	/**
	 * @return the institucion
	 */
	public String getInstitucion() {
		return institucion;
	}

	/**
	 * @param institucion
	 *            the institucion to set
	 */
	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}

	/**
	 * @return the funciones
	 */
	public String getFunciones() {
		return funciones;
	}

	/**
	 * @param funciones
	 *            the funciones to set
	 */
	public void setFunciones(String funciones) {
		this.funciones = funciones;
	}

	/**
	 * @return the fechaInicio
	 */
	public Date getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * @param fechaInicio
	 *            the fechaInicio to set
	 */
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * @return the fechaFin
	 */
	public Date getFechaFin() {
		return fechaFin;
	}

	/**
	 * @param fechaFin
	 *            the fechaFin to set
	 */
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * @return the experienciaList
	 */
	public ArrayList<ExperienciaDTO> getExperienciaList() {
		return experienciaList;
	}

	/**
	 * @param experienciaList
	 *            the experienciaList to set
	 */
	public static void setExperienciaList(ArrayList<ExperienciaDTO> experienciaList) {
		HojaVidaBean.experienciaList = experienciaList;
	}

	/**
	 * @return the experiencias
	 */
	public List<Experiencia> getExperiencias() {
		return experiencias;
	}

	/**
	 * @param experiencias
	 *            the experiencias to set
	 */
	public void setExperiencias(List<Experiencia> experiencias) {
		this.experiencias = experiencias;
	}

}
