package com.hexaware.amazecare.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Medical_record")
public class MedicalRecord {

	@Id
	private int recordId;
	private int appointmentID;
	private int patientId;
	private String currentSymptoms;
	private String physicalExamination;
	private String treatmentPlan;
	private String recomendedTests;
	private String prescription;
	
	public MedicalRecord() {
	}
	
	public MedicalRecord(int recordId, int appointmentID, int patientId, String currentSymptoms,
			String physicalExamination, String treatmentPlan, String recomendedTests, String prescription) {
		super();
		this.recordId = recordId;
		this.appointmentID = appointmentID;
		this.patientId = patientId;
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

	public int getAppointmentID() {
		return appointmentID;
	}

	public void setAppointmentID(int appointmentID) {
		this.appointmentID = appointmentID;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
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
		return "MedicalRecord [recordId=" + recordId + ", appointmentID=" + appointmentID + ", patientId=" + patientId
				+ ", currentSymptoms=" + currentSymptoms + ", physicalExamination=" + physicalExamination
				+ ", treatmentPlan=" + treatmentPlan + ", recomendedTests=" + recomendedTests + ", prescription="
				+ prescription + "]";
	}
}
