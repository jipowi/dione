package ec.com.uce.ejb.doc;

import javax.ejb.Local;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.entities.Docente;
/**
 * <b>Interface de generación de reporte</b>
 *  
 * @author gyandun
 * @version 1.0 <p>[$Author: gyandun $, $Date: 02/05/2014 $]</p>
 */
@Local
public interface GenerarDocumento {
	
	/**
	 * 
	 * <b>
	 * Metodo para generar el xml del documento
	 * </b>
	 * <p>[Author: Paul Jimenez, Date: 25/02/2015]</p>
	 *
	 * @param docente
	 * @return
	 * @throws DioneException
	 */
	String generarXml(Docente docente) throws DioneException;
}
