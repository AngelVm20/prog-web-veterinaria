package com.veterinaira.backend.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.veterinaira.backend.models.entities.Receta;
import com.veterinaira.backend.models.service.interfaces.IRecetaService;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/receta")
public class RecetaController {

	@Autowired
	IRecetaService service;
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody Receta r){
		try {
			service.save(r);
			return ResponseEntity.status(HttpStatus.CREATED).body(r);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	
	@GetMapping("/retrieve/{id}")
	public ResponseEntity<?> retrieve(@PathVariable Integer id){
		try {
			Optional<Receta> r= service.findById(id);
			if(r.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Receta no encontrada");
			}
			return ResponseEntity.ok(r);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
		
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> list(){
		try {
			List<Receta> res= service.findAll();
			if(res.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay recetas");
			}
			return ResponseEntity.ok(res);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	@PutMapping("/update/(id)")
	public ResponseEntity<?> update(@PathVariable Integer id,@RequestBody Receta r){
		try {
			r.setIdReceta(id);
			service.save(r);
			return ResponseEntity.ok(r);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	@DeleteMapping("/delete/(id)")
	public ResponseEntity<?> update(@PathVariable Integer id){
		try {
			Optional<Receta> r= service.findById(id);
			if(r.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Receta no encontrada");
			}
			service.delete(id);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(r);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
}
