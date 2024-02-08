package com.hexaware.amazecare.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hexaware.amazecare.dto.AppointmentDto;
import com.hexaware.amazecare.entities.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer>{

	List<Appointment> findByPatientPatientId(int patientId);
	
	@Query(value = "select appointment_id,date,symptoms,visit_type from Appointment_info where doctor_id = :doctorId", nativeQuery= true)
	List<AppointmentDto> getUpcomingAppointments(int doctorId);
	

}
