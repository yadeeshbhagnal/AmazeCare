package com.hexaware.amazecare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hexaware.amazecare.entities.Admin;
import com.hexaware.amazecare.entities.Appointment;
import com.hexaware.amazecare.entities.Doctor;
import com.hexaware.amazecare.entities.Patient;
import com.hexaware.amazecare.repository.AdminRepository;
import com.hexaware.amazecare.repository.AppointmentRepository;
import com.hexaware.amazecare.repository.DoctorRepository;
import com.hexaware.amazecare.repository.PatientRepository;

public class AdminServiceImp implements IAdminService {
	
	@Autowired
	PatientRepository patientRepository;
	
	@Autowired
	AppointmentRepository appointmentRepository;
		
	@Autowired
	DoctorRepository doctorRepository;
	
	@Autowired
	AdminRepository adminRespository;
	
	@Override
	public Admin addAdmin(Admin admin) {
		return adminRespository.save(admin);
	}
	
	@Override
	public String delteAdmin(long adminId) {
		adminRespository.deleteById(adminId);
		return "admin deleted";
	}

	@Override
	public Doctor addDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);

	}

	@Override
	public Doctor updateDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);

	}

	@Override
	public String deleteDoctor(int doctorId) {
		doctorRepository.deleteById(doctorId);
		return "doctor deleted";
	}

	@Override
	public String deletePatient(int patientId) {
		patientRepository.deleteById(patientId);
		return "patient deleted";
	}

	@Override
	public List<Doctor> viewAllDoctors() {
		return doctorRepository.findAll();
	}

	@Override
	public List<Patient> viewAllPatients() {
		return patientRepository.findAll();
	}

	@Override
	public List<Appointment> viewAllAppointments() {
		return null;
	}

	

}
