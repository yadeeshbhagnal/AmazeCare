package com.hexaware.amazecare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.amazecare.entities.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer>{

}
