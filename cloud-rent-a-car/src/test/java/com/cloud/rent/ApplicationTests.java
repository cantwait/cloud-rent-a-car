package com.cloud.rent;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.web.client.RestTemplate;

import com.cloud.rent.model.Version;

@RunWith(JUnit4.class)
public class ApplicationTests {
	
	public static HttpHeaders headers;
	public static RestTemplate template;
	 
	public ApplicationTests(){}

	@BeforeClass
	public static void init() {
		
		headers = new HttpHeaders();
		byte[] encodedAuthorisation = Base64.encode(new String("admin"+":"+"admin").getBytes());
	    headers.add("Authorization", "Basic " + new String(encodedAuthorisation));
		headers.setContentType(MediaType.APPLICATION_JSON);
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    template = new RestTemplate();
	}
	
	@Test
	public void versionExists() {
	    
	    HttpEntity<Version> requestEntity = new HttpEntity<Version>(headers);

	    ResponseEntity<Version> entity = template.postForEntity(
	        "http://localhost:8080/info/version",
	        requestEntity, Version.class);

	    assertEquals(HttpStatus.OK, entity.getStatusCode());
	    Version version = entity.getBody();

	    System.out.println ("The App Version is " + version.getNumber());

	    assertEquals("1.0.0", version.getNumber());
	 }

}
