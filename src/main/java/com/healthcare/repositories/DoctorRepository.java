package com.healthcare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healthcare.models.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long>{

	Doctor findByName(String name);
}
