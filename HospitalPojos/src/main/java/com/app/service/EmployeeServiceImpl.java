package com.app.service;

import static com.app.dto.EmployeeRequest.createEmployee;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.EmployeeRequest;
import com.app.entities.Doctor;
import com.app.entities.Employee;
import com.app.entities.Patient;
import com.app.entities.Role;
import com.app.entities.User;
import com.app.repository.DoctorRepository;
import com.app.repository.EmployeeRepository;
import com.app.repository.UserRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	
	@Autowired
	private EmployeeRepository repo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private DoctorRepository doctorRepo;
	
	@Override
	public String addNewEmployee(EmployeeRequest emp) {
		// TODO Auto-generated method stub
		
		User u = userRepo.save(mapper.map(emp, User.class));
		
		Employee e = mapper.map(emp, Employee.class);
		
		e.setUser(u);
		
		Employee e1 = repo.save(e);
		
		return "Employee "+e1.getUser().getFirstName() +" is added successfully";
	}

	@Override
	public String removeEmployee(Integer empId) {
		// TODO Auto-generated method stub
		Employee e = repo.findById(empId).orElseThrow();
		if(e.getUser().getRole().equals(Role.valueOf("DOCTOR"))) {
			Doctor d = doctorRepo.findByEmployeeEmpId(empId).orElseThrow();
			List<Patient> list = d.getPatients();
			for(Patient b : list) {
				d.removePatient(b);
			}
			doctorRepo.deleteById(d.getDoctorId());
		}
		else {
			repo.deleteById(empId);
		}
		
		
		return "User  deleted";
	}

	@Override
	public List<EmployeeRequest> displayEmployees() {
		// TODO Auto-generated method stub
		
		List<Employee> eList = repo.findAll();
		
		
		return createEmployee(eList);
	}

	@Override
	public String updateEmployee(EmployeeRequest emp) {
		// TODO Auto-generated method stub
		
		Employee e = repo.findById(emp.getEmpId()).orElseThrow();
		
		e.setHiringDate(emp.getHiringDate());
		e.setSalary(emp.getSalary());
		e.getUser().setFirstName(emp.getFirstName());
		e.getUser().setLastName(emp.getLastName());
		e.getUser().setEmail(emp.getEmail());
		e.getUser().setPassword(emp.getPassword());
		e.getUser().setConfirmPassword(emp.getConfirmPassword());
		e.getUser().setContactNo(emp.getContactNo());
		e.getUser().setDob(emp.getDob());
		e.getUser().setRole(emp.getRole());
		
		return "employee with empId: "+ e.getEmpId()+" updated successfully" ;
	}

	@Override
	public String addEmployeeDoctor(EmployeeRequest emp) {
		// TODO Auto-generated method stub
		
		User u = userRepo.save(mapper.map(emp, User.class));
		
		Employee e = mapper.map(emp, Employee.class);
		
		e.setUser(u);
		
		Employee e1 = repo.save(e);
		
		Doctor d = mapper.map(emp, Doctor.class);
		
		d.setEmployee(e1);
		
		Doctor d1 = doctorRepo.save(d);
		
		
		return "Doctor added successfully with id: "+d1.getDoctorId();
	}

}
