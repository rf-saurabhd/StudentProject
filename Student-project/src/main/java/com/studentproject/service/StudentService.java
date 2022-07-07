package com.studentproject.service;

import java.util.List;

import com.studentproject.model.Student;

public interface StudentService {
	
	public Student createStudent(Student student);

	public Student getStudent(long id);
	
	public List<Student> getStudents();
	
	public void deleteStudent(Student student);
	
	public Student updateStudent(Student student);
	
}
