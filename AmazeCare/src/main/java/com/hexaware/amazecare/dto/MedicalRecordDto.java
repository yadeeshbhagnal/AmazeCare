package com.hexaware.amazecare.dto;

import java.time.LocalDate;

public class MedicalRecordDto {

	private int recordId;
	private String currentSymptoms;
	private String physicalExamination;
	private String treatmentPlan;
	private LocalDate date;


	public MedicalRecordDto() {
		super();
	}
	
	public MedicalRecordDto(int recordId, String currentSymptoms, String physicalExamination, String treatmentPlan,
			LocalDate date) {
		super();
		this.recordId = recordId;
		this.currentSymptoms = currentSymptoms;
		this.physicalExamination = physicalExamination;
		this.treatmentPlan = treatmentPlan;
		this.date = date;
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
}
