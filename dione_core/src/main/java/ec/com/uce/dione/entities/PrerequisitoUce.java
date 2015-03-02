package ec.com.uce.dione.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the prerequisito_uce database table.
 * 
 */
@Entity
@Table(name="prerequisito_uce")
@NamedQuery(name="PrerequisitoUce.findAll", query="SELECT p FROM PrerequisitoUce p")
public class PrerequisitoUce implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_prerequisito_uce")
	private Integer idPrerequisitoUce;

	@Column(name="prerequisito_uce")
	private String prerequisitoUce;

	//bi-directional many-to-one association to MateriaUce
	@ManyToOne
	@JoinColumn(name="id_materia_uce")
	private MateriaUce materiaUce;

	public PrerequisitoUce() {
	}

	public Integer getIdPrerequisitoUce() {
		return this.idPrerequisitoUce;
	}

	public void setIdPrerequisitoUce(Integer idPrerequisitoUce) {
		this.idPrerequisitoUce = idPrerequisitoUce;
	}

	public String getPrerequisitoUce() {
		return this.prerequisitoUce;
	}

	public void setPrerequisitoUce(String prerequisitoUce) {
		this.prerequisitoUce = prerequisitoUce;
	}

	public MateriaUce getMateriaUce() {
		return this.materiaUce;
	}

	public void setMateriaUce(MateriaUce materiaUce) {
		this.materiaUce = materiaUce;
	}

}