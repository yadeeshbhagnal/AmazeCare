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

import com.hexaware.amazecare.entities.Appointment;
import com.hexaware.amazecare.entities.Doctor;
import com.hexaware.amazecare.entities.MedicalRecord;
import com.hexaware.amazecare.entities.Patient;
import com.hexaware.amazecare.service.IPatientService;

@RestController
@RequestMapping("/api/patient")
public class PatientRestController {

	@Autowired
	IPatientService service;
	
	@PutMapping("/update")
	public Patient updatePatientInfo(@RequestBody Patient patient)
	{
		return service.updatePatientInfo(patient);
	}
	
	@PostMapping("/schedule")
	public Appointment scheduleAppointment(@RequestBody Appointment appointment)
	{
		return service.scheduleAppointment(appointment);
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
	
	@GetMapping("/viewAppointment/{patientId}")
	public List<Appointment> viewAppointments(@PathVariable int patientId)
	{
		return service.viewAppointments(patientId);
	}
	
	@GetMapping("/viewMedicalRecord/{patientId}")
	public List<MedicalRecord> viewMedicalRecord(@PathVariable int patientId)
	{
		return service.viewMedicalRecord(patientId);
	}
	
	@GetMapping("/viewDocBySpeciality/{speciality}")
	public List<Doctor> getDocBySpeciality(@PathVariable String speciality)
	{
		return service.getDocBySpeciality(speciality);
	}
}
