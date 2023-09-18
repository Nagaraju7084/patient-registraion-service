package com.boot.healthcare.patient.registraion.service;

import java.util.List;

import com.boot.healthcare.patient.registraion.request.PatientRegistrationRequestDto;
import com.boot.healthcare.patient.registraion.response.PatientRegistrationResponseDto;

public interface PatientRegistrationService {
	
	PatientRegistrationResponseDto registerPatient(PatientRegistrationRequestDto patientRegistrationDto);
	PatientRegistrationResponseDto getPatientById(Integer patientId);
	List<PatientRegistrationResponseDto> getAllPatients();
	PatientRegistrationResponseDto updatePatient(PatientRegistrationRequestDto patientRegistrationDto, Integer patientId);
	void deletePatient(Integer patientId);
	
}
