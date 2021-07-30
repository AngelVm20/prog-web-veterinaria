package com.veterinaira.backend.models.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Persona implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "cedula")
	private String cedula;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

}
