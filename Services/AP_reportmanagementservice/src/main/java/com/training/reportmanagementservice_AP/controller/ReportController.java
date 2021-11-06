package com.training.reportmanagementservice_AP.controller;

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

import com.training.reportmanagementservice_AP.model.Report;
import com.training.reportmanagementservice_AP.service.ReportService;


@RestController
public class ReportController {
	
	@Autowired
	ReportService reportService;
	
	@GetMapping("/reports")
	public ResponseEntity<List> reports(){
		return new ResponseEntity<List>(reportService.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/report")
	public ResponseEntity<Report> report(@RequestParam int id){
		return new ResponseEntity<Report>(reportService.findById(id),HttpStatus.OK);
	}
	
	@PostMapping("/report")
	public ResponseEntity<Report> createReport(@RequestBody Report report){
		return new ResponseEntity<Report>(reportService.save(report),HttpStatus.CREATED);
	}
	
	@PutMapping("/report")
	public ResponseEntity<Report> updateReport(@RequestBody Report report){
		return new ResponseEntity<Report>(reportService.save(report),HttpStatus.OK);
	}

	@DeleteMapping("/report")
	public ResponseEntity<Boolean> deleteReport(@RequestParam int id){
		
		return new ResponseEntity<Boolean>(reportService.deleteById(id),HttpStatus.OK);
	}
	
	@GetMapping("/reportByBatch")
	public ResponseEntity<List> findByBatchId(@RequestParam int batchId) {
		return new ResponseEntity<List>(reportService.findByBatchId(batchId),HttpStatus.OK);
	}
	

}
