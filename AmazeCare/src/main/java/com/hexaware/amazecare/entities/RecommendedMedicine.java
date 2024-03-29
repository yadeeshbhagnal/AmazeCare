package com.hexaware.amazecare.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

@Entity
public class RecommendedMedicine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int recommendedMedicineId;
	
	@NotBlank
	private String medicineName;
	
	@Positive
	@NotNull
	private int quantity;
	
	@Pattern(regexp = "^\\d-\\d-\\d (AF|BF)$")
	private String dosage;
	
	@ManyToOne
	@JoinColumn(name = "record_Id")
	@JsonBackReference
	private MedicalRecord medicalRecord;
	
	public RecommendedMedicine() {
		super();
	}

	

	public RecommendedMedicine(int recommendedMedicineId, String medicineName, int quantity, String dosage,
			MedicalRecord medicalRecord) {
		super();
		this.recommendedMedicineId = recommendedMedicineId;
		this.medicineName = medicineName;
		this.quantity = quantity;
		this.dosage = dosage;
		this.medicalRecord = medicalRecord;
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

	public MedicalRecord getMedicalRecord() {
		return medicalRecord;
	}

	public void setMedicalRecord(MedicalRecord medicalRecord) {
		this.medicalRecord = medicalRecord;
	}
	

	public int getRecommendedMedicineId() {
		return recommendedMedicineId;
	}



	public void setRecommendedMedicineId(int recommendedMedicineId) {
		this.recommendedMedicineId = recommendedMedicineId;
	}



	@Override
	public String toString() {
		return "RecomendedMedicine [medicineName=" + medicineName + ", quantity=" + quantity + ", dosage=" + dosage
				+ ", medicalRecord=" + medicalRecord + "]";
	}

}
