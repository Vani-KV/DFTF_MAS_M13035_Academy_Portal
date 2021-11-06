package com.training.batchallocationservice;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;

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

import com.training.batchallocationservice.model.Batch;




@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BatchControllerTest  {
		@LocalServerPort
		int randomServerPort;

		@Test
		public void testGetBatches() throws URISyntaxException {
			RestTemplate restTemplate = new RestTemplate();
			final String baseUrl2 = "http://localhost:" + randomServerPort + "/batch";
			URI uri2 = new URI(baseUrl2);
			LocalDate d1 = LocalDate.now();
			LocalDate d2 = LocalDate.now();
			ResponseEntity<Batch> result2 = restTemplate.postForEntity(uri2,
					new Batch(1,"JAVAGroup",d1,d2,21,"anbu",1), Batch.class);
			Batch testEmp = result2.getBody();// Verify request succeed
			Assertions.assertEquals(201, result2.getStatusCodeValue());
			
			
			final String baseUrl = "http://localhost:" + randomServerPort + "/batches";
			URI uri = new URI(baseUrl);
			ResponseEntity<Batch[]> result = restTemplate.getForEntity(uri, Batch[].class);
			//System.out.println(result.getBody());// Verify request succeed
			Assertions.assertEquals(200, result.getStatusCodeValue());
		}

		@Test
		public void testGetBatch() throws URISyntaxException {
			RestTemplate restTemplate = new RestTemplate();
			final String baseUrl2 = "http://localhost:" + randomServerPort + "/batch";
			URI uri2 = new URI(baseUrl2);
			LocalDate d1 = LocalDate.now();
			LocalDate d2 = LocalDate.now();
			ResponseEntity<Batch> result2 = restTemplate.postForEntity(uri2,
					new Batch(1,"JAVAGroup",d1,d2,21,"anbu",1), Batch.class);
			Batch testEmp = result2.getBody();// Verify request succeed
			Assertions.assertEquals(201, result2.getStatusCodeValue());
			
			
			
			final String baseUrl = "http://localhost:" + randomServerPort + "/batch?id=" + testEmp.getId();
			URI uri = new URI(baseUrl);
			ResponseEntity<Batch> result = restTemplate.getForEntity(uri, Batch.class);
			//System.out.println(result.getBody());// Verify request succeed
			Assertions.assertEquals(200, result.getStatusCodeValue());

		}
		
		@Test
		public void testPutBatch() throws URISyntaxException {
			RestTemplate restTemplate = new RestTemplate();
			final String baseUrl2 = "http://localhost:" + randomServerPort + "/batch";
			URI uri2 = new URI(baseUrl2);
			LocalDate d1 = LocalDate.now();
			LocalDate d2 = LocalDate.now();
			ResponseEntity<Batch> result2 = restTemplate.postForEntity(uri2,
					new Batch(1,"JAVAGroup",d1,d2,21,"anbu",1), Batch.class);
			Batch testEmp = result2.getBody();
			result2.getBody().setBatchName("SQL");
			testEmp.setBatchName("SQL");
			
			final String baseUrl1= "http://localhost:" + randomServerPort + "/batch";
			URI uri = new URI(baseUrl1);
			ResponseEntity<Batch> result = restTemplate.exchange(uri, HttpMethod.PUT, result2, Batch.class);
			//System.out.println(result.getBody());
			//System.out.println(result.getStatusCodeValue());
			Assertions.assertEquals(200, result.getStatusCodeValue());
		}
		
		@Test
		public void testDeleteBatch() throws URISyntaxException {
			RestTemplate restTemplate = new RestTemplate();
			final String baseUrl2 = "http://localhost:" + randomServerPort + "/batch";
			URI uri2 = new URI(baseUrl2);
			LocalDate d1 = LocalDate.now();
			LocalDate d2 = LocalDate.now();
			ResponseEntity<Batch> result2 = restTemplate.postForEntity(uri2,
					new Batch(1,"JAVAGroup",d1,d2,21,"anbu",1), Batch.class);
			Batch testEmp = result2.getBody();
			
			final String baseUrl1= "http://localhost:" + randomServerPort + "/batch?id=" + testEmp.getId();
			URI uri = new URI(baseUrl1);
			ResponseEntity<Boolean> result = restTemplate.exchange(baseUrl1, HttpMethod.DELETE, result2,Boolean.class,testEmp.getId());
			System.out.println(result.getBody());
			System.out.println(result.getStatusCodeValue());
			Assertions.assertEquals(200, result.getStatusCodeValue());
		}
		
		
	}
		
