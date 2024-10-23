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

import com.healthcare.dtos.MedicalRecordDTO;
import com.healthcare.models.MedicalRecord;
import com.healthcare.services.MedicalRecordService;

@RestController
public class MedicalRecordController {
	
	@Autowired
	MedicalRecordService medicalRecordService;

	@GetMapping("/medicalRecords")
	public List<MedicalRecord> getAllMedicalRecords() {
		
		return medicalRecordService.allMedicalRecords();
	}
	
	@GetMapping("/medicalRecord/{medicalRecord_id}")
	public ResponseEntity<MedicalRecord> getMedicalRecordById(@PathVariable(value = "medicalRecord_id") Long medicalRecord_id) {
		
		try {
		MedicalRecord medicalRecord = medicalRecordService.findById(medicalRecord_id);
		return new ResponseEntity<MedicalRecord>(medicalRecord, HttpStatus.OK);
		
		}catch(Exception ex) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/medicalRecord/name")
	public ResponseEntity<MedicalRecord> getMedicalRecordByName(@RequestParam(value = "name") String name) {
		
		try {
			MedicalRecord MedicalRecord = medicalRecordService.findByName(name);
		return new ResponseEntity<MedicalRecord>(MedicalRecord, HttpStatus.OK);
		
		}catch(Exception ex) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/addMedicalRecord")
	public MedicalRecord  addMedicalRecord(@RequestBody MedicalRecordDTO medicalRecordDTO) {
		
		return medicalRecordService.addMedicalRecord(medicalRecordDTO);
	}
	
	@PutMapping("/updateMedicalRecord/{medicalRecord_id}")
	public ResponseEntity<MedicalRecord>  updateMedicalRecord(@PathVariable(value = "medicalRecord_id") Long medicalRecord_id,@RequestBody MedicalRecordDTO medicalRecordDTO) {
		
		try {
		MedicalRecord updateMedicalRecord = medicalRecordService.updateMedicalRecord(medicalRecord_id, medicalRecordDTO);
		
		return new ResponseEntity<MedicalRecord>(updateMedicalRecord, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
	
	@DeleteMapping("/deleteMedicalRecord/{medicalRecord_id}")
	public void  deleteMedicalRecord(@PathVariable(value = "medicalRecord_id") Long medicalRecord_id) {
		
		 medicalRecordService.deleteMedicalRecord(medicalRecord_id);
	}

}
