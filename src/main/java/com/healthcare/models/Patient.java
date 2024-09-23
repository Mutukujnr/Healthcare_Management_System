package com.healthcare.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long patient_id;
	    private String name;
	    private String email;
	    private String phoneNumber;

	    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private List<Appointment> appointments;

	    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private List<MedicalRecord> medicalRecords;

	    
	    
	    
	    
		public Patient() {
			super();
		}





		public Patient(String name, String email, String phoneNumber, List<Appointment> appointments,
				List<MedicalRecord> medicalRecords) {
			super();
			this.name = name;
			this.email = email;
			this.phoneNumber = phoneNumber;
			this.appointments = appointments;
			this.medicalRecords = medicalRecords;
		}





		public Long getPatient_id() {
			return patient_id;
		}





		public void setPatient_id(Long patient_id) {
			this.patient_id = patient_id;
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
