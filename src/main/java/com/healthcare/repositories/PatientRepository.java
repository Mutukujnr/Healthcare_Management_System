package com.healthcare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healthcare.models.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{

	Patient findByName(String name);

}
