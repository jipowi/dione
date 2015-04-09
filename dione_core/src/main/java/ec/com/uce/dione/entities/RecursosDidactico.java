package ec.com.uce.dione.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the recursos_didacticos database table.
 * 
 */
@Entity
@Table(name="recursos_didacticos")
@NamedQuery(name="RecursosDidactico.findAll", query="SELECT r FROM RecursosDidactico r")
public class RecursosDidactico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_recurso")
	private Integer idRecurso;

	private String recurso;

	//bi-directional many-to-one association to Syllabus
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_syllabus")
	private Syllabus syllabus;

	public RecursosDidactico() {
	}

	public Integer getIdRecurso() {
		return this.idRecurso;
	}

	public void setIdRecurso(Integer idRecurso) {
		this.idRecurso = idRecurso;
	}

	public String getRecurso() {
		return this.recurso;
	}

	public void setRecurso(String recurso) {
		this.recurso = recurso;
	}

	public Syllabus getSyllabus() {
		return this.syllabus;
	}

	public void setSyllabus(Syllabus syllabus) {
		this.syllabus = syllabus;
	}

}