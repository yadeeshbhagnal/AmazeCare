package com.hexaware.amazecare.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Medical_record")
public class MedicalRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int recordId;
	private String currentSymptoms;
	private String physicalExamination;
	private String treatmentPlan;
	private String recomendedTests;
	private String prescription;
	
	@ManyToOne
	@JoinColumn(name="doctor_Id")
	private Doctor doctor;
	
	@ManyToOne
	@JoinColumn(name = "patient_Id")
	private Patient patient;
	
	public MedicalRecord() {
	}
	
	public MedicalRecord(int recordId, int appointmentID, int patientId, String currentSymptoms,
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
