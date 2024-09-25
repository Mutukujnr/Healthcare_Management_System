package com.healthcare.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.dtos.AppointmentDTO;
import com.healthcare.dtos.MedicalRecordDTO;
import com.healthcare.models.Appointment;
import com.healthcare.models.MedicalRecord;
import com.healthcare.repositories.AppointmentRepository;
import com.healthcare.repositories.MedicalRecordRepository;

@Service
public class MedicalRecordService implements IMedicalRecord{
	
	@Autowired
	MedicalRecordRepository medicalRecordRepository;

	@Override
	public MedicalRecord findById(Long id) {
		
		return medicalRecordRepository.findById(id).get();
	}

	@Override
	public MedicalRecord addMedicalRecord(MedicalRecordDTO medicalRecordDTO) {
		
		MedicalRecord medicalRecord = new MedicalRecord(medicalRecordDTO.getDiagnosis(),medicalRecordDTO.getRecordDate(),medicalRecordDTO.getPatient(),medicalRecordDTO.getDoctor());
		return medicalRecordRepository.save(medicalRecord);
	}

	@Override
	public MedicalRecord updateMedicalRecord(Long id, MedicalRecordDTO medicalRecordDTO) {
	
		MedicalRecord medicalRecord = null;
		
		medicalRecord = medicalRecordRepository.findById(id).get();
		
		if(medicalRecord != null) {
			medicalRecord.setDiagnosis(medicalRecordDTO.getDiagnosis());
			medicalRecord.setRecordDate(medicalRecordDTO.getRecordDate());
			medicalRecord.setPatient(medicalRecordDTO.getPatient());
			medicalRecord.setDoctor(medicalRecordDTO.getDoctor());
		}
		
		return medicalRecordRepository.save(medicalRecord);
	}

	@Override
	public void deleteMedicalRecord(Long id) {
		
		medicalRecordRepository.deleteById(id);
		
	}
	
}
