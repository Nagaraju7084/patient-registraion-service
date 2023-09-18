package com.boot.healthcare.patient.registraion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.healthcare.patient.registraion.request.PatientRegistrationRequestDto;
import com.boot.healthcare.patient.registraion.response.PatientRegistrationResponseDto;
import com.boot.healthcare.patient.registraion.service.PatientRegistrationService;

@RestController
@RequestMapping("/api/registration")
public class PatientRegistrationController {

	@Autowired
	private PatientRegistrationService registrationService;
	
	//post - register patient
	
	@PostMapping("/")
	public ResponseEntity<PatientRegistrationResponseDto> registerPatient(@RequestBody PatientRegistrationRequestDto registrationDto){
		PatientRegistrationResponseDto registrationResponse = registrationService.registerPatient(registrationDto);
		return new ResponseEntity<>(registrationResponse, HttpStatus.CREATED);
	}
	
	//put - update patient
	@PutMapping("/{patientId}")
	public ResponseEntity<PatientRegistrationResponseDto> updatePatient(@RequestBody PatientRegistrationRequestDto registrationDto, 
			@PathVariable("patientId") Integer patientId){
		PatientRegistrationResponseDto updatedPatient = registrationService.updatePatient(registrationDto, patientId);
		return ResponseEntity.ok(updatedPatient);
	}
	
	//delete - delete patient
	@DeleteMapping("/{patientId}")
	public ResponseEntity<?> deletePatient(@PathVariable Integer patientId){
		registrationService.deletePatient(patientId);
		return new ResponseEntity<>("Patient Registration Deleted Successfully...", HttpStatus.OK);
	}
	
	//get - get single patient
	@GetMapping("/{patientId}")
	public ResponseEntity<PatientRegistrationResponseDto> getPatientRegistration(@PathVariable Integer patientId){
		return ResponseEntity.ok(registrationService.getPatientById(patientId));
	}
	
	//getall - get all patients
	@GetMapping("/")
	public ResponseEntity<List<PatientRegistrationResponseDto>> getAllPatients(){
		return ResponseEntity.ok(registrationService.getAllPatients());
	}
}
