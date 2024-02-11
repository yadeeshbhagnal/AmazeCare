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

import com.hexaware.amazecare.dto.AppointmentDto;
import com.hexaware.amazecare.dto.PatientDto;
import com.hexaware.amazecare.dto.PatientViewDto;
import com.hexaware.amazecare.entities.Appointment;
import com.hexaware.amazecare.entities.Doctor;
import com.hexaware.amazecare.entities.Patient;
import com.hexaware.amazecare.exception.DoctorNotFoundException;
import com.hexaware.amazecare.exception.PatientNotFoundException;
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
//		PatientDto patientDto = new PatientDto(51,"Ford",16,LocalDate.of(2001,04, 28),"8345634456","USA");
//		boolean result = service.updatePatientInfo(patientDto);
//		assertFalse(result);	
//	}

	@Test
	void testScheduleAppointment() throws DoctorNotFoundException, PatientNotFoundException {
		
		AppointmentDto appointmentDto = new AppointmentDto();
	
		appointmentDto.setDate(LocalDate.of(2024,03,05));
		appointmentDto.setSymptoms("nausea");
		appointmentDto.setVisitType("general checkup");
		appointmentDto.setDoctorId(203);
		appointmentDto.setPatientId(101);
		
		
		boolean result = service.scheduleAppointment(appointmentDto);
		assertTrue(result);
		
	}

	@Test
	void testRescheduleAppointment() {
		boolean result = service.rescheduleAppointment(10, LocalDate.now());
		assertFalse(result);
	}

	@Test
	void testCancelAppointment() {
		service.cancelAppointment(352);
		Appointment appointment = appointmentRepo.findById(352).orElse(null);
		assertEquals("cancelled", appointment.getStatus());
	}

	@Test
	void testViewAppointments() {
		List<Appointment>list = service.viewAppointments(101);
		assertNotNull(list);	
	}
	
	@Test
	void testGetDocBySpeciality() {
		
		List<Doctor>list = service.getDocBySpeciality("Ortho");
		assertFalse(list.isEmpty());	
	}
	
	@Test
	void testViewUpcomingAppointments() {
		List<PatientViewDto> list = service.viewUpcomingAppointments(101);
		assertNotNull(list);
		
	}

}
