package com.hexaware.amazecare.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

@Entity
public class Admin {
	
	@Id
	private long adminId;
	
	@Size(max = 255)
	private String adminUserName;
	
	@Size(max = 255)
	private String adminPassword;
	
	@Size(max = 255)
	@Email
	private String email;
	
	public Admin(long adminId, String adminUserName, String adminPassword, String email) {
		super();
		this.adminId = adminId;
		this.adminUserName = adminUserName;
		this.adminPassword = adminPassword;
		this.email = email;
	}

	public long getAdminId() {
		return adminId;
	}
	
	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}

	public String getAdminUserName() {
		return adminUserName;
	}

	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminUserName=" + adminUserName + ", adminPassword=" + adminPassword
				+ ", email=" + email + "]";
	}
}
