package com.healthcare.dtos;

import java.util.List;

import com.healthcare.models.Appointment;
import com.healthcare.models.Prescription;

public class DoctorDTO {
    private String name;
    private String specialization;
    private String email;

    
    private List<Appointment> appointments;

   
    private List<Prescription> prescriptions;

    public DoctorDTO() {}

	public DoctorDTO(String name, String specialization, String email, List<Appointment> appointments,
			List<Prescription> prescriptions) {
		super();
		this.name = name;
		this.specialization = specialization;
		this.email = email;
		this.appointments = appointments;
		this.prescriptions = prescriptions;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public List<Prescription> getPrescriptions() {
		return prescriptions;
	}

	public void setPrescriptions(List<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}
    
    
    
}
