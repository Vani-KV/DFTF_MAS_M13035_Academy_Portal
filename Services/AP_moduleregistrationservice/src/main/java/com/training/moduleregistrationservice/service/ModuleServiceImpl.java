package com.training.moduleregistrationservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.moduleregistrationservice.model.Modules;
import com.training.moduleregistrationservice.repository.ModuleRepository;

@Service
public class ModuleServiceImpl implements ModuleService {
	
	@Autowired
	ModuleRepository moduleRepo;

	@Override
	public Modules findById(int id) {
		return moduleRepo.findById(id).orElse(null);
	}

	@Override
	public List<Modules> findAll() {
		return moduleRepo.findAll();
	}

	@Override
	public Modules save(Modules mod) {
		return moduleRepo.save(mod);
	}

	@Override
	public boolean deleteById(int id) {
		moduleRepo.deleteById(id);
		return true;
	}
	
	@Override
	public List<Modules> findAllByFacultyId(int facultyId) {
		System.out.println(facultyId);
		System.out.print(moduleRepo.findAllByfacultyId(facultyId));
		return moduleRepo.findAllByfacultyId(facultyId);
	}

	
	
}

