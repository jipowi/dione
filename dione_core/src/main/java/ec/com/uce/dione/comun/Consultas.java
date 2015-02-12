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
		// SYLLABUS
		@NamedQuery(name = "Syllabus.findByDocenteAndMateria", query = "SELECT d FROM Syllabus d WHERE d.materiaUce.idMateriaUce =:idMateria AND d.docente.idDocente=:idDocente"),
		// DETALLE_CATALOGO
		@NamedQuery(name = "DetalleCatalogo.findByCodCatalogo", query = "SELECT d FROM DetalleCatalogo d WHERE d.catalogo.idCatalogo =:idCatalogo ORDER BY d.descDetCatalogo"),
		@NamedQuery(name = "DetalleCatalogo.findByCodCatalogoAndCodDetalle", query = "SELECT d FROM DetalleCatalogo d WHERE d.catalogo.idCatalogo =:idCatalogo AND d.codDetalleCatalogo=:codDetalleCatalogo"),
		// ROL
		@NamedQuery(name = "Rol.findByUsuario", query = "SELECT r FROM Rol r WHERE r.usuario.idUsuario =:idUsuario"),
		// OBJETIVOS
		@NamedQuery(name = "Objetivo.findBysyllabus", query = "SELECT o FROM Objetivo o WHERE o.syllabus.idSyllabus =:idSyllabus"),
		// COMPETENCIAS
		@NamedQuery(name = "CompetenciaGenerale.findBySyllabus", query = "SELECT c FROM CompetenciaGenerale c WHERE c.syllabus.idSyllabus =:idSyllabus"),
		// RESULTADOS APRENDIZAJE
		@NamedQuery(name = "ResultadosAprendizaje.findBySyllabus", query = "SELECT r FROM ResultadosAprendizaje r WHERE r.syllabus.idSyllabus =:idSyllabus"),
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
