package com.training.batchallocationservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.batchallocationservice.model.Batch;
import com.training.batchallocationservice.repository.BatchRepository;
@Service
public class BatchServiceImpl implements BatchService {
	
	@Autowired
	BatchRepository batchRepo;

	@Override
	public Batch findById(int id) {
		return batchRepo.findById(id).get();
	}

	@Override
	public List<Batch> findAll() {
		return batchRepo.findAll();
	}

	@Override
	public Batch save(Batch batch) {
		return batchRepo.save(batch);
	}

	@Override
	public boolean deleteById(int id) {
		batchRepo.deleteById(id);
		return true;
	}

}
