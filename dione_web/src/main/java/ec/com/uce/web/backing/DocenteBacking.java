/**
 * 
 */
package ec.com.uce.web.backing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.entities.Docente;
import ec.com.uce.dione.entities.Escuela;
import ec.com.uce.dione.entities.EscuelaUce;
import ec.com.uce.dione.entities.Materia;
import ec.com.uce.dione.entities.MateriaUce;
import ec.com.uce.dione.enumeration.EstadoEnum;
import ec.com.uce.ejb.dto.AsignaturaDTO;
import ec.com.uce.ejb.dto.MateriaDTO;
import ec.com.uce.ejb.service.CatalogoService;
import ec.com.uce.ejb.service.DocenteService;
import ec.com.uce.web.bean.DocenteBean;
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
public class DocenteBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private CatalogoService catalogoService;
	@EJB
	private DocenteService docenteService;

	@ManagedProperty(value = "#{docenteBean}")
	private DocenteBean docenteBean;

	Logger log = Logger.getLogger(DocenteBacking.class);

	private List<SelectItem> escuelas = new ArrayList<SelectItem>();

	private List<MateriaDTO> materias = new ArrayList<MateriaDTO>();

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
	 * <b> Permite obtener las materias por medio de la escuela seleccionada. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 04/01/2015]
	 * </p>
	 * 
	 * @throws DioneException
	 * 
	 */
	public void obtenerMaterias() throws DioneException {
		try {
			this.materias = new ArrayList<MateriaDTO>();
			List<Materia> materias = docenteService.consultarMateriasByEscuela(Integer.parseInt(docenteBean.getEscuela()));

			for (Materia materia : materias) {
				MateriaDTO materiaDTO = new MateriaDTO();
				materiaDTO.setIdMateria(materia.getIdMateria());
				materiaDTO.setDesMateria(materia.getMateria());
				this.materias.add(materiaDTO);
			}

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (DioneException e) {
			log.error("Error al momento consultar las escuelas", e);
			MessagesController.addError(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.error.save"));

			throw new DioneException(e);
		}
	}

	/**
	 * 
	 * <b> Permite agregar guardar las materias seleccionadas </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 04/01/2015]
	 * </p>
	 * 
	 */
	public void agregarMaterias() {
		List<MateriaDTO> materiaDTOs = new ArrayList<MateriaDTO>();
		for (MateriaDTO materia : this.materias) {
			if (materia.getSeleccion()) {
				materiaDTOs.add(materia);
			}
		}
		docenteBean.setMateriasSeleccionadas(materiaDTOs);
	}

	/**
	 * 
	 * <b> Permite guardar la informacion del docente </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 05/01/2015]
	 * </p>
	 * 
	 * @throws DioneException
	 */
	public void guardarDatosGenerales() throws DioneException {

		Docente docente = new Docente();

		docente.setNombresDocente(docenteBean.getNombresDocente());
		docente.setApellidosDocente(docenteBean.getApellidosDocente());
		docente.setCedulaDocente(docenteBean.getCedulaDocente());
		docente.setDireccionDocente(docenteBean.getDireccionDocente());
		docente.setFechaCreacion(new Date());
		docente.setEstado(EstadoEnum.A);
		docente.setIdUsuarioCreacion(1);

		List<EscuelaUce> escuelasUce = new ArrayList<EscuelaUce>();
		List<MateriaUce> materiaUces = new ArrayList<MateriaUce>();
		for (AsignaturaDTO asiganturaDTO : docenteBean.getAsignaturasList()) {
			EscuelaUce escuelaUce = new EscuelaUce();
			
			EscuelaUce escuelaUceTemp = docenteService.consultarEscuelaUceById(Long.valueOf(asiganturaDTO.getEscuela()));
			escuelaUce.setEscuelaUce(escuelaUceTemp.getEscuelaUce());
			escuelaUce.setDocente(docente);
			escuelasUce.add(escuelaUce);
			
			for (MateriaDTO materiaDTO : asiganturaDTO.getMaterias()) {
				MateriaUce materiaUce = new MateriaUce();
				materiaUce.setMateriaUce(materiaDTO.getDesMateria());
				materiaUces.add(materiaUce);
			}
		}
		docente.setEscuelaUces(escuelasUce);
		

		try {
			docenteService.guardarDocente(docente, materiaUces);
			
			docenteBean.setNombresDocente(null);
			docenteBean.setApellidosDocente(null);
			docenteBean.setCedulaDocente(null);
			docenteBean.setDireccionDocente(null);
			
			MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("dione.mensaje.exito.save"));

		} catch (DioneException e) {
			log.error("Error al momento guardar los datos del docente", e);
			MessagesController.addError(null, HiperionMensajes.getInstancia().getString("dione.mensaje.error.save"));
			throw new DioneException(e);
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
	 * @return the docenteBean
	 */
	public DocenteBean getDocenteBean() {
		return docenteBean;
	}

	/**
	 * @param docenteBean
	 *            the docenteBean to set
	 */
	public void setDocenteBean(DocenteBean docenteBean) {
		this.docenteBean = docenteBean;
	}

	/**
	 * @return the materias
	 */
	public List<MateriaDTO> getMaterias() {
		return materias;
	}

	/**
	 * @param materias
	 *            the materias to set
	 */
	public void setMaterias(List<MateriaDTO> materias) {
		this.materias = materias;
	}

	/*
	 * public List<SelectItem> getEscuelasItems() throws DioneException {
	 * 
	 * this.escuelasItems = new ArrayList<SelectItem>(); Catalogo catalogo =
	 * catalogoService.consultarCatalogoById(HiperionMensajes.getInstancia().getLong("ec.uce.recursos.catalogoEscuelas")); List<DetalleCatalogo>
	 * escuelas = catalogo.getDetalleCatalogos();
	 * 
	 * for (DetalleCatalogo detalle : escuelas) { SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(),
	 * detalle.getDescDetCatalogo()); escuelasItems.add(selectItem); }
	 * 
	 * return escuelasItems; }
	 */

}
