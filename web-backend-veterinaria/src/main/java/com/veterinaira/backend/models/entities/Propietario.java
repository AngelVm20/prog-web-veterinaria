package com.veterinaira.backend.models.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "propietario")
public class Propietario extends Persona implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_propietario")
	private Integer idPropietario;

	@Column(name = "celular")
	private String celular;

	@Column(name = "correo")
	private String correo;

	@OneToMany(mappedBy = "propietario", fetch = FetchType.LAZY)
	private List<mascota> mascotas;

	public Propietario() {
		super();
	}

	public Propietario(Integer idPropietario) {
		super();
		this.idPropietario = idPropietario;
	}

	public Integer getIdPropietario() {
		return idPropietario;
	}

	public void setIdPropietario(Integer idPropietario) {
		this.idPropietario = idPropietario;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public List<mascota> getMascotas() {
		return mascotas;
	}

	public void setMascotas(List<mascota> mascotas) {
		this.mascotas = mascotas;
	}

}
