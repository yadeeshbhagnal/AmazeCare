package com.hexaware.amazecare.service;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import com.hexaware.amazecare.entities.MedicalRecord;
import com.hexaware.amazecare.entities.Patient;
import com.hexaware.amazecare.entities.RecommendedMedicine;
import com.hexaware.amazecare.entities.RecommendedTests;
import com.hexaware.amazecare.repository.MedicalRecordRepository;
import com.hexaware.amazecare.repository.PatientRepository;
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
	
	@Autowired
	PatientRepository patientRepository;
	
	Logger logger = LoggerFactory.getLogger(MedicalRecordServiceImp.class);

	
	@Override
	public List<MedicalRecord> viewMedicalRecordDoc(int patientId) {
		logger.info("Request initiated to view medical record for patient with id: " + patientId);
		return medicalRecordRepository.findByPatientPatientId(patientId);
	}
	
	
	@Override
	public List<MedicalRecord> viewMedicalRecordPatient() {
		Patient patient = getCurrentPatient().get();
		return medicalRecordRepository.findByPatientPatientId(patient.getPatientId());

	}

	@Override
	public List<RecommendedTests> viewRecommendedTests(int recordId) {
		
		String role = getCurrentRole();
		
		List<RecommendedTests> testList = null;
		logger.info("Request initiated to view recommended test for patient with id: " + recordId);
		if(role.equals("Doctor"))
		{
			testList = recommendedTestsRepository.findByMedicalRecordRecordId(recordId);
		}else if(role.equals("Patient")) {
			Patient patient = getCurrentPatient().get();
			if(medicalRecordRepository.findById(recordId).get().getPatient().getPatientId() == patient.getPatientId()) {
				testList = recommendedTestsRepository.findByMedicalRecordRecordId(recordId);
			}
		}
		return testList;
	}

	@Override
	public List<RecommendedMedicine> viewRecommendedMedicine(int recordId) {
		String role = getCurrentRole();
		List<RecommendedMedicine> medicineList = null;
		if(role.equals("Doctor"))
		{	
			medicineList = recommendedMedicineRepository.findByMedicalRecordRecordId(recordId);
		}else if(role.equals("Patient")) {
			Patient patient = getCurrentPatient().get();
			if(medicalRecordRepository.findById(recordId).get().getPatient().getPatientId() == patient.getPatientId()) {
				medicineList = recommendedMedicineRepository.findByMedicalRecordRecordId(recordId);
			}
		}
		return medicineList;
	}
	
	private Optional<Patient> getCurrentPatient(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		return patientRepository.findByUserName(username);
	}
	
	private String getCurrentRole() {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    GrantedAuthority authority = auth.getAuthorities().stream().findFirst().orElse(null);
	    return authority != null ? authority.getAuthority() : null;
	}
}
