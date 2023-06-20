package com.app.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.app.entities.Employee;
import com.app.entities.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor

public class EmployeeRequest {
	
	
	private Integer empId;
	private String firstName;
	private String lastName;
	private String email;
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	@JsonProperty(access = Access.WRITE_ONLY)
	private String confirmPassword;
	private Role role;
	private LocalDate dob;
	private double contactNo;
	private LocalDate hiringDate;
	private double salary;
	private double charges;
	public EmployeeRequest(Integer empId, String firstName, String lastName, String email, Role role, LocalDate dob,
			double contactNo, LocalDate hiringDate, double salary) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
		this.dob = dob;
		this.contactNo = contactNo;
		this.hiringDate = hiringDate;
		this.salary = salary;
	}
	
	
	public static List<EmployeeRequest> createEmployee(List<Employee> emps){
		List<EmployeeRequest> list = new ArrayList<>();
		
		
		
		for(Employee e : emps) {
			EmployeeRequest er = new EmployeeRequest();
			er.setEmpId(e.getEmpId());
			er.setFirstName(e.getUser().getFirstName());
			er.setLastName(e.getUser().getLastName());
			er.setEmail(e.getUser().getEmail());
			er.setRole(e.getUser().getRole());
			er.setDob(e.getUser().getDob());
			er.setContactNo(e.getUser().getContactNo());
			er.setHiringDate(e.getHiringDate());
			er.setSalary(e.getSalary());
			
			list.add(er);
			
		}
		return list;
	}
}
