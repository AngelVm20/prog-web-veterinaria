package com.veterinaira.backend.models.service.interfaces;

import java.util.List;

import com.veterinaira.backend.models.entities.mascota;

public interface IMascotaService {
	
	// la interface del servicio sirve para definir el conjunto de metodos que
	//se van a implementar para la gestion del modelo entidad
	
	public void save(mascota mascotas); //guardar -> create/update
	public mascota findById(Integer id); // consultar -> retrieve
	public void delete(Integer id); //borrar -> delete
	public List<mascota> findAll(); //consultar en conjunto ->list
}
