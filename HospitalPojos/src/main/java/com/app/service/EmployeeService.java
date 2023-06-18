package com.app.service;

import java.util.List;

import com.app.dto.EmployeeRequest;

public interface EmployeeService {
	
	String addNewEmployee(EmployeeRequest emp);
	
	String removeEmployee(Integer empId);
	
	List<EmployeeRequest> displayEmployees();
}
