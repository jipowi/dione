package ec.com.uce.dione.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the corequisito database table.
 * 
 */
@Entity
@NamedQuery(name="Corequisito.findAll", query="SELECT c FROM Corequisito c")
public class Corequisito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_corequisito")
	private Integer idCorequisito;

	private String corequisito;

	//bi-directional many-to-one association to Materia
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_materia")
	private Materia materia;

	public Corequisito() {
	}

	public Integer getIdCorequisito() {
		return this.idCorequisito;
	}

	public void setIdCorequisito(Integer idCorequisito) {
		this.idCorequisito = idCorequisito;
	}

	public String getCorequisito() {
		return this.corequisito;
	}

	public void setCorequisito(String corequisito) {
		this.corequisito = corequisito;
	}

	public Materia getMateria() {
		return this.materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

}