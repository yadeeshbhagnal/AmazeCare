package com.hexaware.amazecare.controller;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.amazecare.dto.AppointmentDetailsDto;
import com.hexaware.amazecare.dto.AppointmentDto;
import com.hexaware.amazecare.dto.MedicalRecordDto;
import com.hexaware.amazecare.dto.PatientDto;
import com.hexaware.amazecare.dto.PatientViewDto;
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
	
	Logger logger = LoggerFactory.getLogger(PatientRestController.class);
	
	@PutMapping("/update")
	public String updatePatientInfo(@RequestBody PatientDto patientDto) throws PatientNotFoundException
	{
		if(service.updatePatientInfo(patientDto))
		{
			return "Patient details updated";
		}else {
			logger.info("Exception occured while updating appointment details, Exception name: PatientNotFoundException");
			throw new PatientNotFoundException("Patient with Id "+patientDto.getPatientId()+" not found");
		}
		
	}
	
	@PostMapping("/schedule")
	public String scheduleAppointment(@RequestBody AppointmentDto appointmentDto)
	{
		try {
			service.scheduleAppointment(appointmentDto);
		} catch (DoctorNotFoundException | PatientNotFoundException e) {
			logger.info("Exception occured while scheduling appointment "+e);
			e.toString();
		}
		 return "Appointment scheduled successfully";
	}
	
	@PutMapping("/reschedule/{appointmentId}/{date}")
	public String rescheduleAppointment(@PathVariable int appointmentId,@PathVariable LocalDate date) throws AppointmentNotFoundException
	{
		if(service.rescheduleAppointment(appointmentId, date))
		{
			return "Appointment rescheduled successfully to " + date;
		}else {
			logger.info("Exception occured while rescheduling appointment, Exception name: AppointmentNotFoundException");
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
			logger.info("Exception occured while cancelling appointment ,Exception name: AppointmentNotFoundException ");
			throw new AppointmentNotFoundException("Invalid appointment ID");
		}
	}
	
	@GetMapping("/viewappointment/{patientId}")
	public List<Appointment> viewAppointments(@PathVariable int patientId) throws PatientNotFoundException
	{
		List<Appointment> list = service.viewAppointments(patientId);
		if(list ==null || list.isEmpty()) {
			logger.info("Exception occured while fetching appointment details ,Exception name: PatientNotFoundException");
			throw new PatientNotFoundException("Patient with Id "+patientId+" not found");
		}
		return list;
	}	
	
	@GetMapping("/viewdocbyspeciality/{speciality}")
	public List<Doctor> getDocBySpeciality(@PathVariable String speciality) throws DoctorNotFoundException
	{
		List<Doctor> doctors = service.getDocBySpeciality(speciality);
		if(doctors == null || doctors.isEmpty())
		{
			logger.info("Exception occured while fetching doctor details ,Exception name: DoctorNotFoundException ");
			throw new DoctorNotFoundException("No doctors found with speciality: " + speciality);
		}
		return doctors;
	}
	
	@GetMapping("/upcoming-appointments/{patientId}")
	public List<PatientViewDto> viewUpcomingAppointments(@PathVariable int patientId) throws AppointmentNotFoundException
	{
		List<PatientViewDto> upcomingAppointments = service.viewUpcomingAppointments(patientId);
		if(upcomingAppointments ==null || upcomingAppointments.isEmpty()) {
			logger.info("Exception occured while fetching appointments , Exception name: AppointmentNotFoundException");
			throw new AppointmentNotFoundException("No appointment found for patient with id: " + patientId);
		}
		return upcomingAppointments;
	}
}
