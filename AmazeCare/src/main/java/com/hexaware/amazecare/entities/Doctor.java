package com.hexaware.amazecare.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="Doctor_info")
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int doctorId;
	
	@Pattern(regexp = "[A-Z][a-z]{3,15}")
	private String doctorName;
	
	@NotBlank
	@Size(max = 30)
	private String speciality;
	
	@Min(0)
	private int experience;
	
	@Pattern(regexp = "^[a-zA-Z().\\s]*$", message = "Invalid Input")
	@Size(max = 25)
	private String qualification;
	
	@Size(max = 25)
	private String designation;
	
	private String userName;
	private String password;
	private String role;
	
	@OneToMany(mappedBy="doctor", cascade=CascadeType.ALL)
	@JsonBackReference
	private List<Appointment> appointments;
	
	@OneToMany(mappedBy="doctor", cascade = CascadeType.ALL)
	@JsonBackReference
	private List<MedicalRecord> medicalRecords;
	
	
	public Doctor() {
		
	}
	
	public Doctor(int doctorId, @Pattern(regexp = "[A-Z][a-z]{3,15}") String doctorName,
			@NotBlank @Size(max = 30) String speciality, @Min(0) int experience,
			@Pattern(regexp = "^[a-zA-Z().\\s]*$", message = "Invalid Input") @Size(max = 25) String qualification,
			@Size(max = 25) String designation, String userName, String password, String role,
			List<Appointment> appointments, List<MedicalRecord> medicalRecords) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.speciality = speciality;
		this.experience = experience;
		this.qualification = qualification;
		this.designation = designation;
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.appointments = appointments;
		this.medicalRecords = medicalRecords;
	}

	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
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
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", speciality=" + speciality
				+ ", experience=" + experience + ", qualification=" + qualification + ", designation=" + designation
				+ "]";
	}
}
