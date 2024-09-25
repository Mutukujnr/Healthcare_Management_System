package com.healthcare.controllers;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.dtos.PatientDTO;
import com.healthcare.models.Patient;
import com.healthcare.services.PatientService;

@RestController

public class PatientController {
	
	@Autowired
	PatientService patientService;
	
	@GetMapping("/patients")
	public List<Patient> getAllPatients() {
		
		return patientService.allPatients();
	}
	
	@GetMapping("/patient/{patient_id}")
	public ResponseEntity<Patient> getPatientById(@PathVariable(value = "patient_id") Long patient_id) {
		
		try {
		Patient patient = patientService.findById(patient_id);
		return new ResponseEntity<Patient>(patient, HttpStatus.OK);
		
		}catch(Exception ex) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/patient/name")
	public ResponseEntity<Patient> getPatientByName(@RequestParam(value = "name") String name) {
		
		try {
		Patient patient = patientService.findByName(name);
		return new ResponseEntity<Patient>(patient, HttpStatus.OK);
		
		}catch(Exception ex) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/addPatient")
	public Patient  addPatient(@RequestBody PatientDTO patient) {
		
		return patientService.addPatient(patient);
	}
	
	@PutMapping("/updatePatient/{patient_id}")
	public ResponseEntity<Patient>  updatePatient(@PathVariable(value = "patient_id") Long patient_id,@RequestBody PatientDTO patient) {
		
		try {
		Patient updatedPatient =  patientService.updatePatient(patient_id, patient);
		
		return new ResponseEntity<Patient>(updatedPatient, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
	
	@DeleteMapping("/deletePatient/{patient_id}")
	public void  deletePatient(@PathVariable(value = "patient_id") Long patient_id) {
		
		 patientService.deletePatient(patient_id);
	}

}
