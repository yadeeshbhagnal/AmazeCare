package com.hexaware.amazecare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.amazecare.entities.RecommendedTests;

public interface RecommendedTestsRepository extends JpaRepository<RecommendedTests, Integer>{

	public List<RecommendedTests> findByMedicalRecordRecordId(int recordId);
}
