package ec.com.uce.ejb.doc.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.commons.lang.StringEscapeUtils;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.entities.Bibliografia;
import ec.com.uce.dione.entities.CompetenciaGenerale;
import ec.com.uce.dione.entities.CompetenciasEspecifica;
import ec.com.uce.dione.entities.CompetenciasGenerica;
import ec.com.uce.dione.entities.Corequisito;
import ec.com.uce.dione.entities.MateriaSyllabus;
import ec.com.uce.dione.entities.Objetivo;
import ec.com.uce.dione.entities.Prerequisito;
import ec.com.uce.dione.entities.ResultadosAprendizaje;
import ec.com.uce.dione.entities.Syllabus;
import ec.com.uce.ejb.doc.GenerarDocumentoSyllabus;
import ec.com.uce.ejb.dto.UnidadCompetenciaDTO;
import ec.com.uce.ejb.service.SyllabusService;

/**
 * 
 * <b> Clase que se encarga de generar el documento PDF. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,10/03/2015
 * @since JDK1.6
 */
@Stateless
public class SyllabusImpl implements GenerarDocumentoSyllabus {

	private static String tagInicioAsignatura = "<asignatura>";
	private static String tagFinAsignatura = "</asignatura>";

	private static String tagInicioHorasPresenciales = "<horasPresenciales>";
	private static String tagFinHorasPresenciales = "</horasPresenciales>";

	private static String tagInicioHorasTutorias = "<horasTutorias>";
	private static String tagFinHorasTutorias = "</horasTutorias>";

	private static String tagInicioDesAsignatura = "<desAsignatura>";
	private static String tagFinDesAsignatura = "</desAsignatura>";

	private static String tagInicioPrerequisitos = "<prerequisitos>";
	private static String tagFinPrerequisitos = "</prerequisitos>";

	private static String tagInicioPrerequisito = "<prerequisito>";
	private static String tagFinPrerequisito = "</prerequisito>";

	private static String tagInicioCorequisitos = "<corequisitos>";
	private static String tagFinCorequisitos = "</corequisitos>";

	private static String tagInicioCorequisito = "<corequisito>";
	private static String tagFinCorequisito = "</corequisito>";

	private static String tagInicioObjetivos = "<objetivos>";
	private static String tagFinObjetivos = "</objetivos>";
	
	private static String tagInicioObjetivo = "<objetivo>";
	private static String tagFinObjetivo = "</objetivo>";

	private static String tagInicioComGenerales = "<comGenerales>";
	private static String tagFinComGenerales = "</comGenerales>";
	
	private static String tagInicioCompGeneral = "<compGeneral>";
	private static String tagFinCompGeneral = "</compGeneral>";

	private static String tagInicioComInterpersonales = "<comInterpersonales>";
	private static String tagFinComInterpersonales = "</comInterpersonales>";
	
	private static String tagInicioComInterpersonal = "<comInterpersonal>";
	private static String tagFinComInterpersonal = "</comInterpersonal>";

	private static String tagInicioComInstrumentales = "<comInstrumentales>";
	private static String tagFinComInstrumentales = "</comInstrumentales>";
	
	private static String tagInicioComInstrumental = "<comInstrumental>";
	private static String tagFinComInstrumental = "</comInstrumental>";
	
	private static String tagInicioComSistematicas = "<comSistematicas>";
	private static String tagFinComSistematicas = "</comSistematicas>";

	private static String tagInicioComSistematica = "<comSistematica>";
	private static String tagFinComSistematica = "</comSistematica>";
	
	private static String tagInicioComEspecificas = "<comEspecificas>";
	private static String tagFinComEspecificas = "</comEspecificas>";
	
	private static String tagInicioComEspecifica = "<comEspecifica>";
	private static String tagFinComEspecifica = "</comEspecifica>";

	@EJB
	private SyllabusService syllabusService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.uce.ejb.doc.GenerarDocumento#generarxmlSyllabus(ec.com.uce.dione.entities.Syllabus, java.util.List, java.util.List, java.util.List,
	 * java.util.List, java.util.List, java.util.List, java.util.List, java.util.List, java.util.List, java.util.List, java.util.List)
	 */
	@Override
	public String generarxmlSyllabus(Syllabus syllabus, List<Prerequisito> prerequisitos, List<Corequisito> corequisitos, List<Objetivo> objetivos,
			List<CompetenciaGenerale> comGenerales, List<CompetenciasGenerica> compInstrumentales, List<CompetenciasGenerica> compInterpersonales,
			List<CompetenciasGenerica> compSistematicas, List<CompetenciasEspecifica> compespecificas, List<Bibliografia> bibliografias, List<ResultadosAprendizaje> resultados,
			List<UnidadCompetenciaDTO> unidadesDTO) throws DioneException {

		StringBuffer buffer = new StringBuffer();

		MateriaSyllabus materiaSyllabus = syllabusService.consultarMateriaSyllabusBySyllabus(syllabus.getIdSyllabus());

		buffer.append(tagInicioAsignatura).append(StringEscapeUtils.escapeXml(materiaSyllabus.getMateriaUce().getMateriaUce())).append(tagFinAsignatura);
		buffer.append(tagInicioHorasPresenciales).append(StringEscapeUtils.escapeXml(syllabus.getNumHorasPresenciales().toString())).append(tagFinHorasPresenciales);
		buffer.append(tagInicioHorasTutorias).append(StringEscapeUtils.escapeXml(syllabus.getHorasTutorias().toString())).append(tagFinHorasTutorias);
		buffer.append(tagInicioDesAsignatura).append(StringEscapeUtils.escapeXml(syllabus.getDescripcionAsignatura())).append(tagFinDesAsignatura);

		// Prerequisitos
		for (Prerequisito prerequisito : prerequisitos) {
			buffer.append(tagInicioPrerequisitos);
			buffer.append(tagInicioPrerequisito).append(StringEscapeUtils.escapeXml(prerequisito.getPrerequisito())).append(tagFinPrerequisito);
			buffer.append(tagFinPrerequisitos);
		}
		// Corequisitos
		for (Corequisito corequisito : corequisitos) {
			buffer.append(tagInicioCorequisitos);
			buffer.append(tagInicioCorequisito).append(StringEscapeUtils.escapeXml(corequisito.getCorequisito())).append(tagFinCorequisito);
			buffer.append(tagFinCorequisitos);
		}
		// Objetivos
		for (Objetivo objetivo : objetivos) {
			buffer.append(tagInicioObjetivos);
			buffer.append(tagInicioObjetivo).append(StringEscapeUtils.escapeXml(objetivo.getObjetivo())).append(tagFinObjetivo);
			buffer.append(tagFinObjetivos);
		}
		// Competencias generales
		for (CompetenciaGenerale coGenerale : comGenerales) {
			buffer.append(tagInicioComGenerales);
			buffer.append(tagInicioCompGeneral).append(StringEscapeUtils.escapeXml(coGenerale.getCompetenciaGeneral())).append(tagFinCompGeneral);
			buffer.append(tagFinComGenerales);
		}
		// Competencias genericas
		for (CompetenciasGenerica generica : compInstrumentales) {
			buffer.append(tagInicioComInstrumentales);
			buffer.append(tagInicioComInstrumental).append(StringEscapeUtils.escapeXml(generica.getCompetenciaGenerica())).append(tagFinComInstrumental);
			buffer.append(tagFinComInstrumentales);
		}
		for (CompetenciasGenerica generica : compInterpersonales) {
			buffer.append(tagInicioComInterpersonales);
			buffer.append(tagInicioComInterpersonal).append(StringEscapeUtils.escapeXml(generica.getCompetenciaGenerica())).append(tagFinComInterpersonal);
			buffer.append(tagFinComInterpersonales);
		}
		for (CompetenciasGenerica generica : compSistematicas) {
			buffer.append(tagInicioComSistematicas);
			buffer.append(tagInicioComSistematica).append(StringEscapeUtils.escapeXml(generica.getCompetenciaGenerica())).append(tagFinComSistematica);
			buffer.append(tagFinComSistematicas);
		}
		// Competencias Especificas
		for (CompetenciasEspecifica especifica : compespecificas) {
			buffer.append(tagInicioComEspecificas);
			buffer.append(tagInicioComEspecifica).append(StringEscapeUtils.escapeXml(especifica.getCompetenciaEspecifica())).append(tagFinComEspecifica);
			buffer.append(tagFinComEspecificas);
		}

		return buffer.toString();
	}
}
