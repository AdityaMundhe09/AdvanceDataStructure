package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.PatientRequest;

import com.app.entities.Patient;
import com.app.entities.User;
import com.app.repository.PatientRepository;
import com.app.repository.UserRepository;



@Service
@Transactional
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository repo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	
	@Override
	public String addPatient(PatientRequest pet) {
		
		User u = userRepo.save(mapper.map(pet, User.class));
		
		Patient p = mapper.map(pet, Patient.class);
		
		p.setUser(u);
		
		Patient p1 = repo.save(p);
		
		return "Patient "+p1.getUser().getFirstName() +" is added successfully";
	}

	
}
