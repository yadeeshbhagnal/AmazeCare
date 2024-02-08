package com.hexaware.amazecare.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentDto {

	private int appointmentId;
	private LocalDate date;
	private String symptoms;
	private String visitType;
	
	public AppointmentDto() {
	}
	
	public AppointmentDto(int appointmentId, int patientId, int doctorId, LocalDate date, LocalTime time, String symptoms,
			String visitType) {
		super();
		this.appointmentId = appointmentId;
		this.date = date;
		this.symptoms = symptoms;
		this.visitType = visitType;
	}
	public int getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getSymptoms() {
		return symptoms;
	}
	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}
	public String getVisitType() {
		return visitType;
	}
	public void setVisitType(String visitType) {
		this.visitType = visitType;
	}

	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", date=" + date + ", symptoms="
				+ symptoms + ", visitType=" + visitType + "]";
	}
}
