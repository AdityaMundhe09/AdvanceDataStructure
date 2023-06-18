package com.app.dto;

import java.time.LocalDate;

import com.app.entities.Role;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor

public class EmployeeRequest {
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String confirmPassword;
	private Role role;
	private LocalDate dob;
	private double contactNo;
	private LocalDate hiringDate;
	private double salary;
	
}
