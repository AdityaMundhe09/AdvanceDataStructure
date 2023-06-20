package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.DoctorService;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

	@Autowired
	private DoctorService service;
	
	@GetMapping("/{doctorId}")
	public ResponseEntity<?> getAllPatients(@PathVariable Integer doctorId){
		return new ResponseEntity<>(service.getAllPatients(doctorId), HttpStatus.OK);
	}
}
