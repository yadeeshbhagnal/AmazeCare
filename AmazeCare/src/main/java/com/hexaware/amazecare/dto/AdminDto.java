package com.hexaware.amazecare.dto;


public class AdminDto {
		private long adminId;
		private String adminName;
		private String userName;		
		private String password;		
		private String email;		
		private String role;
		
		public AdminDto(long adminId, String adminName, String adminUserName, String adminPassword, String email,
				String role) {
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
			return "AdminDto [adminId=" + adminId + ", adminName=" + adminName + ", userName=" + userName
					+ ", password=" + password + ", email=" + email + ", role=" + role + "]";
		}

		
	}