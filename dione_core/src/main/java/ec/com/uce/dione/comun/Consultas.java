package ec.com.uce.dione.comun;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
		// CATALOGO
		@NamedQuery(name = "Catalogo.findById", query = "SELECT c FROM Catalogo c WHERE c.idCatalogo =:idCatalogo"),
		// MATERIAS
		@NamedQuery(name = "MateriaUce.findByEscuela", query = "SELECT m FROM MateriaUce m WHERE m.escuelaUce.idEscuelaUce =:idEscuela"),
		@NamedQuery(name = "Materia.findByEscuela", query = "SELECT m FROM Materia m WHERE m.escuela.idEscuela =:idEscuela"),
		// ESCUELA UCE
		@NamedQuery(name = "EscuelaUce.findByDocente", query = "SELECT m FROM EscuelaUce m WHERE m.docente.idDocente =:idDocente"),
		@NamedQuery(name = "EscuelaUce.findByDescripcion", query = "SELECT m FROM EscuelaUce m WHERE m.escuelaUce =:escuela"),
		// PREREQUISITO
		@NamedQuery(name = "Prerequisito.findByMateria", query = "SELECT m FROM Prerequisito m WHERE m.materia.idMateria =:idMateria"),
		// COREQUISITO
		@NamedQuery(name = "Corequisito.findByMateria", query = "SELECT m FROM Corequisito m WHERE m.materia.idMateria =:idMateria"),
		// FORMACION ACADEMICA
		@NamedQuery(name = "FormacionAcademica.findByDocente", query = "SELECT m FROM FormacionAcademica m WHERE m.docente.idDocente =:idDocente"),
		// FORMACION CONTINUA
		@NamedQuery(name = "FormacionContinua.findByDocente", query = "SELECT m FROM FormacionContinua m WHERE m.docente.idDocente =:idDocente"),
		// USUARIO
		@NamedQuery(name = "Usuario.loginUser", query = "SELECT u FROM Usuario u WHERE u.usuario =:usuario AND u.clave =:clave"),
		// DOCENTE
		@NamedQuery(name = "Docente.findByCedula", query = "SELECT d FROM Docente d WHERE d.cedulaDocente =:cedula"),

		// MATERIA SYLLABUS
		@NamedQuery(name = "MateriaSyllabus.findBySyllabus", query = "SELECT d FROM MateriaSyllabus d WHERE d.syllabus.idSyllabus=:idSyllabus"),
		@NamedQuery(name = "MateriaSyllabus.findByMateriaAndDocente", query = "SELECT m FROM MateriaSyllabus m WHERE m.docente.idDocente =:idDocente AND m.materiaUce.idMateriaUce=:idMateriaUce"),
		// DETALLE_CATALOGO
		@NamedQuery(name = "DetalleCatalogo.findByCodCatalogo", query = "SELECT d FROM DetalleCatalogo d WHERE d.catalogo.idCatalogo =:idCatalogo ORDER BY d.descDetCatalogo"),
		@NamedQuery(name = "DetalleCatalogo.findByCodCatalogoAndCodDetalle", query = "SELECT d FROM DetalleCatalogo d WHERE d.catalogo.idCatalogo =:idCatalogo AND d.codDetalleCatalogo=:codDetalleCatalogo"),
		// ROL
		@NamedQuery(name = "Rol.findByUsuario", query = "SELECT r FROM Rol r WHERE r.usuario.idUsuario =:idUsuario"),
		// OBJETIVOS
		@NamedQuery(name = "Objetivo.findBysyllabus", query = "SELECT o FROM Objetivo o WHERE o.syllabus.idSyllabus =:idSyllabus"),
		// CUMPLIMIENTOS
		@NamedQuery(name = "Cumplimiento.findByIdMateriaSyllabus", query = "SELECT o FROM Cumplimiento o WHERE o.materiaSyllabus.idMateriaSyllabus =:idMateriaSyllabus"),
		// COMPETENCIAS
		@NamedQuery(name = "CompetenciaGenerale.findBySyllabus", query = "SELECT c FROM CompetenciaGenerale c WHERE c.syllabus.idSyllabus =:idSyllabus"),
		@NamedQuery(name = "CompetenciasGenerica.findBySyllabus", query = "SELECT c FROM CompetenciasGenerica c WHERE c.syllabus.idSyllabus =:idSyllabus"),
		@NamedQuery(name = "CompetenciasEspecifica.findBySyllabus", query = "SELECT c FROM CompetenciasEspecifica c WHERE c.syllabus.idSyllabus =:idSyllabus"),
		// RESULTADOS APRENDIZAJE
		@NamedQuery(name = "ResultadosAprendizaje.findBySyllabus", query = "SELECT r FROM ResultadosAprendizaje r WHERE r.syllabus.idSyllabus =:idSyllabus"),
		// BIBLIOGRAFIAS
		@NamedQuery(name = "Bibliografia.findBySyllabus", query = "SELECT r FROM Bibliografia r WHERE r.syllabus.idSyllabus =:idSyllabus"),
		// UNIDADES
		@NamedQuery(name = "UnidadCompetencia.findBySyllabus", query = "SELECT r FROM UnidadCompetencia r WHERE r.syllabus.idSyllabus =:idSyllabus"),
		// EXPERIENCIAS
		@NamedQuery(name = "Experiencia.findByDocente", query = "SELECT e FROM Experiencia e WHERE e.docente.idDocente =:idDocente"),
		// ELEMENTO COMPETENCIA
		@NamedQuery(name = "ElementoCompetencia.findBySyllabus", query = "SELECT r FROM ElementoCompetencia r WHERE r.unidadCompetencia.idUnidadCompetencia =:idUnidadCompetencia"),
		// MENU
		@NamedQuery(name = "Menu.findByRol", query = "SELECT m FROM RolMenu m WHERE m.rol.idRol =:idRol") })
public class Consultas implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Integer comunId;

	/**
	 * 
	 * @return
	 */
	public Integer getComunId() {
		return comunId;
	}

	/**
	 * 
	 * @param comunId
	 */
	public void setComunId(Integer comunId) {
		this.comunId = comunId;
	}
}
