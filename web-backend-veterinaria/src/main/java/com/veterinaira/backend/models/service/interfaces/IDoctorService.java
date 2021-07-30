package com.veterinaira.backend.models.service.interfaces;

import java.util.List;

import com.veterinaira.backend.models.entities.Doctor;
public interface IDoctorService {

	public void save(Doctor doctor); //guardar -> create/update
	public Doctor findById(Integer id); // consultar -> retrieve
	public void delete(Integer id); //borrar -> delete
	public List<Doctor> findAll(); //consultar en conjunto ->list

}
