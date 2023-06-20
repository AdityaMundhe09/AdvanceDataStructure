package com.app.service;

import java.util.List;

import com.app.dto.PatientRequest;

public interface PatientService {
	
	String addPatient(PatientRequest pet);
	
	List<PatientRequest> getAllPatients();

	String removePatient(Integer pid);

	String updatePatient(PatientRequest pt);
}
