package com.app.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.app.entities.BloodGroup;
import com.app.entities.Patient;
import com.app.entities.PaymentStatus;
import com.app.entities.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class PatientRequest {

	private Integer patientId;
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
	private LocalDate dateOfAdmission;
	private BloodGroup bloodGroup;
	private String disease;
	private PaymentStatus paymentStatus;
	private String doctorName;
	
	public static List<PatientRequest> createPatient(List<Patient> pt){
		List<PatientRequest> list = new ArrayList<>();
		
		for(Patient p : pt) {
			PatientRequest pr = new PatientRequest();
			
			pr.setPatientId(p.getPatientId());
			pr.setFirstName(p.getUser().getFirstName());
			pr.setLastName(p.getUser().getLastName());
			pr.setEmail(p.getUser().getEmail());
			pr.setRole(p.getUser().getRole());
			pr.setDob(p.getUser().getDob());
			pr.setContactNo(p.getUser().getContactNo());
			pr.setDateOfAdmission(p.getDateOfAdmission());
			pr.setBloodGroup(p.getBloodGroup());
			pr.setDisease(p.getDisease());
			pr.setPaymentStatus(p.getPaymentStatus());
			
			
			list.add(pr);
		}
		
		return list;
	}
}
