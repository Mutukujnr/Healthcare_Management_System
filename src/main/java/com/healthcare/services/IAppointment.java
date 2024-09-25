package com.healthcare.services;

import com.healthcare.dtos.AppointmentDTO;
import com.healthcare.models.Appointment;

public interface IAppointment {

	Appointment findById(Long id);

	
	Appointment addAppointment(AppointmentDTO appointmentDTO);

	Appointment updateAppointment(Long id, AppointmentDTO appointmentDTO);

	void deleteAppointment(Long id);
}
