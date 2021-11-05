package com.training.AP_userwebservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.AP_userwebservice.model.User;
import com.training.AP_userwebservice.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userrepo;

	@Override
	public User findById(int id) {
		return userrepo.getById(id) ;
	}

	@Override
	public List<User> findAll() {
		return userrepo.findAll();
	}

	@Override
	public User save(User user) {
		return userrepo.save(user);
	}

	@Override
	public boolean deleteById(int id) {
		userrepo.deleteById(id);
		return true;
	}

	@Override
	public User findByemail(String username) {
		return userrepo.findByemail(username);
	}

	@Override
	public List<User> findfaculty(String role, String status) {
		//System.out.print(role);
		//System.out.print(status);

		System.out.println(userrepo.findAllByRoleAndStatus(role,status));
		return userrepo.findAllByRoleAndStatus(role,status);
	}

	@Override
	public List<User> findByrole(String role) {
		System.out.println(userrepo.findAllByRole(role));
		return userrepo.findAllByRole(role);
	}

	@Override
	public User findByfirstname(String firstname) {
		System.out.println(userrepo.findrecordbyname(firstname));
		return userrepo.findrecordbyname(firstname);
	}

}
