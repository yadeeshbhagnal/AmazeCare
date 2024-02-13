package com.hexaware.amazecare.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
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
import com.hexaware.amazecare.exception.MedicalRecordNotFoundException;
import com.hexaware.amazecare.exception.MedicineNotFoundException;
import com.hexaware.amazecare.exception.PatientNotFoundException;
import com.hexaware.amazecare.exception.TestNotFoundException;
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

	@Autowired
    PasswordEncoder passwordEncoder;


	Logger logger = LoggerFactory.getLogger(DoctorServiceImp.class);
	
	@Override
	public List<AppointmentDetailsDto>viewAppointments() {
		Doctor doctor = getCurrentDoctor().get();
		logger.info("Fetching all doctor appointments for id: " + doctor.getDoctorId());
		return appointmentRepository.getUpcomingAppointments(doctor.getDoctorId());
	}

	@Override
	public boolean acceptAppointment(int appointmentId) {
		logger.info("Request initiated to accept appointment for id: " + appointmentId);
		boolean flag = false;
		Doctor doctor = getCurrentDoctor().get();
		
		Appointment existingAppointment = appointmentRepository.findById(appointmentId).orElse(null);
		if(existingAppointment != null && existingAppointment.getDoctor().getDoctorId() == doctor.getDoctorId() && existingAppointment.getStatus().equals("Assigned")) {
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
		Doctor doctor = getCurrentDoctor().get();

		Appointment existingAppointment = appointmentRepository.findById(appointmentId).orElse(null);
		if(existingAppointment != null && existingAppointment.getDoctor().getDoctorId() == doctor.getDoctorId() && existingAppointment.getStatus().equals("Assigned")) {
			flag = true;
			existingAppointment.setStatus("Rejected by doctor");
			appointmentRepository.save(existingAppointment);
			logger.info("successfully rejected appointment for id: " + appointmentId);
		}
		return flag;
	}

	@Override
	public boolean rescheduleAppointment(int appointmentId, LocalDate date) {
		logger.info("Request initiated to rescheduled appointment for id: " + appointmentId);
		boolean flag = false;
		Doctor doctor = getCurrentDoctor().get();

		Appointment existingAppointment = appointmentRepository.findById(appointmentId).orElse(null);
		if(existingAppointment != null && existingAppointment.getDoctor().getDoctorId() == doctor.getDoctorId() && existingAppointment.getStatus().equals("Assigned")) {
			flag = true;
			existingAppointment.setDate(date);
			existingAppointment.setStatus("Rescheduled");
			appointmentRepository.save(existingAppointment);
			logger.info("successfully rescheduled appointment for id: " + appointmentId);
		}
		return flag;
	}

	@Override
	public boolean createMedicalRecord(MedicalRecordDto medicalRecordDto, int appointmentId){
		logger.info("Request initiated to create medical record for appointment id: " + appointmentId);
		boolean flag = false;
		Doctor doctor = getCurrentDoctor().get();
		
		Appointment existingAppointment = appointmentRepository.findById(appointmentId).orElse(null);
		
		if(existingAppointment!=null && existingAppointment.getDoctor().getDoctorId() == doctor.getDoctorId() && existingAppointment.getStatus().equals("Accepted")) {
			MedicalRecord medicalRecord = new MedicalRecord();
			
			medicalRecord.setCurrentSymptoms(medicalRecordDto.getCurrentSymptoms());
			medicalRecord.setDate(medicalRecordDto.getDate());
			medicalRecord.setPhysicalExamination(medicalRecordDto.getPhysicalExamination());
			medicalRecord.setTreatmentPlan(medicalRecordDto.getTreatmentPlan());
			medicalRecord.setDoctor(doctor);
			medicalRecord.setPatient(existingAppointment.getPatient());
			medicalRecordRepository.save(medicalRecord);
			
			existingAppointment.setStatus("Completed");
			appointmentRepository.save(existingAppointment);
			
			flag =true;
		
		}
		return flag;
	}

	@Override
	public boolean prescribeMedicine(RecommendedMedicineDto recommendedMedicineDto, int recordId) throws MedicalRecordNotFoundException, MedicineNotFoundException{
		logger.info("Request initiated to prescribe medicine for medical Record: " + recordId);
		
		Doctor doctor = getCurrentDoctor().get();
		MedicalRecord medicalRecord = medicalRecordRepository.findById(recordId).orElse(null);
		
		if(medicalRecord == null ||  medicalRecord.getDoctor().getDoctorId() != doctor.getDoctorId()) {
			throw new MedicalRecordNotFoundException("Medical record for id " +  recordId +  " not found");
		}
		
		String medicineName = recommendedMedicineDto.getMedicineName();
		if(availableMedicineRepository.findByMedicineName(medicineName) == null){
			throw new MedicineNotFoundException("Medicine with name: " + medicineName + " not available");
		}
		
		RecommendedMedicine recommendedMedicine = new RecommendedMedicine();
		
		recommendedMedicine.setMedicineName(recommendedMedicineDto.getMedicineName());
		recommendedMedicine.setDosage(recommendedMedicineDto.getDosage());
		recommendedMedicine.setQuantity(recommendedMedicineDto.getQuantity());
		recommendedMedicine.setMedicalRecord(medicalRecord);
		recommendedMedicineRepository.save(recommendedMedicine);
		
		return true;
	}

	@Override
	public boolean prescribeTest(RecommendedTestsDto recommendedTestsDto, int recordId) throws MedicalRecordNotFoundException, TestNotFoundException{
		logger.info("Request initiated to prescribe test for medical Record: " + recordId);
		
		Doctor doctor = getCurrentDoctor().get();
		MedicalRecord medicalRecord = medicalRecordRepository.findById(recordId).orElse(null);
		
		if(medicalRecord == null || medicalRecord.getDoctor().getDoctorId() != doctor.getDoctorId()) {
			throw new MedicalRecordNotFoundException("Medical record for id " +  recordId +  " not found");
		}
		
		String testName = recommendedTestsDto.getTestName();
		if(availableTestsRepository.findByTestName(testName) == null) {
			throw new TestNotFoundException("Test with name " + testName + " not found");
		}
		
		RecommendedTests recommendedTests = new RecommendedTests();
		recommendedTests.setMedicalRecord(medicalRecord);
		recommendedTests.setTestName(recommendedTestsDto.getTestName());
		recommendedTests.setTestResult("To be conducted");
		recommendedTestRepository.save(recommendedTests);
		logger.info("Successfully prescribed test for record: " + recordId);
		
		return true;
	}

	@Override
	public boolean updateTestResult(int recommendedTestId, String result) {
		logger.info("updating test result for test id: " + recommendedTestId + "to " + result);
		boolean flag = false;
		RecommendedTests test = recommendedTestRepository.findById(recommendedTestId).orElse(null);
		if(test!=null) {
			test.setTestResult(result);
			recommendedTestRepository.save(test);
			flag = true;
		}
		return flag;
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
	
	private Optional<Doctor> getCurrentDoctor(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		return doctorRepository.findByUserName(username);
	}
}
