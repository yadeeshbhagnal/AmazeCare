package com.hexaware.amazecare.service;

import java.time.LocalTime;
import java.util.List;

import com.hexaware.amazecare.dto.DoctorDto;
import com.hexaware.amazecare.entities.Admin;
import com.hexaware.amazecare.entities.Appointment;
import com.hexaware.amazecare.entities.Doctor;
import com.hexaware.amazecare.entities.Patient;

public interface IAdminService {
	
	public boolean addDoctor(DoctorDto doctorDto);
	
	public boolean updateDoctor(DoctorDto doctorId);
	
	public boolean deleteDoctor(int doctorId);
	
	public boolean deletePatient(int patientId);
	
	public List<Doctor> viewAllDoctors();
	
	public List<Patient> viewAllPatients();
	
	public List<Appointment> viewAllAppointments();
	
	public boolean assignAppointmentToDoctor(int appointmentId, LocalTime time);

}
