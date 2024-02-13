package com.hexaware.amazecare.dto;


public class RecommendedTestsDto {
	private int recommendedTestId;
	private String testName;
	private String testResult;
	

	public RecommendedTestsDto() {
		super();
	}

	public RecommendedTestsDto(int recommendedTestId, String testName, String testResult) {
		super();
		this.recommendedTestId = recommendedTestId;
		this.testName = testName;
		this.testResult = testResult;
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

	public int getRecommendedTestId() {
		return recommendedTestId;
	}

	public void setRecommendedTestId(int recommendedTestId) {
		this.recommendedTestId = recommendedTestId;
	}

	@Override
	public String toString() {
		return "RecommendedTestsDto [recommendedTestId=" + recommendedTestId + ", testName=" + testName
				+ ", testResult=" + testResult + "]";
	}
	
	
}

