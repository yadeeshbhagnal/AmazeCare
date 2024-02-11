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
import com.hexaware.amazecare.dto.MedicalRecordDto;
import com.hexaware.amazecare.dto.RecommendedMedicineDto;
import com.hexaware.amazecare.dto.RecommendedTestsDto;
import com.hexaware.amazecare.entities.Appointment;
import com.hexaware.amazecare.entities.MedicalRecord;
import com.hexaware.amazecare.exception.AppointmentNotFoundException;
import com.hexaware.amazecare.exception.DoctorNotFoundException;
import com.hexaware.amazecare.exception.MedicineNotFoundException;
import com.hexaware.amazecare.exception.PatientNotFoundException;
import com.hexaware.amazecare.exception.TestNotFoundException;
import com.hexaware.amazecare.service.DoctorServiceImp;
import com.hexaware.amazecare.service.IDoctorService;
import com.hexaware.amazecare.service.IMedicalRecordService;

@RestController
@RequestMapping("/doctor")
public class DoctorRestController {
	
	@Autowired
	IDoctorService doctorService;
	
	@Autowired
	IMedicalRecordService medicalRecordService;
	
	Logger logger = LoggerFactory.getLogger(DoctorRestController.class);
	
	@GetMapping("/upcoming-appointments")
	public List<AppointmentDetailsDto> viewUpcomingAppointments(int doctorId) throws AppointmentNotFoundException{
		List<AppointmentDetailsDto> upcomingAppointments = doctorService.viewAppointments(doctorId);
		if(upcomingAppointments ==null || upcomingAppointments.isEmpty()) {
			logger.info("Exception occured while fetching appointments ,Exception name : AppointmentNotFoundException");
			throw new AppointmentNotFoundException("No appointment found for doctor with id: " + doctorId);
		}
		return upcomingAppointments;
	}
	
	@PutMapping("/accept-appointment/{appointmentId}")
	public String acceptAppointment(@PathVariable  int appointmentId) throws AppointmentNotFoundException{
		if(doctorService.acceptAppointment(appointmentId)) {
			return "Appointment accepted";
		}else {
			logger.info("Exception occured while fetching appointment ,Exception name : AppointmentNotFoundException");
			throw new AppointmentNotFoundException("Appointment not found");
		}
	}
	
	@PutMapping("/reject-appointment/{appointmentId}") 
	public String rejectAppointment(@PathVariable  int appointmentId) throws AppointmentNotFoundException {
		if(doctorService.rejectAppointment(appointmentId)) {
			return "Appointment rejected";
		}else {
			logger.info("Exception occured while fetching appointments ,Exception name : AppointmentNotFoundException");
			throw new AppointmentNotFoundException("Appointment not found");
		}
	}
	
	@PutMapping("/reschedule-appointment/{appointmentId}/{date}")
	public String rescheduleAppointment(@PathVariable  int appointmentId,@PathVariable LocalDate date) throws AppointmentNotFoundException {
		if(doctorService.rescheduleAppointment(appointmentId, date)) {
		return "Appointment Reschedules to date: + " + date; 
		}else {
			logger.info("Exception occured while fetching appointments ,Exception name : AppointmentNotFoundException");
			throw new AppointmentNotFoundException("Appointment not found");
		}
	}
	
	@PostMapping("/createmedicalrecord")
	public String createMedicalRecord(@RequestBody MedicalRecordDto medicalRecordDto) {
		try {
			doctorService.createMedicalRecord(medicalRecordDto);
		} catch (DoctorNotFoundException | PatientNotFoundException e) {
			logger.info("Exception occured while creating medical record "+e);
			e.toString();
		}
		return "Medical record created";
	}
	
	@PostMapping("/prescribemedicine")
	public String prescribeMedicine(@RequestBody RecommendedMedicineDto recomenMedicineDto) throws MedicineNotFoundException{
		if(doctorService.prescribeMedicine(recomenMedicineDto)) {
			return "Medicine added to the prescription";
		}else {
			logger.info("Exception occured while prescribing medicine ,Exception name : MedicineNotFoundException");
			throw new MedicineNotFoundException("Medicine not available");
		}
	}
	
	@PostMapping("/prescribetest")
	public String prescribeTest(@RequestBody RecommendedTestsDto recommendedTestDto) throws TestNotFoundException{
		if(doctorService.prescribeTest(recommendedTestDto)) {
			return "Medicine added to the prescription";
		}else {
			logger.info("Exception occured while prescribing tests ,Exception name : TestNotFoundException");
			throw new TestNotFoundException("Medicine not available");
		}
	}
	
	@PutMapping("/updatetestresult/{recommendedTestId}/{result}")
	public String updateTestResult(@PathVariable int recommendedTestId, @PathVariable String result) {
		doctorService.updateTestResult(recommendedTestId, result);
		return "Test result updated sucessfully";
	}
}
