package ec.com.uce.dione.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the documento_docente database table.
 * 
 */
@Entity
@Table(name="documento_docente")
@NamedQuery(name="DocumentoDocente.findAll", query="SELECT d FROM DocumentoDocente d")
public class DocumentoDocente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_doc_docente")
	private Integer idDocDocente;

	//bi-directional many-to-one association to ArchivoBase
	@ManyToOne
	@JoinColumn(name="id_archivo")
	private ArchivoBase archivoBase;

	//bi-directional many-to-one association to Docente
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_docente")
	private Docente docente;

	public DocumentoDocente() {
	}

	public Integer getIdDocDocente() {
		return this.idDocDocente;
	}

	public void setIdDocDocente(Integer idDocDocente) {
		this.idDocDocente = idDocDocente;
	}

	public ArchivoBase getArchivoBase() {
		return this.archivoBase;
	}

	public void setArchivoBase(ArchivoBase archivoBase) {
		this.archivoBase = archivoBase;
	}

	public Docente getDocente() {
		return this.docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

}