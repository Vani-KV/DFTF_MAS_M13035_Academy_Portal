package com.training.AP_userwebservice.service;

import java.util.List;

import com.training.AP_userwebservice.model.User;


public interface UserService {
	public User findById(int id);

	public List<User> findAll();

	public User save(User user);

	public boolean deleteById(int id);

	public User findByemail(String username);

	public List<User> findfaculty(String role, String status);

	public List<User> findByrole(String role);

	public User findByfirstname(String firstname);
}
