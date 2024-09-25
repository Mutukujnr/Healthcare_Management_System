package com.healthcare.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.dtos.DoctorDTO;
import com.healthcare.models.Doctor;
import com.healthcare.repositories.DoctorRepository;

@Service
public class DoctorService implements IDoctor{

	@Autowired
	DoctorRepository doctorRepository;
	
	@Override
	public List<Doctor> allDoctors() {
		
		return doctorRepository.findAll();
	}

	@Override
	public Doctor findById(Long id) {
		
		return doctorRepository.findById(id).get();
	}

	@Override
	public Doctor findByName(String name) {
		
		return doctorRepository.findByName(name);
	}

	@Override
	public Doctor addDoctor(DoctorDTO doctorDTO) {
		Doctor doctor = new Doctor(doctorDTO.getName(),doctorDTO.getSpecialization(),doctorDTO.getEmail(),doctorDTO.getAppointments(),doctorDTO.getPrescriptions());
		return doctorRepository.save(doctor);
	}

	@Override
	public Doctor updateDoctor(Long id, DoctorDTO doctorDTO) {
		
		Doctor doctor = null;
		
		doctor = doctorRepository.findById(id).get();
		
		if(doctor != null) {
			doctor.setName(doctorDTO.getName());
			doctor.setSpecialization(doctorDTO.getSpecialization());
			doctor.setEmail(doctorDTO.getEmail());
			doctor.setAppointments(doctorDTO.getAppointments());
			doctor.setPrescriptions(doctorDTO.getPrescriptions());
		}
		
		return doctorRepository.save(doctor);
	}

	@Override
	public void deleteDoctor(Long id) {
		
		doctorRepository.deleteById(id);
		
	}

}
