package com.veterinaira.backend.models.service.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaira.backend.models.entities.Propietario;
import com.veterinaira.backend.models.repositories.IPropietario;
import com.veterinaira.backend.models.service.interfaces.IPropietarioService;

@Service
public class PropietarioService implements IPropietarioService{

	
	@Autowired
	IPropietario repository;
	
	@Override
	public void save(Propietario propietario) {
		repository.save(propietario);
		
	}

	@Override
	public Propietario findById(Integer id) {
		return repository.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);
		
	}

	@Override
	public List<Propietario> findAll() {
		return (List<Propietario>) repository.findAll();
	}

}
