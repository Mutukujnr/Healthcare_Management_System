package com.healthcare.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.dtos.AppointmentDTO;
import com.healthcare.models.Appointment;
import com.healthcare.repositories.AppointmentRepository;

@Service
public class AppointmentService implements IAppointment{
	
	@Autowired
	AppointmentRepository appointmentRepository;

	@Override
	public Appointment findById(Long id) {
		
		return appointmentRepository.findById(id).get();
	}

	

	@Override
	public Appointment addAppointment(AppointmentDTO appointmentDTO) {
		
		Appointment appointment = new Appointment(appointmentDTO.getAppointmentDate(),appointmentDTO.getPatient(),appointmentDTO.getDoctor(),appointmentDTO.getPrescription());
		return null;
	}

	@Override
	public Appointment updateAppointment(Long id, AppointmentDTO appointmentDTO) {
		 Appointment appointment = null;
		 
		 appointment = appointmentRepository.findById(id).get();
		 
		 if(appointment != null) {
			 appointment.setAppointmentDate(appointmentDTO.getAppointmentDate());
			 appointment.setPatient(appointmentDTO.getPatient());
			 appointment.setDoctor(appointmentDTO.getDoctor());
			 appointment.setPrescription(appointmentDTO.getPrescription());
		 }
		return appointmentRepository.save(appointment);
	}

	@Override
	public void deleteAppointment(Long id) {
		appointmentRepository.deleteById(id);
		
	}

}
