package com.hexaware.amazecare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.amazecare.entities.RecommendedMedicine;
import com.hexaware.amazecare.entities.RecommendedTests;

public interface RecommendedMedicineRepository extends JpaRepository<RecommendedMedicine, Integer>{

	public List<RecommendedMedicine> findByMedicalRecordRecordId(int recordId);
}
