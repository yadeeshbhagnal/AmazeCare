package com.hexaware.amazecare.service;

import java.util.List;

import com.hexaware.amazecare.dto.MedicalRecordDto;
import com.hexaware.amazecare.entities.MedicalRecord;
import com.hexaware.amazecare.entities.RecommendedMedicine;
import com.hexaware.amazecare.entities.RecommendedTests;
import com.hexaware.amazecare.exception.MedicalRecordNotFoundException;

public interface IMedicalRecordService {

	public List<MedicalRecord> viewMedicalRecordDoc(int patientId);
	
	public List<RecommendedTests> viewRecommendedTests(int recordId);
	
	public List<RecommendedMedicine> viewRecommendedMedicine(int recordId);

	public List<MedicalRecord> viewMedicalRecordPatient();
	
}
