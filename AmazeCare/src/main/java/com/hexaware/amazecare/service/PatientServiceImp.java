package com.hexaware.amazecare.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.amazecare.dto.AppointmentDto;
import com.hexaware.amazecare.dto.PatientDto;
import com.hexaware.amazecare.entities.Appointment;
import com.hexaware.amazecare.entities.Doctor;
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
		
		Patient patient = patientRepository.findById(patientDto.getPatientId()).orElse(null);
		boolean flag = false;
		
		if(patient!=null)
		{
			if(patientDto.getAddress()!=null)
			{
				patient.setAddress(patientDto.getAddress());
			}
			
			Integer age = patientDto.getAge();
			if(age!=0)
			{
				patient.setAge(patientDto.getAge());
			}
			if(patientDto.getContactNumber()!=null)
			{
				patient.setContactNumber(patientDto.getContactNumber());
			}
			if(patientDto.getDateOfBirth()!=null)
			{
				patient.setDateOfBirth(patientDto.getDateOfBirth());
			}
			if(patientDto.getPatientName()!=null)
			{
				patient.setPatientName(patientDto.getPatientName());
			}
			patientRepository.save(patient);
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean scheduleAppointment(AppointmentDto appointmentDto) {
		
		Appointment appointment = new Appointment();
		
		Doctor doctor = doctorRepository.findById(appointmentDto.getDoctorId()).orElse(null);
		Patient patient = patientRepository.findById(appointmentDto.getPatientId()).orElse(null);
		
		boolean flag = true;
		
		appointment.setStatus("Pending");
		appointment.setDate(appointmentDto.getDate());
		appointment.setSymptoms(appointmentDto.getSymptoms());
		appointment.setVisitType(appointmentDto.getVisitType());
		appointment.setPatient(patient);
		appointment.setDoctor(doctor);
		
		appointmentRepository.save(appointment);
		return flag;
	}

	@Override
	public boolean rescheduleAppointment(int appointmentId, LocalDate date) {
		
		boolean flag = false;
		Appointment existingAppointment = appointmentRepository.findById(appointmentId).orElse(null);
		if(existingAppointment!=null)
		{
			flag = true;
			existingAppointment.setStatus("Pending");
			existingAppointment.setDate(date);
			appointmentRepository.save(existingAppointment);
		}
		return flag ;
	}

	@Override
	public boolean cancelAppointment(int appointmentId) {
		
		boolean flag = false;
		Appointment existingAppointment = appointmentRepository.findById(appointmentId).orElse(null);
		if(existingAppointment!=null)
		{
			flag = true;
			existingAppointment.setStatus("Cancelled");
			appointmentRepository.save(existingAppointment);
		}
		return flag;
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
