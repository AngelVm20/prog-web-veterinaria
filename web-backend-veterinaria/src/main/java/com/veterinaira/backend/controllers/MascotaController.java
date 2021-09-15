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

import com.veterinaira.backend.models.entities.mascota;
import com.veterinaira.backend.models.service.interfaces.IMascotaService;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/mascota")
public class MascotaController {

	@Autowired
	IMascotaService service;
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody mascota m){
		try {
			service.save(m);
			return ResponseEntity.status(HttpStatus.CREATED).body(m);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	
	@GetMapping("/retrieve/{id}")
	public ResponseEntity<?> retrieve(@PathVariable Integer id){
		try {
			Optional<mascota> m= service.findById(id);
			if(m.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mascota no encontrado");
			}
			return ResponseEntity.ok(m);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
		
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> list(){
		try {
			List<mascota> mas= service.findAll();
			if(mas.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay mascota");
			}
			return ResponseEntity.ok(mas);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	@PutMapping("/update/(id)")
	public ResponseEntity<?> update(@PathVariable Integer id,@RequestBody mascota m){
		try {
			m.setIdMascota(id);
			service.save(m);
			return ResponseEntity.ok(m);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	@DeleteMapping("/delete/(id)")
	public ResponseEntity<?> update(@PathVariable Integer id){
		try {
			Optional<mascota> m= service.findById(id);
			if(m.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mascota no encontrado");
			}
			service.delete(id);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(m);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	
	
	
	
	
}
