package com.hexaware.amazecare.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	
	@Size(max = 255)
	private String recomendedTests;
	
	@Size(max = 255)
	private String prescription;
	
	@ManyToOne
	@JoinColumn(name="doctor_id")
	private Doctor doctor;
	
	@ManyToOne
	@JoinColumn(name = "patient_id")
	private Patient patient;
	
	public MedicalRecord() {
	}

	public MedicalRecord(int recordId, String currentSymptoms,
			String physicalExamination, String treatmentPlan, String recomendedTests, String prescription) {
		super();
		this.recordId = recordId;
		this.currentSymptoms = currentSymptoms;
		this.physicalExamination = physicalExamination;
		this.treatmentPlan = treatmentPlan;
		this.recomendedTests = recomendedTests;
		this.prescription = prescription;
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

	public String getRecomendedTests() {
		return recomendedTests;
	}

	public void setRecomendedTests(String recomendedTests) {
		this.recomendedTests = recomendedTests;
	}

	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

	@Override
	public String toString() {
		return "MedicalRecord [recordId=" + recordId + ", currentSymptoms=" + currentSymptoms + ", physicalExamination="
				+ physicalExamination + ", treatmentPlan=" + treatmentPlan + ", recomendedTests=" + recomendedTests
				+ ", prescription=" + prescription + "]";
	}
}
