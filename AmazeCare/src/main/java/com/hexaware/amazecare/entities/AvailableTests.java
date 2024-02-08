package com.hexaware.amazecare.entities;

public class AvailableTests {
	
	private int testId;
	private String testName;
	private double testPrice;

	public AvailableTests() {
		super();
	}

	public AvailableTests(int testId, String testName, double testPrice) {
		super();
		this.testId = testId;
		this.testName = testName;
		this.testPrice = testPrice;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public double getTestPrice() {
		return testPrice;
	}

	public void setTestPrice(double testPrice) {
		this.testPrice = testPrice;
	}

	@Override
	public String toString() {
		return "AvailableTests [testId=" + testId + ", testName=" + testName + ", testPrice=" + testPrice + "]";
	}

}