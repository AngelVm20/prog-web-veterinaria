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

import com.veterinaira.backend.models.entities.Propietario;
import com.veterinaira.backend.models.service.interfaces.IPropietarioService;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/propietario")
public class PropietarioController {

	@Autowired
	IPropietarioService service;
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody Propietario p){
		try {
			service.save(p);
			return ResponseEntity.status(HttpStatus.CREATED).body(p);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	
	@GetMapping("/retrieve/{id}")
	public ResponseEntity<?> retrieve(@PathVariable Integer id){
		try {
			Optional<Propietario> p= service.findById(id);
			if(p.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Propietario no encontrado");
			}
			return ResponseEntity.ok(p);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
		
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> list(){
		try {
			List <Propietario> con= service.findAll();
			if(con.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay propietario");
			}
			return ResponseEntity.ok(con);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	@PutMapping("/update/(id)")
	public ResponseEntity<?> update(@PathVariable Integer id,@RequestBody Propietario c){
		try {
			c.setIdPropietario(id);
			service.save(c);
			return ResponseEntity.ok(c);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	@DeleteMapping("/delete/(id)")
	public ResponseEntity<?> update(@PathVariable Integer id){
		try {
			Optional<Propietario> c= service.findById(id);
			if(c.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Propietario no encontrado");
			}
			service.delete(id);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(c);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
}
