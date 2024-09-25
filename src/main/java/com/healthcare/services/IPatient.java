package com.healthcare.services;

import java.util.List;

import com.healthcare.dtos.PatientDTO;
import com.healthcare.models.Patient;

public interface IPatient{

	List<Patient> allPatients();
	
	Patient findById(Long id);
	
	Patient findByName(String name);
	
	Patient addPatient(PatientDTO patientDTO);
	
	Patient updatePatient(Long id, PatientDTO patientDTO);
	
	void deletePatient(Long id);
}
