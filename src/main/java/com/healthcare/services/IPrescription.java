package com.healthcare.services;

import java.util.List;

import com.healthcare.dtos.PrescriptionDTO;
import com.healthcare.models.Doctor;
import com.healthcare.models.Prescription;

public interface IPrescription {
	List<Prescription> allPrescriptions();

	Prescription findById(Long id);

	Prescription findByName(String name);

	Prescription addPrescription(PrescriptionDTO prescriptionDTO);

	Prescription updatePrescription(Long id, PrescriptionDTO prescriptionDTO);

	void deletePrescription(Long id);
}
