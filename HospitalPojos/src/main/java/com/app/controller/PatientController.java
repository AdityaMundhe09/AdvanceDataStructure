package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.PatientRequest;
import com.app.service.PatientService;

@RestController
@RequestMapping("/patients")
public class PatientController {

	
	@Autowired
	private PatientService service;
	
	
	@PostMapping
	public ResponseEntity<?> addPatient(@RequestBody PatientRequest pet){
		return new ResponseEntity<>(new ApiResponse(service.addPatient(pet)), HttpStatus.CREATED);
	}
}
