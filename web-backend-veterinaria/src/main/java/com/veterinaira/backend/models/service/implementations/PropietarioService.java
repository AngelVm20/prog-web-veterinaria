package com.veterinaira.backend.models.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.veterinaira.backend.models.entities.Propietario;
import com.veterinaira.backend.models.entities.mascota;
import com.veterinaira.backend.models.repositories.IMascota;
import com.veterinaira.backend.models.repositories.IPropietario;
import com.veterinaira.backend.models.service.interfaces.IPropietarioService;

@Service
public class PropietarioService implements IPropietarioService{

	
	@Autowired
	IPropietario repository;
	
	@Autowired
	IMascota masc;
	
	@Override
	@Transactional
	public void save(Propietario propietario) {
		repository.save(propietario);
		for(mascota m : propietario.getMascotas()) {
			m.setPropietario(propietario);
			masc.save(m);
		}
	}

	@Override
	@Transactional(readOnly=true)
	public Optional <Propietario> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		repository.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly=true)
	public List<Propietario> findAll() {
		return (List<Propietario>) repository.findAll();
	}

}
