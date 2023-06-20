package com.app.service;

import static com.app.dto.PatientRequest.createPatient;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.PatientRequest;
import com.app.entities.Doctor;
import com.app.entities.Patient;
import com.app.entities.User;
import com.app.repository.DoctorRepository;
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
	
	@Autowired
	private DoctorRepository doctorRepo;
	
	
	@Override
	public String addPatient(PatientRequest pet) {
		
		User u = userRepo.save(mapper.map(pet, User.class));
		
		Patient p = mapper.map(pet, Patient.class);
		
		p.setUser(u);
		
		
		Doctor d = doctorRepo.findByEmployeeUserFirstName(pet.getDoctorName()).orElseThrow();
		
		
		d.addPatient(p);
		
		return "Patient "+p.getUser().getFirstName() +" is added successfully";
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


	@Override
	public String updatePatient(PatientRequest pt) {
		// TODO Auto-generated method stub
		
		Patient p = repo.findById(pt.getPatientId()).orElseThrow();
		
		p.getUser().setFirstName(pt.getFirstName());
		p.getUser().setLastName(pt.getLastName());
		p.getUser().setEmail(pt.getEmail());
		p.getUser().setPassword(pt.getPassword());
		p.getUser().setConfirmPassword(pt.getConfirmPassword());
		p.getUser().setContactNo(pt.getContactNo());
		p.getUser().setDob(pt.getDob());
		p.getUser().setRole(pt.getRole());
		p.setBloodGroup(pt.getBloodGroup());
		p.setDateOfAdmission(pt.getDateOfAdmission());
		p.setDisease(pt.getDisease());
		p.setPaymentStatus(pt.getPaymentStatus());
		
		
		return "patient with ID: "+p.getPatientId()+" details updated successfully";
	}

	
}
