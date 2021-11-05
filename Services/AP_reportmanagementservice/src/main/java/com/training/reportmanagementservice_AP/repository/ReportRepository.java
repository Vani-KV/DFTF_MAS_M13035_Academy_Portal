package com.training.reportmanagementservice_AP.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.reportmanagementservice_AP.model.Report;


@Repository
public interface ReportRepository extends JpaRepository<Report, Integer> {
	
	public List<Report> findByBatchId(int batchId);

}
