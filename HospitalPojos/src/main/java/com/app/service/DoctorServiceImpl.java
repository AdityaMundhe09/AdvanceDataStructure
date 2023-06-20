package com.app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.PatientRequest;
import com.app.entities.Doctor;
import com.app.entities.Patient;
import com.app.repository.DoctorRepository;

import static com.app.dto.PatientRequest.createPatient;


@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorRepository repo;
	
	@Autowired
	private ModelMapper mapper;
	
	
	
	@Override
	public List<PatientRequest> getAllPatients(Integer doctorId) {
		// TODO Auto-generated method stub
		
		Doctor d = repo.findById(doctorId).orElseThrow();
		
		List<Patient> list = d.getPatients();
		
		return createPatient(list);
	}

}
