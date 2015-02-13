/**
 * 
 */
package ec.com.uce.web.util;

import org.apache.log4j.Logger;
import org.jdom.Document;

import ec.com.kruger.framework.common.util.TransformerUtil;
import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.entities.Docente;
import ec.com.uce.web.xsl.HojaVida;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * @author jarana
 * 
 */
public class XSLUtil {

	private XSLUtil() {
	}

	private static final XSLUtil INSTANCIA = new XSLUtil();

	public static XSLUtil getInstancia() {
		return INSTANCIA;
	}

	private static final String tagInicioMail = "<mail>";
	private static final String tagFinMail = "</mail>";

	Logger log = Logger.getLogger(XSLUtil.class);

	/**
	 * 
	 * @param propuestaProyectoDTO
	 * @param accionesDTO
	 * @param personasDTO
	 * @param clienteDTO
	 * @param nombreArchivo
	 * @return
	 * @throws MercadoValoresException
	 * @throws DAOException
	 */
	public String generarXmlCorreo(Docente docente) {
		StringBuilder xml = new StringBuilder();

		try {
			xml.append(tagInicioMail);

			try {
				String nombreClase = "java:app/dione_web/HojaVida";
				HojaVida generarMail = (HojaVida) getObjectByJndi(nombreClase);
				xml.append(generarMail.generarXml(docente));

			} catch (Exception e) {
				log.error("Error, generacion xml reporte, e{}", e);
			}
			xml.append(tagFinMail);
		} catch (Exception e) {
			log.error("Error", e);

		}
		return xml.toString();

	}

	/**
	 * <b>Obtiene los datos del correo para envio</b>
	 * <p>
	 * [Author: gyandun, Date: 30/05/2014]
	 * </p>
	 * 
	 * @param evento
	 *            Datos del evento que se ejecuta
	 * @param mail
	 *            Datos del mail a enviar
	 * @return Devuelve el texto a enviar en el correo
	 */
	public String obtenerCorreoHtml(Docente docente) {
		String html = null;
		try {

			String contenidoXSL = "";

			// Se genera el XML con los datos del correo
			String contenidoXml = generarXmlCorreo(docente);
			Document docXML = TransformerUtil.stringToXMLDocument(contenidoXml.toString());
			Document docXSL = TransformerUtil.stringToXML(contenidoXSL);
			Document result = TransformerUtil.transformar(docXML, docXSL);
			html = TransformerUtil.xmlToString(result);
			html = html.replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&amp;", "&").replace("UTF-8", "ISO-8859-1");
		} catch (Exception e) {
			log.error("Error ", e);

		}

		return html;
	}

	/**
	 * <b>Obtiene el servicio de Seguridad del sistema de mercado de valores</b>
	 * <p>
	 * [Author: gyandun, Date: 07/05/2014]
	 * </p>
	 * 
	 * @return
	 * @throws MercadoValoresException
	 *             En caso de no encontrar el EJB
	 */
	public Object getObjectByJndi(String jndiName) throws DioneException {
		try {
			return getContext().lookup(jndiName);
		} catch (Exception e) {
			throw new DioneException(e);
		}
	}

	/**
	 * <b> Permite inicializar el InitialContext. </b>
	 * <p>
	 * [Author: gyandun, Date: 16/03/2014]
	 * </p>
	 * 
	 * @return Context
	 * @throws NamingException
	 *             NamingException
	 */
	public Context getContext() throws NamingException {
		return new InitialContext();
	}

}
