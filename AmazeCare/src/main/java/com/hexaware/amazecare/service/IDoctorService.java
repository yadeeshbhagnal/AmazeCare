package com.hexaware.amazecare.service;

import java.time.LocalDate;
import java.util.List;
import com.hexaware.amazecare.entities.Appointment;
import com.hexaware.amazecare.entities.MedicalRecord;

public interface IDoctorService {
	
	public List<Appointment> viewAppointments(int doctorId);
	
	public String acceptAppointment(int appointmentId);
	
	public String rejectAppointment(int appointmentId);
	
	public String rescheduleAppointment(int appointmentId, LocalDate date);
		
	public List<MedicalRecord> viewMedicalRecord(int patientId);
	
	public MedicalRecord createMedicalRecord(MedicalRecord medicalRecord);
	
	public String updateRecomendedTest(int medicalRecordId, String recomendedTests);
	
	public String updateMedicalPrescription(int medicalRecordId, String prescription);

}
