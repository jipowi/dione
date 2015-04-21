package ec.com.uce.dione.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the archivo_base database table.
 * 
 */
@Entity
@Table(name="archivo_base")
@NamedQuery(name="ArchivoBase.findAll", query="SELECT a FROM ArchivoBase a")
public class ArchivoBase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_archivo")
	private Integer idArchivo;

	@Column(name="descripcion_documento")
	private String descripcionDocumento;

	@Column(name="documento_byte")
	private byte[] documentoByte;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_carga")
	private Date fechaCarga;

	@Column(name="mime_type")
	private String mimeType;

	@Column(name="nombre_archivo")
	private String nombreArchivo;

	@Column(name="tipo_archivo")
	private String tipoArchivo;

	@Column(name="tipo_documento")
	private String tipoDocumento;

	//bi-directional many-to-one association to DocumentoDocente
	@OneToMany(mappedBy="archivoBase")
	private List<DocumentoDocente> documentoDocentes;

	

	/**
	 * 
	 */
	public ArchivoBase() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getIdArchivo() {
		return this.idArchivo;
	}

	public void setIdArchivo(Integer idArchivo) {
		this.idArchivo = idArchivo;
	}

	public String getDescripcionDocumento() {
		return this.descripcionDocumento;
	}

	public void setDescripcionDocumento(String descripcionDocumento) {
		this.descripcionDocumento = descripcionDocumento;
	}

	public byte[] getDocumentoByte() {
		return this.documentoByte;
	}

	public void setDocumentoByte(byte[] documentoByte) {
		this.documentoByte = documentoByte;
	}

	public Date getFechaCarga() {
		return this.fechaCarga;
	}

	public void setFechaCarga(Date fechaCarga) {
		this.fechaCarga = fechaCarga;
	}

	public String getMimeType() {
		return this.mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public String getNombreArchivo() {
		return this.nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public String getTipoArchivo() {
		return this.tipoArchivo;
	}

	public void setTipoArchivo(String tipoArchivo) {
		this.tipoArchivo = tipoArchivo;
	}

	public String getTipoDocumento() {
		return this.tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public List<DocumentoDocente> getDocumentoDocentes() {
		return this.documentoDocentes;
	}

	public void setDocumentoDocentes(List<DocumentoDocente> documentoDocentes) {
		this.documentoDocentes = documentoDocentes;
	}

	public DocumentoDocente addDocumentoDocente(DocumentoDocente documentoDocente) {
		getDocumentoDocentes().add(documentoDocente);
		documentoDocente.setArchivoBase(this);

		return documentoDocente;
	}

	public DocumentoDocente removeDocumentoDocente(DocumentoDocente documentoDocente) {
		getDocumentoDocentes().remove(documentoDocente);
		documentoDocente.setArchivoBase(null);

		return documentoDocente;
	}

}