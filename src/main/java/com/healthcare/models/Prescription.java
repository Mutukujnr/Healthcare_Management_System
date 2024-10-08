package com.healthcare.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Prescription {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prescription_id;
    private String medicine;
    private String dosage;

    @OneToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

	public Prescription() {
		super();
	}

	public Prescription(String medicine, String dosage, Appointment appointment, Doctor doctor) {
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
