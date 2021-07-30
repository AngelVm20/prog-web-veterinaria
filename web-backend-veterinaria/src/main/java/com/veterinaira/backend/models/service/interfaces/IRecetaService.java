package com.veterinaira.backend.models.service.interfaces;

import java.util.List;

import com.veterinaira.backend.models.entities.Receta;

public interface IRecetaService {

	public void save(Receta receta); //guardar -> create/update
	public Receta findById(Integer id); // consultar -> retrieve
	public void delete(Integer id); //borrar -> delete
	public List<Receta> findAll(); //consultar en conjunto ->list
}
