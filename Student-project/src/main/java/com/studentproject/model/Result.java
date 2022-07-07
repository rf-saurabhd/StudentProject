package com.studentproject.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Result {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="srNo")
	private long srNo;
	
	@OneToOne(targetEntity = Student.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "student_id",referencedColumnName = "id")
	 Student student;
	
	@NotNull(message = "Enter valid marks")
	@Max(value = 100,message ="Marks should not be greater than 100" )
	@Min(value = 0)
	private int physics;
	
	@NotNull(message = "Enter valid marks")
	@Max(value = 100,message ="Marks should not be greater than 100" )
	@Min(value = 0)
	private int chemistry;
	
	@NotNull(message = "Enter valid marks")
	@Max(value = 100,message ="Marks should not be greater than 100" )
	@Min(value = 0)
	private int biology;
	
	@NotNull(message = "Enter valid marks")
	@Max(value = 100,message ="Marks should not be greater than 100" )
	@Min(value = 0)
	private int mathematics;
	
	
	
	public Result() {}
	
	
	public Result(int physics, int chemistry, int biology, int mathematics) {
		super();
		this.physics = physics;
		this.chemistry = chemistry;
		this.biology = biology;
		this.mathematics = mathematics;
	}


	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}


	public int getPhysics() {
		return physics;
	}
	public void setPhysics(int physics) {
		this.physics = physics;
	}
	public int getChemistry() {
		return chemistry;
	}
	public void setChemistry(int chemistry) {
		this.chemistry = chemistry;
	}
	public int getBiology() {
		return biology;
	}
	public void setBiology(int biology) {
		this.biology = biology;
	}
	public int getMathematics() {
		return mathematics;
	}
	public void setMathematics(int mathematics) {
		this.mathematics = mathematics;
	}
	
	
}
