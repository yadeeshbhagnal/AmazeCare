package com.hexaware.amazecare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hexaware.amazecare.entities.Appointment;
import com.hexaware.amazecare.entities.MedicalRecord;
import com.hexaware.amazecare.entities.Patient;
import com.hexaware.amazecare.repository.AppointmentRepository;
import com.hexaware.amazecare.repository.MedicalRecordRepository;

@Service
public class DoctorServiceImp implements IDoctorService {
	
	@Autowired
	MedicalRecordRepository medicalRecordRepository;
	
	@Autowired 
	AppointmentRepository appointmentRepository;

	@Override
	public List<Appointment> viewAppointments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String acceptAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String rejectAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String rescheduleAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Patient viewPatientDetails(int patientId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MedicalRecord viewMedicalRecord(int patientId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MedicalRecord createMedicalRecord(MedicalRecord medicalRecord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateMedicalRecord(MedicalRecord medicalRecord) {
		// TODO Auto-generated method stub
		return null;
	}

}
