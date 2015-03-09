package ec.com.uce.ejb.doc;

import java.util.List;

import javax.ejb.Local;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.entities.Docente;
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
public interface GenerarDocumento {

	/**
	 * 
	 * <b> Permite generar el XMl del documento. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 09/03/2015]
	 * </p>
	 * 
	 * @param docente
	 * @param formacionesC
	 * @param formacionesA
	 * @return
	 * @throws DioneException
	 */
	String generarXml(Docente docente, List<FormacionAcademica> formacionesA,  List<FormacionContinua> formacionesC) throws DioneException;
}
