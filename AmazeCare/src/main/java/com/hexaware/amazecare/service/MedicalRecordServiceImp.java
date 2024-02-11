package com.hexaware.amazecare.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.hexaware.amazecare.dto.MedicalRecordDto;
import com.hexaware.amazecare.entities.MedicalRecord;
import com.hexaware.amazecare.entities.Patient;
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
	
	Logger logger = LoggerFactory.getLogger(MedicalRecordServiceImp.class);

	
	@Override
	public List<MedicalRecord> viewMedicalRecord(int patientId) {
		logger.info("Request initiated to view medical record for patient with id: " + patientId);
		return medicalRecordRepository.findByPatientPatientId(patientId);

	}

	@Override
	public List<RecommendedTests> viewRecommendedTests(int recordId) {
		logger.info("Request initiated to view recommended test for patient with id: " + recordId);
		return recommendedTestsRepository.findByMedicalRecordRecordId(recordId);
	}

	@Override
	public List<RecommendedMedicine> viewRecommendedMedicine(int recordId) {
		logger.info("Request initiated to view recommended medicined for patient with id: " + recordId);
		return recommendedMedicineRepository.findByMedicalRecordRecordId(recordId);
	}

	private String getCurrentRole(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		GrantedAuthority authority = auth.getAuthorities().stream().findFirst().orElse(null);
		return authority!= null ? authority.getAuthority() : null;
	}
}
