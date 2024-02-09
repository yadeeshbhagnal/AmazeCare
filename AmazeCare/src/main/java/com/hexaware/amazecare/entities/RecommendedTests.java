package com.hexaware.amazecare.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class RecommendedTests {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int recommendedTestId;
	
	private String testName;
	private String testResult;
	
	@ManyToOne
	@JoinColumn(name = "record_Id")
	private MedicalRecord medicalRecord;
	

	public RecommendedTests() {
		super();
	}

	public RecommendedTests(int recommendedTestId, String testName, String testResult, MedicalRecord medicalRecord) {
		super();
		this.recommendedTestId = recommendedTestId;
		this.testName = testName;
		this.testResult = testResult;
		this.medicalRecord = medicalRecord;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getTestResult() {
		return testResult;
	}

	public void setTestResult(String testResult) {
		this.testResult = testResult;
	}

	public MedicalRecord getMedicalRecord() {
		return medicalRecord;
	}

	public void setMedicalRecord(MedicalRecord medicalRecord) {
		this.medicalRecord = medicalRecord;
	}
	

	public int getRecommendedTestId() {
		return recommendedTestId;
	}

	public void setRecommendedTestId(int recommendedTestId) {
		this.recommendedTestId = recommendedTestId;
	}

	@Override
	public String toString() {
		return "RecommendedTests [testName=" + testName + ", testResult=" + testResult + ", medicalRecord="
				+ medicalRecord + "]";
	}
}
