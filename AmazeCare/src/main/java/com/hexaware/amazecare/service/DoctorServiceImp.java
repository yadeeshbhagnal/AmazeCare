package com.hexaware.amazecare.service;

import java.time.LocalDate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hexaware.amazecare.entities.Appointment;
import com.hexaware.amazecare.entities.MedicalRecord;
import com.hexaware.amazecare.repository.AppointmentRepository;
import com.hexaware.amazecare.repository.MedicalRecordRepository;

@Service
public class DoctorServiceImp implements IDoctorService {
	
	@Autowired
	MedicalRecordRepository medicalRecordRepository;
	
	@Autowired 
	AppointmentRepository appointmentRepository;

	@Override
	public List<Appointment> viewAppointments(int doctorId) {
		return appointmentRepository.getUpcomingAppointments();

	}

	@Override
	public String acceptAppointment(int appointmentId) {
		
		Appointment existingAppointment = appointmentRepository.findById(appointmentId).orElse(null);
		existingAppointment.setStatus("Accepted");
		appointmentRepository.save(existingAppointment);
		return "Appointment with appointment id: " + appointmentId + " accepted";
	
	}

	@Override
	public String rejectAppointment(int appointmentId) {
		
		Appointment existingAppointment = appointmentRepository.findById(appointmentId).orElse(null);
		existingAppointment.setStatus("rejected");
		appointmentRepository.save(existingAppointment);
		return "Appointment with appointment id: " + appointmentId + " rejected";
	}

	@Override
	public String rescheduleAppointment(int appointmentId, LocalDate date) {
		
		Appointment existingAppointment = appointmentRepository.findById(appointmentId).orElse(null);
		existingAppointment.setDate(date);
		appointmentRepository.save(existingAppointment);
		return "Appointment Rescheduled";
	}

	@Override
	public MedicalRecord createMedicalRecord(MedicalRecord medicalRecord) {
		return medicalRecordRepository.save(medicalRecord);
	}
}
