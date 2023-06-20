package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer>{

	Optional<Doctor> findByEmployeeUserFirstName(String name);
	
	Optional<Doctor> findByEmployeeEmpId(Integer id);
}
