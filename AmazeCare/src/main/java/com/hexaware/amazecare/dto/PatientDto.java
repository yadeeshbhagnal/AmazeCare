package com.hexaware.amazecare.dto;

import java.time.LocalDate;

public class PatientDto {

	private int patientId;
	private String patientName;
	private int age;
	private LocalDate dateOfBirth;
	private String contactNumber;
	private String address;
	
	public PatientDto() {
		
	}
	public PatientDto(int patientId, String patientName, int age, LocalDate dateOfBirth, String contactNumber,
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

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", age=" + age + ", dateOfBirth="
				+ dateOfBirth + ", contactNumber=" + contactNumber + ", address=" + address + "]";
	}
}
