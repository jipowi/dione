package ec.com.uce.web.backing;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.entities.Docente;
import ec.com.uce.dione.entities.EscuelaUce;
import ec.com.uce.dione.entities.MateriaUce;
import ec.com.uce.ejb.dto.AsignaturaDTO;
import ec.com.uce.ejb.dto.MateriaDTO;
import ec.com.uce.ejb.service.DocenteService;
import ec.com.uce.ejb.service.SyllabusService;
import ec.com.uce.web.bean.BuscarDocenteBean;
import ec.com.uce.web.util.HiperionMensajes;
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
public class BuscarDocenteBacking {

	@EJB
	private DocenteService docenteService;
	@EJB
	private SyllabusService syllabusService;

	@ManagedProperty(value = "#{buscarDocenteBean}")
	private BuscarDocenteBean buscarDocenteBean;

	private Docente docente;
	private Boolean activarHojaVida = false;

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
				activarHojaVida = true;
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

			} else {
				MessagesController.addError(null, HiperionMensajes.getInstancia().getString("dione.mensaje.error.buscar"));
			}

		} catch (DioneException e) {
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

}
