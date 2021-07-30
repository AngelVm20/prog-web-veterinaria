package com.veterinaira.backend.models.repositories;

import org.springframework.data.repository.CrudRepository;

import com.veterinaira.backend.models.entities.Consulta;

public interface IConsulta extends CrudRepository <Consulta, Integer >{

}
