package com.healthcare.services;

import com.healthcare.dtos.MedicalRecordDTO;
import com.healthcare.models.MedicalRecord;

public interface IMedicalRecord {

	MedicalRecord findById(Long id);

	
	MedicalRecord addMedicalRecord(MedicalRecordDTO medicalRecordDTO);

	MedicalRecord updateMedicalRecord(Long id, MedicalRecordDTO medicalRecordDTO);

	void deleteMedicalRecord(Long id);
}
