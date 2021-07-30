package com.veterinaira.backend.models.service.interfaces;

import java.util.List;

import com.veterinaira.backend.models.entities.Consulta;
public interface IConsultaService {

	public void save(Consulta consulta); //guardar -> create/update
	public Consulta findById(Integer id); // consultar -> retrieve
	public void delete(Integer id); //borrar -> delete
	public List<Consulta> findAll(); //consultar en conjunto ->list
}
