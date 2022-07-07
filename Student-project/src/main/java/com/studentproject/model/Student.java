package com.studentproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@OneToOne(mappedBy = "student")
	 Result result;
	
	@NotEmpty(message = "First Name should contain atleast 4 Characters")
	@Pattern(regexp = "[A-Z][a-z]{14}",message ="Initial character should be In Uppercase" )
	private String firstName;
	
	@NotEmpty(message = "Last Name should not Empty")
	@Pattern(regexp = "[A-Z][a-z]{14}",message ="Initial character should be In Uppercase" )
	private String lastName;
	
	@NotNull(message = "Age should be greater than 18")
	@Min(value = 18)
	private int age;
	
	@Email //"^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$"
	@Pattern(regexp = "[a-z0-9_.-]+[@][a-z]+[.][a-z]{2,3}", message = "Email id should contain @ symbol")
	private String emailId;
	
	@Column(name="mobileNumber")
	@Size(max = 10, min = 10,message = "Enter 10 digits mobile Number")
	private String phoneNumber;
	
	
	public Student(String firstName, String lastName, int age, String emailId, String phoneNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
	}
	
	public Student() {
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}
	
	
	
	
}
