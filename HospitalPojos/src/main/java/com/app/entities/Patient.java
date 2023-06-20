package com.app.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Table(name = "patients")
@Getter
@Setter
@NoArgsConstructor
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "patient_id")
	private Integer patientId;
	
	private LocalDate dateOfAdmission;
	
	@Enumerated(EnumType.STRING)
	private BloodGroup bloodGroup;
	
	private String disease;
	
	@Enumerated(EnumType.STRING)
	private PaymentStatus paymentStatus;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;

	public Patient(LocalDate dateOfAdmission, BloodGroup bloodGroup, String disease, PaymentStatus paymentStatus) {
		super();
		this.dateOfAdmission = dateOfAdmission;
		this.bloodGroup = bloodGroup;
		this.disease = disease;
		this.paymentStatus = paymentStatus;
	}
	
	
}
