package com.hexaware.amazecare.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;


import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.hexaware.amazecare.entities.MedicalRecord;
import com.hexaware.amazecare.repository.MedicalRecordRepository;

@SpringBootTest
class MedicalRecordServiceImpTest {
	
	@Autowired
	IMedicalRecordService medicalService;
	
	@Autowired
	MedicalRecordRepository medicalRecordRepository;
	
	@BeforeEach
	void setUp() {
		Authentication auth = new UsernamePasswordAuthenticationToken("Chris11","chrish123"); 
		SecurityContextHolder.getContext().setAuthentication(auth);
	}

	@Test
	void testViewMedicalRecordDoc() {
		List<MedicalRecord> list = medicalService.viewMedicalRecordDoc(1);
		assertNotNull(list);
		
	}

	@Test
	void testViewMedicalRecordPatient() {
		List<MedicalRecord> list = medicalService.viewMedicalRecordPatient();
		assertNotNull(list);
	}

	@Test
	void testViewRecommendedTests() {
		List<MedicalRecord> list = medicalService.viewMedicalRecordDoc(1);
		assertNotNull(list);
	}

	@Test
	void testViewRecommendedMedicine() {
		List<MedicalRecord> list = medicalService.viewMedicalRecordDoc(1);
		assertNotNull(list);
	}

}
