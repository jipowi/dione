package ec.com.uce.dione.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the cumplimiento database table.
 * 
 */
@Entity
@NamedQuery(name="Cumplimiento.findAll", query="SELECT c FROM Cumplimiento c")
public class Cumplimiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cumplimiento")
	private Integer idCumplimiento;

	private BigDecimal efectividad;

	@Column(name="porcentaje_competencias")
	private BigDecimal porcentajeCompetencias;

	@Column(name="porcentaje_objetivos")
	private BigDecimal porcentajeObjetivos;

	@Column(name="porcentaje_resultados")
	private BigDecimal porcentajeResultados;

	//bi-directional many-to-one association to MateriaSyllabus
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_materia_syllabus")
	private MateriaSyllabus materiaSyllabus;

	public Cumplimiento() {
	}

	public Integer getIdCumplimiento() {
		return this.idCumplimiento;
	}

	public void setIdCumplimiento(Integer idCumplimiento) {
		this.idCumplimiento = idCumplimiento;
	}

	public BigDecimal getEfectividad() {
		return this.efectividad;
	}

	public void setEfectividad(BigDecimal efectividad) {
		this.efectividad = efectividad;
	}

	public BigDecimal getPorcentajeCompetencias() {
		return this.porcentajeCompetencias;
	}

	public void setPorcentajeCompetencias(BigDecimal porcentajeCompetencias) {
		this.porcentajeCompetencias = porcentajeCompetencias;
	}

	public BigDecimal getPorcentajeObjetivos() {
		return this.porcentajeObjetivos;
	}

	public void setPorcentajeObjetivos(BigDecimal porcentajeObjetivos) {
		this.porcentajeObjetivos = porcentajeObjetivos;
	}

	public BigDecimal getPorcentajeResultados() {
		return this.porcentajeResultados;
	}

	public void setPorcentajeResultados(BigDecimal porcentajeResultados) {
		this.porcentajeResultados = porcentajeResultados;
	}

	public MateriaSyllabus getMateriaSyllabus() {
		return this.materiaSyllabus;
	}

	public void setMateriaSyllabus(MateriaSyllabus materiaSyllabus) {
		this.materiaSyllabus = materiaSyllabus;
	}

}