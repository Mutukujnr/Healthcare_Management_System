package com.healthcare.dtos;

import java.sql.Date;
import java.time.LocalDateTime;

import com.healthcare.models.Doctor;
import com.healthcare.models.Patient;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class MedicalRecordDTO {

	 private String diagnosis;
	    private Date recordDate;

	    private Patient patient;

	    
	    private Doctor doctor;


		public MedicalRecordDTO() {
			super();
		}


		public MedicalRecordDTO(String diagnosis, Date recordDate, Patient patient, Doctor doctor) {
			super();
			this.diagnosis = diagnosis;
			this.recordDate = recordDate;
			this.patient = patient;
			this.doctor = doctor;
		}


		public String getDiagnosis() {
			return diagnosis;
		}


		public void setDiagnosis(String diagnosis) {
			this.diagnosis = diagnosis;
		}


		public Date getRecordDate() {
			return recordDate;
		}


		public void setRecordDate(Date recordDate) {
			this.recordDate = recordDate;
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
	    
	    
}
