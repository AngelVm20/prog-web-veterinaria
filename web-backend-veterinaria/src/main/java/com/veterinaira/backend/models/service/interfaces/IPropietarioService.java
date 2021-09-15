package com.veterinaira.backend.models.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.veterinaira.backend.models.entities.Propietario;

public interface IPropietarioService {

	void save(Propietario propietario); //guardar -> create/update
	Optional <Propietario> findById(Integer id); // consultar -> retrieve
	void delete(Integer id); //borrar -> delete
	List<Propietario> findAll();
}
