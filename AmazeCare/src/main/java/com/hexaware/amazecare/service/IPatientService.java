package com.hexaware.amazecare.service;

import java.time.LocalDate;
import java.util.List;

import com.hexaware.amazecare.dto.AppointmentDto;
import com.hexaware.amazecare.dto.AuthRequest;
import com.hexaware.amazecare.dto.PatientDto;
import com.hexaware.amazecare.dto.PatientViewDto;
import com.hexaware.amazecare.entities.Appointment;
import com.hexaware.amazecare.entities.Doctor;
import com.hexaware.amazecare.exception.DoctorNotFoundException;
import com.hexaware.amazecare.exception.PatientNotFoundException;

public interface IPatientService {
	
	public boolean registerPatient(PatientDto patientDto);
	
	public String loginPatient(AuthRequest authRequest);
	
	public boolean updatePatientInfo(PatientDto patientDto);
	
	public boolean scheduleAppointment(AppointmentDto appointmentDto) throws DoctorNotFoundException, PatientNotFoundException;
	
	public boolean rescheduleAppointment(int appointmentId, LocalDate date);
	
	public boolean cancelAppointment(int appointmentId);
	
	public List<Appointment> viewAppointments();
		
	public List<Doctor> getDocBySpeciality(String speciality);
	
	public List<PatientViewDto> viewUpcomingAppointments(int patientId);

	
}
