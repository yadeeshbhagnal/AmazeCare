package com.hexaware.amazecare.service;

import java.time.LocalDate;
import java.util.List;

import com.hexaware.amazecare.dto.AppointmentDetailsDto;
import com.hexaware.amazecare.dto.AuthRequest;
import com.hexaware.amazecare.dto.MedicalRecordDto;
import com.hexaware.amazecare.dto.RecommendedMedicineDto;
import com.hexaware.amazecare.dto.RecommendedTestsDto;
import com.hexaware.amazecare.exception.DoctorNotFoundException;
import com.hexaware.amazecare.exception.MedicalRecordNotFoundException;
import com.hexaware.amazecare.exception.MedicineNotFoundException;
import com.hexaware.amazecare.exception.PatientNotFoundException;
import com.hexaware.amazecare.exception.TestNotFoundException;

public interface IDoctorService {
	
	public String loginDoctor(AuthRequest authRequest);
	
	public List<AppointmentDetailsDto> viewAppointments();
	
	public boolean acceptAppointment(int appointmentId);
	
	public boolean rejectAppointment(int appointmentId);
	
	public boolean rescheduleAppointment(int appointmentId, LocalDate date);
			
	public boolean createMedicalRecord(MedicalRecordDto medicalRecordDto, int patientId);
	
	public boolean prescribeMedicine(RecommendedMedicineDto recommendedMedicinesDto, int recordId) throws MedicalRecordNotFoundException, MedicineNotFoundException;
	
	public boolean prescribeTest(RecommendedTestsDto recommendedTestsDto, int recordId) throws MedicalRecordNotFoundException, TestNotFoundException;
	
	public boolean updateTestResult(int recommendedTestId, String result);
}
