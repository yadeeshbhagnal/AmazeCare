package com.hexaware.amazecare.service;

import java.time.LocalDate;
import java.util.List;

import com.hexaware.amazecare.dto.AppointmentDto;
import com.hexaware.amazecare.dto.PatientDto;
import com.hexaware.amazecare.dto.PatientViewDto;
import com.hexaware.amazecare.entities.Appointment;
import com.hexaware.amazecare.entities.Doctor;

public interface IPatientService {
	
	public boolean updatePatientInfo(PatientDto patientDto);
	
	public boolean scheduleAppointment(AppointmentDto appointmentDto);
	
	public boolean rescheduleAppointment(int appointmentId, LocalDate date);
	
	public boolean cancelAppointment(int appointmentId);
	
	public List<Appointment> viewAppointments(int patientId);
		
	public List<Doctor> getDocBySpeciality(String speciality);
	
	public List<PatientViewDto> viewUpcomingAppointments(int patientId);

	
}
