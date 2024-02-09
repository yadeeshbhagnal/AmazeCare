package com.hexaware.amazecare.dto;

public class RecommendedMedicineDto {
	
	private int recommendedMedicineId;
	private String medicineName;
	private int quantity;
	private String dosage;
	private int RecordId;
	
	public RecommendedMedicineDto() {
		super();
	}

	public RecommendedMedicineDto(int recommendedMedicineId, String medicineName, int quantity, String dosage,
			int recordId) {
		super();
		this.recommendedMedicineId = recommendedMedicineId;
		this.medicineName = medicineName;
		this.quantity = quantity;
		this.dosage = dosage;
		RecordId = recordId;
	}

	public int getRecommendedMedicineId() {
		return recommendedMedicineId;
	}

	public void setRecommendedMedicineId(int recommendedMedicineId) {
		this.recommendedMedicineId = recommendedMedicineId;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public int getRecordId() {
		return RecordId;
	}

	public void setRecordId(int recordId) {
		RecordId = recordId;
	}
}
