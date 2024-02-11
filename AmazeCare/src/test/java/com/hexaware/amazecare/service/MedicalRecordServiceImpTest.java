package com.hexaware.amazecare.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.amazecare.entities.MedicalRecord;
import com.hexaware.amazecare.entities.RecommendedMedicine;
import com.hexaware.amazecare.entities.RecommendedTests;

@SpringBootTest
class MedicalRecordServiceImpTest {

	@Autowired
	IMedicalRecordService medicalService;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

//	@Test
//	void testViewMedicalRecord() {
//		List<MedicalRecord> list = medicalService.viewMedicalRecord(38);
//		assertTrue(list.isEmpty());
//	}

	@Test
	void testViewRecommendedTests() {
		List<RecommendedTests> list = medicalService.viewRecommendedTests(105);
		assertTrue(list.isEmpty());
	}

	@Test
	void testViewRecommendedMedicine() {
		List<RecommendedMedicine> list = medicalService.viewRecommendedMedicine(105);
		assertTrue(list.isEmpty());
	}

}
