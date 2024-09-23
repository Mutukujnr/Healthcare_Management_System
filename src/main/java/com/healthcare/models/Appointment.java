package com.healthcare.models;

import java.sql.Date;
import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
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
public class Appointment {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long appointment_id;
	    private Date appointmentDate;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "patient_id")
	    private Patient patient;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "doctor_id")
	    private Doctor doctor;

	    @OneToOne(mappedBy = "appointment", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private Prescription prescription;
}
