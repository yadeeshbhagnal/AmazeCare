package com.hexaware.amazecare.service;

import java.util.List;

import com.hexaware.amazecare.entities.Appointment;
import com.hexaware.amazecare.entities.MedicalRecord;
import com.hexaware.amazecare.entities.Patient;

public interface IDoctorService {
	
	public List<Appointment> viewAppointments();
	
	public String acceptAppointment(Appointment appointment);
	
	public String rejectAppointment(Appointment appointment);
	
	public String rescheduleAppointment(Appointment appointment);
	
	public Patient viewPatientDetails(int patientId);
	
	public MedicalRecord viewMedicalRecord(int patientId);
	
	public MedicalRecord createMedicalRecord(MedicalRecord medicalRecord);
	
	public String updateMedicalRecord(MedicalRecord medicalRecord);

}
