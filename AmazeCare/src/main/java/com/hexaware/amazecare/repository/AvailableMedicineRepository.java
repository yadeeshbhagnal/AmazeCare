package com.hexaware.amazecare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.amazecare.entities.AvailableMedicines;

public interface AvailableMedicineRepository extends JpaRepository<AvailableMedicines, Integer>{
	
	AvailableMedicines findByMedicineName(String medicineName);
}
