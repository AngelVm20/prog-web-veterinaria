package com.veterinaira.backend.models.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.veterinaira.backend.models.entities.Doctor;
public interface IDoctorService {

	void save(Doctor doctor); //guardar -> create/update
	Optional <Doctor> findById(Integer id); // consultar -> retrieve
	void delete(Integer id); //borrar -> delete
	List<Doctor> findAll(); //consultar en conjunto ->list

}
