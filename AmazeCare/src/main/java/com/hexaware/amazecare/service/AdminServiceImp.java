package com.hexaware.amazecare.service;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hexaware.amazecare.dto.DoctorDto;
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
	public boolean addDoctor(DoctorDto doctorDto) {
		Doctor doctor = new Doctor();
		
		doctor.setDoctorName(doctorDto.getDoctorName());
		doctor.setExperience(doctorDto.getExperience());
		doctor.setQualification(doctorDto.getQualification());
		doctor.setSpeciality(doctorDto.getSpeciality());
		doctor.setDesignation(doctorDto.getDesignation());
		doctorRepository.save(doctor);
		
		return true;
	}

	@Override
	public boolean updateDoctor(DoctorDto doctorDto) {
		Doctor doctor = doctorRepository.findById(doctorDto.getDoctorId()).orElse(null);
		boolean flag = false;
		
		if(doctor!=null) {
			if (doctorDto.getDoctorName() != null) {
	            doctor.setDoctorName(doctorDto.getDoctorName());
	        }
			Integer experience = doctorDto.getExperience();
	        if (experience != null) {
	            doctor.setExperience(doctorDto.getExperience());
	        }
	        if (doctorDto.getQualification() != null) {
	            doctor.setQualification(doctorDto.getQualification());
	        }
	        if (doctorDto.getSpeciality() != null) {
	            doctor.setSpeciality(doctorDto.getSpeciality());
	        }
	        if (doctorDto.getDesignation() != null) {
	            doctor.setDesignation(doctorDto.getDesignation());
	        }
			doctorRepository.save(doctor);
			flag = true;

		}
		return flag;
	}

	@Override
	public boolean deleteDoctor(int doctorId) {
		boolean flag = false;
		Doctor doctor = doctorRepository.findById(doctorId).orElse(null);
		if(doctor!=null) {
			doctorRepository.deleteById(doctorId);
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean deletePatient(int patientId) {
		boolean flag = false;
		Patient patient = patientRepository.findById(patientId).orElse(null);
		if(patient!=null) {
			patientRepository.deleteById(patientId);
			flag = true;
		}
		return flag;
	
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
		return appointmentRepository.findAll();
	}

	@Override
	public boolean assignAppointmentToDoctor(int appointmentId, LocalTime time) {
		boolean flag = false;
		Appointment appointment = appointmentRepository.findById(appointmentId).orElse(null);
		if(appointment!=null) {
			appointment.setTime(time);
			flag = true;
		}
		return flag;
	}
}
