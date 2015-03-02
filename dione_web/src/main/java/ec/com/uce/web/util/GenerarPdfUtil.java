package ec.com.uce.web.util;

import java.io.Serializable;
import java.util.HashMap;

import javax.faces.context.FacesContext;

import ec.com.kruger.framework.common.util.pdf.HtmltoPDF;
import ec.com.uce.dione.entities.Docente;

public class GenerarPdfUtil implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Permite generar el comprobante en formato pdf
	 * 
	 * @param pComprobanteVO
	 *            El documento que se desea procesar como PDF
	 * @param pCodigoTipoComprobante
	 *            El codigo del tipo de comprobante
	 * @return El contenido del archivo PDF como array de bytes
	 * @throws LnException
	 */
	public static byte[] generarAchivoPDF(Docente pDocente) throws Exception {
		String pHtml = XSLUtil.getInstancia().obtenerHtml(pDocente);

		pHtml = pHtml.replace(ConstantesUtil.ENCABEZADO_ISO_XML, "");
		pHtml = pHtml.replace(ConstantesUtil.ENCABEZADO_XML, "");
		pHtml = pHtml.replace(ConstantesUtil.ENCABEZADO_XML_STANDALONE, "");
		pHtml = pHtml.replace(ConstantesUtil.ENCABEZADO_XML, "");

		HtmltoPDF htmltoPDF = new HtmltoPDF(FacesContext.getCurrentInstance().getExternalContext().getRealPath(ConstantesUtil.DIRECTORIO_PLANTILLA_XHTML2FO));
		HashMap<String, String> parametros = new HashMap<String, String>();
		parametros.put(ConstantesUtil.ANCHO_CODIGO_BARRAS, ConstantesUtil.VALOR_ANCHO_CODIGO_BARRAS_73);
		byte contenido[] = htmltoPDF.convertir(pHtml, "", "", parametros, null);

		// Agregar marca de agua al Pdf
		return ConcatenadorPdf.numerarMarcar(contenido, Boolean.TRUE, Boolean.TRUE, ConstantesUtil.PATH_MARCA_AGUA_PDF);
	}
}
