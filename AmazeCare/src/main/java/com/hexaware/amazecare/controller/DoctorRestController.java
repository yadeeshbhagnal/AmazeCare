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
import com.hexaware.amazecare.dto.MedicalRecordDto;
import com.hexaware.amazecare.entities.Appointment;
import com.hexaware.amazecare.entities.MedicalRecord;
import com.hexaware.amazecare.entities.RecommendedMedicine;
import com.hexaware.amazecare.entities.RecommendedTests;
import com.hexaware.amazecare.exception.AppointmentNotFoundException;
import com.hexaware.amazecare.exception.MedicalRecordNotFoundException;
import com.hexaware.amazecare.exception.MedicineNotFoundException;
import com.hexaware.amazecare.exception.TestNotFoundException;
import com.hexaware.amazecare.service.IDoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorRestController {
	
	@Autowired
	IDoctorService doctorService;
	
	@GetMapping("/upcoming-appointments")
	public List<Appointment> viewUpcomingAppointments(int doctorId){
		
		return doctorService.viewAppointments(doctorId);
	}
	
	@PutMapping("/accept-appointment/{appointmentId}")
	public String acceptAppointment(@PathVariable  int appointmentId) throws AppointmentNotFoundException{
		if(doctorService.acceptAppointment(appointmentId)) {
			return "Appointment accepted";
		}else {
			throw new AppointmentNotFoundException("Appointment not found");
		}
	}
	
	@PutMapping("/reject-appointment/{appointmentId}") 
	public String rejectAppointment(@PathVariable  int appointmentId) throws AppointmentNotFoundException {
		if(doctorService.rejectAppointment(appointmentId)) {
			return "Appointment rejected";
		}else {
			throw new AppointmentNotFoundException("Appointment not found");
		}
	}
	
	@PutMapping("/reschedule-appointment/{appointmentId}/{date}")
	public String rescheduleAppointment(@PathVariable  int appointmentId,@PathVariable LocalDate date) throws AppointmentNotFoundException {
		if(doctorService.rescheduleAppointment(appointmentId, date)) {
		return "Appointment Reschedules to date: + " + date; 
		}else {
			throw new AppointmentNotFoundException("Appointment not found");
		}
	}
	
	@PostMapping("/createmedicalrecord")
	public String createMedicalRecord(@RequestBody MedicalRecordDto medicalRecordDto) {
		doctorService.createMedicalRecord(medicalRecordDto);
			return "Medical record created";
	}
	
	@GetMapping("/viewmedicalrecord/{patientId}")
	public List<MedicalRecord> viewPatientMedicalRecord(@PathVariable int patientId){
		return doctorService.viewMedicalRecord(patientId);
	}
	
	@PostMapping("/prescribemedicine")
	public String prescribeMedicine(@RequestBody RecommendedMedicine recomenMedicine) throws MedicineNotFoundException{
		if(doctorService.prescribeMedicine(recomenMedicine)) {
			return "Medicine added to the prescription";
		}else {
			throw new MedicineNotFoundException("Medicine not available");
		}
	}
	
	@PostMapping("/prescribetest")
	public String prescribeTest(@RequestBody RecommendedTests recommendedTest) throws TestNotFoundException{
		if(doctorService.prescribeTest(recommendedTest)) {
			return "Medicine added to the prescription";
		}else {
			throw new TestNotFoundException("Medicine not available");
		}
	}
	
	@PutMapping("/updatetestresult/{recommendedTestId}/{result}")
	public String updateTestResult(@PathVariable int recommendedTestId, @PathVariable String result) {
		doctorService.updateTestResult(recommendedTestId, result);
		return "Test result updated sucessfully";
	}
}
