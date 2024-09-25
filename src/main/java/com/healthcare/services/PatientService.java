package com.healthcare.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.dtos.PatientDTO;
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
	public Patient addPatient(PatientDTO patientDTO) {
		
		Patient newPatient = new Patient(patientDTO.getName(),patientDTO.getEmail(),patientDTO.getPhoneNumber(),patientDTO.getAppointments(),patientDTO.getMedicalRecords());
		
		return patientRepository.save(newPatient);
	}

	@Override
	public Patient updatePatient(Long id, PatientDTO patientDTO) {
		
		Patient getPatient = null;
		getPatient = patientRepository.findById(id).get();
		
		if(getPatient != null) {
			
			getPatient.setName(patientDTO.getName());
			getPatient.setEmail(patientDTO.getEmail());
			getPatient.setPhoneNumber(patientDTO.getPhoneNumber());
		}
		
		return patientRepository.save(getPatient);
	}

	@Override
	public void deletePatient(Long id) {
	
		patientRepository.deleteById(id);
		
	}
	
	

}
