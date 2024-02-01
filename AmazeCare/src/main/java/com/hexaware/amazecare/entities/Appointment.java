package com.hexaware.amazecare.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Appointment_info")
public class Appointment {

	@Id
	private int appointmentId;
	private LocalDate date;
	private LocalTime time;
	private String symptoms;
	private String visitType;
	
	@ManyToOne
	@JoinColumn(name="doctor_id")
	private Doctor doctor;
	
	@ManyToOne
	@JoinColumn(name = "patient_id")
	private Patient patient;
	
	public Appointment() {
		
	}
	
	public Appointment(int appointmentId, int patientId, int doctorId, LocalDate date, LocalTime time, String symptoms,
			String visitType) {
		super();
		this.appointmentId = appointmentId;
		this.date = date;
		this.time = time;
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
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
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
		return "Appointment [appointmentId=" + appointmentId + ", date=" + date + ", time=" + time + ", symptoms="
				+ symptoms + ", visitType=" + visitType + "]";
	}
}
