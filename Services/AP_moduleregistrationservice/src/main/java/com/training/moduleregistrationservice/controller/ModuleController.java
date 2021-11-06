package com.training.moduleregistrationservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.moduleregistrationservice.service.ModuleService;
import com.training.moduleregistrationservice.model.Modules;



@RestController
public class ModuleController {
	
	@Autowired
	ModuleService ModulesService;
	
	@GetMapping("/modules")
	public ResponseEntity<List> Modules(){
		return new ResponseEntity<List>(ModulesService.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/module")
	public ResponseEntity<Modules> Module(@RequestParam int id){
		return new ResponseEntity<Modules>(ModulesService.findById(id),HttpStatus.OK);
	}
	
	@GetMapping("/facultymodules")
	public ResponseEntity<List> facultyModules(@RequestParam int facultyId){
		System.out.print(ModulesService.findAllByFacultyId(facultyId));
		return new ResponseEntity<List>(ModulesService.findAllByFacultyId(facultyId),HttpStatus.OK);
	}
	
	@PostMapping("/module")
	public ResponseEntity<Modules> createModule(@RequestBody Modules mod){
		return new ResponseEntity<Modules>(ModulesService.save(mod),HttpStatus.CREATED);
	}
	
	@PutMapping("/module")
	public ResponseEntity<Modules> updateModule(@RequestBody Modules mod){
		return new ResponseEntity<Modules>(ModulesService.save(mod),HttpStatus.OK);
	}

	@DeleteMapping("/module")
	public ResponseEntity<Boolean> deleteModule(@RequestParam int id){
		
		return new ResponseEntity<Boolean>(ModulesService.deleteById(id),HttpStatus.OK);
	}
	
}


