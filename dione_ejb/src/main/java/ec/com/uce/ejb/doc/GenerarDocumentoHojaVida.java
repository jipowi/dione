package ec.com.uce.ejb.doc;

import java.util.List;

import javax.ejb.Local;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.entities.Docente;
import ec.com.uce.dione.entities.Experiencia;
import ec.com.uce.dione.entities.FormacionAcademica;
import ec.com.uce.dione.entities.FormacionContinua;

/**
 * <b>Interface de generación de reporte</b>
 * 
 * @author gyandun
 * @version 1.0
 *          <p>
 *          [$Author: gyandun $, $Date: 02/05/2014 $]
 *          </p>
 */
@Local
public interface GenerarDocumentoHojaVida {

	/**
	 * 
	 * <b> Permite generar el XMl del documento hoja de vida. </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 10/03/2015]
	 * </p>
	 * 
	 * @param docente
	 * @param formacionesA
	 * @param formacionesC
	 * @param experiencias
	 * @return
	 * @throws DioneException
	 */
	String generarXmlHojaVida(Docente docente, List<FormacionAcademica> formacionesA, List<FormacionContinua> formacionesC, List<Experiencia> experiencias) throws DioneException;

}
