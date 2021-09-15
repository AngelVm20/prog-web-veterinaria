package com.veterinaira.backend.models.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.veterinaira.backend.models.entities.Consulta;
public interface IConsultaService {

	void save(Consulta consulta); //guardar -> create/update
	Optional <Consulta> findById(Integer id); // consultar -> retrieve
	void delete(Integer id); //borrar -> delete
	List<Consulta> findAll(); //consultar en conjunto ->list
}
