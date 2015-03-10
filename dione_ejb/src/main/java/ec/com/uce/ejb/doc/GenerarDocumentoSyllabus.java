package ec.com.uce.ejb.doc;

import java.util.List;

import javax.ejb.Local;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.entities.Bibliografia;
import ec.com.uce.dione.entities.CompetenciaGenerale;
import ec.com.uce.dione.entities.CompetenciasEspecifica;
import ec.com.uce.dione.entities.CompetenciasGenerica;
import ec.com.uce.dione.entities.Corequisito;
import ec.com.uce.dione.entities.Objetivo;
import ec.com.uce.dione.entities.Prerequisito;
import ec.com.uce.dione.entities.ResultadosAprendizaje;
import ec.com.uce.dione.entities.Syllabus;
import ec.com.uce.ejb.dto.UnidadCompetenciaDTO;

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
public interface GenerarDocumentoSyllabus {

	/**
	 * 
	 * <b> Permite generar el XMl del documento syllabus. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 10/03/2015]
	 * </p>
	 * 
	 * @param docente
	 * @param formacionesA
	 * @param formacionesC
	 * @param experiencias
	 * @return
	 * @throws DioneException
	 */
	String generarxmlSyllabus(Syllabus syllabus, List<Prerequisito> prerequisitos, List<Corequisito> corequisitos, List<Objetivo> objetivos,
			List<CompetenciaGenerale> comGenerales, List<CompetenciasGenerica> compInstrumentales, List<CompetenciasGenerica> compInterpersonales,
			List<CompetenciasGenerica> compSistematicas, List<CompetenciasEspecifica> compespecificas, List<Bibliografia> bibliografias, List<ResultadosAprendizaje> resultados,
			List<UnidadCompetenciaDTO> unidadesDTO) throws DioneException;
}
