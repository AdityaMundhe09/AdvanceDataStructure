package com.app.service;

import java.util.List;

import com.app.dto.PatientRequest;

public interface DoctorService {
	
	List<PatientRequest> getAllPatients(Integer doctorId);
}
