package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.EmployeeRequest;
import com.app.entities.Employee;
import com.app.entities.User;
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
	
	@Override
	public String addNewEmployee(EmployeeRequest emp) {
		// TODO Auto-generated method stub
		
		User u = userRepo.save(mapper.map(emp, User.class));
		
		Employee e = mapper.map(emp, Employee.class);
		
		e.setUser(u);
		
		Employee e1 = repo.save(e);
		
		return "Employee "+e1.getUser().getFirstName() +" is added successfully";
	}

}
