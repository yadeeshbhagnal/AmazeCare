package com.hexaware.amazecare.dto;

public class DoctorDto {
	private int doctorId;
	private String doctorName;
	private String speciality;
	private int experience;
	private String qualification;
	private String designation;
	
	public DoctorDto() {
		
	}
	public DoctorDto(int doctorId, String doctorName, String speciality, int experience, String qualification,
			String designation) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.speciality = speciality;
		this.experience = experience;
		this.qualification = qualification;
		this.designation = designation;
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

	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", speciality=" + speciality
				+ ", experience=" + experience + ", qualification=" + qualification + ", designation=" + designation
				+ "]";
	}
}
