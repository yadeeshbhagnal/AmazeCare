package com.hexaware.amazecare.service;

import java.time.LocalTime;
import java.util.List;

import com.hexaware.amazecare.dto.AdminViewDto;
import com.hexaware.amazecare.dto.DoctorDto;
import com.hexaware.amazecare.dto.PatientViewDto;
import com.hexaware.amazecare.entities.Admin;
import com.hexaware.amazecare.entities.Appointment;
import com.hexaware.amazecare.entities.AvailableMedicines;
import com.hexaware.amazecare.entities.AvailableTests;
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
	
	public List<Doctor> getByName(String doctorName);
	
	public boolean addTests(AvailableTests availableTests);
	
	public boolean addMedicines(AvailableMedicines availableMedicines);
	
	public List<AdminViewDto> viewUpcomingAppointments();

}
