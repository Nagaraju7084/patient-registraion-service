package com.boot.healthcare.patient.registraion.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.healthcare.patient.registraion.entity.PatientRegistration;
import com.boot.healthcare.patient.registraion.exception.PatientNotFoundException;
import com.boot.healthcare.patient.registraion.repository.PatientRegistrationRepository;
import com.boot.healthcare.patient.registraion.request.PatientRegistrationRequestDto;
import com.boot.healthcare.patient.registraion.response.PatientRegistrationResponseDto;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PatientRegistrationServiceImpl implements PatientRegistrationService{
	
	@Autowired
	private PatientRegistrationRepository patientRegistrationRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(PatientRegistrationServiceImpl.class);

	@Override
	public PatientRegistrationResponseDto registerPatient(PatientRegistrationRequestDto patientRegistrationDto) {
		return entityToDto(patientRegistrationRepository.save(dtoToEntity(patientRegistrationDto)));
	}

	@Override
	public PatientRegistrationResponseDto getPatientById(Integer patientId) {
		PatientRegistration patientRegistration = patientRegistrationRepository.findById(patientId)
				.orElseThrow(()->new PatientNotFoundException("Patient","id", patientId));
		return entityToDto(patientRegistration);
	}

	@Override
	public List<PatientRegistrationResponseDto> getAllPatients() {
		List<PatientRegistrationResponseDto> patientsList = patientRegistrationRepository.findAll().stream()
				.map(patient ->entityToDto(patient)).collect(Collectors.toList());
		return patientsList;
	}

	@Override
	public PatientRegistrationResponseDto updatePatient(PatientRegistrationRequestDto patientRegistrationDto, Integer patientId) {
		PatientRegistration registration = patientRegistrationRepository.findById(patientId).orElseThrow(
				()-> new PatientNotFoundException("Registration", "id", patientId));
		BeanUtils.copyProperties(patientRegistrationDto, registration);
		PatientRegistration updatedRegistration = patientRegistrationRepository.save(registration);
		
		return entityToDto(updatedRegistration);
	}

	@Override
	public void deletePatient(Integer patientId) {
		PatientRegistration registration = patientRegistrationRepository.findById(patientId).orElseThrow(
				()-> new PatientNotFoundException("Registration", "id", patientId));
		patientRegistrationRepository.deleteById(patientId);
	}
	
	private PatientRegistration dtoToEntity(PatientRegistrationRequestDto dto) {
		PatientRegistration patientRegistration = new PatientRegistration();
		BeanUtils.copyProperties(dto, patientRegistration);
		return patientRegistration;
	}
	private PatientRegistrationResponseDto entityToDto(PatientRegistration entity) {
		PatientRegistrationResponseDto responseDto = new PatientRegistrationResponseDto();
		BeanUtils.copyProperties(entity, responseDto);
		return responseDto;
	}
}
