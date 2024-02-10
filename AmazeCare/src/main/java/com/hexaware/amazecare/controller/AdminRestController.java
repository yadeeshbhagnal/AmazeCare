package com.hexaware.amazecare.controller;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.amazecare.dto.AdminViewDto;
import com.hexaware.amazecare.dto.AppointmentDetailsDto;
import com.hexaware.amazecare.dto.DoctorDto;
import com.hexaware.amazecare.entities.AvailableMedicines;
import com.hexaware.amazecare.entities.AvailableTests;
import com.hexaware.amazecare.entities.Doctor;
import com.hexaware.amazecare.entities.Patient;
import com.hexaware.amazecare.exception.AppointmentNotFoundException;
import com.hexaware.amazecare.exception.DoctorNotFoundException;
import com.hexaware.amazecare.exception.PatientNotFoundException;
import com.hexaware.amazecare.service.IAdminService;

@RestController
@RequestMapping("/admin")
public class AdminRestController {
	
	@Autowired
	IAdminService adminService;
	
	@PostMapping("/adddoctor")
	public String addDoctor(@RequestBody DoctorDto doctorDto) {
		adminService.addDoctor(doctorDto);
		return "Doctor successfully added";
	}
	
	@PutMapping("/updatedoctordetails")
	public String updateDoctor(@RequestBody DoctorDto doctorDto) throws DoctorNotFoundException{
		if(adminService.updateDoctor(doctorDto)) {
			return "Doctor details updated";
		}else {
			throw new DoctorNotFoundException("Doctor not found");
		}
	}
	
	@DeleteMapping("/deletedoctor/{doctorId}")
	public String deleteDoctor(@PathVariable int doctorId) throws DoctorNotFoundException {
		if(adminService.deleteDoctor(doctorId)) {
			return "Doctor deleted successfully";
		}else {
			throw new DoctorNotFoundException("Doctor not found");
		}
	}
	
	@DeleteMapping("/deletepatient/{patientId}")
	public String deletePatiend(@PathVariable int patientId) throws PatientNotFoundException{
		if(adminService.deletePatient(patientId)) {
			return "patient deleted successfully";
		}else {
			throw new PatientNotFoundException("patient not found");
		}
	}
	
	@GetMapping("/viewalldoctors")
	public List<Doctor> getAllDoctors(){
		return adminService.viewAllDoctors();
	}
	
	@GetMapping("/viewallpatients")
	public List<Patient> getAllPatient() {
		return adminService.viewAllPatients();
	}
	
	@PutMapping("/assignappointment/{appointmentId}/{time}")
	public String assignAppointment(@PathVariable int appointmentId,@PathVariable LocalTime time) throws AppointmentNotFoundException {
		if(adminService.assignAppointmentToDoctor(appointmentId, time)) {
			return "appointment successfully assigned";
		}else {
			throw new AppointmentNotFoundException("appointment not found");
		}
	}
	@PostMapping("/addtests")
	public String addTests(@RequestBody AvailableTests availableTests)
	{
		adminService.addTests(availableTests);
		return "Test added";
	}
	
	@PostMapping("/addmedicine")
	public String addMedicines(@RequestBody AvailableMedicines availableMedicines)
	{
		adminService.addMedicines(availableMedicines);
		return "Medicine added";
	}
	
	@GetMapping("/getdoctorbyname/{doctorName}")
	public List<Doctor> getDoctorByName(@PathVariable String doctorName)throws DoctorNotFoundException{
		List<Doctor> doctorList = adminService.getByName(doctorName);
		if(!doctorList.isEmpty()) {
			return doctorList;
		}else {
			throw new DoctorNotFoundException("No doctor found with name" + doctorName);
		}
	}
	
	@GetMapping("/view-upcomingappointment")
	public List<AdminViewDto> viewUpcomingAppointments() throws AppointmentNotFoundException
	{
		List<AdminViewDto> upcomingAppointments = adminService.viewUpcomingAppointments();
		if(upcomingAppointments ==null || upcomingAppointments.isEmpty()) {
			throw new AppointmentNotFoundException("No appointment found");
		}
		return upcomingAppointments;
	}
}
