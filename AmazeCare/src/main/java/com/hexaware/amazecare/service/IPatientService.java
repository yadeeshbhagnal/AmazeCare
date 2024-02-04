package com.hexaware.amazecare.service;

import java.time.LocalDate;
import java.util.List;

import com.hexaware.amazecare.entities.Appointment;
import com.hexaware.amazecare.entities.Doctor;
import com.hexaware.amazecare.entities.MedicalRecord;
import com.hexaware.amazecare.entities.Patient;

public interface IPatientService {
	
	public Patient updatePatientInfo(Patient patient);
	
	public Appointment scheduleAppointment(Appointment appointment);
	
	public String rescheduleAppointment(int appointmentId, LocalDate date);
	
	public String cancelAppointment(int appointmentId);
	
	public List<Appointment> viewAppointments(int patientId);
	
	public List<MedicalRecord> viewMedicalRecord(int patientId);
	
	public List<Doctor> getDocBySpeciality(String speciality);
	
}
