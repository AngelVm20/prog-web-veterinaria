package com.veterinaira.backend.models.repositories;

import org.springframework.data.repository.CrudRepository;

import com.veterinaira.backend.models.entities.Doctor;

public interface IDoctor extends CrudRepository <Doctor, Integer >{

}
