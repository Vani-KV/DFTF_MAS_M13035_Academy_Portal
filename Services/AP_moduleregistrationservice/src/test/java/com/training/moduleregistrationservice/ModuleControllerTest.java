package com.training.moduleregistrationservice;

import static org.junit.jupiter.api.Assertions.*;


import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.List;

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

import com.training.moduleregistrationservice.model.Modules;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ModuleControllerTest {
	@LocalServerPort
	int randomServerPort;
	
	@Test
	public void testGetModules() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl2 = "http://localhost:" + randomServerPort + "/module";
		URI uri2 = new URI(baseUrl2);
		LocalDate d1 = LocalDate.now();
		LocalDate d2 = LocalDate.now();
		ResponseEntity<Modules> result2 = restTemplate.postForEntity(uri2,
				new Modules(1,"FGTR",d1,d2,1,"vani","online"), Modules.class);
		Modules testEmp = result2.getBody();
		System.out.print(testEmp);
		System.out.print(result2.getStatusCodeValue());
		Assertions.assertEquals(201, result2.getStatusCodeValue());
		
		
		final String baseUrl = "http://localhost:" + randomServerPort + "/modules";
		URI uri = new URI(baseUrl);
		ResponseEntity<Modules[]> result = restTemplate.getForEntity(uri, Modules[].class);
		System.out.println(result.getBody());// Verify request succeed
		Assertions.assertEquals(200, result.getStatusCodeValue());
		//Assertions.assertEquals(true, List.of(result.getBody()).contains(testEmp)); 
		
	}
	
	@Test
	public void testGetModule() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl2 = "http://localhost:" + randomServerPort + "/module";
		URI uri2 = new URI(baseUrl2);
		LocalDate d1 = LocalDate.now();
		LocalDate d2 = LocalDate.now();
		ResponseEntity<Modules> result2 = restTemplate.postForEntity(uri2,
				new Modules(1,"FGTR",d1,d2,1,"vani","online"), Modules.class);
		Modules testEmp = result2.getBody();// Verify request succeed
		Assertions.assertEquals(201, result2.getStatusCodeValue());

		final String baseUrl = "http://localhost:" + randomServerPort + "/module?id=" + testEmp.getId();
		URI uri = new URI(baseUrl);
		ResponseEntity<Modules> result = restTemplate.getForEntity(uri, Modules.class);
		//System.out.println(result.getBody());// Verify request succeed
		Assertions.assertEquals(200, result.getStatusCodeValue());
		//Assertions.assertEquals(true, List.of(result.getBody()).contains(testEmp)); // Object verification
	}
	
	@Test
	public void testPutModule() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl2 = "http://localhost:" + randomServerPort + "/module";
		URI uri2 = new URI(baseUrl2);
		LocalDate d1 = LocalDate.now();
		LocalDate d2 = LocalDate.now();
		ResponseEntity<Modules> result2 = restTemplate.postForEntity(uri2,
				new Modules(1,"FGTR",d1,d2,1,"vani","online"), Modules.class);
		Modules testEmp = result2.getBody();
		result2.getBody().setModuleType("offline");;
		testEmp.setModuleType("offline");
		
		final String baseUrl1= "http://localhost:" + randomServerPort + "/module";
		URI uri = new URI(baseUrl1);
		ResponseEntity<Modules> result = restTemplate.exchange(uri, HttpMethod.PUT, result2, Modules.class);
		//System.out.println(result.getBody());
		//System.out.println(result.getStatusCodeValue());
		Assertions.assertEquals(200, result.getStatusCodeValue());
		//Assertions.assertEquals(true, List.of(result.getBody().getAge()).contains(10));
	}
	
	@Test
	public void testDeleteModule() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl2 = "http://localhost:" + randomServerPort + "/module";
		URI uri2 = new URI(baseUrl2);
		LocalDate d1 = LocalDate.now();
		LocalDate d2 = LocalDate.now();
		ResponseEntity<Modules> result2 = restTemplate.postForEntity(uri2,
				new Modules(1,"FGTR",d1,d2,1,"vani","online"), Modules.class);
		Modules testEmp = result2.getBody();
		
		final String baseUrl1= "http://localhost:" + randomServerPort + "/module?id=" + testEmp.getId();
		URI uri = new URI(baseUrl1);
		ResponseEntity<Boolean> result = restTemplate.exchange(baseUrl1, HttpMethod.DELETE, result2,Boolean.class,testEmp.getId());
		System.out.println(result.getBody());
		System.out.println(result.getStatusCodeValue());
		Assertions.assertEquals(200, result.getStatusCodeValue());
	}

}
