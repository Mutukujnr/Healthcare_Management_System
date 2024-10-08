package com.healthcare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healthcare.models.Prescription;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Long>{

}
