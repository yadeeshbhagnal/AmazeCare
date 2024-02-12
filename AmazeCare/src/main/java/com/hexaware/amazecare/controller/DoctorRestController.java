package com.hexaware.amazecare.controller;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.amazecare.dto.AppointmentDetailsDto;
import com.hexaware.amazecare.dto.AuthRequest;
import com.hexaware.amazecare.dto.MedicalRecordDto;
import com.hexaware.amazecare.dto.RecommendedMedicineDto;
import com.hexaware.amazecare.dto.RecommendedTestsDto;
import com.hexaware.amazecare.entities.Appointment;
import com.hexaware.amazecare.entities.MedicalRecord;
import com.hexaware.amazecare.exception.AppointmentNotFoundException;
import com.hexaware.amazecare.exception.DoctorNotFoundException;
import com.hexaware.amazecare.exception.MedicalRecordNotFoundException;
import com.hexaware.amazecare.exception.MedicineNotFoundException;
import com.hexaware.amazecare.exception.PatientNotFoundException;
import com.hexaware.amazecare.exception.RecommendedTestNotFound;
import com.hexaware.amazecare.exception.TestNotFoundException;
import com.hexaware.amazecare.service.DoctorServiceImp;
import com.hexaware.amazecare.service.IDoctorService;
import com.hexaware.amazecare.service.IMedicalRecordService;

@RestController
@RequestMapping("/api/doctor")
public class DoctorRestController {
	
	@Autowired
	IDoctorService doctorService;
	
	@Autowired
	IMedicalRecordService medicalRecordService;
	
	Logger logger = LoggerFactory.getLogger(DoctorRestController.class);
	
	@PostMapping("/login")
	public String authenticate(@RequestBody AuthRequest authRequest) {
		return doctorService.loginDoctor(authRequest);
	}
	
	@GetMapping("/upcoming-appointments")
    @PreAuthorize("hasAuthority('Doctor')")
	public List<AppointmentDetailsDto> viewUpcomingAppointments() throws AppointmentNotFoundException{
		List<AppointmentDetailsDto> upcomingAppointments = doctorService.viewAppointments();
		
		if(upcomingAppointments ==null || upcomingAppointments.isEmpty()) {
			logger.info("Exception occured while fetching appointments ,Exception name : AppointmentNotFoundException");
			throw new AppointmentNotFoundException("No appointment found for the doctor");
		}
		return upcomingAppointments;
	}
	
	@PutMapping("/accept-appointment/{appointmentId}")
    @PreAuthorize("hasAuthority('Doctor')")
	public String acceptAppointment(@PathVariable  int appointmentId) throws AppointmentNotFoundException{
		if(doctorService.acceptAppointment(appointmentId)) {
			return "Appointment accepted";
		}else {
			logger.info("Exception occured while fetching appointment ,Exception name : AppointmentNotFoundException");
			throw new AppointmentNotFoundException("Appointment not found");
		}
	}
	
	@PutMapping("/reject-appointment/{appointmentId}") 
    @PreAuthorize("hasAuthority('Doctor')")
	public String rejectAppointment(@PathVariable  int appointmentId) throws AppointmentNotFoundException {
		if(doctorService.rejectAppointment(appointmentId)) {
			return "Appointment rejected";
		}else {
			logger.info("Exception occured while fetching appointments ,Exception name : AppointmentNotFoundException");
			throw new AppointmentNotFoundException("Appointment not found");
		}
	}
	
	@PutMapping("/reschedule-appointment/{appointmentId}/{date}")
    @PreAuthorize("hasAuthority('Doctor')")
	public String rescheduleAppointment(@PathVariable  int appointmentId,@PathVariable LocalDate date) throws AppointmentNotFoundException {
		if(doctorService.rescheduleAppointment(appointmentId, date)) {
		return "Appointment Reschedules to date: " + date; 
		}else {
			logger.info("Exception occured while fetching appointments ,Exception name : AppointmentNotFoundException");
			throw new AppointmentNotFoundException("Appointment not found");
		}
	}
	
	@PostMapping("/createmedicalrecord/{appointmentId}")
    @PreAuthorize("hasAuthority('Doctor')")
	public String createMedicalRecord(@RequestBody MedicalRecordDto medicalRecordDto, @PathVariable int appointmentId) throws AppointmentNotFoundException{
		if(doctorService.createMedicalRecord(medicalRecordDto,appointmentId)) {
			return "Medical record created";
		}else{
			throw new AppointmentNotFoundException("Appointment not found for id: " + appointmentId);
		}	
	}
	
	@PostMapping("/prescribemedicine/{recordId}")
    @PreAuthorize("hasAuthority('Doctor')")
	public String prescribeMedicine(@RequestBody RecommendedMedicineDto recomenMedicineDto, @PathVariable int recordId){
		String result = null;
		try {
			if(doctorService.prescribeMedicine(recomenMedicineDto, recordId)) {
				result = "Medicine prescribed";
			}
		} catch (MedicalRecordNotFoundException | MedicineNotFoundException e) {
			result = "Error occured while prescribing medicing: " + e.getMessage();
		}
		return result;
	}
	
	@PostMapping("/prescribetest/{recordId}")
    @PreAuthorize("hasAuthority('Doctor')")
	public String prescribeTest(@RequestBody RecommendedTestsDto recommendedTestDto, @PathVariable int recordId){
		String result = null;
		try {
			if(doctorService.prescribeTest(recommendedTestDto, recordId)) {
				result = "Test added to the prescription";
			}
		} catch (MedicalRecordNotFoundException | TestNotFoundException e) {
			result = "Error occured while prescribing medicine: " + e.getMessage();
		}
		return result;
	}
	
	@PutMapping("/updatetestresult/{recommendedTestId}/{result}")
    @PreAuthorize("hasAuthority('Doctor')")
	public String updateTestResult(@PathVariable int recommendedTestId, @PathVariable String result) throws RecommendedTestNotFound{
		if(doctorService.updateTestResult(recommendedTestId, result)) {
		return "Test result updated sucessfully";
		}else {
			throw new RecommendedTestNotFound("Test for the given id not found");
		}
	}
}
