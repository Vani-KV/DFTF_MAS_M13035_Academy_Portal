package com.training.AP_userwebservice.repository;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.training.AP_userwebservice.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	public User findByemail(String username);
	public List<User> findAllByRoleAndStatus(String role,String status);
	
	public List<User> findAllByRole(String role);
	
	//public User findByFirstname(String firstname);
	
	@Query(nativeQuery=true ,value="select * from User where firstname=:firstname")
	  public User findrecordbyname(String firstname);
	
}
