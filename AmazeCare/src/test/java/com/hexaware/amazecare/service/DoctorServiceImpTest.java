package com.hexaware.amazecare.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import com.hexaware.amazecare.dto.AppointmentDetailsDto;
import com.hexaware.amazecare.dto.AuthRequest;
import com.hexaware.amazecare.dto.MedicalRecordDto;
import com.hexaware.amazecare.dto.RecommendedMedicineDto;
import com.hexaware.amazecare.dto.RecommendedTestsDto;
import com.hexaware.amazecare.entities.Appointment;
import com.hexaware.amazecare.exception.MedicalRecordNotFoundException;
import com.hexaware.amazecare.exception.MedicineNotFoundException;
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
	
	@BeforeEach
	void setUp() {
		Authentication auth = new UsernamePasswordAuthenticationToken("Piyush123","Piyush1234"); 
		SecurityContextHolder.getContext().setAuthentication(auth);
	}
	
	
	@Test
	void testLoginDoctor() {
		AuthRequest authRequest = new AuthRequest();
		authRequest.setUsername("Piyush123");
		authRequest.setPassword("Piyush1234");
		assertNotNull(doctorService.loginDoctor(authRequest));
	}
	
	@Test
	void testViewAppointments() {
		List<AppointmentDetailsDto> list = doctorService.viewAppointments();
		assertNotNull(list);
	}

	@Test
	void testAcceptAppointment() {
		doctorService.acceptAppointment(103);
		Appointment appointment = appointmentRepository.findById(103).orElse(null);
		String status = appointment.getStatus();
		assertEquals("Accepted", status);
	}

	@Test
	void testRejectAppointment() {
		boolean result = doctorService.rejectAppointment(103);
		assertFalse(result);
	}

	@Test
	void testRescheduleAppointment() {
		boolean result = doctorService.rescheduleAppointment(150, LocalDate.now());
		assertFalse(result);
	}
	
	@Test
	void testCreateMedicalRecord() {
		MedicalRecordDto medicalRecordDto = new MedicalRecordDto(156,"runnny nose","mild fever","medicine for 3 days",LocalDate.now());
		assertTrue(doctorService.createMedicalRecord(medicalRecordDto,103));
	}
	
	@Test 
	void testPrescribeMedicine() {
		RecommendedMedicineDto recommendedMedicineDto = new RecommendedMedicineDto();
		recommendedMedicineDto.setMedicineName("sipnol");
		recommendedMedicineDto.setDosage("0-0-1 AF");
		recommendedMedicineDto.setQuantity(10);
		assertThrows(MedicineNotFoundException.class, () -> {doctorService.prescribeMedicine(recommendedMedicineDto,952);});
		
	}
	
	@Test 
	void testPrescribeTest() {
		RecommendedTestsDto recommendedTestsDto = new RecommendedTestsDto();
		recommendedTestsDto.setTestName("blood test");
		assertThrows(MedicalRecordNotFoundException.class, () ->  {doctorService.prescribeTest(recommendedTestsDto,560);});
	}
	
	@Test
	void testUpdateTestResult() {
		boolean result = doctorService.updateTestResult(252,"negative");
		assertTrue(result);
	}
	}
