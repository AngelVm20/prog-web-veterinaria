package com.veterinaira.backend.models.service.interfaces;

import java.util.List;

import com.veterinaira.backend.models.entities.Propietario;

public interface IPropietarioService {

	public void save(Propietario propietario); //guardar -> create/update
	public Propietario findById(Integer id); // consultar -> retrieve
	public void delete(Integer id); //borrar -> delete
	public List<Propietario> findAll();
}
