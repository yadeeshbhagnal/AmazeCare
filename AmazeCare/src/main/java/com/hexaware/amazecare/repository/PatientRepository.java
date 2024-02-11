package com.hexaware.amazecare.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.amazecare.entities.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer>{
	
    Optional<Patient> findByUserName(String username);

}
