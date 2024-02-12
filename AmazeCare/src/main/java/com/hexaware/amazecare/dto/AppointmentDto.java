package com.hexaware.amazecare.dto;

import java.time.LocalDate;
public class AppointmentDto {

	private int appointmentId;
	private LocalDate date;
	private String symptoms;
	private String visitType;
	
	public AppointmentDto() {
	}
	
	public AppointmentDto(int appointmentId, LocalDate date, String symptoms, String visitType, int patientId,
			int doctorId) {
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
		return "AppointmentDto [appointmentId=" + appointmentId + ", date=" + date + ", symptoms=" + symptoms
				+ ", visitType=" + visitType + "]";
	}
}
