package com.hexaware.amazecare.repository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.hexaware.amazecare.dto.AppointmentDetailsDto;
import com.hexaware.amazecare.entities.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer>{

	List<Appointment> findByPatientPatientId(int patientId);
	
	@Query("select new com.hexaware.amazecare.dto.AppointmentDetailsDto(p.patientName,p.contactNumber,a.symptoms,a.time) from Appointment "
			+ "a join a.doctor d join a.patient p where d.doctorId =?1 "
			+ "and a.date>=CURRENT_DATE and (a.status = 'Assigned')")
	List<AppointmentDetailsDto> getUpcomingAppointments(int doctorId);
}
