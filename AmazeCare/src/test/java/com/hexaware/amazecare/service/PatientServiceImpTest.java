package com.hexaware.amazecare.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.amazecare.entities.Appointment;
import com.hexaware.amazecare.entities.Patient;
import com.hexaware.amazecare.repository.AppointmentRepository;

@SpringBootTest
class PatientServiceImpTest {

	@Autowired
	IPatientService service;
	
	@Autowired
	AppointmentRepository appointmentRepo;

	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

//	@Test
//	void testUpdatePatientInfo() {
//		
//		Patient patient = new Patient(38,"Adam",40,LocalDate.of(2001,04, 28),"6355324456","Mumbai");
//		Patient patient2 = service.updatePatientInfo(patient);
//		String name = patient2.getPatientName();
//		assertEquals("Adam", name);
//		
//		
//		
//	}

//	@Test
//	@Disabled
//	void testScheduleAppointment() {
//		
//		Appointment appointment = new Appointment();
//		
//		
//		appointment.setDate(LocalDate.of(2024,03,05));
//		appointment.setStatus("pending");
//		appointment.setTime(LocalTime.of(10, 0, 0));
//		appointment.setSymptoms("nausea");
//		appointment.setVisitType("general checkup");
//		
//		Appointment appointment2 = service.scheduleAppointment(appointment);
//		assertEquals("nausea", appointment2.getSymptoms());
//		
//	}

	@Test

	void testRescheduleAppointment() {
		service.rescheduleAppointment(5, LocalDate.now());
		Appointment appointment = appointmentRepo.findById(5).orElse(null);
		assertEquals(LocalDate.now(),appointment.getDate());
		
		
	}

	@Test
	
	void testCancelAppointment() {
		service.cancelAppointment(5);
		Appointment appointment = appointmentRepo.findById(5).orElse(null);
		assertEquals("cancelled", appointment.getStatus());
	}

	@Test
	
	void testViewAppointments() {
		List list = service.viewAppointments(101);
		assertNotNull(list);
		
	}

	
	
	void testGetDocBySpeciality() {
		
		List list = service.getDocBySpeciality("Ortho");
		assertNotNull(list);
		
	}

}
