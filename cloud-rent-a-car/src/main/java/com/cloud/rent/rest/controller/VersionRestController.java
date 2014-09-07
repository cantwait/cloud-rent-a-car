package com.cloud.rent.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.rent.model.Version;

@RestController
@RequestMapping("info")
public class VersionRestController {
	
	@RequestMapping(value="version",produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> getVersion(){
		
		return new ResponseEntity<Version>(Version.getInstance(),HttpStatus.OK);
	}

}
