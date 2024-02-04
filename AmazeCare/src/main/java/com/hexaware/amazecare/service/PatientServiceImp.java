package com.hexaware.amazecare.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.amazecare.entities.Appointment;
import com.hexaware.amazecare.entities.Doctor;
import com.hexaware.amazecare.entities.MedicalRecord;
import com.hexaware.amazecare.entities.Patient;
import com.hexaware.amazecare.repository.AppointmentRepository;
import com.hexaware.amazecare.repository.DoctorRepository;
import com.hexaware.amazecare.repository.MedicalRecordRepository;
import com.hexaware.amazecare.repository.PatientRepository;

@Service
public class PatientServiceImp implements IPatientService {

	@Autowired
	PatientRepository patientRepository;
	
	@Autowired
	AppointmentRepository appointmentRepository;
	
	@Autowired
	MedicalRecordRepository medicalRecordRepository;
	
	@Autowired
	DoctorRepository doctorRepository;
	
	@Override
	public Patient updatePatientInfo(Patient patient) {
		
		return patientRepository.save(patient);
	}

	@Override
	public Appointment scheduleAppointment(Appointment appointment) {
		appointment.setStatus("pending");
		return appointmentRepository.save(appointment);
	}

	@Override
	public String rescheduleAppointment(int appointmentId, LocalDate date) {
		
		Appointment existingAppointment = appointmentRepository.findById(appointmentId).orElse(null);
		existingAppointment.setDate(date);
		appointmentRepository.save(existingAppointment);
		return "Appointment Rescheduled to "+date ;
	}

	@Override
	public String cancelAppointment(int appointmentId) {
		Appointment existingAppointment = appointmentRepository.findById(appointmentId).orElse(null);
		existingAppointment.setStatus("canceled");
		appointmentRepository.save(existingAppointment);
		return "Appointment with appointment id: "+appointmentId+"cancelled";
	}

	@Override
	public List<Appointment> viewAppointments(int patientId) {
		
		return appointmentRepository.findByPatientPatientId(patientId);
	}

	@Override
	public List<MedicalRecord> viewMedicalRecord(int patientId) {
		
		return medicalRecordRepository.findByPatientPatientId(patientId);
	}

	@Override
	public List<Doctor> getDocBySpeciality(String speciality) {
		
		return doctorRepository.findBySpeciality(speciality);
	}

}
