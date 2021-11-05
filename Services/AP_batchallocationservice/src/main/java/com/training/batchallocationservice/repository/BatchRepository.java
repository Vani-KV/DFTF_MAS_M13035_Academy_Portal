package com.training.batchallocationservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.training.batchallocationservice.model.Batch;

@Repository
public interface BatchRepository extends JpaRepository<Batch, Integer> {
	

}
