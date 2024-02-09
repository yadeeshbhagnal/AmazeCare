package com.hexaware.amazecare.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.hexaware.amazecare.dto.MedicalRecordDto;
import com.hexaware.amazecare.dto.RecommendedMedicineDto;
import com.hexaware.amazecare.dto.RecommendedTestsDto;
import com.hexaware.amazecare.entities.Appointment;
import com.hexaware.amazecare.repository.AppointmentRepository;
import com.hexaware.amazecare.repository.MedicalRecordRepository;

@SpringBootTest
class DoctorServiceImpTest {
	
	@Autowired
	IDoctorService doctorService;
	
	@Autowired
	AppointmentRepository appointmentRepository;
	
	@Autowired 
	MedicalRecordRepository medicalRecordRespository;

	@Test
	void testAcceptAppointment() {
		doctorService.acceptAppointment(102);
		Appointment appointment = appointmentRepository.findById(101).orElse(null);
		String status = appointment.getStatus();
		assertEquals("Accepted", status);
	}

	@Test
	void testRejectAppointment() {
		doctorService.rejectAppointment(102);
		Appointment appointment = appointmentRepository.findById(102).orElse(null);
		String status = appointment.getStatus();
		assertEquals("rejected", status);
	}

	@Test
	void testRescheduleAppointment() {
		boolean result = doctorService.rescheduleAppointment(101, LocalDate.now());
		assertTrue(result);
	}
	
	@Test
	void testCreateMedicalRecord() {
		MedicalRecordDto medicalRecordDto = new MedicalRecordDto(101,"cough and cold","sore throat","take medicine for 7 days",LocalDate.now(),101,452);
		boolean result = doctorService.createMedicalRecord(medicalRecordDto);
		assertTrue(result);
	}
	
	@Test 
	void testPrescribeMedicine() {
		RecommendedMedicineDto recommendedMedicineDto = new RecommendedMedicineDto(156,"para",20,"one after dinner",101);
		boolean result = doctorService.prescribeMedicine(recommendedMedicineDto);
		assertTrue(result);
	}
	
	@Test 
	void testPrescribeTest() {
		RecommendedTestsDto recommendedTestsDto = new RecommendedTestsDto(126,"typhoid test","not yet taken",453);
		boolean result = doctorService.prescribeTest(recommendedTestsDto);
		assertTrue(result);
	}
	
	@Test
	void testUpdateTestResult() {
		boolean result = doctorService.updateTestResult(1,"negative");
		assertTrue(result);
	}
}
