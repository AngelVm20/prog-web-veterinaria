package com.veterinaira.backend.models.service.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaira.backend.models.entities.Consulta;
import com.veterinaira.backend.models.repositories.IConsulta;
import com.veterinaira.backend.models.service.interfaces.IConsultaService;

@Service
public class ConsultaService implements IConsultaService{

	@Autowired
	IConsulta repository;
	
	
	@Override
	public void save(Consulta consulta) {
		repository.save(consulta);
		
	}

	@Override
	public Consulta findById(Integer id) {
		return repository.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);
		
	}

	@Override
	public List<Consulta> findAll() {
		return (List<Consulta>) repository.findAll();
	}

}
