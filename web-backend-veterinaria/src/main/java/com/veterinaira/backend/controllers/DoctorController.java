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

import com.veterinaira.backend.models.entities.Doctor;
import com.veterinaira.backend.models.service.interfaces.IDoctorService;


@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	IDoctorService service;
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody Doctor d){
		try {
			service.save(d);
			return ResponseEntity.status(HttpStatus.CREATED).body(d);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	
	@GetMapping("/retrieve/{id}")
	public ResponseEntity<?> retrieve(@PathVariable Integer id){
		try {
			Optional<Doctor> d= service.findById(id);
			if(d.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Doctor no encontrado");
			}
			return ResponseEntity.ok(d);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
		
	}
	
	
	
	@GetMapping("/list")
	public ResponseEntity<?> list(){
		try {
			List<Doctor> doc= service.findAll();
			if(doc.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay doctor");
			}
			return ResponseEntity.ok(doc);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	@PutMapping("/update/(id)")
	public ResponseEntity<?> update(@PathVariable Integer id,@RequestBody Doctor d){
		try {
			d.setIdDoctor(id);
			service.save(d);
			return ResponseEntity.ok(d);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	@DeleteMapping("/delete/(id)")
	public ResponseEntity<?> update(@PathVariable Integer id){
		try {
			Optional<Doctor> m= service.findById(id);
			if(m.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Doctor no encontrado");
			}
			service.delete(id);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(m);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
}
