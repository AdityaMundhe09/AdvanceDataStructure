package com.app.service;

import static com.app.dto.PatientRequest.createPatient;
import java.util.List;

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


	@Override
	public List<PatientRequest> getAllPatients() {
		// TODO Auto-generated method stub
		List<Patient> p = repo.findAll();
		return createPatient(p);
	}
	
	@Override
	public String removePatient(Integer pid) {
		repo.deleteById(pid);
		return "Patient deleted";
	}

	
}
