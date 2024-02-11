package com.hexaware.amazecare.service;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.hexaware.amazecare.dto.AppointmentDetailsDto;
import com.hexaware.amazecare.dto.AuthRequest;
import com.hexaware.amazecare.dto.MedicalRecordDto;
import com.hexaware.amazecare.dto.RecommendedMedicineDto;
import com.hexaware.amazecare.dto.RecommendedTestsDto;
import com.hexaware.amazecare.entities.Appointment;
import com.hexaware.amazecare.entities.Doctor;
import com.hexaware.amazecare.entities.MedicalRecord;
import com.hexaware.amazecare.entities.Patient;
import com.hexaware.amazecare.entities.RecommendedMedicine;
import com.hexaware.amazecare.entities.RecommendedTests;
import com.hexaware.amazecare.exception.DoctorNotFoundException;
import com.hexaware.amazecare.exception.PatientNotFoundException;
import com.hexaware.amazecare.repository.AppointmentRepository;
import com.hexaware.amazecare.repository.AvailableMedicineRepository;
import com.hexaware.amazecare.repository.AvailableTestsRepository;
import com.hexaware.amazecare.repository.DoctorRepository;
import com.hexaware.amazecare.repository.MedicalRecordRepository;
import com.hexaware.amazecare.repository.PatientRepository;
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
	
	@Autowired
	DoctorRepository doctorRepository;
	
	@Autowired
	PatientRepository patientRepository;
	
	@Autowired
	JwtService jwtService;
	
	@Autowired
	AuthenticationManager authenticationManager;

	Logger logger = LoggerFactory.getLogger(DoctorServiceImp.class);
	
	@Override
	public List<AppointmentDetailsDto>viewAppointments(int doctorId) {
		logger.info("Fetching all doctor appointments for id: " + doctorId);
		return appointmentRepository.getUpcomingAppointments(doctorId);
		
	}

	@Override
	public boolean acceptAppointment(int appointmentId) {
		logger.info("Request initiated to accept appointment for id: " + appointmentId);
		boolean flag = false;
		Appointment existingAppointment = appointmentRepository.findById(appointmentId).orElse(null);
		if(existingAppointment != null) {
			flag = true;
			existingAppointment.setStatus("Accepted");
			appointmentRepository.save(existingAppointment);
			logger.info("successfully accepted appointment for id: " + appointmentId);
		}
		return flag;
	}

	@Override
	public boolean rejectAppointment(int appointmentId) {
		logger.info("Request initiated to reject appointment for id: " + appointmentId);
		boolean flag = false;
		Appointment existingAppointment = appointmentRepository.findById(appointmentId).orElse(null);
		if(existingAppointment != null) {
			flag = true;
			existingAppointment.setStatus("Rejected");
			appointmentRepository.save(existingAppointment);
			logger.info("successfully rejected appointment for id: " + appointmentId);
		}
		return flag;
	}

	@Override
	public boolean rescheduleAppointment(int appointmentId, LocalDate date) {
		logger.info("Request initiated to rescheduled appointment for id: " + appointmentId);
		boolean flag = false;
		Appointment existingAppointment = appointmentRepository.findById(appointmentId).orElse(null);
		if(existingAppointment != null) {
			flag = true;
			existingAppointment.setDate(date);
			existingAppointment.setStatus("Rescheduled");
			appointmentRepository.save(existingAppointment);
			logger.info("successfully rescheduled appointment for id: " + appointmentId);
		}
		return flag;
	}

	@Override
	public boolean createMedicalRecord(MedicalRecordDto medicalRecordDto) throws DoctorNotFoundException,PatientNotFoundException{
		logger.info("Request initiated to create medical record for patient id: " + medicalRecordDto.getPatientId());
		boolean flag = true;
		
		Doctor doctor = doctorRepository.findById(medicalRecordDto.getDoctorId()).orElse(null);
		if(doctor == null) {
			throw new DoctorNotFoundException("Doctor with id: " + medicalRecordDto.getDoctorId() + " not found");
		}
		Patient patient = patientRepository.findById(medicalRecordDto.getPatientId()).orElse(null);
		if(patient == null) {
			throw new PatientNotFoundException("Patient with id: " + medicalRecordDto.getPatientId() + " not found");
		}
		
		MedicalRecord medicalRecord = new MedicalRecord();
		medicalRecord.setCurrentSymptoms(medicalRecordDto.getCurrentSymptoms());
		medicalRecord.setDate(medicalRecordDto.getDate());
		medicalRecord.setPhysicalExamination(medicalRecordDto.getPhysicalExamination());
		medicalRecord.setTreatmentPlan(medicalRecordDto.getTreatmentPlan());
		medicalRecord.setDoctor(doctor);
		medicalRecord.setPatient(patient);
		medicalRecordRepository.save(medicalRecord);
		
		return flag;
	}

	@Override
	public boolean prescribeMedicine(RecommendedMedicineDto recommendedMedicineDto) {
		logger.info("Request initiated to prescribe medicine for medical Record: " + recommendedMedicineDto.getRecordId());
		MedicalRecord medicalRecord = medicalRecordRepository.findById(recommendedMedicineDto.getRecordId())
									  .orElse(null);
		
		RecommendedMedicine recommendedMedicine = new RecommendedMedicine();
		recommendedMedicine.setMedicineName(recommendedMedicineDto.getMedicineName());
		recommendedMedicine.setDosage(recommendedMedicineDto.getDosage());
		recommendedMedicine.setQuantity(recommendedMedicineDto.getQuantity());
		recommendedMedicine.setMedicalRecord(medicalRecord);
		
		boolean flag = false;
		String medicineName = recommendedMedicine.getMedicineName();
		
		if(availableMedicineRepository.findByMedicineName(medicineName)!=null){
			flag = true;
			recommendedMedicineRepository.save(recommendedMedicine);
			logger.info("Successfully prescribed medicine for record: " + recommendedMedicineDto.getRecordId());
		}
		return flag;
	}

	@Override
	public boolean prescribeTest(RecommendedTestsDto recommendedTestsDto) {
		logger.info("Request initiated to prescribe test for medical Record: " + recommendedTestsDto.getRecordId());
		MedicalRecord medicalRecord = medicalRecordRepository.findById(recommendedTestsDto.getRecordId())
				.orElse(null);
		
		RecommendedTests recommendedTests = new RecommendedTests();
		recommendedTests.setMedicalRecord(medicalRecord);
		recommendedTests.setTestName(recommendedTestsDto.getTestName());
		recommendedTests.setTestResult(recommendedTestsDto.getTestResult());
		
		boolean flag = false;
		String testName = recommendedTests.getTestName();
		if(availableTestsRepository.findByTestName(testName)!=null){
			flag = true;
			recommendedTestRepository.save(recommendedTests);
			logger.info("Successfully prescribed test for record: " + recommendedTestsDto.getRecordId());

		}
		return flag;
	}
	
	@Override
	public boolean updateTestResult(int recommendedTestId, String result) {
		logger.info("updating test result for test id: " + recommendedTestId + "to " + 
				result);
		RecommendedTests test = recommendedTestRepository.findById(recommendedTestId).orElse(null);
		test.setTestResult(result);
		recommendedTestRepository.save(test);
		return true;
	}

	@Override
	public String loginDoctor(AuthRequest authRequest) {
		
		String token = null;
		
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		
		if(authentication.isAuthenticated())
		{
			token = jwtService.generateToken(authRequest.getUsername());
			
		}
		else {
			throw new UsernameNotFoundException("Username or password is invlaid");
		}
		return token;
	}
}
