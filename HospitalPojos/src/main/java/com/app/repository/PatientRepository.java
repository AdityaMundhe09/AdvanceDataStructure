package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer>{

}
