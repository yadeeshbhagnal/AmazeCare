package com.hexaware.amazecare.entities;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="Medical_record")
public class MedicalRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int recordId;
	
	@Size(max = 255)
	private String currentSymptoms;
	
	@Size(max = 255)
	private String physicalExamination;
	
	@Size(max = 255)
	private String treatmentPlan;
	
	private LocalDate date;
	
	@OneToMany(mappedBy = "medicalRecord",cascade = CascadeType.ALL)
	private List<RecommendedTests> recommendedTests;
	
	@OneToMany(mappedBy = "medicalRecord",cascade = CascadeType.ALL)
	private List<RecommendedMedicine> recommendedMedicine;
	
	@ManyToOne
	@JoinColumn(name="doctor_Id")
	@JsonBackReference
	private Doctor doctor;
	
	@ManyToOne
	@JoinColumn(name = "patient_Id")
	@JsonBackReference
	private Patient patient;

	public MedicalRecord() {
		super();
	}

	public MedicalRecord(int recordId, @Size(max = 255) String currentSymptoms,
			@Size(max = 255) String physicalExamination, @Size(max = 255) String treatmentPlan, LocalDate date,
			List<RecommendedTests> recommendedTests, List<RecommendedMedicine> recommendedMedicine, Doctor doctor,
			Patient patient) {
		super();
		this.recordId = recordId;
		this.currentSymptoms = currentSymptoms;
		this.physicalExamination = physicalExamination;
		this.treatmentPlan = treatmentPlan;
		this.date = date;
		this.recommendedTests = recommendedTests;
		this.recommendedMedicine = recommendedMedicine;
		this.doctor = doctor;
		this.patient = patient;
	}

	public int getRecordId() {
		return recordId;
	}

	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}

	public String getCurrentSymptoms() {
		return currentSymptoms;
	}

	public void setCurrentSymptoms(String currentSymptoms) {
		this.currentSymptoms = currentSymptoms;
	}

	public String getPhysicalExamination() {
		return physicalExamination;
	}

	public void setPhysicalExamination(String physicalExamination) {
		this.physicalExamination = physicalExamination;
	}

	public String getTreatmentPlan() {
		return treatmentPlan;
	}

	public void setTreatmentPlan(String treatmentPlan) {
		this.treatmentPlan = treatmentPlan;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public List<RecommendedTests> getRecommendedTests() {
		return recommendedTests;
	}

	public void setRecommendedTests(List<RecommendedTests> recommendedTests) {
		this.recommendedTests = recommendedTests;
	}

	public List<RecommendedMedicine> getRecommendedMedicine() {
		return recommendedMedicine;
	}

	public void setRecommendedMedicine(List<RecommendedMedicine> recommendedMedicine) {
		this.recommendedMedicine = recommendedMedicine;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "MedicalRecord [recordId=" + recordId + ", currentSymptoms=" + currentSymptoms + ", physicalExamination="
				+ physicalExamination + ", treatmentPlan=" + treatmentPlan + ", date=" + date + ", recommendedTests="
				+ recommendedTests + ", recommendedMedicine=" + recommendedMedicine + ", doctor=" + doctor
				+ ", patient=" + patient + "]";
	}
}
