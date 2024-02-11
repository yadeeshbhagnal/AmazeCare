package com.hexaware.amazecare.config;

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
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Patient patient = patientRepo.findByUserName(username).orElse(null);
		if(patient!=null) {
			return new PatientInfoDetails(patient);
		}
		
		Doctor doctor = doctorRepo.findByUserName(username).orElse(null);
		if(doctor!=null) {
			return new DoctorInfoDetails(doctor);
		}
		
		Admin admin = adminRepo.findByUserName(username).orElse(null);
		if(admin!=null) {
			return new AdminInfoDetails(admin);
		}
		
		throw new UsernameNotFoundException("User not found for username: " + username);
	}
}
