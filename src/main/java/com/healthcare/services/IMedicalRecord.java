package com.healthcare.services;

import java.util.List;

import com.healthcare.dtos.MedicalRecordDTO;
import com.healthcare.models.Doctor;
import com.healthcare.models.MedicalRecord;

public interface IMedicalRecord {
	List<MedicalRecord> allMedicalRecords();

	MedicalRecord findById(Long id);
	
	 MedicalRecord findByName(String name);

	
	MedicalRecord addMedicalRecord(MedicalRecordDTO medicalRecordDTO);

	MedicalRecord updateMedicalRecord(Long id, MedicalRecordDTO medicalRecordDTO);

	void deleteMedicalRecord(Long id);
}
