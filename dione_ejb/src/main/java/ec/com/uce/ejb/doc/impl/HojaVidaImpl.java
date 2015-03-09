package ec.com.uce.ejb.doc.impl;

import java.util.List;

import javax.ejb.Stateless;

import org.apache.commons.lang.StringEscapeUtils;

import ec.com.uce.dione.entities.Docente;
import ec.com.uce.dione.entities.FormacionAcademica;
import ec.com.uce.dione.entities.FormacionContinua;
import ec.com.uce.ejb.doc.GenerarDocumento;

/**
 * <b>Clase que se encarga de generar el envio del mail para el funcionario notificando la solicitud de incripción</b>
 * 
 * @author gyandun
 * @version 1.0
 *          <p>
 *          [$Author: gyandun $, $Date: 05/06/2014 $]
 *          </p>
 */
@Stateless
public class HojaVidaImpl implements GenerarDocumento {

	private static String tagInicioCedula = "<cedula>";
	private static String tagFinCedula = "</cedula>";

	private static String tagInicioNombre = "<nombre>";
	private static String tagFinNombre = "</nombre>";

	private static String tagInicioApellido = "<apellido>";
	private static String tagFinApellido = "</apellido>";

	private static String tagInicioDireccion = "<direccion>";
	private static String tagFinDireccion = "</direccion>";

	private static String tagInicioFormacionAcademica = "<formacionAcademica>";
	private static String tagFinFarmacionAcademica = "</formacionAcademica>";

	private static String tagInicioTitulo = "<titulo>";
	private static String tagFinTitulo = "</titulo>";

	private static String tagInicioInstitucionA = "<institucionA>";
	private static String tagFinInstitucionA = "</institucionA>";

	private static String tagInicioFormacionC = "<formacionC>";
	private static String tagFinFarmacionC = "</formacionC>";

	private static String tagInicioCurso = "<curso>";
	private static String tagFinCurso = "</curso>";

	private static String tagInicioDuracion = "<duracion>";
	private static String tagFinDuracion = "</duracion>";

	private static String tagInicioInstitucionC = "<institucionC>";
	private static String tagFinInstitucionC = "</institucionC>";

	public String generarXml(Docente docente, List<FormacionAcademica> formacionesA, List<FormacionContinua> formacionesC) {

		StringBuffer buffer = new StringBuffer();
		buffer.append(tagInicioCedula).append(StringEscapeUtils.escapeXml(docente.getCedulaDocente())).append(tagFinCedula);
		buffer.append(tagInicioNombre).append(StringEscapeUtils.escapeXml(docente.getNombresDocente())).append(tagFinNombre);
		buffer.append(tagInicioApellido).append(StringEscapeUtils.escapeXml(docente.getApellidosDocente())).append(tagFinApellido);
		buffer.append(tagInicioDireccion).append(StringEscapeUtils.escapeXml(docente.getDireccionDocente())).append(tagFinDireccion);

		for (FormacionAcademica formacionA : formacionesA) {
			buffer.append(tagInicioFormacionAcademica);
			buffer.append(tagInicioInstitucionA).append(StringEscapeUtils.escapeXml(formacionA.getInstitucionAca())).append(tagFinInstitucionA);
			buffer.append(tagInicioTitulo).append(StringEscapeUtils.escapeXml(formacionA.getTitulo())).append(tagFinTitulo);
			buffer.append(tagFinFarmacionAcademica);
		}

		for (FormacionContinua formacionC : formacionesC) {
			buffer.append(tagInicioFormacionC);
			buffer.append(tagInicioCurso).append(StringEscapeUtils.escapeXml(formacionC.getCurso())).append(tagFinCurso);
			buffer.append(tagInicioDuracion).append(StringEscapeUtils.escapeXml(formacionC.getDuracion())).append(tagFinDuracion);
			buffer.append(tagInicioInstitucionC).append(StringEscapeUtils.escapeXml(formacionC.getInstitucionContinua())).append(tagFinInstitucionC);
			buffer.append(tagFinFarmacionC);
		}
		return buffer.toString();
	}

}
