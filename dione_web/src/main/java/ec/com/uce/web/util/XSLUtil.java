/**
 * 
 */
package ec.com.uce.web.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.jdom.Document;

import ec.com.kruger.framework.common.util.TransformerUtil;
import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.entities.Bibliografia;
import ec.com.uce.dione.entities.CompetenciaGenerale;
import ec.com.uce.dione.entities.CompetenciasEspecifica;
import ec.com.uce.dione.entities.CompetenciasGenerica;
import ec.com.uce.dione.entities.Corequisito;
import ec.com.uce.dione.entities.Docente;
import ec.com.uce.dione.entities.Experiencia;
import ec.com.uce.dione.entities.FormacionAcademica;
import ec.com.uce.dione.entities.FormacionContinua;
import ec.com.uce.dione.entities.Objetivo;
import ec.com.uce.dione.entities.Prerequisito;
import ec.com.uce.dione.entities.ResultadosAprendizaje;
import ec.com.uce.dione.entities.Syllabus;
import ec.com.uce.ejb.doc.GenerarDocumentoHojaVida;
import ec.com.uce.ejb.doc.GenerarDocumentoSyllabus;
import ec.com.uce.ejb.dto.UnidadCompetenciaDTO;
import ec.com.uce.web.xsl.XSLHelper;

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

	private static final String tagInicioDocumento = "<documento>";
	private static final String tagFinDocumento = "</documento>";

	Logger log = Logger.getLogger(XSLUtil.class);

	/**
	 * 
	 * <b> Permite generar un contenido XML. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 01/03/2015]
	 * </p>
	 * 
	 * @param docente
	 * @return
	 */
	public String generarXmlHojaVida(Docente docente, List<FormacionAcademica> formacionesA, List<FormacionContinua> formacionesC, List<Experiencia> experiencias) {
		StringBuilder xml = new StringBuilder();

		try {
			xml.append(tagInicioDocumento);

			try {
				String nombreClase = "java:app/dione_web/HojaVidaImpl";
				GenerarDocumentoHojaVida generarDocumento = (GenerarDocumentoHojaVida) getObjectByJndi(nombreClase);
				xml.append(generarDocumento.generarXmlHojaVida(docente, formacionesA, formacionesC, experiencias));

			} catch (Exception e) {
				log.error("Error, generacion xml reporte, e{}", e);
			}
			xml.append(tagFinDocumento);
		} catch (Exception e) {
			log.error("Error", e);

		}
		return xml.toString();
	}

	/**
	 * 
	 * <b> Permite generar el XML del syllabus. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 10/03/2015]
	 * </p>
	 * 
	 * @param syllabus
	 * @param prerequisitos
	 * @param corequisitos
	 * @param objetivos
	 * @param comGenerales
	 * @param compInstrumentales
	 * @param compInterpersonales
	 * @param compSistematicas
	 * @param compespecificas
	 * @param bibliografias
	 * @param resultados
	 * @param unidadesDTO
	 * @return
	 */
	public String generarXmlSyllabus(Syllabus syllabus, List<Prerequisito> prerequisitos, List<Corequisito> corequisitos, List<Objetivo> objetivos,
			List<CompetenciaGenerale> comGenerales, List<CompetenciasGenerica> compInstrumentales, List<CompetenciasGenerica> compInterpersonales,
			List<CompetenciasGenerica> compSistematicas, List<CompetenciasEspecifica> compespecificas, List<Bibliografia> bibliografias, List<ResultadosAprendizaje> resultados,
			List<UnidadCompetenciaDTO> unidadesDTO) {

		StringBuilder xml = new StringBuilder();

		try {
			xml.append(tagInicioDocumento);

			try {
				String nombreClase = "java:app/dione_web/SyllabusImpl";
				GenerarDocumentoSyllabus generarDocumento = (GenerarDocumentoSyllabus) getObjectByJndi(nombreClase);

				xml.append(generarDocumento.generarxmlSyllabus(syllabus, prerequisitos, corequisitos, objetivos, comGenerales, compInstrumentales, compInterpersonales,
						compSistematicas, compespecificas, bibliografias, resultados, unidadesDTO));

			} catch (Exception e) {
				log.error("Error, generacion xml del syllabus, e{}", e);
			}
			xml.append(tagFinDocumento);
		} catch (Exception e) {
			log.error("Error", e);

		}
		return xml.toString();
	}

	/**
	 * 
	 * <b> Permite generar el HTML de la hoja de vida. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 09/03/2015]
	 * </p>
	 * 
	 * @param docente
	 * @param formacionesC
	 * @param formacionesA
	 * @return
	 */
	public String obtenerHtmlHojaVida(Docente docente, List<FormacionAcademica> formacionesA, List<FormacionContinua> formacionesC, List<Experiencia> experiencias) {
		String html = null;
		try {
			InputStream in = XSLHelper.class.getResourceAsStream("HojaVidaHTML.xsl");
			InputStreamReader is = new InputStreamReader(in);
			StringBuilder sb = new StringBuilder();
			BufferedReader br = new BufferedReader(is);
			String read = br.readLine();

			while (read != null) {
				sb.append(read);
				read = br.readLine();

			}

			String contenidoXSL = sb.toString();

			// Se genera el XML con los datos del correo
			String contenidoXml = generarXmlHojaVida(docente, formacionesA, formacionesC, experiencias);
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
	 * 
	 * <b> Permite obtener el HTML del syllabus. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 10/03/2015]
	 * </p>
	 * 
	 * @param syllabus
	 * @param prerequisitos
	 * @param corequisitos
	 * @param objetivos
	 * @param comGenerales
	 * @param compInstrumentales
	 * @param compInterpersonales
	 * @param compSistematicas
	 * @param compespecificas
	 * @param bibliografias
	 * @param resultados
	 * @param unidadesDTO
	 * @return
	 */
	public String obtenerHtmlSyllabus(Syllabus syllabus, List<Prerequisito> prerequisitos, List<Corequisito> corequisitos, List<Objetivo> objetivos,
			List<CompetenciaGenerale> comGenerales, List<CompetenciasGenerica> compInstrumentales, List<CompetenciasGenerica> compInterpersonales,
			List<CompetenciasGenerica> compSistematicas, List<CompetenciasEspecifica> compespecificas, List<Bibliografia> bibliografias, List<ResultadosAprendizaje> resultados,
			List<UnidadCompetenciaDTO> unidadesDTO) {

		String html = null;

		try {

			InputStream in = XSLHelper.class.getResourceAsStream("SyllabusHTML.xsl");
			InputStreamReader is = new InputStreamReader(in);
			StringBuilder sb = new StringBuilder();
			BufferedReader br = new BufferedReader(is);
			String read = br.readLine();

			while (read != null) {
				sb.append(read);
				read = br.readLine();

			}

			String contenidoXSL = sb.toString();

			// Se genera el XML con los datos del correo
			String contenidoXml = generarXmlSyllabus(syllabus, prerequisitos, corequisitos, objetivos, comGenerales, compInstrumentales, compInterpersonales, compSistematicas,
					compespecificas, bibliografias, resultados, unidadesDTO);

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
