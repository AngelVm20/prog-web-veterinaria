package com.veterinaira.backend.models.service.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaira.backend.models.entities.mascota;
import com.veterinaira.backend.models.repositories.IMascota;
import com.veterinaira.backend.models.service.interfaces.IMascotaService;

@Service
public class MascotaService implements IMascotaService{

	//el servicio sirve para implementar los metodos de gestion inyectando el DAO
	
	@Autowired
	IMascota repository; //<- DAO -DATA ACCESS OBJECT
	
	
	@Override
	public void save(mascota mascotas) {
		repository.save(mascotas);
		
	}

	@Override
	public mascota findById(Integer id) {
		return repository.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);
		
	}

	@Override
	public List<mascota> findAll() {
		return (List<mascota>) repository.findAll();
	}
	

}
