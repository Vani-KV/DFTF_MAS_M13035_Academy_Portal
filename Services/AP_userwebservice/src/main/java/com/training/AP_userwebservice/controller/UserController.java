package com.training.AP_userwebservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.AP_userwebservice.model.User;
import com.training.AP_userwebservice.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userserv;
	
	
	@GetMapping("/users")
	public ResponseEntity<List> users() {
		return new ResponseEntity<List>(userserv.findAll(), HttpStatus.OK);
	}

	@GetMapping("/user")
	public ResponseEntity<User> user(@RequestParam int id) {
		return new ResponseEntity<User>(userserv.findById(id), HttpStatus.OK);
	}
	
	@GetMapping("/username")
	public ResponseEntity<User> userbyemail(@RequestParam String email) {
		User result=userserv.findByemail(email);
		
		return new ResponseEntity<User>(result, HttpStatus.OK);
	}
	
	@GetMapping("/facultyname")
	public ResponseEntity<User> userbyfirstname(@RequestParam String firstname) {
		return new ResponseEntity<User>(userserv.findByfirstname(firstname), HttpStatus.OK);
	}
	
	@GetMapping("/userrole")
	public ResponseEntity<List> userbyrole(@RequestParam String role) {
		return new ResponseEntity<List>(userserv.findByrole(role), HttpStatus.OK);
	}

	@GetMapping("/faculty")
	public ResponseEntity<List> getfaculty(@RequestParam String role,@RequestParam String status) {
		//System.out.print(role);
		//System.out.print(status);
		return new ResponseEntity<List>(userserv.findfaculty(role,status), HttpStatus.OK);
	}
	@PostMapping("/user")
	public ResponseEntity<User> createuser(@RequestBody User user) {
		return new ResponseEntity<User>(userserv.save(user), HttpStatus.CREATED);
	}

	@PutMapping("/user")
	public ResponseEntity<User> updateuser(@RequestBody User user) {
		return new ResponseEntity<User>(userserv.save(user), HttpStatus.OK);
	}

	@DeleteMapping("/user")
	public ResponseEntity<Boolean> deleteuser(@RequestParam int id) {
		
		return new ResponseEntity<Boolean>(userserv.deleteById(id), HttpStatus.OK);
	}
	
	

}
