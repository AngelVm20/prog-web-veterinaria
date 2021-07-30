package com.veterinaira.backend.models.repositories;

import org.springframework.data.repository.CrudRepository;

import com.veterinaira.backend.models.entities.mascota;

public interface IMascota extends CrudRepository <mascota, Integer >{
	//tambien es conocido como el Data Access Object -DAO-
	
}
