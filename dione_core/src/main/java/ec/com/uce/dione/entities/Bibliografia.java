package ec.com.uce.dione.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the bibliografia database table.
 * 
 */
@Entity
@NamedQuery(name="Bibliografia.findAll", query="SELECT b FROM Bibliografia b")
public class Bibliografia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_bibliografia")
	private Integer idBibliografia;

	private String bibliografia;

	//bi-directional many-to-one association to Syllabus
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_syllabus")
	private Syllabus syllabus;

	public Bibliografia() {
	}

	public Integer getIdBibliografia() {
		return this.idBibliografia;
	}

	public void setIdBibliografia(Integer idBibliografia) {
		this.idBibliografia = idBibliografia;
	}

	public String getBibliografia() {
		return this.bibliografia;
	}

	public void setBibliografia(String bibliografia) {
		this.bibliografia = bibliografia;
	}

	public Syllabus getSyllabus() {
		return this.syllabus;
	}

	public void setSyllabus(Syllabus syllabus) {
		this.syllabus = syllabus;
	}

}