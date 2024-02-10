package com.hexaware.amazecare.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.amazecare.entities.MedicalRecord;
import com.hexaware.amazecare.entities.RecommendedMedicine;
import com.hexaware.amazecare.entities.RecommendedTests;
import com.hexaware.amazecare.exception.MedicalRecordNotFoundException;
import com.hexaware.amazecare.service.IMedicalRecordService;

@RestController
@RequestMapping("/api/medicalrecord")
public class MedicalRecordRestController {

	
	@Autowired
	IMedicalRecordService medicalService;
	
	Logger logger = LoggerFactory.getLogger(DoctorRestController.class);
	
	@GetMapping("/viewmedicalrecord/{patientId}")
	public List<MedicalRecord> viewMedicalRecord(@PathVariable int patientId) throws MedicalRecordNotFoundException
	{
		List<MedicalRecord> medicalRecord = medicalService.viewMedicalRecord(patientId);
        if (medicalRecord == null || medicalRecord.isEmpty()) {
        	logger.info("Exception occured while fetching medical record for patient id: " + patientId);
            throw new MedicalRecordNotFoundException("No record found for patient with id: " +patientId);
        }
        return medicalRecord;
	}
	
	@GetMapping("/getrecommendedtests/{recordId}")
	public List<RecommendedTests> viewRecommendedTests(@PathVariable int recordId) throws MedicalRecordNotFoundException
	{
		List<RecommendedTests> recommendedTests = medicalService.viewRecommendedTests(recordId);
        if (recommendedTests == null || recommendedTests.isEmpty()) {
        	logger.info("Exception occured while fetching recommended tests for record id: " + recordId);
            throw new MedicalRecordNotFoundException("Record with ID " + recordId + " not found.");
        }
        return recommendedTests;
	}

	@GetMapping("/getrecommendedmedicine/{recordId}")
	public List<RecommendedMedicine> viewRecommendedMedicine(@PathVariable int recordId) throws MedicalRecordNotFoundException
	{
		List<RecommendedMedicine> recommendedMedicine = medicalService.viewRecommendedMedicine(recordId);
		if (recommendedMedicine == null || recommendedMedicine.isEmpty()) {
        	logger.info("Exception occured while fetching recommended medicine for record id: " + recordId);
            throw new MedicalRecordNotFoundException("Record with ID " + recordId + " not found.");
        }
        return recommendedMedicine;
	}
}
