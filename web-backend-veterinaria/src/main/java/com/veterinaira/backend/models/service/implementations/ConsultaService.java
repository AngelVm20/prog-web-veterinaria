package com.veterinaira.backend.models.service.implementations;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.veterinaira.backend.models.entities.Consulta;
import com.veterinaira.backend.models.entities.Receta;
import com.veterinaira.backend.models.repositories.IConsulta;
import com.veterinaira.backend.models.repositories.IReceta;
import com.veterinaira.backend.models.service.interfaces.IConsultaService;

@Service
public class ConsultaService implements IConsultaService{

	@Autowired
	IConsulta repository;
	
	@Autowired
	IReceta repo;
	
	
	@Override
	@Transactional
	public void save(Consulta consulta) {
		repository.save(consulta);
		for(Receta r : consulta.getRecetas()) {
			r.setConsulta(consulta);
			repo.save(r);
		}
		
	}

	@Override
	@Transactional(readOnly=true)
	public Optional <Consulta> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		repository.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly=true)
	public List<Consulta> findAll() {
		return (List<Consulta>) repository.findAll();
	}

}
