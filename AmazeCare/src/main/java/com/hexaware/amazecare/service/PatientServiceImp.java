package com.hexaware.amazecare.service;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.amazecare.dto.AppointmentDto;
import com.hexaware.amazecare.dto.PatientDto;
import com.hexaware.amazecare.dto.PatientViewDto;
import com.hexaware.amazecare.entities.Appointment;
import com.hexaware.amazecare.entities.Doctor;
import com.hexaware.amazecare.entities.Patient;
import com.hexaware.amazecare.exception.DoctorNotFoundException;
import com.hexaware.amazecare.exception.PatientNotFoundException;
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
	
	Logger logger = LoggerFactory.getLogger(PatientServiceImp.class);
	
	@Override
	public boolean updatePatientInfo(PatientDto patientDto) {
		
		logger.info("Request initiated to update patient with id: " +patientDto.getPatientId());
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
			logger.info("Patient details updated successfully ");
		}
		return flag;
	}

	@Override
	public boolean scheduleAppointment(AppointmentDto appointmentDto) throws DoctorNotFoundException, PatientNotFoundException {
		
		logger.info("Request initiated to schedule appointmnet for patient id: " + appointmentDto.getPatientId());
		Appointment appointment = new Appointment();
		boolean flag = true;
		Doctor doctor = doctorRepository.findById(appointmentDto.getDoctorId()).orElse(null);
		if(doctor == null) {
			throw new DoctorNotFoundException("Doctor with id: " + appointmentDto.getDoctorId() + " not found");
		}
		Patient patient = patientRepository.findById(appointmentDto.getPatientId()).orElse(null);
		if(patient == null) {
			throw new PatientNotFoundException("Patient with id: " + appointmentDto.getPatientId() + " not found");
		}
	
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
		
		logger.info("Request initiated to rescheduled appointment for id: " + appointmentId);
		boolean flag = false;
		Appointment existingAppointment = appointmentRepository.findById(appointmentId).orElse(null);
		if(existingAppointment!=null)
		{
			flag = true;
			existingAppointment.setStatus("Pending");
			existingAppointment.setDate(date);
			appointmentRepository.save(existingAppointment);
			logger.info("Appointment rescheduled successfully for id: " + appointmentId);
		}
		return flag ;
	}

	@Override
	public boolean cancelAppointment(int appointmentId) {
		
		logger.info("Request initiated to cancel appointment for id: " + appointmentId);
		boolean flag = false;
		Appointment existingAppointment = appointmentRepository.findById(appointmentId).orElse(null);
		if(existingAppointment!=null)
		{
			flag = true;
			existingAppointment.setStatus("Cancelled");
			appointmentRepository.save(existingAppointment);
			logger.info("Appointment cancelled successfully for id: " + appointmentId);
		}
		return flag;
	}

	@Override
	public List<Appointment> viewAppointments(int patientId) {
		logger.info("Request initiated to view appointments for patient ID: " + patientId);
		return appointmentRepository.findByPatientPatientId(patientId);
	}

	@Override
	public List<Doctor> getDocBySpeciality(String speciality) {
		logger.info("Request initiated to get all doctors with speciality: " + speciality);
		return doctorRepository.findBySpeciality(speciality);
	}

	@Override
	public List<PatientViewDto> viewUpcomingAppointments(int patientId) {
		logger.info("Request initiated to view upcoming appointments for patient ID: " + patientId);
		return appointmentRepository.getUpcomingPatientAppointments(patientId);
	}

}
