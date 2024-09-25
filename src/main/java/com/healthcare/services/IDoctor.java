package com.healthcare.services;

import java.util.List;

import com.healthcare.dtos.DoctorDTO;
import com.healthcare.models.Doctor;

public interface IDoctor {

List<Doctor> allDoctors();
	
	Doctor findById(Long id);
	
	Doctor findByName(String name);
	
	Doctor addDoctor(DoctorDTO doctorDTO);
	
	Doctor updateDoctor(Long id, DoctorDTO doctorDTO);
	
	void deleteDoctor(Long id);
}
