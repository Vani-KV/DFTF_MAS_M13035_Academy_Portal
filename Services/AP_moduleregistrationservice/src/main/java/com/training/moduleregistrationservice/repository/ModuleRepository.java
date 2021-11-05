package com.training.moduleregistrationservice.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.moduleregistrationservice.model.Modules;



@Repository
public interface ModuleRepository extends JpaRepository<Modules,Integer> {
	
	public List<Modules> findAllByFacultyId(int facultyId);
}
