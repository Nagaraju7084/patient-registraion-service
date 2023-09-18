package com.boot.healthcare.patient.registraion.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.boot.healthcare.patient.registraion.constants.Gender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "patient")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientRegistration {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int patientId;
	
	private String firstName;
	private String lastName;
	@Column(name = "dateOfBirth")
	private LocalDate dateOfBirth;
	@Column(name = "gender")
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@Column(name = "contactNumber")
	private String contactNumber;
	private String email;
	private String address;
	private String registrationDate;
	
}
