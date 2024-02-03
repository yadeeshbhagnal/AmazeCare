package com.hexaware.amazecare.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.amazecare.entities.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer>{


}
