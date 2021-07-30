package com.veterinaira.backend.models.repositories;

import org.springframework.data.repository.CrudRepository;

import com.veterinaira.backend.models.entities.Receta;

public interface IReceta extends CrudRepository <Receta, Integer >{

}
