package com.studentproject.model;

import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Admin {

	@Id
	@NotEmpty(message = "Admin Id should not be empty ")
	@Size(min=5, max=10,message = "Admin Id should contain Minimum 5 characters")
	private String adminId;
	
	@NotEmpty(message = "Admin Password should not be empty ")
	@Pattern(regexp = "[A-Z][a-z0-9]{5,9}[@][a-z0-9]{5}", message = "Password should contain at least @ digits")
	private String password;
	
	public Admin() {}
	
	public Admin(String adminId, String password) {
		super();
		this.adminId = adminId;
		this.password = password;
	}
	public String getAdminName() {
		return adminId;
	}
	public void setAdminName(String adminName) {
		this.adminId = adminName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
