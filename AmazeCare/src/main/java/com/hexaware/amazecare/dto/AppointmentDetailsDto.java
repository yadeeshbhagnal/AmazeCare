package com.hexaware.amazecare.dto;

import java.time.LocalTime;

public class AppointmentDetailsDto {
		
	private String patientName;
	private String contactNumber;
	private String symptoms;
	private LocalTime time;

	public AppointmentDetailsDto() {
		super();
	}

	public AppointmentDetailsDto(String patientName, String contactNumber, String symptoms, LocalTime time) {
		super();
		this.patientName = patientName;
		this.contactNumber = contactNumber;
		this.symptoms = symptoms;
		this.time = time;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}	
}
