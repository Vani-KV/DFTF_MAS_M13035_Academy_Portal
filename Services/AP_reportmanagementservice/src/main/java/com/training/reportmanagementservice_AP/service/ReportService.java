package com.training.reportmanagementservice_AP.service;

import java.util.List;

import com.training.reportmanagementservice_AP.model.Report;

public interface ReportService {
	
	public Report findById(int id);
	public List<Report> findAll();
	public Report save(Report report);
	public boolean deleteById(int id);
	public List<Report> findByBatchId(int batchId);


}
