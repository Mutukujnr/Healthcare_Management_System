package com.healthcare.services;

import java.util.List;
import java.util.Optional;

import com.healthcare.models.Patient;

public interface IPatient{

	List<Patient> allPatients();
	
	Patient findById(Long id);
	
	Patient findByName(String name);
	
	Patient addPatient(Patient patient);
	
	Patient updatePatient(Long id, Patient patient);
	
	void deletePatient(Long id);
}
