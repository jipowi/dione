package ec.com.uce.dione.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the corequisito_uce database table.
 * 
 */
@Entity
@Table(name="corequisito_uce")
@NamedQuery(name="CorequisitoUce.findAll", query="SELECT c FROM CorequisitoUce c")
public class CorequisitoUce implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_corequisito_uce")
	private Integer idCorequisitoUce;

	@Column(name="corequisito_uce")
	private String corequisitoUce;

	//bi-directional many-to-one association to MateriaUce
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_materia_uce")
	private MateriaUce materiaUce;

	public CorequisitoUce() {
	}

	public Integer getIdCorequisitoUce() {
		return this.idCorequisitoUce;
	}

	public void setIdCorequisitoUce(Integer idCorequisitoUce) {
		this.idCorequisitoUce = idCorequisitoUce;
	}

	public String getCorequisitoUce() {
		return this.corequisitoUce;
	}

	public void setCorequisitoUce(String corequisitoUce) {
		this.corequisitoUce = corequisitoUce;
	}

	public MateriaUce getMateriaUce() {
		return this.materiaUce;
	}

	public void setMateriaUce(MateriaUce materiaUce) {
		this.materiaUce = materiaUce;
	}

}