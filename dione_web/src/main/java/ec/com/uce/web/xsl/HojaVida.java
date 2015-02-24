package ec.com.uce.web.xsl;

import org.apache.commons.lang.StringEscapeUtils;

import ec.com.uce.dione.entities.Docente;

/**
 * <b>Clase que se encarga de generar el envio del mail para el funcionario notificando la solicitud de incripción</b>
 * 
 * @author gyandun
 * @version 1.0
 *          <p>
 *          [$Author: gyandun $, $Date: 05/06/2014 $]
 *          </p>
 */

public class HojaVida {

	private static String tagInicioCedula = "<cedula>";
	private static String tagFinCedula = "</cedula>";

	private static String tagInicioNombre = "<nombre>";
	private static String tagFinNombre = "</nombre>";

	private static String tagInicioApellido = "<apellido>";
	private static String tagFinApellido = "</apellido>";

	private static String tagInicioDireccion = "<direccion>";
	private static String tagFinDireccion = "</direccion>";

	public String generarXml(Docente docente) {

		StringBuffer buffer = new StringBuffer();
		buffer.append(tagInicioCedula).append(StringEscapeUtils.escapeXml(docente.getCedulaDocente())).append(tagFinCedula);
		buffer.append(tagInicioNombre).append(StringEscapeUtils.escapeXml(docente.getNombresDocente())).append(tagFinNombre);
		buffer.append(tagInicioApellido).append(StringEscapeUtils.escapeXml(docente.getApellidosDocente())).append(tagFinApellido);
		buffer.append(tagInicioDireccion).append(StringEscapeUtils.escapeXml(docente.getApellidosDocente())).append(tagFinDireccion);

		return buffer.toString();
	}

}
