package com.healthcare.services;

import com.healthcare.dtos.PrescriptionDTO;
import com.healthcare.models.Prescription;

public interface IPrescription {

Prescription findById(Long id);

	
	Prescription addPrescription(PrescriptionDTO prescriptionDTO);

	Prescription updatePrescription(Long id, PrescriptionDTO prescriptionDTO);

	void deletePrescription(Long id);
}
