package com.healthcare.dtos;

import com.healthcare.models.Appointment;
import com.healthcare.models.Doctor;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrescriptionDTO {

	
    private Long prescription_id;
    private String medicine;
    private String dosage;

   
    private Appointment appointment;

   
    private Doctor doctor;

	public PrescriptionDTO() {
		super();
	}

	public PrescriptionDTO(String medicine, String dosage, Appointment appointment, Doctor doctor) {
		super();
		this.medicine = medicine;
		this.dosage = dosage;
		this.appointment = appointment;
		this.doctor = doctor;
	}

	public Long getPrescription_id() {
		return prescription_id;
	}

	public void setPrescription_id(Long prescription_id) {
		this.prescription_id = prescription_id;
	}

	public String getMedicine() {
		return medicine;
	}

	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}

	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}	
    
    
}
