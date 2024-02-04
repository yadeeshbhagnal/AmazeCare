package com.hexaware.amazecare.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hexaware.amazecare.entities.Appointment;

class PatientServiceImpTest {

	@Autowired
	IPatientService service;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	@Disabled
	void testUpdatePatientInfo() {
		fail("Not yet implemented");
	}

	@Test
	void testScheduleAppointment() {
		
		Appointment appointment = new Appointment();
		
		appointment.setAppointmentId(21);
		appointment.setDate(LocalDate.of(2024,03,05));
		appointment.setStatus("pending");
		appointment.setTime(LocalTime.of(10, 0, 0));
		appointment.setSymptoms("nausea");
		appointment.setVisitType("general checkup");
		
		Appointment appointment2 = service.scheduleAppointment(appointment);
		assertEquals(21, appointment2.getAppointmentId());
		
	}

	@Test
	@Disabled
	void testRescheduleAppointment() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testCancelAppointment() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testViewAppointments() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testViewMedicalRecord() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testGetDocBySpeciality() {
		fail("Not yet implemented");
	}

}
