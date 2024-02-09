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
import com.hexaware.amazecare.exception.AppointmentNotFoundException;
import com.hexaware.amazecare.exception.DoctorNotFoundException;
import com.hexaware.amazecare.exception.MedicalRecordNotFoundException;
import com.hexaware.amazecare.exception.PatientNotFoundException;
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
	public String updatePatientInfo(@RequestBody PatientDto patientDto) throws PatientNotFoundException
	{
		if(service.updatePatientInfo(patientDto))
		{
			return "Patient details updated";
		}else {
			throw new PatientNotFoundException("Patient not found");
		}
		
	}
	
	@PostMapping("/schedule")
	public String scheduleAppointment(@RequestBody AppointmentDto appointmentDto)
	{
		 service.scheduleAppointment(appointmentDto);
		 return "Appointment scheduled successfully";
	}
	
	@PutMapping("/reschedule/{appointmentId}/{date}")
	public String rescheduleAppointment(@PathVariable int appointmentId,@PathVariable LocalDate date) throws AppointmentNotFoundException
	{
		if(service.rescheduleAppointment(appointmentId, date))
		{
			return "Appointment rescheduled successfully to " + date;
		}else {
			throw new AppointmentNotFoundException("Invalid appointment ID");
		}
		
	}
	
	@PutMapping("cancel/{appointmentId}")
	public String cancelAppointment(@PathVariable int appointmentId) throws AppointmentNotFoundException
	{
		if(service.cancelAppointment(appointmentId))
		{
			return "Appointment with ID "+appointmentId+" cancelled successfully";
		}else {
			throw new AppointmentNotFoundException("Invalid appointment ID");
		}
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
	public List<Doctor> getDocBySpeciality(@PathVariable String speciality) throws DoctorNotFoundException
	{
		List<Doctor> doctors = service.getDocBySpeciality(speciality);
		if(doctors == null || doctors.isEmpty())
		{
			throw new DoctorNotFoundException("No doctors found with speciality: " + speciality);
		}
		return doctors;
	}
	
	@GetMapping("/getrecommendedtests/{recordId}")
	public List<RecommendedTests> viewRecommendedTests(@PathVariable int recordId) throws MedicalRecordNotFoundException
	{
		List<RecommendedTests> recommendedTests = medicalService.viewRecommendedTests(recordId);
        if (recommendedTests == null || recommendedTests.isEmpty()) {
            throw new MedicalRecordNotFoundException("Record with ID " + recordId + " not found.");
        }
        return recommendedTests;
	}
	
	@GetMapping("/getrecommendedmedicine/{recordId}")
	public List<RecommendedMedicine> viewRecommendedMedicine(@PathVariable int recordId) throws MedicalRecordNotFoundException
	{
		List<RecommendedMedicine> recommendedMedicine = medicalService.viewRecommendedMedicine(recordId);
		if (recommendedMedicine == null || recommendedMedicine.isEmpty()) {
            throw new MedicalRecordNotFoundException("Record with ID " + recordId + " not found.");
        }
        return recommendedMedicine;
	}
}
