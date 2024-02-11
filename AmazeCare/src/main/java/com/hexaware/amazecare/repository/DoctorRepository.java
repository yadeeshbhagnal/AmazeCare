package com.hexaware.amazecare.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hexaware.amazecare.entities.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer>{
	
    Optional<Doctor> findByUserName(String username);

	public List<Doctor> findBySpeciality(String speciality);
	
	public List<Doctor> findByDoctorName(String doctorName);

}
