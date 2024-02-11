package com.hexaware.amazecare.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.amazecare.dto.AdminViewDto;
import com.hexaware.amazecare.dto.DoctorDto;
import com.hexaware.amazecare.entities.Appointment;
import com.hexaware.amazecare.entities.AvailableMedicines;
import com.hexaware.amazecare.entities.AvailableTests;
import com.hexaware.amazecare.entities.Doctor;
import com.hexaware.amazecare.entities.Patient;

@SpringBootTest
class AdminServiceImpTest {

	@Autowired
	IAdminService adminService;
	
//	@Test
//	void testAddDoctor() {
//		DoctorDto doctorDto = new DoctorDto(102,"Jackson","dental surgoen",6,"M.s. in dental","senior surgeon");
//		boolean result = adminService.addDoctor(doctorDto);
//		assertTrue(result);
//	}

	@Test
	void testUpdateDoctor(){
		DoctorDto doctorDto = new DoctorDto();
		doctorDto.setDoctorId(94);
		doctorDto.setDoctorName("aman");
		boolean result = adminService.updateDoctor(doctorDto);
		assertFalse(result);
	}

	@Test
	void testDeleteDoctor() {
		boolean result = adminService.deleteDoctor(104);
		assertTrue(result);
	}

	@Test
	void testDeletePatient() {
		boolean result = adminService.deletePatient(56);
		assertFalse(result);
	}

	@Test
	void testViewAllDoctors() {
		List<Doctor> list = adminService.viewAllDoctors();
		assertNotNull(list);
	}

	@Test
	void testViewAllPatients() {
		List<Patient> list = adminService.viewAllPatients();
		assertNotNull(list);
	}

	@Test
	void testViewAllAppointments() {
		List<Appointment> list = adminService.viewAllAppointments();
		assertNotNull(list);
	}

	@Test
	void testAssignAppointmentToDoctor() {
		boolean result = adminService.assignAppointmentToDoctor(102, LocalTime.now());
		assertTrue(result);
	}

	@Test
	void testGetByName() {
		List<Doctor> list = adminService.getByName("rohit");
		assertTrue(list.isEmpty());
	}

	@Test
	void testAddTests() {
		AvailableTests availableTests = new AvailableTests(101,"blood test",3000);
		boolean result = adminService.addTests(availableTests);
		assertTrue(result);	
	}

	@Test
	void testAddMedicines(){
		AvailableMedicines availableMedicines = new AvailableMedicines(180,"safrox-650",600);
		boolean result = adminService.addMedicines(availableMedicines);
		assertTrue(result);
		
	}
	
	@Test
	void viewUpcomingAppointments()
	{
		List<AdminViewDto> list = adminService.viewUpcomingAppointments();
		assertNotNull(list);
	}

}
