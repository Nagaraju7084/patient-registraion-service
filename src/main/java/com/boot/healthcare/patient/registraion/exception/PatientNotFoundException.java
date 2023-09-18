package com.boot.healthcare.patient.registraion.exception;

import lombok.Data;

@Data
public class PatientNotFoundException extends RuntimeException{

	private String resourceName;
	private String fieldName;
	private long fieldValue;
	
	public PatientNotFoundException(String resourceName, String fieldName, long fieldValue) {
		String.format("%s not found with %s : %s", resourceName, fieldName, fieldValue);
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
}
