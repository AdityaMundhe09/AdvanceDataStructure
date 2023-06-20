package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@DeleteMapping("/{empId}")
	public ResponseEntity<?> removeEmployee(@PathVariable Integer empId){
		return new ResponseEntity<>(new ApiResponse(service.removeEmployee(empId)), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<?> displayAllEmployees(){
		return new ResponseEntity<>(service.displayEmployees(),HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> updateEmployeeDetails(@RequestBody EmployeeRequest emp){
		return new ResponseEntity<>(new ApiResponse(service.updateEmployee(emp)), HttpStatus.OK);
	}
	
	@PostMapping("/doctor")
	public ResponseEntity<?> addEmployeeDoctor(@RequestBody EmployeeRequest emp) {
		return new ResponseEntity<>(new ApiResponse(service.addEmployeeDoctor(emp)), HttpStatus.CREATED);
	}
}
