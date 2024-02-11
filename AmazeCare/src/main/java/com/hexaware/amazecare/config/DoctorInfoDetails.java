package com.hexaware.amazecare.config;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.hexaware.amazecare.entities.Doctor;

public class DoctorInfoDetails  implements UserDetails{

	private String userName;
	private String password;
	private List<GrantedAuthority> authorities;
	
	public DoctorInfoDetails(Doctor doctor) {
		userName = doctor.getUserName();
		password = doctor.getPassword();
		authorities = Arrays.stream(doctor.getRole().split(","))
						.map(SimpleGrantedAuthority::new)
						.collect(Collectors.toList());			
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
