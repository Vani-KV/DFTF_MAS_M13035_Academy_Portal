package com.training.moduleregistrationservice.service;

import java.util.List;

import com.training.moduleregistrationservice.model.Modules;




public interface ModuleService {
	
	public Modules findById(int id);
	public List<Modules> findAll();
	public Modules save(Modules mod);
	public boolean deleteById(int id);
	public List<Modules> findAllByFacultyId(int facultyId);


}
