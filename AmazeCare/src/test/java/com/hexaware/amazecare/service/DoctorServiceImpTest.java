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

	@Test
	void testViewMedicalRecord() {
		List<MedicalRecord> medicalRecord  = doctorService.viewMedicalRecord(101);
		assertNotNull(medicalRecord);
	}

	@Test
	void testCreateMedicalRecord() {
		MedicalRecord medicalRecord = new  MedicalRecord(111,"cold", "suffering from cold", "7 days medicine", "none", "CFZ-250");
		assertNotNull(doctorService.createMedicalRecord(medicalRecord));
	}

	@Test
	void testUpdateRecomendedTest() {
		doctorService.updateRecomendedTest(252, "blood test");
		MedicalRecord medicalRecord = medicalRecordRespository.findById(101).orElse(null);
		assertEquals("blood test",medicalRecord.getRecomendedTests());
	}

	@Test
	void testUpdateMedicalPrescription() {
		doctorService.updateMedicalPrescription(252, "Dollo 900");
		MedicalRecord medicalRecord = medicalRecordRespository.findById(101).orElse(null);
		assertEquals("Dollo 900", medicalRecord.getPrescription());
	}

}
