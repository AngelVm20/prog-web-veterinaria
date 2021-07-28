package com.veterinaira.backend.models.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="recetas")
public class Receta {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="id_receta")
	private Integer idReceta;
	
	@Column(name="medicamento")
	private String medicamento;
	
	@Column(name="dosis")
	private String dosis;

	
	@JoinColumn(name="id_consulta",referencedColumnName="id_consulta") //se mapea una clave foranea
	@ManyToOne
	private Consulta consulta;
	
	
	
	
	public Receta(Integer idReceta) {
		super();
		this.idReceta = idReceta;
	}

	public Receta() {
		super();
	}

	public Integer getIdReceta() {
		return idReceta;
	}

	public void setIdReceta(Integer idReceta) {
		this.idReceta = idReceta;
	}

	public String getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(String medicamento) {
		this.medicamento = medicamento;
	}

	public String getDosis() {
		return dosis;
	}

	public void setDosis(String dosis) {
		this.dosis = dosis;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}
	
	
	
}
