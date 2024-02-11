package com.hexaware.amazecare.service;

import java.time.LocalDate;
import java.util.List;

import com.hexaware.amazecare.dto.AppointmentDetailsDto;
import com.hexaware.amazecare.dto.AuthRequest;
import com.hexaware.amazecare.dto.MedicalRecordDto;
import com.hexaware.amazecare.dto.RecommendedMedicineDto;
import com.hexaware.amazecare.dto.RecommendedTestsDto;
import com.hexaware.amazecare.exception.DoctorNotFoundException;
import com.hexaware.amazecare.exception.PatientNotFoundException;

public interface IDoctorService {
	
	public String loginDoctor(AuthRequest authRequest);
	
	public List<AppointmentDetailsDto> viewAppointments(int doctorId);
	
	public boolean acceptAppointment(int appointmentId);
	
	public boolean rejectAppointment(int appointmentId);
	
	public boolean rescheduleAppointment(int appointmentId, LocalDate date);
			
	public boolean createMedicalRecord(MedicalRecordDto medicalRecordDto) throws DoctorNotFoundException,PatientNotFoundException;
	
	public boolean prescribeMedicine(RecommendedMedicineDto recommendedMedicinesDto);
	
	public boolean prescribeTest(RecommendedTestsDto recommendedTestsDto);
	
	public boolean updateTestResult(int recommendedTestId, String result);
}
