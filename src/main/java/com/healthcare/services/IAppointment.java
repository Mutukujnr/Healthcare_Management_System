package com.healthcare.services;

import java.util.List;

import com.healthcare.dtos.AppointmentDTO;
import com.healthcare.models.Appointment;
import com.healthcare.models.Appointment;

public interface IAppointment {
	List<Appointment> allAppointments();

	Appointment findById(Long id);
	
	 Appointment findByName(String name);

	
	Appointment addAppointment(AppointmentDTO appointmentDTO);

	Appointment updateAppointment(Long id, AppointmentDTO appointmentDTO);

	void deleteAppointment(Long id);
}
