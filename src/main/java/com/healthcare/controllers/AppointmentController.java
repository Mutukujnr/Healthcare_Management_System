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

import com.healthcare.dtos.AppointmentDTO;
import com.healthcare.models.Appointment;
import com.healthcare.services.AppointmentService;

@RestController
public class AppointmentController {
	
	@Autowired
	AppointmentService appointmentService;

	@GetMapping("/appointments")
	public List<Appointment> getAllAppointments() {
		
		return appointmentService.allAppointments();
	}
	
	@GetMapping("/appointment/{appointment_id}")
	public ResponseEntity<Appointment> getAppointmentById(@PathVariable(value = "appointment_id") Long appointment_id) {
		
		try {
		Appointment appointment = appointmentService.findById(appointment_id);
		return new ResponseEntity<Appointment>(appointment, HttpStatus.OK);
		
		}catch(Exception ex) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/appointment/name")
	public ResponseEntity<Appointment> getAppointmentByName(@RequestParam(value = "name") String name) {
		
		try {
			Appointment Appointment = appointmentService.findByName(name);
		return new ResponseEntity<Appointment>(Appointment, HttpStatus.OK);
		
		}catch(Exception ex) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/addAppointment")
	public Appointment  addAppointment(@RequestBody AppointmentDTO AppointmentDTO) {
		
		return appointmentService.addAppointment(AppointmentDTO);
	}
	
	@PutMapping("/updateAppointment/{appointment_id}")
	public ResponseEntity<Appointment>  updateAppointment(@PathVariable(value = "appointment_id") Long appointment_id,@RequestBody AppointmentDTO AppointmentDTO) {
		
		try {
		Appointment updateAppointment = appointmentService.updateAppointment(appointment_id, AppointmentDTO);
		
		return new ResponseEntity<Appointment>(updateAppointment, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
	
	@DeleteMapping("/deleteAppointment/{appointment_id}")
	public void  deleteAppointment(@PathVariable(value = "appointment_id") Long appointment_id) {
		
		 appointmentService.deleteAppointment(appointment_id);
	}

}
