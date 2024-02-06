package com.hexaware.amazecare.service;

import java.util.List;

import com.hexaware.amazecare.entities.Appointment;
import com.hexaware.amazecare.entities.Doctor;
import com.hexaware.amazecare.entities.Patient;

public interface IAdminService {
	
	public Doctor addDoctor(Doctor doctor);
	
	public Doctor updateDoctor(Doctor doctorId);
	
	public String deleteDoctor(int doctorId);
	
	public String deletePatient(int patientId);
	
	public List<Doctor> viewAllDoctors();
	
	public List<Patient> viewAllPatients();
	
	public List<Appointment> viewAllAppointments();
	

}
