package com.hexaware.amazecare.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.amazecare.dto.AppointmentDto;
import com.hexaware.amazecare.dto.PatientDto;
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
	public boolean updatePatientInfo(PatientDto patientDto) {
		
		Patient patient = new Patient();
		boolean flag = false;
		
		patient.setAddress(patientDto.getAddress());
		patient.setAge(patientDto.getAge());
		patient.setContactNumber(patientDto.getContactNumber());
		patient.setDateOfBirth(patientDto.getDateOfBirth());
		patient.setPatientId(patientDto.getPatientId());
		patient.setPatientName(patientDto.getPatientName());
		
		Patient patient2 = patientRepository.save(patient);
		if(patient2!=null)
		{
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean scheduleAppointment(AppointmentDto appointmentDto) {
		
		Appointment appointment = new Appointment();
		boolean flag = false;
		
		appointment.setStatus("pending");
		
		appointment.setAppointmentId(appointmentDto.getAppointmentId());
		appointment.setDate(appointmentDto.getDate());
		appointment.setSymptoms(appointmentDto.getSymptoms());
		appointment.setVisitType(appointmentDto.getVisitType());
		Appointment appointment2= appointmentRepository.save(appointment);
		if(appointment2!=null)
		{
			flag = true;
		}
		return flag;
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
		existingAppointment.setStatus("cancelled");
		appointmentRepository.save(existingAppointment);
		return "Appointment with appointment id: "+appointmentId+"cancelled";
	}

	@Override
	public List<Appointment> viewAppointments(int patientId) {
		return appointmentRepository.findByPatientPatientId(patientId);
	
		
	}

	@Override
	public List<Doctor> getDocBySpeciality(String speciality) {
		return doctorRepository.findBySpeciality(speciality);
	}

}
