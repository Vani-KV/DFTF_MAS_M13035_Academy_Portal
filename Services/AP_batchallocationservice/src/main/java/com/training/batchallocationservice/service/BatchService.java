package com.training.batchallocationservice.service;

import java.util.List;

import com.training.batchallocationservice.model.Batch;


public interface BatchService {
	
	public Batch findById(int id);
	public List<Batch> findAll();
	public Batch save(Batch batch);
	public boolean deleteById(int id);


}
