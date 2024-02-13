package com.hexaware.amazecare.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalTime;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.amazecare.dto.AdminDto;
import com.hexaware.amazecare.dto.AdminViewDto;
import com.hexaware.amazecare.dto.DoctorDto;
import com.hexaware.amazecare.entities.AvailableMedicines;
import com.hexaware.amazecare.entities.Doctor;
import com.hexaware.amazecare.entities.Patient;

@SpringBootTest
class AdminServiceImpTest {

	@Autowired
	IAdminService adminService;
	
	@Disabled
	@Test
    public void testRegisterAdmin() {
      
        AdminDto adminDto = new AdminDto();
        
        adminDto.setUserName("Ankush123");
        adminDto.setPassword("Ankush1234");
        adminDto.setAdminName("Ankush");
        adminDto.setEmail("ankush@gmail.com");

        boolean result = adminService.registerAdmin(adminDto);
        assertTrue(result);
    }
	
	@Test
    public void testRegisterDoctor() {
        DoctorDto doctorDto = new DoctorDto();
        
        doctorDto.setDoctorName("Nitin");
        doctorDto.setExperience(5);
        doctorDto.setQualification("MBBS");
        doctorDto.setSpeciality("Cardiology");
        doctorDto.setDesignation("Senior Doctor");
        doctorDto.setUserName("Nitin123");
        doctorDto.setPassword("Nitin1234");

        boolean result = adminService.registerDoctor(doctorDto);

        assertTrue(result);
    }

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
		assertFalse(result);
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
		List<AdminViewDto> list = adminService.viewAllAppointments();
		assertNotNull(list);
	}

	@Test
	void testAssignAppointmentToDoctor() {
		boolean result = adminService.assignAppointmentToDoctor(102, LocalTime.now());
		assertFalse(result);
	}

	@Test
	void testGetByName() {
		List<Doctor> list = adminService.getByName("rohit");
		assertTrue(list.isEmpty());
	}

//	@Test
//	void testAddTests() {
//		AvailableTests availableTests = new AvailableTests();
//		availableTests.setTestId(265);
//		availableTests.setTestName("Vitamin test");
//		availableTests.setTestPrice(200);
//		boolean result = adminService.addTests(availableTests);
//		
//		assertTrue(result);	
//	}

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
