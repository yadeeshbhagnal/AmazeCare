package com.hexaware.amazecare.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.hexaware.amazecare.entities.Admin;
import com.hexaware.amazecare.entities.Doctor;
import com.hexaware.amazecare.entities.Patient;
import com.hexaware.amazecare.repository.AdminRepository;
import com.hexaware.amazecare.repository.DoctorRepository;
import com.hexaware.amazecare.repository.PatientRepository;

@Component
public class UserInfoUserDetailsService implements UserDetailsService{

	@Autowired
	private PatientRepository patientRepo;
	
	@Autowired
	private DoctorRepository doctorRepo;
	
	@Autowired
	private AdminRepository adminRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) {
		Optional<Patient> patientOptional = patientRepo.findByUserName(username);
		
		if(patientOptional.isPresent()) {
			Patient patient = patientOptional.get();
			return new PatientInfoDetails(patient);
		}
		
		Optional<Doctor> doctorOptional = doctorRepo.findByUserName(username);
		if(doctorOptional.isPresent()) {
			Doctor doctor = doctorOptional.get();
			return new DoctorInfoDetails(doctor);
		}
		
		Optional<Admin> adminOptional = adminRepo.findByUserName(username);
		if(adminOptional.isPresent()) {
			Admin admin = adminOptional.get();
			return new AdminInfoDetails(admin);
		}
		
		throw new UsernameNotFoundException("User not found for username: " + username);
	}
}
