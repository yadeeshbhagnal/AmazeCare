package com.hexaware.amazecare.entities;

public class AvailableMedicines {
	
	private int medicineId;
	private String medicineName;
	private double medicinePrice;
	public AvailableMedicines() {
		super();
	}
	public AvailableMedicines(int medicineId, String medicineName, double medicinePrice) {
		super();
		this.medicineId = medicineId;
		this.medicineName = medicineName;
		this.medicinePrice = medicinePrice;
	}
	public int getMedicineId() {
		return medicineId;
	}
	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	public double getMedicinePrice() {
		return medicinePrice;
	}
	public void setMedicinePrice(double medicinePrice) {
		this.medicinePrice = medicinePrice;
	}
	@Override
	public String toString() {
		return "AvailableMedicines [medicineId=" + medicineId + ", medicineName=" + medicineName + ", medicinePrice="
				+ medicinePrice + "]";
	}
}
