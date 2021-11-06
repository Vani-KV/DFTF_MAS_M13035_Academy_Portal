package com.training.moduleregistrationservice.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.training.moduleregistrationservice.model.Modules;



@Repository
public interface ModuleRepository extends JpaRepository<Modules,Integer> {
	
	  @Query(nativeQuery=true ,value="select * from Modules where faculty_id=:facultyId")
	  public List<Modules> findAllByfacultyId(@Param("facultyId") int facultyId);
	
}
