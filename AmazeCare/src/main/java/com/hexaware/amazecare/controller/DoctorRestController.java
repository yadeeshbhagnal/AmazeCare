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
import com.hexaware.amazecare.entities.MedicalRecord;
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
	public String acceptAppointment(@PathVariable  int appointmentId) {
		return doctorService.acceptAppointment(appointmentId);
	}
	
	@PutMapping("/reject-appointment/{appointmentId}")
	public String rejectAppointment(@PathVariable  int appointmentId) {
		return doctorService.rejectAppointment(appointmentId);
	}
	
	@PutMapping("/reschedule-appointment/{appointmentId}/{date}")
	public String rescheduleAppointment(@PathVariable  int appointmentId,@PathVariable LocalDate date) {
		return doctorService.rescheduleAppointment(appointmentId,date);
	}
	
	@GetMapping("/viewmedicalrecord/{patientId}")
	public List<MedicalRecord> viewPatientMedicalRecord(@PathVariable int patientId){
		return doctorService.viewMedicalRecord(patientId);
	}
	
	@PostMapping("/createmedicalrecord")
	public MedicalRecord createMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
		return doctorService.createMedicalRecord(medicalRecord);
	}
	
	@PutMapping("/updatetest/{medicalRecordId}/{recomendedTest}")
	public String updateRecomendedTest(@PathVariable int medicalRecordId, @PathVariable String recomendedTest) {
		return doctorService.updateRecomendedTest(medicalRecordId,recomendedTest);
	}
	
	@PutMapping("/updateprescription/{medicalRecordId}/{prescription}")
	public String updatePresription(@PathVariable int medicalRecordId, @PathVariable String prescription) {
		return doctorService.updateMedicalPrescription(medicalRecordId,prescription);
	}
}
