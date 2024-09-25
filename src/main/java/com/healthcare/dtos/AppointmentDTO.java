package com.healthcare.dtos;

import java.sql.Date;

import com.healthcare.models.Doctor;
import com.healthcare.models.Patient;
import com.healthcare.models.Prescription;

public class AppointmentDTO {

	 private Date appointmentDate;

	   
	    private Patient patient;

	    
	    private Doctor doctor;

	    
	    private Prescription prescription;


		public AppointmentDTO() {
			super();
		}


		public AppointmentDTO(Date appointmentDate, Patient patient, Doctor doctor, Prescription prescription) {
			super();
			this.appointmentDate = appointmentDate;
			this.patient = patient;
			this.doctor = doctor;
			this.prescription = prescription;
		}


		public Date getAppointmentDate() {
			return appointmentDate;
		}


		public void setAppointmentDate(Date appointmentDate) {
			this.appointmentDate = appointmentDate;
		}


		public Patient getPatient() {
			return patient;
		}


		public void setPatient(Patient patient) {
			this.patient = patient;
		}


		public Doctor getDoctor() {
			return doctor;
		}


		public void setDoctor(Doctor doctor) {
			this.doctor = doctor;
		}


		public Prescription getPrescription() {
			return prescription;
		}


		public void setPrescription(Prescription prescription) {
			this.prescription = prescription;
		}
	    
	    
}
