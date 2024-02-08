package com.hexaware.amazecare.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.amazecare.dto.AppointmentDto;
import com.hexaware.amazecare.dto.MedicalRecordDto;
import com.hexaware.amazecare.dto.PatientDto;
import com.hexaware.amazecare.entities.Appointment;
import com.hexaware.amazecare.entities.Doctor;
import com.hexaware.amazecare.entities.MedicalRecord;
import com.hexaware.amazecare.entities.Patient;
import com.hexaware.amazecare.entities.RecommendedMedicine;
import com.hexaware.amazecare.entities.RecommendedTests;
import com.hexaware.amazecare.service.IMedicalRecordService;
import com.hexaware.amazecare.service.IPatientService;

@RestController
@RequestMapping("/api/patient")
public class PatientRestController {

	@Autowired
	IPatientService service;
	
	@Autowired
	IMedicalRecordService medicalService;
	
	@PutMapping("/update")
	public boolean updatePatientInfo(@RequestBody PatientDto patientDto)
	{
		return service.updatePatientInfo(patientDto);
	}
	
	@PostMapping("/schedule")
	public boolean scheduleAppointment(@RequestBody AppointmentDto appointmentDto)
	{
		return service.scheduleAppointment(appointmentDto);
	}
	
	@PutMapping("/reschedule/{appointmentId}/{date}")
	public String rescheduleAppointment(@PathVariable int appointmentId,@PathVariable LocalDate date)
	{
		return service.rescheduleAppointment(appointmentId, date);
	}
	
	@PutMapping("cancel/{appointmentId}")
	public String cancelAppointment(@PathVariable int appointmentId)
	{
		return service.cancelAppointment(appointmentId);
	}
	
	@GetMapping("/viewappointment/{patientId}")
	public List<Appointment> viewAppointments(@PathVariable int patientId)
	{
		return service.viewAppointments(patientId);
	}
	
	@GetMapping("/viewmedicalrecord/{patientId}")
	public List<MedicalRecord> viewMedicalRecord(@PathVariable int patientId)
	{
		return medicalService.viewMedicalRecord(patientId);
	}
	
	@GetMapping("/viewdocbyspeciality/{speciality}")
	public List<Doctor> getDocBySpeciality(@PathVariable String speciality)
	{
		return service.getDocBySpeciality(speciality);
	}
	
	@GetMapping("/getrecommendedtests/{recordId}")
	public List<RecommendedTests> viewRecommendedTests(int recordId)
	{
		return medicalService.viewRecommendedTests(recordId);
	}
	
	@GetMapping("/getrecommendedmedicine/{recordId}")
	public List<RecommendedMedicine> viewRecommendedMedicine(int recordId)
	{
		return medicalService.viewRecommendedMedicine(recordId);
	}
}
