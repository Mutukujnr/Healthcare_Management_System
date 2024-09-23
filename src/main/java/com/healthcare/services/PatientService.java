package com.healthcare.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.models.Patient;
import com.healthcare.repositories.PatientRepository;

@Service
public class PatientService implements IPatient{
	
	@Autowired
	PatientRepository patientRepository;

	@Override
	public List<Patient> allPatients() {
		
		return patientRepository.findAll();
	}

	@Override
	public Patient findById(Long id) {
		
		return patientRepository.findById(id).get();
	}

	@Override
	public Patient findByName(String name) {
		
		return patientRepository.findByName(name);
	}

	@Override
	public Patient addPatient(Patient patient) {
		
		Patient newPatient = new Patient(patient.getName(),patient.getEmail(),patient.getPhoneNumber(),patient.getAppointments(),patient.getMedicalRecords());
		
		return patientRepository.save(newPatient);
	}

	@Override
	public Patient updatePatient(Long id, Patient patient) {
		
		Patient getPatient = null;
		getPatient = patientRepository.findById(id).get();
		
		if(getPatient != null) {
			
			getPatient.setName(patient.getName());
			getPatient.setEmail(patient.getEmail());
			getPatient.setPhoneNumber(patient.getPhoneNumber());
		}
		
		return patientRepository.save(getPatient);
	}

	@Override
	public void deletePatient(Long id) {
	
		patientRepository.deleteById(id);
		
	}
	
	

}
