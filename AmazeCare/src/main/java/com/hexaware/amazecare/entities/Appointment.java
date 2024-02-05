package com.hexaware.amazecare.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="Appointment_info")
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int appointmentId;
	
	@NotNull
	private LocalDate date;
	
	@NotNull
	private LocalTime time;
	
	@Size(max = 255)
	private String symptoms;
	
	@Size(max = 255)
	private String visitType;
	
	@Size(max = 255)
	private String status;
	
	@ManyToOne
	@JoinColumn(name="doctor_Id")
	private Doctor doctor;
	
	@ManyToOne
	@JoinColumn(name = "patient_Id")
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
	
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", date=" + date + ", time=" + time + ", symptoms="
				+ symptoms + ", visitType=" + visitType + "]";
	}
}
