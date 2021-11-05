package com.training.reportmanagementservice_AP.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.reportmanagementservice_AP.model.Report;
import com.training.reportmanagementservice_AP.repository.ReportRepository;

@Service
public class ReportServiceImpl implements ReportService {
	
	@Autowired
	ReportRepository reportRepo;

	@Override
	public Report findById(int id) {
		return reportRepo.findById(id).get();
	}

	@Override
	public List<Report> findAll() {
		return reportRepo.findAll();
	}

	@Override
	public Report save(Report report) {
		return reportRepo.save(report);
	}

	@Override
	public boolean deleteById(int id) {
		reportRepo.deleteById(id);
		return true;
	}

	@Override
	public List<Report> findByBatchId(int batchId) {
		return reportRepo.findByBatchId(batchId);
	}

}
