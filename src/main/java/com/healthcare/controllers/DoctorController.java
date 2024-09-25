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

import com.healthcare.dtos.DoctorDTO;
import com.healthcare.dtos.PatientDTO;
import com.healthcare.models.Doctor;
import com.healthcare.models.Patient;
import com.healthcare.services.DoctorService;

@RestController
public class DoctorController {
	
	@Autowired
	DoctorService doctorService;

	@GetMapping("/doctors")
	public List<Doctor> getAllDoctors() {
		
		return doctorService.allDoctors();
	}
	
	@GetMapping("/doctor/{doctor_id}")
	public ResponseEntity<Doctor> getDoctorById(@PathVariable(value = "doctor_id") Long doctor_id) {
		
		try {
		Doctor doctor = doctorService.findById(doctor_id);
		return new ResponseEntity<Doctor>(doctor, HttpStatus.OK);
		
		}catch(Exception ex) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/doctor/name")
	public ResponseEntity<Doctor> getDoctorByName(@RequestParam(value = "name") String name) {
		
		try {
			Doctor doctor = doctorService.findByName(name);
		return new ResponseEntity<Doctor>(doctor, HttpStatus.OK);
		
		}catch(Exception ex) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/addDoctor")
	public Doctor  addDoctor(@RequestBody DoctorDTO doctorDTO) {
		
		return doctorService.addDoctor(doctorDTO);
	}
	
	@PutMapping("/updateDoctor/{doctor_id}")
	public ResponseEntity<Doctor>  updateDoctor(@PathVariable(value = "doctor_id") Long doctor_id,@RequestBody DoctorDTO doctorDTO) {
		
		try {
		Doctor updateDoctor = doctorService.updateDoctor(doctor_id, doctorDTO);
		
		return new ResponseEntity<Doctor>(updateDoctor, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
	
	@DeleteMapping("/deleteDoctor/{doctor_id}")
	public void  deleteDoctor(@PathVariable(value = "doctor_id") Long doctor_id) {
		
		 doctorService.deleteDoctor(doctor_id);
	}

}
