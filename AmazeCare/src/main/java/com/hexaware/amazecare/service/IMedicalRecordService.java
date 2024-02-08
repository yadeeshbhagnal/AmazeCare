package com.hexaware.amazecare.service;

import java.util.List;

import com.hexaware.amazecare.dto.MedicalRecordDto;
import com.hexaware.amazecare.entities.MedicalRecord;
import com.hexaware.amazecare.entities.RecommendedMedicine;
import com.hexaware.amazecare.entities.RecommendedTests;

public interface IMedicalRecordService {

	public List<MedicalRecord> viewMedicalRecord(int patientId);
	
	public List<RecommendedTests> viewRecommendedTests(int recordId);
	
	public List<RecommendedMedicine> viewRecommendedMedicine(int recordId);
	
}
