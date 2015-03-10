package ec.com.uce.ejb.doc.impl;

import java.util.List;

import javax.ejb.Stateless;

import org.apache.commons.lang.StringEscapeUtils;

import ec.com.uce.dione.entities.Docente;
import ec.com.uce.dione.entities.Experiencia;
import ec.com.uce.dione.entities.FormacionAcademica;
import ec.com.uce.dione.entities.FormacionContinua;
import ec.com.uce.ejb.doc.GenerarDocumentoHojaVida;

/**
 * 
 * <b> Clase que se encarga de generar el documento PDF. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,10/03/2015
 * @since JDK1.6
 */
@Stateless
public class HojaVidaImpl implements GenerarDocumentoHojaVida {

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

	private static String tagInicioExperiencia = "<experiencia>";
	private static String tagFinExperiencia = "</experiencia>";

	private static String tagInicioInstitucionE = "<institucionE>";
	private static String tagFinInstitucionE = "</institucionE>";

	private static String tagInicioFechaInicio = "<fechaInicio>";
	private static String tagFinFechaInicio = "</fechaInicio>";

	private static String tagInicioFechaFin = "<fechaFin>";
	private static String tagFinFechaFin = "</fechaFin>";

	private static String tagInicioFuncion = "<funcion>";
	private static String tagFinFuncion = "</funcion>";

	@Override
	public String generarXmlHojaVida(Docente docente, List<FormacionAcademica> formacionesA, List<FormacionContinua> formacionesC, List<Experiencia> experiencias) {

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

		for (Experiencia experiencia : experiencias) {
			buffer.append(tagInicioExperiencia);
			buffer.append(tagInicioInstitucionE).append(StringEscapeUtils.escapeXml(experiencia.getInstitucionExp())).append(tagFinInstitucionE);
			buffer.append(tagInicioFechaInicio).append(StringEscapeUtils.escapeXml(experiencia.getFechaInicioExp().toString())).append(tagFinFechaInicio);
			buffer.append(tagInicioFechaFin).append(StringEscapeUtils.escapeXml(experiencia.getFechaFinExp().toString())).append(tagFinFechaFin);
			buffer.append(tagInicioFuncion).append(StringEscapeUtils.escapeXml(experiencia.getFuncionExp())).append(tagFinFuncion);
			buffer.append(tagFinExperiencia);
		}
		return buffer.toString();
	}


}
