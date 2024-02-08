package com.hexaware.amazecare.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Patient_info")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int patientId;
	
	@Pattern(regexp = "[A-z][a-z]{3,10}")
	@Size(max = 255)
	private String patientName;
	
	@Min(value = 1)
	private int age;
	
	private LocalDate dateOfBirth;
	
	@Pattern(regexp = "^\\d{10}$")
	@Size(max = 255)
	private String contactNumber;
	
	@Pattern(regexp = "^[a-zA-Z0-9\s.,#-]*$")
	@Size(max = 255)
	private String address;
	
	@OneToMany(mappedBy="patient", cascade=CascadeType.ALL)
	private List<Appointment> appointments;
	
	@OneToMany(mappedBy="patient", cascade = CascadeType.ALL)
	private List<MedicalRecord> medicalRecords;
	
	public Patient() {
	}
	
	public Patient(int patientId, String patientName, int age, LocalDate dateOfBirth, String contactNumber,
			String address) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.age = age;
		this.dateOfBirth = dateOfBirth;
		this.contactNumber = contactNumber;
		this.address = address;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public List<MedicalRecord> getMedicalRecords() {
		return medicalRecords;
	}

	public void setMedicalRecords(List<MedicalRecord> medicalRecords) {
		this.medicalRecords = medicalRecords;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", age=" + age + ", dateOfBirth="
				+ dateOfBirth + ", contactNumber=" + contactNumber + ", address=" + address + "]";
	}
}
