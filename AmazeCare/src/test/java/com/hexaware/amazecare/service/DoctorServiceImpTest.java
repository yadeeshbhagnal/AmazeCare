package com.hexaware.amazecare.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.hexaware.amazecare.entities.Appointment;
import com.hexaware.amazecare.entities.MedicalRecord;
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
	void testViewAppointments() {
		List<Appointment> list = doctorService.viewAppointments(101);
		assertNotNull(list);
	}

	@Test
	void testAcceptAppointment() {
		doctorService.acceptAppointment(101);
		Appointment appointment = appointmentRepository.findById(101).orElse(null);
		String status = appointment.getStatus();
		assertEquals("Accepted", status);
	}

	@Test
	void testRejectAppointment() {
		doctorService.rejectAppointment(102);
		Appointment appointment = appointmentRepository.findById(101).orElse(null);
		String status = appointment.getStatus();
		assertEquals("Rejected", status);

	}

	@Test
	void testRescheduleAppointment() {
		doctorService.rescheduleAppointment(101, LocalDate.now());
		Appointment appointment = appointmentRepository.findById(102).orElse(null);
		LocalDate date = appointment.getDate();
		assertEquals(LocalDate.now(), date);
		
	}
}
