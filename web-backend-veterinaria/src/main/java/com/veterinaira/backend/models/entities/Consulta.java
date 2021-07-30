package com.veterinaira.backend.models.entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "consulta")
public class Consulta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_consulta")
	private Integer idConsulta;

	@Column(name = "sintoma")
	private String sintoma;

	@Column(name = "diagnostico")
	private String diagnostico;

	@Column(name = "monto")
	private float monto;

	@Column(name = "fecha_hora")
	private Calendar fechaHora;

	// mappedBy va el nombre del atributo de esta clase[Consulta] en la clase
	// asociada[Receta]
	@OneToMany(mappedBy = "consulta", fetch = FetchType.LAZY)
	private List<Receta> recetas;

	@JoinColumn(name = "id_mascota", nullable = false)
	@OneToOne(fetch = FetchType.LAZY)
	private mascota mascotas;

	@JoinColumn(name = "id_doctor", nullable = false)
	@OneToOne(fetch = FetchType.LAZY)
	private Doctor doctor;

	public Consulta() {
		super();
	}

	public Consulta(Integer idConsulta) {
		super();
		this.idConsulta = idConsulta;
	}

	public Integer getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(Integer idConsulta) {
		this.idConsulta = idConsulta;
	}

	public String getSintoma() {
		return sintoma;
	}

	public void setSintoma(String sintoma) {
		this.sintoma = sintoma;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

	public Calendar getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Calendar fechaHora) {
		this.fechaHora = fechaHora;
	}

	public mascota getMascotas() {
		return mascotas;
	}

	public void setMascotas(mascota mascotas) {
		this.mascotas = mascotas;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

}
