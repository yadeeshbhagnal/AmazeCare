package com.hexaware.amazecare.service;

import java.time.LocalTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.amazecare.dto.AdminViewDto;
import com.hexaware.amazecare.dto.DoctorDto;
import com.hexaware.amazecare.entities.Appointment;
import com.hexaware.amazecare.entities.AvailableMedicines;
import com.hexaware.amazecare.entities.AvailableTests;
import com.hexaware.amazecare.entities.Doctor;
import com.hexaware.amazecare.entities.Patient;
import com.hexaware.amazecare.repository.AdminRepository;
import com.hexaware.amazecare.repository.AppointmentRepository;
import com.hexaware.amazecare.repository.AvailableMedicineRepository;
import com.hexaware.amazecare.repository.AvailableTestsRepository;
import com.hexaware.amazecare.repository.DoctorRepository;
import com.hexaware.amazecare.repository.PatientRepository;

@Service
public class AdminServiceImp implements IAdminService {
	
	@Autowired
	PatientRepository patientRepository;
	
	@Autowired
	AppointmentRepository appointmentRepository;
		
	@Autowired
	DoctorRepository doctorRepository;
	
	@Autowired
	AdminRepository adminRespository;
	
	@Autowired
	AvailableTestsRepository testRepository;
	
	@Autowired
	AvailableMedicineRepository medicineRepository;
	
	Logger logger = LoggerFactory.getLogger(AdminServiceImp.class);

	
	@Override
	public boolean addDoctor(DoctorDto doctorDto) {
		logger.info("Request initated to add new doctor");
		Doctor doctor = new Doctor();
		doctor.setDoctorName(doctorDto.getDoctorName());
		doctor.setExperience(doctorDto.getExperience());
		doctor.setQualification(doctorDto.getQualification());
		doctor.setSpeciality(doctorDto.getSpeciality());
		doctor.setDesignation(doctorDto.getDesignation());
		doctorRepository.save(doctor);
		
		return true;
	}

	@Override
	public boolean updateDoctor(DoctorDto doctorDto) {
		logger.info("Request initiated to update doctor with id: " + doctorDto.getDoctorId());
		Doctor doctor = doctorRepository.findById(doctorDto.getDoctorId()).orElse(null);
		boolean flag = false;
		
		if(doctor!=null) {
			if (doctorDto.getDoctorName() != null) {
	            doctor.setDoctorName(doctorDto.getDoctorName());
	        }
			
			Integer experience = doctorDto.getExperience();
	        if (experience != null) {
	            doctor.setExperience(doctorDto.getExperience());
	        }
	        if (doctorDto.getQualification() != null) {
	            doctor.setQualification(doctorDto.getQualification());
	        }
	        if (doctorDto.getSpeciality() != null) {
	            doctor.setSpeciality(doctorDto.getSpeciality());
	        }
	        if (doctorDto.getDesignation() != null) {
	            doctor.setDesignation(doctorDto.getDesignation());
	        }
			doctorRepository.save(doctor);
			flag = true;
			logger.info("Doctor details for id: " + doctorDto.getDoctorId() + " updated");
		}
		return flag;
	}

	@Override
	public boolean deleteDoctor(int doctorId) {
		logger.info("Request initiated to delete doctor with id: " + doctorId);
		boolean flag = false;
		Doctor doctor = doctorRepository.findById(doctorId).orElse(null);
		if(doctor!=null) {
			doctorRepository.deleteById(doctorId);
			logger.info("doctor with id: " + doctorId + " deleted");
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean deletePatient(int patientId) {
		logger.info("Request initiated to delete patient with id: " + patientId);
		boolean flag = false;
		Patient patient = patientRepository.findById(patientId).orElse(null);
		if(patient!=null) {
			patientRepository.deleteById(patientId);
			flag = true;
		}
		return flag;
	
	}

	@Override
	public List<Doctor> viewAllDoctors() {
		logger.info("Request initiated to view all doctors");
		return doctorRepository.findAll();
	}

	@Override
	public List<Patient> viewAllPatients() {
		logger.info("Request initiated to view all patients");
		return patientRepository.findAll();
	}

	@Override
	public List<Appointment> viewAllAppointments() {
		logger.info("Request initiated to view all appointments");
		return appointmentRepository.findAll();
	}

	@Override
	public boolean assignAppointmentToDoctor(int appointmentId, LocalTime time) {
		logger.info("Request initiated to assign appointment to doctor for id: " + appointmentId);
		boolean flag = false;
		Appointment appointment = appointmentRepository.findById(appointmentId).orElse(null);
		if(appointment!=null) {
			appointment.setTime(time);
			appointment.setStatus("Assigned");
			logger.info("Appointment successfully assigned");
			flag = true;
		}
		return flag;
	}

	@Override
	public List<Doctor> getByName(String doctorName) {
		logger.info("Request initiated to get all doctors with name: " + doctorName);
		return doctorRepository.findByDoctorName(doctorName);
	}

	@Override
	public boolean addTests(AvailableTests availableTests) {
		logger.info("Request initiated to add new test with id: " + availableTests.getTestId());
		testRepository.save(availableTests);
		return true;
	}

	@Override
	public boolean addMedicines(AvailableMedicines availableMedicines) {
		logger.info("Request initiated to add new medicine with id: " + availableMedicines.getMedicineId());
		medicineRepository.save(availableMedicines);
		return true;
	}
	
	@Override
	public List<AdminViewDto> viewUpcomingAppointments() {
		return appointmentRepository.getAdminAppointments();
	}
}