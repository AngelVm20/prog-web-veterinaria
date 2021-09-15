package com.veterinaira.backend.models.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.veterinaira.backend.models.entities.Receta;

public interface IRecetaService {

	void save(Receta receta); //guardar -> create/update
	Optional <Receta> findById(Integer id); // consultar -> retrieve
	void delete(Integer id); //borrar -> delete
	List<Receta> findAll(); //consultar en conjunto ->list
}
