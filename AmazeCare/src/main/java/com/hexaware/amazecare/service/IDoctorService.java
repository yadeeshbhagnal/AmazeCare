package com.hexaware.amazecare.service;

import java.time.LocalDate;
import java.util.List;

import com.hexaware.amazecare.dto.MedicalRecordDto;
import com.hexaware.amazecare.entities.Appointment;
import com.hexaware.amazecare.entities.MedicalRecord;
import com.hexaware.amazecare.entities.RecommendedMedicine;
import com.hexaware.amazecare.entities.RecommendedTests;

public interface IDoctorService {
	
	public List<Appointment> viewAppointments(int doctorId);
	
	public boolean acceptAppointment(int appointmentId);
	
	public boolean rejectAppointment(int appointmentId);
	
	public boolean rescheduleAppointment(int appointmentId, LocalDate date);
			
	public boolean createMedicalRecord(MedicalRecordDto medicalRecordDto);
	
	public boolean prescribeMedicine(RecommendedMedicine recommendedMedicines);
	
	public boolean prescribeTest(RecommendedTests recommendedTests);
	
	public boolean updateTestResult(int recommendedTestId, String result);
}
