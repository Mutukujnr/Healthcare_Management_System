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

import com.healthcare.dtos.PrescriptionDTO;
import com.healthcare.models.Prescription;
import com.healthcare.services.IPrescription;
import com.healthcare.services.PrescriptionService;

@RestController
public class PrescriptionController {
	
	@Autowired
	PrescriptionService prescriptionService;

	@GetMapping("/Prescriptions")
	public List<Prescription> getAllPrescriptions() {
		
		return prescriptionService.allPrescriptions();
	}
	
	@GetMapping("/Prescription/{Prescription_id}")
	public ResponseEntity<Prescription> getPrescriptionById(@PathVariable(value = "Prescription_id") Long Prescription_id) {
		
		try {
		Prescription Prescription = prescriptionService.findById(Prescription_id);
		return new ResponseEntity<Prescription>(Prescription, HttpStatus.OK);
		
		}catch(Exception ex) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/Prescription/name")
	public ResponseEntity<Prescription> getPrescriptionByName(@RequestParam(value = "name") String name) {
		
		try {
			Prescription Prescription = prescriptionService.findByName(name);
		return new ResponseEntity<Prescription>(Prescription, HttpStatus.OK);
		
		}catch(Exception ex) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/addPrescription")
	public Prescription  addPrescription(@RequestBody PrescriptionDTO PrescriptionDTO) {
		
		return prescriptionService.addPrescription(PrescriptionDTO);
	}
	
	@PutMapping("/updatePrescription/{Prescription_id}")
	public ResponseEntity<Prescription>  updatePrescription(@PathVariable(value = "Prescription_id") Long Prescription_id,@RequestBody PrescriptionDTO PrescriptionDTO) {
		
		try {
		Prescription updatePrescription = prescriptionService.updatePrescription(Prescription_id, PrescriptionDTO);
		
		return new ResponseEntity<Prescription>(updatePrescription, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
	
	@DeleteMapping("/deletePrescription/{Prescription_id}")
	public void  deletePrescription(@PathVariable(value = "Prescription_id") Long Prescription_id) {
		
		 prescriptionService.deletePrescription(Prescription_id);
	}

}
