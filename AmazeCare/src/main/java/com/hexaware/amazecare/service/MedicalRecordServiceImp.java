package com.hexaware.amazecare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.amazecare.dto.MedicalRecordDto;
import com.hexaware.amazecare.entities.MedicalRecord;
import com.hexaware.amazecare.entities.RecommendedMedicine;
import com.hexaware.amazecare.entities.RecommendedTests;
import com.hexaware.amazecare.repository.MedicalRecordRepository;
import com.hexaware.amazecare.repository.RecommendedMedicineRepository;
import com.hexaware.amazecare.repository.RecommendedTestsRepository;

@Service
public class MedicalRecordServiceImp implements IMedicalRecordService {

	@Autowired
	MedicalRecordRepository medicalRecordRepository;
	
	@Autowired
	RecommendedTestsRepository recommendedTestsRepository;
	
	@Autowired
	RecommendedMedicineRepository recommendedMedicineRepository;
	
	@Override
	public List<MedicalRecord> viewMedicalRecord(int patientId) {
		return medicalRecordRepository.findByPatientPatientId(patientId);

	}

	@Override
	public List<RecommendedTests> viewRecommendedTests(int recordId) {
		return recommendedTestsRepository.findByMedicalRecordRecordId(recordId);
	}

	@Override
	public List<RecommendedMedicine> viewRecommendedMedicine(int recordId) {
		
		return recommendedMedicineRepository.findByMedicalRecordRecordId(recordId);
	}

}
