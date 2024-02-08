package com.hexaware.amazecare.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hexaware.amazecare.dto.MedicalRecordDto;
import com.hexaware.amazecare.entities.Appointment;
import com.hexaware.amazecare.entities.AvailableMedicines;
import com.hexaware.amazecare.entities.MedicalRecord;
import com.hexaware.amazecare.entities.RecommendedMedicine;
import com.hexaware.amazecare.entities.RecommendedTests;
import com.hexaware.amazecare.repository.AppointmentRepository;
import com.hexaware.amazecare.repository.AvailableMedicineRepository;
import com.hexaware.amazecare.repository.AvailableTestsRepository;
import com.hexaware.amazecare.repository.MedicalRecordRepository;
import com.hexaware.amazecare.repository.RecommendedMedicineRepository;
import com.hexaware.amazecare.repository.RecommendedTestsRepository;

@Service
public class DoctorServiceImp implements IDoctorService {
	
	@Autowired
	MedicalRecordRepository medicalRecordRepository;
	
	@Autowired 
	AppointmentRepository appointmentRepository;
	
	@Autowired
	RecommendedMedicineRepository recommendedMedicineRepository;
	
	@Autowired
	RecommendedTestsRepository recommendedTestRepository;
	
	@Autowired
	AvailableMedicineRepository availableMedicineRepository;
	
	@Autowired
	AvailableTestsRepository availableTestsRepository;

	@Override
	public List<Appointment>viewAppointments(int doctorId) {
		return appointmentRepository.getUpcomingAppointments();
	}

	@Override
	public boolean acceptAppointment(int appointmentId) {
		boolean flag = false;
		Appointment existingAppointment = appointmentRepository.findById(appointmentId).orElse(null);
		if(existingAppointment != null) {
			flag = true;
			existingAppointment.setStatus("Accepted");
			appointmentRepository.save(existingAppointment);
		}
		return flag;
	}

	@Override
	public boolean rejectAppointment(int appointmentId) {
		boolean flag = false;
		Appointment existingAppointment = appointmentRepository.findById(appointmentId).orElse(null);
		if(existingAppointment != null) {
			flag = true;
			existingAppointment.setStatus("rejected");
			appointmentRepository.save(existingAppointment);
		}
		return flag;
	}

	@Override
	public boolean rescheduleAppointment(int appointmentId, LocalDate date) {
		boolean flag = false;
		Appointment existingAppointment = appointmentRepository.findById(appointmentId).orElse(null);
		if(existingAppointment != null) {
			flag = true;
			existingAppointment.setDate(date);
			appointmentRepository.save(existingAppointment);
		}
		return flag;
	}

	@Override
	public boolean createMedicalRecord(MedicalRecordDto medicalRecordDto) {
		MedicalRecord medicalRecord = new MedicalRecord();
		boolean flag = true;
		
		medicalRecord.setCurrentSymptoms(medicalRecordDto.getCurrentSymptoms());
		medicalRecord.setDate(medicalRecordDto.getDate());
		medicalRecord.setPhysicalExamination(medicalRecordDto.getPhysicalExamination());
		medicalRecord.setTreatmentPlan(medicalRecordDto.getTreatmentPlan());
		medicalRecordRepository.save(medicalRecord);
		
		return flag;
	}

	@Override
	public boolean prescribeMedicine(RecommendedMedicine recommendedMedicine) {
		boolean flag = false;
		String medicineName = recommendedMedicine.getMedicineName();
		if(availableMedicineRepository.findByMedicineName(medicineName)!=null){
			flag = true;
			recommendedMedicineRepository.save(recommendedMedicine);
		}
		return flag;
	}

	@Override
	public boolean prescribeTest(RecommendedTests recommendedTests) {
		boolean flag = false;
		String testName = recommendedTests.getTestName();
		if(availableTestsRepository.findByTestName(testName)!=null){
			flag = true;
			recommendedTestRepository.save(recommendedTests);
		}
		return flag;
	}
	
	public boolean updateTestResult(int recommendedTestId, String result) {
		RecommendedTests test = recommendedTestRepository.findById(recommendedTestId).orElse(null);
		test.setTestResult(result);
		return true;
	}
}