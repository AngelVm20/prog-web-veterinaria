package com.veterinaira.backend.models.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.veterinaira.backend.models.entities.mascota;

public interface IMascotaService {
	
	// la interface del servicio sirve para definir el conjunto de metodos que
	//se van a implementar para la gestion del modelo entidad
	
	void save(mascota mascotas); //guardar -> create/update
	Optional <mascota> findById(Integer id); // consultar -> retrieve
	void delete(Integer id); //borrar -> delete
	List<mascota> findAll(); //consultar en conjunto ->list
}
