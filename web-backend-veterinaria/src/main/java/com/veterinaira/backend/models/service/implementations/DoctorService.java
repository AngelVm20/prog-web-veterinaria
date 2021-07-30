package com.veterinaira.backend.models.service.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaira.backend.models.entities.Doctor;
import com.veterinaira.backend.models.repositories.IDoctor;
import com.veterinaira.backend.models.service.interfaces.IDoctorService;

@Service
public class DoctorService implements IDoctorService{

	
	@Autowired
	IDoctor repository;
	
	@Override
	public void save(Doctor doctor) {
		repository.save(doctor);
		
	}

	@Override
	public Doctor findById(Integer id) {
		return repository.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);
		
	}

	@Override
	public List<Doctor> findAll() {
		return (List<Doctor>) repository.findAll();
	}

}
