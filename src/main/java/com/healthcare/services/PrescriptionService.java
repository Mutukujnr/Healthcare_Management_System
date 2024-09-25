package com.healthcare.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.dtos.PrescriptionDTO;
import com.healthcare.models.Prescription;
import com.healthcare.repositories.PrescriptionRepository;

@Service
public class PrescriptionService implements IPrescription{

	
	@Autowired
	PrescriptionRepository prescriptionRepository;
	@Override
	public Prescription findById(Long id) {
		
		return prescriptionRepository.findById(id).get();
	}

	@Override
	public Prescription addPrescription(PrescriptionDTO prescriptionDTO) {
		Prescription prescription = new Prescription(prescriptionDTO.getMedicine(),prescriptionDTO.getDosage(),prescriptionDTO.getAppointment(),prescriptionDTO.getDoctor());
		return prescriptionRepository.save(prescription);
	}

	@Override
	public Prescription updatePrescription(Long id, PrescriptionDTO prescriptionDTO) {
		
		Prescription prescription = null;
		
		prescription = prescriptionRepository.findById(id).get();
		
		if(prescription != null) {
			prescription.setMedicine(prescriptionDTO.getMedicine());
			prescription.setDosage(prescriptionDTO.getDosage());
			prescription.setAppointment(prescriptionDTO.getAppointment());
			prescription.setDoctor(prescriptionDTO.getDoctor());
		}
		
		return prescriptionRepository.save(prescription);
	}

	@Override
	public void deletePrescription(Long id) {
		prescriptionRepository.deleteById(id);
		
	}

}
