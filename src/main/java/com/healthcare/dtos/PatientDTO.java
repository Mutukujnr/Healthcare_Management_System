package com.healthcare.dtos;

import java.util.List;

import com.healthcare.models.Appointment;
import com.healthcare.models.MedicalRecord;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

public class PatientDTO {

	private String name;
	private String email;
	private String phoneNumber;

	private List<Appointment> appointments;

	private List<MedicalRecord> medicalRecords;

	public PatientDTO() {
		super();
	}

	public PatientDTO(String name, String email, String phoneNumber, List<Appointment> appointments,
			List<MedicalRecord> medicalRecords) {
		super();
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.appointments = appointments;
		this.medicalRecords = medicalRecords;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public List<MedicalRecord> getMedicalRecords() {
		return medicalRecords;
	}

	public void setMedicalRecords(List<MedicalRecord> medicalRecords) {
		this.medicalRecords = medicalRecords;
	}
	
	

}
