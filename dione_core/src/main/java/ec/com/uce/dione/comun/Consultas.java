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
		//MATERIAS
		@NamedQuery(name = "Materia.findByEscuela", query = "SELECT m FROM Materia m WHERE m.escuela.idEscuela =:idEscuela"),
		@NamedQuery(name = "MateriaUce.findByDocente", query = "SELECT m FROM MateriaUce m WHERE m.docente.idDocente =:idDocente"),
		//DOCENTE
		@NamedQuery(name = "Docente.findByCedula", query = "SELECT d FROM Docente d WHERE d.cedulaDocente =:cedula"),
		// DETALLE_CATALOGO
		@NamedQuery(name = "DetalleCatalogo.findByCodCatalogo", query = "SELECT d FROM DetalleCatalogo d WHERE d.catalogo.idCatalogo =:idCatalogo ORDER BY d.descDetCatalogo"),
		@NamedQuery(name = "DetalleCatalogo.findByCodCatalogoAndCodDetalle", query = "SELECT d FROM DetalleCatalogo d WHERE d.catalogo.idCatalogo =:idCatalogo AND d.codDetalleCatalogo=:codDetalleCatalogo") })
		
		
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
