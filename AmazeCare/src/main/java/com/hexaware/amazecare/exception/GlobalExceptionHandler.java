package com.hexaware.amazecare.exception;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
@ExceptionHandler({AppointmentNotFoundException.class, DoctorNotFoundException.class, 
	MedicalRecordNotFoundException.class, MedicineNotFoundException.class,
	PatientNotFoundException.class, TestNotFoundException.class, RecommendedTestNotFound.class})

public ResponseEntity<String> handleExp(Exception e){
	return new ResponseEntity<>(e.toString(),HttpStatus.EXPECTATION_FAILED);
}
}
