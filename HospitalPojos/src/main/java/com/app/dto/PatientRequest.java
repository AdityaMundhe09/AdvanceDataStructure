package com.app.dto;

import java.time.LocalDate;

import com.app.entities.BloodGroup;
import com.app.entities.PaymentStatus;
import com.app.entities.Role;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class PatientRequest {

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String confirmPassword;
	private Role role;
	private LocalDate dob;
	private double contactNo;
	private LocalDate dateOfAdmission;
	private BloodGroup bloodGroup;
	private String disease;
	private PaymentStatus paymentStatus;
}
