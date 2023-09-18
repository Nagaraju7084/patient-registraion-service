package com.boot.healthcare.patient.registraion.request;

import java.time.LocalDate;

import com.boot.healthcare.patient.registraion.constants.Gender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientRegistrationRequestDto {

	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private Gender gender;
	private String contactNumber;
	private String email;
	private String address;
	private String registrationDate;
	
}
