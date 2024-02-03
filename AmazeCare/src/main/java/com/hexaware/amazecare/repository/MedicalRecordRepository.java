package com.hexaware.amazecare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.amazecare.entities.MedicalRecord;

@Repository
public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Integer>{

	List<MedicalRecord> findByPatientPatientId(int patientId);

	
}
