package com.hexaware.amazecare.service;

import static org.junit.jupiter.api.Assertions.assertFalse;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.hexaware.amazecare.dto.AppointmentDto;
import com.hexaware.amazecare.dto.AuthRequest;
import com.hexaware.amazecare.dto.PatientDto;
import com.hexaware.amazecare.dto.PatientViewDto;
import com.hexaware.amazecare.entities.Appointment;
import com.hexaware.amazecare.entities.Doctor;
import com.hexaware.amazecare.exception.DoctorNotFoundException;
import com.hexaware.amazecare.exception.PatientNotFoundException;
import com.hexaware.amazecare.repository.AppointmentRepository;

@SpringBootTest
class PatientServiceImpTest {

	@Autowired
	IPatientService service;
	
	@Autowired
	AppointmentRepository appointmentRepo;

	
	@BeforeEach
	void setUp(){
		Authentication auth = new UsernamePasswordAuthenticationToken("Sanket123","Sanket1234"); 
		SecurityContextHolder.getContext().setAuthentication(auth);
	}
	
	

	@Test
	void testUpdatePatientInfo() {
		
		PatientDto patientDto = new PatientDto();
		patientDto.setAddress("Indore");
		boolean result = service.updatePatientInfo(patientDto);
		assertTrue(result);	
	}

	@Test
	void testScheduleAppointment() throws DoctorNotFoundException, PatientNotFoundException {
		
		AppointmentDto appointmentDto = new AppointmentDto();
	
		appointmentDto.setDate(LocalDate.of(2024,03,05));
		appointmentDto.setSymptoms("nausea");
		appointmentDto.setVisitType("general checkup");
		
		
		boolean result = service.scheduleAppointment(appointmentDto,752);
		assertTrue(result);
		
	}

	@Test
	void testRescheduleAppointment() {
		boolean result = service.rescheduleAppointment(304, LocalDate.now());
		assertTrue(result);
	}

	@Test
	void testCancelAppointment() {
		boolean result = service.cancelAppointment(6);
		assertFalse(result);
	}

	@Test
	void testViewAppointments() {
		List<Appointment>list = service.viewAppointments();
		assertNotNull(list);	
	}
	
	@Test
	void testGetDocBySpeciality() {
		
		List<Doctor>list = service.getDocBySpeciality("Ortho");
		assertFalse(list.isEmpty());	
	}
	
	@Test
	void testViewUpcomingAppointments() {
		List<PatientViewDto> list = service.viewUpcomingAppointments();
		assertNotNull(list);
	}
	
	@Test
	void testRegisterPatient() {
		PatientDto patient = new PatientDto();
		patient.setPatientName("Abhishek");
		patient.setContactNumber("7256324595");
		patient.setAge(32);
		patient.setUserName("Abhishek123");
		patient.setPassword("Abhishek1234");
		LocalDate date = LocalDate.of(1996,06,06);
		patient.setDateOfBirth(date);
		service.registerPatient(patient);
	}
	
	@Test
	void  testPatientLoginTest() {
		
		AuthRequest authRequest = new AuthRequest();
		authRequest.setUsername("Sanket123");
		authRequest.setPassword("Sanket12345");
		assertNotNull(service.loginPatient(authRequest));
	}
}
