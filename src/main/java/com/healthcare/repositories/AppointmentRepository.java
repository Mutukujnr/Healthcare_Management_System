package com.healthcare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healthcare.models.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long>{

}
