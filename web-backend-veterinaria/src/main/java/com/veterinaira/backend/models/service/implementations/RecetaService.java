package com.veterinaira.backend.models.service.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaira.backend.models.entities.Receta;
import com.veterinaira.backend.models.repositories.IReceta;
import com.veterinaira.backend.models.service.interfaces.IRecetaService;

@Service
public class RecetaService implements IRecetaService{

	
	@Autowired
	IReceta repository;
	
	@Override
	public void save(Receta receta) {
		repository.save(receta);
		
	}

	@Override
	public Receta findById(Integer id) {
		return repository.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);
		
	}

	@Override
	public List<Receta> findAll() {
		return (List<Receta>) repository.findAll();
	}

}
