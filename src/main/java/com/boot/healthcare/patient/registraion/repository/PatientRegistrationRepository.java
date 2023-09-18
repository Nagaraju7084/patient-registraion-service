package com.boot.healthcare.patient.registraion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.healthcare.patient.registraion.entity.PatientRegistration;

public interface PatientRegistrationRepository extends JpaRepository<PatientRegistration, Integer> {

}
