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
		return null;
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
	public List<MedicalRecord> viewMedicalRecord(int patientId) {
		
		return medicalRecordRepository.findByPatientPatientId(patientId);
	}

	@Override
	public MedicalRecord createMedicalRecord(MedicalRecord medicalRecord) {
		return medicalRecordRepository.save(medicalRecord);
	}

	@Override
	public String updateRecomendedTest(int medicalRecordId, String recomendedTests) {
		
		MedicalRecord existingMedicalRecord = medicalRecordRepository.findById(medicalRecordId).orElse(null);
		existingMedicalRecord.setRecomendedTests(recomendedTests);
		medicalRecordRepository.save(existingMedicalRecord);
		
		return "Recomended test for medical record" + medicalRecordId + " updated";
	}

	@Override
	public String updateMedicalPrescription(int medicalRecordId, String prescription) {
		
		MedicalRecord existingMedicalRecord = medicalRecordRepository.findById(medicalRecordId).orElse(null);
		existingMedicalRecord.setPrescription(prescription);
		return "Prescription for medical record" + medicalRecordId + " updated";
	}
}
