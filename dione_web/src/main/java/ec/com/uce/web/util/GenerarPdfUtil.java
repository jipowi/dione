package ec.com.uce.web.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.xml.transform.TransformerException;

import org.jdom.JDOMException;

import com.lowagie.text.DocumentException;

import ec.com.kruger.framework.common.util.pdf.HtmltoPDF;
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
import ec.com.uce.ejb.dto.UnidadCompetenciaDTO;

public class GenerarPdfUtil implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * <b> Permite generar la hoja de vida en formato PDF. </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 10/03/2015]
	 * </p>
	 * 
	 * @param docente
	 * @param formacionesA
	 * @param formacionesC
	 * @param experiencias
	 * @return
	 * @throws Exception
	 */
	public static byte[] generarAchivoPDFHojaVida(Docente docente, List<FormacionAcademica> formacionesA, List<FormacionContinua> formacionesC, List<Experiencia> experiencias)
			throws Exception {
		String pHtml = XSLUtil.getInstancia().obtenerHtmlHojaVida(docente, formacionesA, formacionesC, experiencias);

		byte[] contenido = obtenerCadenaBytes(pHtml);

		// Agregar marca de agua y piede de pagina al Pdf
		return ConcatenadorPdf.numerarMarcar(contenido, Boolean.TRUE, Boolean.TRUE, ConstantesUtil.PATH_MARCA_AGUA_PDF);
	}

	/**
	 * 
	 * <b> Permite generar PDF para descargar. </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 04/05/2015]
	 * </p>
	 * 
	 * @param contenido
	 * @return
	 * @throws IOException
	 * @throws DocumentException
	 */
	public static byte[] generarPDFs(byte[] contenido) throws IOException, DocumentException {
		return ConcatenadorPdf.numerarMarcar(contenido, Boolean.TRUE, Boolean.TRUE, ConstantesUtil.PATH_MARCA_AGUA_PDF);
	}

	/**
	 * 
	 * <b> Permite obtener el archivo PDF del Syllabus. </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 10/03/2015]
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
	 * @throws Exception
	 */
	public static byte[] generarAchivoPDFSyllabus(Syllabus syllabus, List<Prerequisito> prerequisitos, List<Corequisito> corequisitos, List<Objetivo> objetivos,
			List<CompetenciaGenerale> comGenerales, List<CompetenciasGenerica> compInstrumentales, List<CompetenciasGenerica> compInterpersonales,
			List<CompetenciasGenerica> compSistematicas, List<CompetenciasEspecifica> compespecificas, List<Bibliografia> bibliografias, List<ResultadosAprendizaje> resultados,
			List<UnidadCompetenciaDTO> unidadesDTO) throws Exception {

		String pHtml = XSLUtil.getInstancia().obtenerHtmlSyllabus(syllabus, prerequisitos, corequisitos, objetivos, comGenerales, compInstrumentales, compInterpersonales,
				compSistematicas, compespecificas, bibliografias, resultados, unidadesDTO);

		byte[] contenido = obtenerCadenaBytes(pHtml);

		// Agregar marca de agua al Pdf
		return ConcatenadorPdf.numerarMarcar(contenido, Boolean.TRUE, Boolean.TRUE, ConstantesUtil.PATH_MARCA_AGUA_PDF);
	}

	/**
	 * <b> Permite obtener la cadena de bytes del archivo HTML. </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 10/03/2015]
	 * </p>
	 * 
	 * @param pHtml
	 * @return
	 * @throws FileNotFoundException
	 * @throws JDOMException
	 * @throws IOException
	 * @throws TransformerException
	 */
	private static byte[] obtenerCadenaBytes(String pHtml) throws FileNotFoundException, JDOMException, IOException, TransformerException {
		pHtml = pHtml.replace(ConstantesUtil.ENCABEZADO_ISO_XML, "");
		pHtml = pHtml.replace(ConstantesUtil.ENCABEZADO_XML, "");
		pHtml = pHtml.replace(ConstantesUtil.ENCABEZADO_XML_STANDALONE, "");
		pHtml = pHtml.replace(ConstantesUtil.ENCABEZADO_XML, "");

		HtmltoPDF htmltoPDF = new HtmltoPDF(FacesContext.getCurrentInstance().getExternalContext().getRealPath(ConstantesUtil.DIRECTORIO_PLANTILLA_XHTML2FO));
		HashMap<String, String> parametros = new HashMap<String, String>();
		byte contenido[] = htmltoPDF.convertir(pHtml, "", "", parametros, null);
		return contenido;
	}
}
