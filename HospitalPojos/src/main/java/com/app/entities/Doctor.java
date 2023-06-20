package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "doctors")
@Getter
@Setter
@NoArgsConstructor
public class Doctor {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer doctorId;
	
	
	private double charges;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_id")
	private Employee employee;
	
	@OneToMany(mappedBy = "doctor",cascade = CascadeType.DETACH.MERGE.PERSIST.REFRESH,fetch = FetchType.EAGER)
	private List<Patient> patients = new ArrayList<>();
	
	
	
	public void addPatient(Patient p) {
		patients.add(p);
		p.setDoctor(this);
	}
	
	public void removePatient(Patient p) {
		patients.remove(p);
		p.setDoctor(null);
	}

	public Doctor(double charges) {
		super();
		this.charges = charges;
	}
}
