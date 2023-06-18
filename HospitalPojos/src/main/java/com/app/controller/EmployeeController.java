package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.EmployeeRequest;
import com.app.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	
	
	@PostMapping
	public ResponseEntity<?> addEmployee(@RequestBody EmployeeRequest emp) {
		return new ResponseEntity<>(new ApiResponse(service.addNewEmployee(emp)), HttpStatus.CREATED);
	}
}
