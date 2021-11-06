package com.training.batchallocationservice.controller;

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

import com.training.batchallocationservice.model.Batch;
import com.training.batchallocationservice.service.BatchService;

@RestController
public class BatchController {
	
	@Autowired
	BatchService bService;
	
	@GetMapping("/batches")
	public ResponseEntity<List> batches(){
		return new ResponseEntity<List>(bService.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/batch")
	public ResponseEntity<Batch> batch(@RequestParam int id){
		return new ResponseEntity<Batch>(bService.findById(id),HttpStatus.OK);
	}
	
	@PostMapping("/batch")
	public ResponseEntity<Batch> createBatch(@RequestBody Batch batch){
		return new ResponseEntity<Batch>(bService.save(batch),HttpStatus.CREATED);
	}
	
	@PutMapping("/batch")
	public ResponseEntity<Batch> updateBatch(@RequestBody Batch batch){
		return new ResponseEntity<Batch>(bService.save(batch),HttpStatus.OK);
	}

	@DeleteMapping("/batch")
	public ResponseEntity<Boolean> deleteBatch(@RequestParam int id){
		return new ResponseEntity<Boolean>(bService.deleteById(id),HttpStatus.OK);
	}
	
	

}

