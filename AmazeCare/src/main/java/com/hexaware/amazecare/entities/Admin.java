package com.hexaware.amazecare.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long adminId;
	
	@NotBlank
	private String adminName;
	
	@Size(max = 30)
	@NotBlank
	private String userName;
	
	@NotBlank
	private String password;
	
	@Size(max = 255)
	@Email
	private String email;
	
	
	private String role;
	
	
	
	public Admin() {
		super();
	}

	public Admin(long adminId, String adminName, @Size(max = 255) String adminUserName,
			@Size(max = 255) String adminPassword, @Size(max = 255) @Email String email, String role) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.userName = adminUserName;
		this.password = adminPassword;
		this.email = email;
		this.role = role;
	}

	public long getAdminId() {
		return adminId;
	}
	
	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}

	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", userName=" + userName + ", password="
				+ password + ", email=" + email + ", role=" + role + "]";
	}
	

	
	
}
