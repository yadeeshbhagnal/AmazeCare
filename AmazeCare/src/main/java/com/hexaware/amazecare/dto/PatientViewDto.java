package com.hexaware.amazecare.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class PatientViewDto {

	private String doctorName;
	private String status;
	private LocalTime time;
	private LocalDate date;
	
	public PatientViewDto() {
		super();
	}

	public PatientViewDto(String doctorName, String status, LocalTime time, LocalDate date) {
		super();
		this.doctorName = doctorName;
		this.status = status;
		this.time = time;
		this.date = date;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
}
