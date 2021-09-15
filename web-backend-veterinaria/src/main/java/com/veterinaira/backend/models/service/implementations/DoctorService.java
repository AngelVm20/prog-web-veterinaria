package com.veterinaira.backend.models.service.implementations;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional(readOnly=true)
	public Optional <Doctor> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		repository.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly=true)
	public List<Doctor> findAll() {
		return (List<Doctor>) repository.findAll();
	}

}
