package com.training.AP_userwebservice;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import com.training.AP_userwebservice.model.User;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class UserControllerTest {
	@LocalServerPort
	int randomServerPort;
	
	@Test
	public void testGetUsers() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl2 = "http://localhost:" + randomServerPort + "/user";
		URI uri2 = new URI(baseUrl2);
		
		ResponseEntity<User> result2 = restTemplate.postForEntity(uri2,
				new User(1,"vani","k","SE",21,"F","a@a.com","bgyuyg",4,"active",1,1), User.class);
		User testEmp = result2.getBody();
		System.out.print(testEmp);
		System.out.print(result2.getStatusCodeValue());
		Assertions.assertEquals(201, result2.getStatusCodeValue());
		
		
		final String baseUrl = "http://localhost:" + randomServerPort + "/users";
		URI uri = new URI(baseUrl);
		ResponseEntity<User[]> result = restTemplate.getForEntity(uri, User[].class);
		System.out.println(result.getBody());// Verify request succeed
		Assertions.assertEquals(200, result.getStatusCodeValue());
		//Assertions.assertEquals(true, List.of(result.getBody()).contains(testEmp)); 
		
	}
	
	@Test
	public void testGetUser() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl2 = "http://localhost:" + randomServerPort + "/user";
		URI uri2 = new URI(baseUrl2);
		
		ResponseEntity<User> result2 = restTemplate.postForEntity(uri2,
				new User(1,"vani","k","SE",21,"F","a@a.com","bgyuyg",4,"active",1,1), User.class);
		User testEmp = result2.getBody();// Verify request succeed
		Assertions.assertEquals(201, result2.getStatusCodeValue());

		final String baseUrl = "http://localhost:" + randomServerPort + "/user?id=" + testEmp.getId();
		URI uri = new URI(baseUrl);
		ResponseEntity<User> result = restTemplate.getForEntity(uri, User.class);
		//System.out.println(result.getBody());// Verify request succeed
		Assertions.assertEquals(200, result.getStatusCodeValue());
		//Assertions.assertEquals(true, List.of(result.getBody()).contains(testEmp)); // Object verification
	}
	
	@Test
	public void testPutModule() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl2 = "http://localhost:" + randomServerPort + "/user";
		URI uri2 = new URI(baseUrl2);
		
		ResponseEntity<User> result2 = restTemplate.postForEntity(uri2,
				new User(1,"vani","k","SE",21,"F","a@a.com","bgyuyg",4,"active",1,1), User.class);
		User testEmp = result2.getBody();
		result2.getBody().setCredit(4);
		testEmp.setCredit(4);
		
		final String baseUrl1= "http://localhost:" + randomServerPort + "/user";
		URI uri = new URI(baseUrl1);
		ResponseEntity<User> result = restTemplate.exchange(uri, HttpMethod.PUT, result2, User.class);
		//System.out.println(result.getBody());
		//System.out.println(result.getStatusCodeValue());
		Assertions.assertEquals(200, result.getStatusCodeValue());
		//Assertions.assertEquals(true, List.of(result.getBody().getAge()).contains(10));
	}
	
	@Test
	public void testDeleteModule() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl2 = "http://localhost:" + randomServerPort + "/user";
		URI uri2 = new URI(baseUrl2);
		
		ResponseEntity<User> result2 = restTemplate.postForEntity(uri2,
				new User(1,"vani","k","SE",21,"F","a@a.com","bgyuyg",4,"active",1,1), User.class);
		User testEmp = result2.getBody();
		
		final String baseUrl1= "http://localhost:" + randomServerPort + "/user?id=" + testEmp.getId();
		URI uri = new URI(baseUrl1);
		ResponseEntity<Boolean> result = restTemplate.exchange(baseUrl1, HttpMethod.DELETE, result2,Boolean.class,testEmp.getId());
		System.out.println(result.getBody());
		System.out.println(result.getStatusCodeValue());
		Assertions.assertEquals(200, result.getStatusCodeValue());
	}

}
